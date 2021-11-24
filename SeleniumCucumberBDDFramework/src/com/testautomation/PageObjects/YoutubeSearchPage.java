package com.testautomation.PageObjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.testautomation.Utility.PropertiesFileReader;

public class YoutubeSearchPage 
{
	PropertiesFileReader obj= new PropertiesFileReader();

	WebDriver driver;
	
	public YoutubeSearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how=How.ID,using="search")
	public WebElement SearchTextbox;
	
	@FindBy(how=How.CSS,using="#search-icon-legacy")
	public WebElement SearchButton;
	
	@FindBy(how=How.ID,using="signInName")
	public WebElement userName;
	
	@FindBy(how=How.ID,using="password")
	public WebElement passWord;
	
	@FindBy(how=How.ID,using="next")
	public WebElement submit;
	
	@FindBy(how=How.XPATH,using="//span[@class='account-user-name']")
	public WebElement user;
		
	@FindBy(how=How.XPATH,using="//span[contains(.,'Logout')]")
	public WebElement logout;
	
	public void Login() {

		try {
			Properties properties = obj.getProperty();
			Thread.sleep(2000);
			userName.clear();
			userName.sendKeys(properties.getProperty("username"));
			Thread.sleep(1000);
			passWord.clear();
			passWord.sendKeys(properties.getProperty("password"));
			submit.click();
		} catch (Exception e) {
			e.printStackTrace();

		} 
	}

	public void NavigateToResultPage(String searchString)
	{
		SearchTextbox.sendKeys(searchString);
		SearchButton.click();
	}
	public void Logout() {

		try {
			Properties properties = obj.getProperty();
			Thread.sleep(2000);
			if(user.getText().equals("vijay neela")){
			user.click();
			Thread.sleep(1000);
			logout.click();
			
			}else{
				System.out.println("failed");
			}
			
		} catch (Exception e) {
			e.printStackTrace();

		} 
	}

}
