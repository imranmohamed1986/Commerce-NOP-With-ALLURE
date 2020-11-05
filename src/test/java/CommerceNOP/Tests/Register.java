package CommerceNOP.Tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Step;
import io.qameta.allure.Story;

@Listeners({ AllureListener.class })
public class Register extends BasePage {

	public WebDriver driver;

	@BeforeClass
	public void setUp() {
		BasePage bs = new BasePage();
		driver = bs.initialize_driver();
		driver.get("https://demo.nopcommerce.com/");

	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 0, description = "Verify Register Button on Home Page")
	@Description("Verify RegisterButton on Home Page........")
	@Epic("EP001")
	@Feature("Feature1: Register")
	@Story("Story:RegisterButton Presence")
	@Step("Register Button Presence")

	public void validatingRegisterButton() throws InterruptedException {

		driver.findElement(By.xpath("//a[@class='ico-register']")).click();
		Thread.sleep(5000);
		boolean flag = driver.findElement(By.xpath("//a[@class='ico-register']")).isDisplayed();
		Assert.assertTrue(flag, "Register Button Verified");

	}

	@Severity(SeverityLevel.CRITICAL)
	@Test(priority = 1, description = "Verify Credentials on Home Page")
	@Description("Verify Credentials on Home Page........")
	@Epic("EP001")
	@Feature("Feature1: Credentials")
	@Story("Story:RegisterCredentials")
	@Step("Register Credentials")
	public void enterCredentials() throws InterruptedException {

		driver.findElement(By.name("Gender")).click();
		Thread.sleep(5000);
		driver.findElement(By.name("FirstName")).sendKeys("mohamed");
		Thread.sleep(3000);
		driver.findElement(By.name("LastName")).sendKeys("Imran");
		Thread.sleep(3000);
		Select DropDown = new Select(driver.findElement(By.name("DateOfBirthDay")));
		DropDown.selectByVisibleText("6");
		Thread.sleep(3000);
		Select DropDown1 = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		DropDown1.selectByVisibleText("October");
		Thread.sleep(3000);
		Select DropDown2 = new Select(driver.findElement(By.name("DateOfBirthYear")));
		DropDown2.selectByVisibleText("1986");
		Thread.sleep(3000);
		driver.findElement(By.name("Email")).sendKeys("narmi53@yahoo.com");
		Thread.sleep(3000);
		driver.findElement(By.name("Company")).sendKeys("Mo and Sons");
		Thread.sleep(3000);
		driver.findElement(By.name("Password")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.name("ConfirmPassword")).sendKeys("123456");
		Thread.sleep(3000);
		driver.findElement(By.name("register-button")).click();
		Thread.sleep(3000);
		boolean flag2 = driver.findElement(By.xpath("//div[@class='result']")).isDisplayed();
		Assert.assertTrue(flag2, "Account Created");

	}

	  @Severity(SeverityLevel.NORMAL)
	  @Test(priority = 2, description = "Verify logOut on Home Page")
	  @Description("logOut on Home Page........")
	  @Epic("EP001")
	  @Feature("Feature1: logOut")
	  @Story("Story:logOut")
	  @Step("logOut") 
	  public void logOut() throws InterruptedException {
	  
	  driver.findElement(By.name("register-continue")).click(); Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[text()='Log out']")).click();
	  Thread.sleep(3000); String Login =
	  driver.findElement(By.xpath("//a[text()='Log in']")).getText();
	  Assert.assertEquals(Login, "Log in", "ButtonAvailable"); }
	 

	
	  @AfterClass 
	  public void tearDown() { 
		  driver.quit(); 
		  }
	 
}