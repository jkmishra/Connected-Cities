package org.connectedCities.domain;

/**
 * Contain Error message.
 * */
public enum ErrorMsgs {
	FILE_NOT_FOUND(" file not found."), FILE_IS_EMPTY(" file is empty!");
	private String errorMsg;

	private ErrorMsgs(String msg) {
		this.errorMsg = msg;
	}

	public final String value() {
		return this.errorMsg;
	}
}
