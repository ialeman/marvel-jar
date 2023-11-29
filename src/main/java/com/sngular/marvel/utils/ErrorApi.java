package com.sngular.marvel.utils;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class ErrorApi {

	private String code;
	private String message;
	
}
