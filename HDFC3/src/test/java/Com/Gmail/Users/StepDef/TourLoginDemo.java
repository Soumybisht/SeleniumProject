package Com.Gmail.Users.StepDef;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;

import Com.Gmail.Users.Pages.UserInteraction2;
import Com.Gmail.Users.hooks.Hooks;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.But;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TourLoginDemo {

	UserInteraction2 ui;
	WebDriver driver = Hooks.driver;
	ExtentTest test = Hooks.test;

	@Given("I navigated to login page")
	public void i_navigated_to_login_page() {
		ui = new UserInteraction2(driver, test);
		driver.get("https://demo.guru99.com/test/newtours/");
		System.out.println("Navigated to login page");
	}

	@And("I entered the username and password")
	public void i_entered_the_username_and_password() {
		ui.getUserName("mercury");
		ui.getPassword("mercury");
	}

	@And("I clicked the signin button")
	public void i_clicked_the_signin_button() {
		ui.getSubmitted();
	}

	@Then("Its navigated to the HomePage correctly")
	public void its_navigated_to_the_home_page_correctly() {
		ui.LoginSuccess();
	}

	@But("Invalid password")
	public void invalid_password() {
		ui.getPassword("dsfasdfsdf");
	}

	@Then("It navigates to the Error Page")
	public void it_navigates_to_the_error_page() {
		ui.LoginFails();
	}

	@When("I entered following details")
	public void i_entered_following_details(DataTable dataTable) {
		List<List<String>> ele = dataTable.cells();
		for (int i = 1; i < dataTable.height(); i++) {
			ui.getUserName(ele.get(i).get(0));
			ui.getPassword(ele.get(i).get(1));
		}
		System.out.println("credentials were entered");
	}

	@When("I insert {string} and {string}")
	public void i_insert_and(String name, String pass) {
		ui.getUserName(name);
		ui.getPassword(pass);
		System.out.println("credentials were entered using scenario outline");
	}

	@Then("Its navigated to the {string}")
	public void its_navigated_to_the(String expectedResult) {
		boolean result = ui.Run(expectedResult);
		try {
			Assert.assertTrue(result, "There was some issue while running the testcase");
			System.out.println("Success");
		} catch (AssertionError ae) {
			System.out.println("Failure... Assertion failed: ");
		}
	}
}