package com.sngular.marvel.models;

import java.util.ArrayList;
import java.util.Date;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MarvelCharacter {
	private int id;
	private String name;
	private String description;
	private Date modified;
	private MarvelThumbnail thumbnail;
	private String resourceURI;
	private MarvelComics comics;
	private MarvelSeries series;
    private MarvelStories stories;
    private MarvelEvents events;
    private ArrayList<Url> urls;
}
