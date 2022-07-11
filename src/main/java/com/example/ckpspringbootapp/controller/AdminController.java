package com.example.ckpspringbootapp.controller;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ckpspringbootapp.util.APIConfiguration;
import com.example.ckpspringbootapp.util.HttpIteractionHelper;
import com.example.ckpspringbootapp.util.MyCustomConfiguration;
import com.example.ckpspringbootapp.util.pojos.KBBizDate;
import com.google.gson.Gson;

@RestController
public class AdminController {
	@Autowired
	private MyCustomConfiguration ccfg;
	
	@Autowired
	private APIConfiguration apicfg;
	
	@RequestMapping("/changeDate")
	public String changeDate(@RequestParam("date") String cd) {
		
		String url = ccfg.getUrlBase() + "/"+ apicfg.getChangeclock()+cd;
		
		HttpIteractionHelper o = HttpIteractionHelper.getInstance(ccfg.getAuthUid(), ccfg.getAuthPwd());
		String res = "Error!";
		try {
			res = o.makePostCall(url, null);
			KBBizDate kbd = o.getGson().fromJson(res,KBBizDate.class);
			res = kbd.getLocalDate();
		} catch (URISyntaxException e) { System.out.println("post Url is wrong format!"+url);
		} catch (IOException e) { System.out.println("post IOException!");
		} catch (InterruptedException e) {System.out.println("post InterruptedException!");	}
		
		return res;
	}
}
