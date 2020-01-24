package stepDefinition;

import java.io.FileInputStream;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.training.generics.ScreenShot;
import com.training.pom.LoginPOM;
import com.training.pom.ManageLoanPOM;
import com.training.utility.DriverFactory;
import com.training.utility.DriverNames;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Manageloans {
	
	WebDriver driver;
	private String baseUrl;
	private ManageLoanPOM ManagePOM;
	private static Properties properties;
	private ScreenShot screenShot;
	private LoginPOM lgpm;
	
	
	@Given("^Logged in as admin$")
	public void logged_in_as_admin() throws Throwable 
	{
		properties = new Properties();
		FileInputStream inStream = new FileInputStream("./resources/others.properties");
		properties.load(inStream);
		driver = DriverFactory.getDriver(DriverNames.CHROME);
		ManagePOM = new ManageLoanPOM(driver); 
		baseUrl = properties.getProperty("baseURL");
		screenShot = new ScreenShot(driver); 
		// open the browser 
		driver.get(baseUrl);
		driver.get("http://localhost:8585/");
		//driver.navigate().to("http://localhost:8585/");


		//System.setProperty("webdriver.chrome.driver", "E:\\seleniumGH20software\\chromedriver_win32\\chromedriver.exe");
	   // driver=new ChromeDriver();
	    
	    
	    driver.findElement(By.xpath("//input[@id='cyclosUsername']")).sendKeys("admin");
	    driver.findElement(By.xpath("//body[@class='login']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='loginTable']/tbody/tr/td[@class='loginFormContainer']/table[@class='nested loginFormTable']/tbody/tr/td[@class='loginForm']/form[@id='cyclosLogin']/table[@class='nested']/tbody/tr/td/div[@id='virtualKeyboard']/div/input[1]")).click();
		driver.findElement(By.xpath("//body[@class='login']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='loginTable']/tbody/tr/td[@class='loginFormContainer']/table[@class='nested loginFormTable']/tbody/tr/td[@class='loginForm']/form[@id='cyclosLogin']/table[@class='nested']/tbody/tr/td/div[@id='virtualKeyboard']/div/input[2]")).click();
		driver.findElement(By.xpath("//body[@class='login']/div[@id='topContainer']/div[@class='topContainerBorder']/div[@id='topTable']/div[@id='tdContents']/table[@class='loginTable']/tbody/tr/td[@class='loginFormContainer']/table[@class='nested loginFormTable']/tbody/tr/td[@class='loginForm']/form[@id='cyclosLogin']/table[@class='nested']/tbody/tr/td/div[@id='virtualKeyboard']/div/input[3]")).click();
		driver.findElement(By.xpath("//input[4]")).click();
		driver.findElement(By.xpath("//div[@id='virtualKeyboard']//div//input[@class='button']")).click();
		//driver.manage().window().maximize();
		/*lgpm.sendUserName("admin");
		lgpm.sendPassword();
		lgpm.clickLoginBtn();*/
		
	}

	@When("^Admin enters valid credentials$")
	public void admin_enters_valid_credentials() throws Throwable 
	{
		ManagePOM.clickaccount();
		ManagePOM.clickmanageloan();
		ManagePOM.entermemberlogin("Dhwani");
		driver.quit();
		
		
	}

	@Then("^Loan details of user should be displayed$")
	public void loan_details_of_user_should_be_displayed() throws Throwable {
	    
		ManagePOM.clicksearch();
		ManagePOM.clickview();
		
		String actual="Loan details";
		String expected=driver.findElement(By.xpath("//td[contains(text(),'Loan details')]")).getText();
		Assert.assertEquals(actual, expected);
		System.out.println(expected);
	}
}