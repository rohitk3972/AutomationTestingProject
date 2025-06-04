package com.practice.page;

public class LoginPage extends CommonMethods {
	
	
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
		enterData("EmailOrPhone");
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
		enterData("Password");
		handleLogger("LoginPage","Entered Password");
	}

	//get text
	public void getFacebookText() {
		getWebElementText("FacebookText");
		handleLogger("LoginPage","Get facebook Text");
	}

	//click login button
	public void clickLoginButton(){
		clickWebElement("LoginButton");
		handleLogger("LoginPage","Clicked Login Button");
		
	}	
}
