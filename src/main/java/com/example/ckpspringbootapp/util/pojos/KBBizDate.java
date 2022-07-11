package com.example.ckpspringbootapp.util.pojos;

public class KBBizDate {
	
    private String currentUtcTime;
    private String timeZone;
    private String localDate;
	public String getCurrentUtcTime() {
		return currentUtcTime;
	}
	public void setCurrentUtcTime(String currentUtcTime) {
		this.currentUtcTime = currentUtcTime;
	}
	public String getTimeZone() {
		return timeZone;
	}
	public void setTimeZone(String timeZone) {
		this.timeZone = timeZone;
	}
	public String getLocalDate() {
		return localDate;
	}
	public void setLocalDate(String localDate) {
		this.localDate = localDate;
	}

}
