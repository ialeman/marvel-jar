package com.sngular.marvel.models;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class MarvelData {
	private int code;
	private String status;
	private String copyright;
	private String attributionText;
	private String attributionHTML;
	private String etag;
	private MarvelPage data;
}
