package com.onecomics.webpages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.onecomics.projectmethods.ProjectMethods;

public class AuthenticationPage extends ProjectMethods {
	
	public AuthenticationPage() {
		 PageFactory.initElements(driver, this);
	 }

	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
	@FindBy(id = "AppleExchange")
	public static WebElement loginWithAppleBtn;
	
	@FindBy(id = "FacebookExchange")
	public static WebElement loginWithFacebookBtn;
	
	@FindBy(id = "GoogleExchange")
	public static WebElement loginWithGoogleeBtn;
	
	@FindBy(id = "signInName")
	public static WebElement emailIdTxtBox;
	
//	@FindBy(xpath = "(//div[@class='entry-item'])[1]")
//	public static WebElement emailIdTxtBox;

	@FindBy(id = "password")
	public static WebElement passwordTxtBox;
	
	@FindBy(id = "forgotPassword")
	public static WebElement forgotPasswordBtn;
	
	@FindBy(id = "next")
	public static WebElement signInBtn;
	
	@FindBy(id = "createAccount")
	public static WebElement signUpBtn;
	
	@FindBy(xpath = "//div[text()='PRE-REGISTER FOR BENEFITS']")
	public static WebElement preRegisterBtn;

	@FindBy(xpath = "//button[text()='FREE MINT ON SUI']")
	public static WebElement freeMintBtn;

	@FindBy(xpath = "//span[text()='All Set']")
	public static WebElement allSetText;

	@FindBy(xpath = "//img[@alt='Profile']")
	public static WebElement profileIcon;

	@FindBy(xpath = "//div[text()='COPY']")
	public static WebElement copyBtn;
	
	@FindBy(xpath = "//button[text()='LOGOUT']")
	public static WebElement logoutBtn;
	
	public void login(String id, String password) throws InterruptedException {
		clickElement(preRegisterBtn);		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("signInName")));
		Thread.sleep(2000);
		sendKeys(emailIdTxtBox, id);
//		emailIdTxtBox.sendKeys(id);
		sendKeys(passwordTxtBox, password);
		clickElement(signInBtn);
//		checkPageIsReady();
		Thread.sleep(8000);
		Assert.assertTrue(waitUntilTextIsPresent("All Set"));
		clickElement(profileIcon);
		clickElement(copyBtn);	
		clickElement(logoutBtn);
		Assert.assertTrue(waitUntilTextIsPresent("PRE-REGISTER FOR BENEFITS"));
	}

}
