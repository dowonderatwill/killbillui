package com.example.ckpspringbootapp.util;

import java.io.IOException;
import java.net.Authenticator;
import java.net.PasswordAuthentication;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.net.http.HttpRequest.Builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

public class HttpIteractionHelper {
	
	private static final HttpIteractionHelper Instance = new HttpIteractionHelper(); // to make it singleton class
	private HttpIteractionHelper() {}
	private static HttpClient httpcl = null;
	private Gson gson = new Gson();
	
	public static HttpIteractionHelper getInstance(final String uid, final String pwd) {
		
		if(null!=httpcl) return Instance; //already created so return from here.
		
		httpcl= HttpClient
				.newBuilder()
				.authenticator(
						new Authenticator() {
							@Override
							protected PasswordAuthentication getPasswordAuthentication() {
								return new PasswordAuthentication(uid,pwd.toCharArray());
							}
						})
				.build();
		
		return Instance;
	}
	
	
		
	public String makeGetCall(String url, HashMap<String,String> headerMaps) throws URISyntaxException, IOException, InterruptedException {
		
		Builder b = withBasicHeaders(HttpRequest.newBuilder(new URI(url)).GET());
		
		if(headerMaps !=null && headerMaps.size() > 0) headerMaps.forEach((k,v)-> b.header(k, v) );
		
		HttpResponse<String> res = httpcl.send(b.build(), BodyHandlers.ofString());
		
		return res.body();

	}
	
	
	public String makePostCall(String url, Map<String,String> formData) throws URISyntaxException, IOException, InterruptedException {
		
		Builder b = withBasicHeaders(HttpRequest.newBuilder(new URI(url)));
			
		b.POST(ofFormData(formData));
		
		HttpResponse<String> res = httpcl.send(b.build(), BodyHandlers.ofString());
		
		return res.body();

	}
	
	
	
	/**
	 * Just to avoid boiler plate code.
	 * @param reqb
	 * @return
	 */
	private Builder withBasicHeaders(Builder reqb) {
		reqb.header("Accept","application/json")
		.header("X-Killbill-ApiKey", "ckptestapikey")
		.header("X-Killbill-ApiSecret", "asdfghjkl")
		.header("X-Killbill-CreatedBy", "springboot");
		return reqb;
	}
	
	// Sample: 'password=123&custom=secret&username=abc&ts=1570704369823'
    public static HttpRequest.BodyPublisher ofFormData(Map<String, String> formData) {
    	
    	StringBuilder builder = new StringBuilder("blankkey=dummyVal");
    	
    	if(null== formData) return HttpRequest.BodyPublishers.ofString(builder.toString());
        
    	for (Map.Entry<String, String> entry : formData.entrySet()) {
            if (builder.length() > 0) {
                builder.append("&");
            }
            builder.append(URLEncoder.encode(entry.getKey(), StandardCharsets.UTF_8));
            builder.append("=");
            builder.append(URLEncoder.encode(entry.getValue(), StandardCharsets.UTF_8));
        }
    	
        return HttpRequest.BodyPublishers.ofString(builder.toString());
    }
	
    public Gson getGson() {return gson;}

    /**
     * Helper method to replace a/b/{}/c to a/b/v/c
     * @param u
     * @param v
     * @return
     */
    public static String replacePathParam(String p, String u, String v) {
    	int i = u.indexOf('{') ,j = u.indexOf('}');
    	return (p==null ? "" : p ) + u.substring(0,i) + v + u.substring(j+1);
    }
}
