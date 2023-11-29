package com.sngular.marvel.controller;

import org.apache.commons.codec.digest.DigestUtils;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.sngular.marvel.models.MarvelPage;
import com.sngular.marvel.models.MarvelData;
import com.sngular.marvel.service.MarvelApiService;
import com.sngular.marvel.utils.ErrorApi;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MarvelApi implements MarvelApiService {

	private final String MARVEL_API = "https://gateway.marvel.com:443/v1/public/characters";

	private String apiPrivateKey;
	private String apiPublicKey;
	private String timestamp;
	
    public MarvelApi(String apiPrivateKey, String apiPublicKey, String timestamp) {
        this.apiPrivateKey = apiPrivateKey;
        this.apiPublicKey = apiPublicKey;
        this.timestamp = timestamp;
    }

    @Override
    public MarvelPage getCharacters() {
    	try {
    		String apiKey = generateMD5ApiKey(timestamp, apiPrivateKey, apiPublicKey);
            String completeUrl = MARVEL_API + "?apikey="+apiPublicKey+"&hash="+apiKey+"&ts="+timestamp;
            
            Unirest.setTimeouts(0, 0);
        	Gson gson = new Gson();
            HttpResponse<String> response = Unirest
                    .get(completeUrl)
                    .header("Content-Type", "application/json")
                    .asString();
            
            if (response.getStatus() == 200) {
    			MarvelData marvelData = gson.fromJson(response.getBody(), MarvelData.class);
                return marvelData.getData();
            }
            
            ErrorApi errorApi = gson.fromJson(response.getBody(), ErrorApi.class);
            throw new RuntimeException(errorApi.toString());
        } catch (UnirestException e) {
        	log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public MarvelPage getCharacterById(int characterId) {
    	try {
    		String apiKey = generateMD5ApiKey(timestamp, apiPrivateKey, apiPublicKey);
            String completeUrl = MARVEL_API + "/"+characterId+"?apikey="+apiPublicKey+"&hash="+apiKey+"&ts="+timestamp;
            
            Unirest.setTimeouts(0, 0);
        	Gson gson = new Gson();
            HttpResponse<String> response = Unirest
                    .get(completeUrl)
                    .header("Content-Type", "application/json")
                    .asString();
            
            if (response.getStatus() == 200) {
    			MarvelData marvelData = gson.fromJson(response.getBody(), MarvelData.class);
                return marvelData.getData();
            }
            
            ErrorApi errorApi = gson.fromJson(response.getBody(), ErrorApi.class);
            throw new RuntimeException(errorApi.toString());
        } catch (UnirestException e) {
        	log.error(e.getMessage(), e);
            throw new RuntimeException(e.getMessage());
        }
    }
    
    private String generateMD5ApiKey(String timestamp, String apiPrivateKey, String apiPublicKey) {
    	return DigestUtils.md5Hex(timestamp+apiPrivateKey+apiPublicKey);
    }

}
