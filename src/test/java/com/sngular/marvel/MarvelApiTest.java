package com.sngular.marvel;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import com.sngular.marvel.controller.MarvelApi;
import com.sngular.marvel.models.MarvelPage;

@SpringBootTest
public class MarvelApiTest {

	@Value("${marvel.api.private-key}")
    private String apiPrivateKey;
    
    @Value("${marvel.api.public-key}")
    private String apiPublicKey;
    
	@Test
    public void testGetCharacters() {
		String timestamp = "2";
        MarvelApi marvelApiClient = new MarvelApi(apiPrivateKey, apiPublicKey, timestamp);
        MarvelPage page = marvelApiClient.getCharacters();
        System.out.println(page.toString());
        assertNotNull(page);
    }

    @Test
    public void testGetCharacterById() {
    	String timestamp = "2";
    	MarvelApi marvelApiClient = new MarvelApi(apiPrivateKey, apiPublicKey, timestamp);
        MarvelPage page = marvelApiClient.getCharacterById(1012717);
        System.out.println(page.toString());
        assertNotNull(page);
    }
	
}
