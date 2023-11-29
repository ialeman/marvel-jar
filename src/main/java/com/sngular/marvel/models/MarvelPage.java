package com.sngular.marvel.models;

import java.util.ArrayList;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MarvelPage {
	private int offset;
    private int limit;
    private int total;
    private int count;
    private ArrayList<MarvelCharacter> results;
}
