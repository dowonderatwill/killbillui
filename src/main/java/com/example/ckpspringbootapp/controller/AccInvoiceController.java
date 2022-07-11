package com.example.ckpspringbootapp.controller;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URISyntaxException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.ckpspringbootapp.util.APIConfiguration;
import com.example.ckpspringbootapp.util.HttpIteractionHelper;
import com.example.ckpspringbootapp.util.MyCustomConfiguration;
import com.example.ckpspringbootapp.util.pojos.AccInvoiceInfo;
import com.example.ckpspringbootapp.util.pojos.KBBizDate;
import com.google.gson.reflect.TypeToken;

@Controller
public class AccInvoiceController {

	@Autowired
	protected MyCustomConfiguration ccfg;
	
	@Autowired
	protected APIConfiguration acfg;
	
	//@Value("${admin.message}") If I want to pass the default values from application.properties.
	String respmsg ="blank";  
	
	protected HttpIteractionHelper o = null;

	@RequestMapping("/1.0/kb/accounts/{accountId}/invoices")
	public String getInvoices(@PathVariable("accountId") String a, Model m) {
		o = HttpIteractionHelper.getInstance(ccfg.getAuthUid(), ccfg.getAuthPwd());
		String url = HttpIteractionHelper.replacePathParam(ccfg.getUrlBase(), acfg.getAcctoinvoice(), a);
		try {
			String res = o.makeGetCall(url, null);
			Type t = new TypeToken<ArrayList<AccInvoiceInfo>>() {}.getType();
			ArrayList<AccInvoiceInfo> accInvList = o.getGson().fromJson(res,t);
			m.addAttribute("response", accInvList); 
		} catch (URISyntaxException e) { System.out.println("post Url is wrong format!"+url);
		} catch (IOException e) { System.out.println("post IOException!");
		} catch (InterruptedException e) {System.out.println("post InterruptedException!");	} 
		return "accounts";
	}
	
	@RequestMapping("/1.0/kb/accounts/{accountId}/test")
	public String getTest(@PathVariable("accountId") String a, Model m) {
		System.out.println("getTest");
		return "accounts";
	}
}
