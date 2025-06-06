package com.practice.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.practice.genericPage.MasterPage;
import com.practice.page.LoginPage;

public class LoginTest {
	
	@Test
	public void loginTest() throws IOException, InterruptedException {
		
		LoginPage lp= new LoginPage();
		
		lp.clickEmail();
		lp.enterEmail();
		lp.clickPassword();
		lp.enterPassword();
		lp.clickLoginButton();
		Thread.sleep(30000);
		Assert.assertEquals(lp.getText(),"Account Services");
	  //  Thread.sleep(3000);
		//lp.clearEmail();
		//Thread.sleep(3000);
		//lp.readExcelData("EmailOrPhone", 3, 1);
		//Thread.sleep(3000);
		//lp.clearPassword();
		//Thread.sleep(3000);
		//lp.readExcelData("Password", 3, 2);
			
	}
	
	@AfterMethod
	public void takeScreenshot(ITestResult result) throws IOException {
		LoginPage lp= new LoginPage();
		lp.captureScreenshot(result);
	}
	
	@AfterClass
	public static void closeLoginPage() {
		MasterPage.driver.close();
	}

}
