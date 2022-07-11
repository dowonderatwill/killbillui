package com.example.ckpspringbootapp.util.pojos;

import java.util.ArrayList;

public class AccInvoiceInfo {
	
	private String amount;        
	private String currency;      
	private String status;        
	private String creditAdj;     
	private String refundAdj;     
	private String invoiceId;     
	private String invoiceDate;   
	private String targetDate;    
	private String invoiceNumber; 
	private String balance;       
	private String accountId;     
	private String bundleKeys;    
	private String credits;

	private ArrayList<Item> items;
	
	
	

	public ArrayList<Item> getItems() {
		return items;
	}
	public void setItems(ArrayList<Item> items) {
		this.items = items;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreditAdj() {
		return creditAdj;
	}
	public void setCreditAdj(String creditAdj) {
		this.creditAdj = creditAdj;
	}
	public String getRefundAdj() {
		return refundAdj;
	}
	public void setRefundAdj(String refundAdj) {
		this.refundAdj = refundAdj;
	}
	public String getInvoiceId() {
		return invoiceId;
	}
	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}
	public String getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(String invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
	public String getAccountId() {
		return accountId;
	}
	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}
	public String getBundleKeys() {
		return bundleKeys;
	}
	public void setBundleKeys(String bundleKeys) {
		this.bundleKeys = bundleKeys;
	}
	public String getCredits() {
		return credits;
	}
	public void setCredits(String credits) {
		this.credits = credits;
	}  

}
