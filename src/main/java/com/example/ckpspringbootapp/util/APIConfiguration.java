package com.example.ckpspringbootapp.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix="api")
@Configuration("APIConfiguration")
public class APIConfiguration {
	
	@Value("${api.acctoinvoice}")
	private String acctoinvoice;
	
	@Value("${api.changeclock}")
	private String changeclock;
	
	@Value("${api.getclock}")
	private String getclock;
	
	@Value("${api.getaccounts}")
	private String getaccounts;
	
	
	
	public String getChangeclock() {
		return changeclock;
	}
	public void setChangeclock(String changeclock) {
		this.changeclock = changeclock;
	}
	public String getGetclock() {
		return getclock;
	}
	public void setGetclock(String getclock) {
		this.getclock = getclock;
	}
	public String getGetaccounts() {
		return getaccounts;
	}
	public void setGetaccounts(String getaccounts) {
		this.getaccounts = getaccounts;
	}
	public String getAcctoinvoice() {
		return acctoinvoice;
	}
	public void setAcctoinvoice(String acctoinvoice) {
		this.acctoinvoice = acctoinvoice;
	}
	
}
