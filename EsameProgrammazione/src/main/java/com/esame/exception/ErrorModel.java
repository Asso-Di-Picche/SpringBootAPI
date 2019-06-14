package com.esame.exception;

import java.time.Instant;

import org.springframework.http.HttpStatus;

public class ErrorModel {

	private final HttpStatus httpstatus;
	private final Instant instant;
	private final String errorName;
	private final String expecting;

	
	public ErrorModel(HttpStatus httpstatus, Instant instant, String errorName, String expecting) {

		this.httpstatus = httpstatus;
		this.instant = instant;
		this.errorName = errorName;
		this.expecting = expecting;
	}

	public HttpStatus getHttpstatus() {
		return httpstatus;
	}

	public Instant getInstant() {
		return instant;
	}

	public String geterrorName() {
		return errorName;
	}

	public String getExpecting() {
		return expecting;
	}
}
