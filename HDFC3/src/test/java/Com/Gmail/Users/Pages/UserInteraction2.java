package Com.Gmail.Users.Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Com.Gmail.Users.Config.Reports;

public class UserInteraction2 extends Reports {
	WebDriver driver;
	ExtentTest test;
	WebDriverWait wait;

	public UserInteraction2(WebDriver driver, ExtentTest test) {
		this.driver = driver;
		this.test = test;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(4));
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
		wait.until(ExpectedConditions.visibilityOf(userName));
		try {

			generateReport(driver, test, Status.PASS, "Username valid");
			userName.sendKeys(un);

		} catch (Exception e) {
			generateReport(driver, test, Status.FAIL, "Username not found");
		}

	}

	public void getPassword(String pwrd) {

		pwd.clear();
		wait.until(ExpectedConditions.visibilityOf(pwd));
		try {
			generateReport(driver, test, Status.PASS, "password entered");
			pwd.sendKeys(pwrd);
		} catch (Exception e) {
			generateReport(driver, test, Status.FAIL, "Invalid password");
		}

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

	public boolean Run(String expectedResult) {
		boolean actResult = true;
		try {
			if (expectedResult.equals("Login Successfully")) {
				Assert.assertEquals(success.getText(), "Login Successfully");
				System.out.println("Navigated to HomePage");
				generateReport(driver, test, Status.PASS, "Valid User");
			} else if (expectedResult.equals("Enter your userName and password correct")) {
				actResult = false;
				Assert.assertEquals(errMsg.getText(), "Enter your userName and password correct");
				System.out.println("Error message appeared");
				generateReport(driver, test, Status.FAIL, "InValid User, Check your username or password");
			} else {
				Assert.fail("Unexpected result: " + expectedResult);
			}
		} catch (Exception e) {
			actResult = false;
			Reports.generateReport(driver, test, Status.FAIL, "Something went wrong");
		}
		return actResult;
	}
}