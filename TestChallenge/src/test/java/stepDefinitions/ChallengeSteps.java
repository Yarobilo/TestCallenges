package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.By;

import base.BaseTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChallengeSteps extends BaseTest {

	BaseTest bt = new BaseTest();

	@Given("user is on the challenge page")
	public void user_is_on_the_challenge_page() throws IOException, InterruptedException {
		bt.setUp();
	}

	@When("^user enters (.*)$")
	public void user_enters(String CNP) {

		driver.findElement(By.xpath(locators.getProperty("input"))).sendKeys(bt.ValidCNP(CNP));

	}

	@And("clicks on checkValidity button")
	public void clicks_on_check_validity_button() {

		driver.findElement(By.xpath(locators.getProperty("validityBtn"))).click();

	}

	@Then("close browser")
	public void close_browser() throws InterruptedException {
		

		if (driver.getPageSource().contains(" YOU HAVE DONE IT. Please enter your name.")) {

			bt.tearDown();
		}

	}

}
