package com.example.ckpspringbootapp.util;

/**
 * Currently not in use: 20220629
 */

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

@ConfigurationProperties(prefix="config")
@Configuration("MyCustomConfiguration")
public class MyCustomConfiguration {
	
	@Value("${config.uid}")
	private  String authUid;
	
	@Value("${config.pwd}")
	private  String authPwd;
	
	@Value("${config.keyname1}")
	private  String apiKey1;
	
	@Value("${config.keyname2}")
	private  String apiKey2;
	
	@Value("${config.keyname3}")
	private  String apiKey3;
	
	@Value("${config.keyname1Val}")
	private  String apiKey1Val;
	
	@Value("${config.keyname2Val}")
	private  String apiKey2Val;
	
	@Value("${config.keyname3Val}")
	private  String apiKey3Val;
	
	@Value("${config.urlBase}")
	private  String urlBase;
	
	
	//------------- Setter and Getter follows below
	
	public  String getAuthUid() {
		return authUid;
	}

	public  void setAuthUid(String authUid) {
		authUid = authUid;
	}

	public String getAuthPwd() {
		return authPwd;
	}

	public void setAuthPwd(String authPwd) {
		authPwd = authPwd;
	}

	public String getApiKey1() {
		return apiKey1;
	}

	public void setApiKey1(String apiKey1) {
		apiKey1 = apiKey1;
	}

	public String getApiKey2() {
		return apiKey2;
	}

	public void setApiKey2(String apiKey2) {
		apiKey2 = apiKey2;
	}

	public String getApiKey3() {
		return apiKey3;
	}

	public  void setApiKey3(String apiKey3) {
		apiKey3 = apiKey3;
	}

	public  String getApiKey1Val() {
		return apiKey1Val;
	}

	public  void setApiKey1Val(String apiKey1Val) {
		apiKey1Val = apiKey1Val;
	}

	public  String getApiKey2Val() {
		return apiKey2Val;
	}

	public  void setApiKey2Val(String apiKey2Val) {
		apiKey2Val = apiKey2Val;
	}

	public  String getApiKey3Val() {
		return apiKey3Val;
	}

	public  void setApiKey3Val(String apiKey3Val) {
		System.out.println("value set done!");
		apiKey3Val = apiKey3Val;
	}
	

	public String getUrlBase() {
		return urlBase;
	}

	public void setUrlBase(String urlBase) {
		this.urlBase = urlBase;
	}

	

	

}
