package com.example.ckpspringbootapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.ckpspringbootapp.services.LaunchExecutorService;
import com.example.ckpspringbootapp.util.APIConfiguration;
import com.example.ckpspringbootapp.util.HttpIteractionHelper;
import com.example.ckpspringbootapp.util.MyCustomConfiguration;
import com.example.ckpspringbootapp.util.pojos.AccountInfo;
import com.example.ckpspringbootapp.util.pojos.KBBizDate;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

@Controller
public class MainController {
		
	@Autowired
	protected MyCustomConfiguration ccfg;
	
	@Autowired
	protected APIConfiguration acfg;
	
	//@Value("${admin.message}") If I want to pass the default values from application.properties.
	String respmsg ="blank";  
	
	protected HttpIteractionHelper o = null;
	
	@RequestMapping("/hello")
	public String sayHello(Model model) {
		
		respmsg = "Hello From Ckp!";
		model.addAttribute("message", respmsg);
		model.addAttribute("bizdate", "someinfo");
	
		return "admin";
	}
	
	@RequestMapping("/home")
	public String home(Model model) {
		o = HttpIteractionHelper.getInstance(ccfg.getAuthUid(), ccfg.getAuthPwd());
		CompletableFuture<String> future1 = callApiAsync(acfg.getGetclock())	.handle((m,e)-> (null==e) ? m : e.getMessage());
		CompletableFuture<String> future2 = callApiAsync(acfg.getGetaccounts())	.handle((m,e)-> (null==e) ? m : e.getMessage());
		
		try {							
			String s1 = future1.get();	
			String s2 = future2.get();
			KBBizDate kbd = o.getGson().fromJson(s1,KBBizDate.class);
			model.addAttribute("bizdate", kbd.getLocalDate());
			Type accInfoType = new TypeToken<ArrayList<AccountInfo>>() {}.getType();
			ArrayList<AccountInfo> list = o.getGson().fromJson(s2, accInfoType);
			for(AccountInfo a : list)   
				a.setInvoiceUrl(HttpIteractionHelper
				.replacePathParam(null,acfg.getAcctoinvoice(), a.getAccountId())); 
			model.addAttribute("accountinfolist", list); 
		} catch (InterruptedException e) {model.addAttribute("bizdate", "InterruptedException Occurred!");
		} catch (ExecutionException e) { model.addAttribute("bizdate", "ExecutionException Occurred!");	}
		return "admin";
	}
	
	
	/**
	 * Helper private method which executes the given url in different thread.
	 * @param urlsfx
	 * @return CompletableFuture<String> : This is the json returned by server. 
	 * The caller can create pojo, as caller would be knowing what to expect.
	 */
	private CompletableFuture<String> callApiAsync(String urlsfx){
		CompletableFuture<String> future = CompletableFuture.supplyAsync(()->{
			try{ return o.makeGetCall(ccfg.getUrlBase()+urlsfx, null);	}catch(Exception e) { e.printStackTrace(); return "error"+e.getMessage();}
		},LaunchExecutorService.getExecutors());
		
		return future;
	}

}
