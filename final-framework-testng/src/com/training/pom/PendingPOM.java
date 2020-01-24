package com.training.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.training.utility.DriverFactory;

public class PendingPOM {

	private WebDriver driver;
	

	public void PendingPOM() {
		this.driver = driver; 
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Account')]")
	private WebElement Acc;
	
	@FindBy(xpath="//span[contains(text(),'Loans')]")
	private WebElement loan;
	
	@FindBy(xpath="//img[@class='details view']")
	private WebElement view;
	
	@FindBy(xpath="//input[@id='amountText']")
	private WebElement txt;
	
	@FindBy(xpath="//table[@class='defaultTable']//input[@class='button']")
	private WebElement repay;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	@FindBy(xpath="//input[@id='memberUsername']")
	private WebElement un;
	
	@FindBy(xpath="//tr[8]//td[1]//fieldset[1]//table[1]//tbody[1]//tr[1]//td[2]//input[1]")
	private WebElement lview;
	
	@FindBy(xpath="//span[@class='menuText'][contains(text(),'Accounts')]")
	private WebElement accounts;
	
	
	public void Account(){
		Acc.click();
	}
	
	public void loan(){
		loan.click();
	}
	public void view(){
		view.click();
	}
	public void Entertext(String txt){
	this.txt.clear();
	this.txt.sendKeys(txt);
	}
	
	public void repay(){
		repay.click();
	}
	
	public void logout(){
		logout.click();
	}
	
	public void un(String un){
		this.un.clear();
		this.un.sendKeys(un);
			
	}
	public void lview(){
		lview.click();
	}
	
	public void account1(){
		accounts.click();
	}
}
