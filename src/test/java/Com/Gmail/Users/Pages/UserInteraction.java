package Com.Gmail.Users.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

public class UserInteraction {
	WebDriver driver;
	ExtentTest test;

	public UserInteraction(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "userName")
	private WebElement userName;

	@FindBy(name = "password")
	private WebElement pwd;

	@FindBy(name = "submit")
	private WebElement submitBtn;

	@FindBy(xpath = "//h3[normalize-space()='Login Successfully']")
	private WebElement target;

	@FindBy(xpath = "//span[normalize-space()='Enter your userName and password correct']")
	private WebElement target1;

	@FindBy(xpath = "//h3[normalize-space()='Login Successfully']")
	private WebElement success;

	@FindBy(xpath = "//span[normalize-space()='Enter your userName and password correct']")
	private WebElement errMsg;

	public void getUserName(String un) {
		userName.clear();
		userName.sendKeys(un);
	}

	public void getPassword(String pwrd) {

		pwd.clear();
		pwd.sendKeys(pwrd);
	}

	public void getSubmitted() {
		System.out.println("I clicked the submit button");
		submitBtn.click();

	}

	public void LoginSuccess() {
		Assert.assertTrue(target.isDisplayed(), "Login success message not displayed");
		System.out.println("Login Successfully.");
	}

	public void LoginFails() {
		Assert.assertTrue(target1.isDisplayed(), "Error message not displayed");
		System.out.println("Login Failed....");
	}

	public void Run(String expectedResult) {
		if (expectedResult.equals("Login Successfully")) {
			Assert.assertEquals(success.getText(), "Login Successfully");
			System.out.println("Navigated to HomePage");
		} else if (expectedResult.equals("Enter your userName and password correct")) {
			Assert.assertEquals(errMsg.getText(), "Enter your userName and password correct");
			System.out.println("Error message appeared");
		} else {
			Assert.fail("Unexpected result: " + expectedResult);
		}
	}
}