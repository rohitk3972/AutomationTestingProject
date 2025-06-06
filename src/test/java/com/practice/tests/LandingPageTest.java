package com.practice.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.practice.page.LandingPage;

public class LandingPageTest {
	
	@Test
	public void landingPageTest() throws IOException {
		
		LandingPage ld= new LandingPage();
		
		Assert.assertEquals(ld.cardCount(), 6);
	}

}
