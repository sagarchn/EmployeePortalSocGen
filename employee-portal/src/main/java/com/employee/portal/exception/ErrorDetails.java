package com.employee.portal.exception;

import java.time.LocalDateTime;

public class ErrorDetails {

	private String path;
	private LocalDateTime timesString;
	private String className;
	private String message;

	public ErrorDetails(String path, LocalDateTime timesString, String className, String message) {
		super();
		this.path = path;
		this.timesString = timesString;
		this.className = className;
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public LocalDateTime getTimesString() {
		return timesString;
	}

	public void setTimesString(LocalDateTime timesString) {
		this.timesString = timesString;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
