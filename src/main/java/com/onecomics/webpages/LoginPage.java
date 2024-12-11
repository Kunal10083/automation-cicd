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

public class LoginPage extends ProjectMethods {
	
	public LoginPage() {
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
		sendKeys(emailIdTxtBox, id);
//		emailIdTxtBox.sendKeys(id);
		sendKeys(passwordTxtBox, password);
		clickElement(signInBtn);
//		Assert.assertTrue(waitUntilTextIsPresent("All Set"));
//		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("allSetText")));
//		System.out.println(allSetText.getText());
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//img[@alt='Profile']")));
		clickElement(profileIcon);
		clickElement(copyBtn);	
		clickElement(logoutBtn);
		Assert.assertTrue(waitUntilTextIsPresent("PRE-REGISTER FOR BENEFITS"));
	}

}
