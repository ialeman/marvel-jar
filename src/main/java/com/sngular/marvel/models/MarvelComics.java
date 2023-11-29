package com.sngular.marvel.models;

import java.util.ArrayList;

import lombok.Data;

@Data
public class MarvelComics {
	private int available;
	private String collectionURI;
	private ArrayList<Item> items;
	private int returned;
}
