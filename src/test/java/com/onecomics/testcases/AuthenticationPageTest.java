package com.onecomics.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onecomics.base.BaseClass;
import com.onecomics.webpages.LandingPage;
import com.onecomics.webpages.AuthenticationPage;

public class AuthenticationPageTest extends BaseClass{
	
	AuthenticationPage loginpage;
	
	@BeforeMethod
	public void initialSetup() {
		loginpage = new AuthenticationPage();		
	}
	
	@Test  (priority = 1)
	public void verifyLoginPage() throws InterruptedException {
		loginpage.login("kunal.anarse@eminds.ai", "Test@1234");
	}

}
