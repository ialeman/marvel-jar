package com.sngular.marvel.service;

import com.sngular.marvel.models.MarvelPage;

public interface MarvelApiService {

	public MarvelPage getCharacters();
    
	public MarvelPage getCharacterById(int characterId);
}
