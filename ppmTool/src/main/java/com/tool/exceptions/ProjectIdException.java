package com.tool.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ProjectIdException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8354926313154458451L;

	public ProjectIdException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
}
