package com.practice.page;

import java.io.IOException;

import com.practice.genericPage.CommonMethods;

public class LandingPage extends CommonMethods{

	public LandingPage() throws IOException {
		super();
		// TODO Auto-generated constructor stub
	}

	public long  cardCount() {
		return countWebElements("ElementCount");
				
	}

}
