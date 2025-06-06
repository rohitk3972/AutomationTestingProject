package com.practice.page;

import java.io.IOException;

import com.practice.genericPage.CommonMethods;


public class LoginPage extends CommonMethods {
	
	
	public LoginPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	//click email
	public void clickEmail() {
		clickWebElement("EmailOrPhone");
		handleLogger("LoginPage","Clicked on Email");
	}

	//clear email
	public void clearEmail() {
		clearData("EmailOrPhone");
		handleLogger("LoginPage","Cleared Email");
	}
	
	//enter email
	public void enterEmail() {
		enterData("EmailOrPhone","TestData1");
		handleLogger("LoginPage","Entered Email");
		
	}
	
	//click password
	public void clickPassword() {
		clickWebElement("Password");
		handleLogger("LoginPage","Clicked on Password");
	}
	
	//clear password
	public void clearPassword() {
		clearData("Password");
		handleLogger("LoginPage","Cleared Password");
	}

	//enter password
	public void enterPassword() {
		enterData("Password","TestData2");
		handleLogger("LoginPage","Entered Password");
	}

	//get text
	public String getFacebookText() {
		String abc="";
		getWebElementText("FacebookText");
		handleLogger("LoginPage","Get facebook Text");
		return abc;
	}

	//click login button
	public void clickLoginButton(){
		clickWebElement("LoginButton");
		handleLogger("LoginPage","Clicked Login Button");
		
	}
	
	public void blockNotification() {
		dismissAlert();
		handleLogger("LoginPage","Dismiss Show Notification");
		
	}	
		
	}	

