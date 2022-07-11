package com.example.ckpspringbootapp.services;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.springframework.stereotype.Component;

@Component
public class LaunchExecutorService {

	private static final ExecutorService es = Executors.newFixedThreadPool(2);
  
	private LaunchExecutorService() {};
	
	public static ExecutorService getExecutors() { return es;}
	
}
