package com.exception;

public class ErrorResponse {

    private String message;
    private int status;
	private long time;

	public ErrorResponse(String message, int status) {
		this.message = message;
		this.status = status;
		this.time = System.currentTimeMillis();
	}

	public String getMessage() {
		return message;
	}

	public int getStatus() {
		return status;
	}

	public long getTime() {
		return time;
	}
}