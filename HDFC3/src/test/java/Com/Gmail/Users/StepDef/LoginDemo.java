package Com.Gmail.Users.StepDef;

import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.But;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class LoginDemo {
	@Given("I navigate to login page")
	public void i_navigate_to_login_page() {
		System.out.println("Navigated to login page");
		// Assert.assertEquals("a", "b");
		;
		// throw new io.cucumber.java.PendingException();
	}

	@And("I entered username and password")
	public void i_entered_username_and_password() {
		System.out.println("Correct credentials were entered");
		// throw new io.cucumber.java.PendingException();
	}

	@And("I entered username and invalid password")
	public void i_entered_username_and_Invalidpassword() {
		System.out.println("wrong credentials were entered");
		// throw new io.cucumber.java.PendingException();
	}

	@And("I clicked signin button")
	public void i_clicked_signin_button() {
		System.out.println("Clicked signin button");
		// throw new io.cucumber.java.PendingException();
	}

	@Then("Its navigated to the HomePage")
	public void its_navigated_to_the_home_page() {
		System.out.println("Navigated to HomePage");
		// throw new io.cucumber.java.PendingException();
	}

	@But("Invalid pwd")
	public void Invalidpassword() {
		System.out.println("Wrong password entered");
	}

	@Then("Its navigated to the error message")
	public void its_navigated_to_the_error_message() {
		System.out.println("Login failed");
		Assert.assertEquals("error", "error");
	}
}