package org.step;

import java.io.IOException;

import org.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pojo.LoginPojo;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinition extends BaseClass{
	
	public LoginPojo login;
	
	@Given("user is on facebook login page")
	public void user_is_on_facebook_login_page() {
	  loadBrowser();
	  maxiWindow();
	  loadUrl("https://www.facebook.com/");
	}

	@When("user enters the invalid username and invalid password")
	public void user_enters_the_invalid_username_and_invalid_password() throws IOException {
		login=new LoginPojo();
		fill(login.getTxtUsername(), excelRead("D:\\eclipse-workspace\\FinalCucumber\\ExcelSheets\\Login.xlsx", "Input", 1, 0));
		fill(login.getTxtPassword(), excelRead("D:\\eclipse-workspace\\FinalCucumber\\ExcelSheets\\Login.xlsx", "Input", 1, 1));
	   
	}

	@Then("user clicks on the login button")
	public void user_clicks_on_the_login_button() throws IOException, InterruptedException {
      click(login.getBtnLogin());
      Thread.sleep(3000);
      takessnap("facebook");
	}

	@Then("user verifies the login functionality")
	public void user_verifies_the_login_functionality() {
	    System.out.println("Verified");
	}

	@When("user clicks on the forgot password link")
	public void user_clicks_on_the_forgot_password_link() {
	   login=new LoginPojo();
	   click(login.getLnkForgotPassword());
	}

	@Then("user enters the mobile number for the password recovery")
	public void user_enters_the_mobile_number_for_the_password_recovery() {
		login=new LoginPojo();
		fill(login.getTxtMobileNo(),"8754544243");
	}

	@Then("user validates the forgot password page")
	public void user_validates_the_forgot_password_page() {
	   System.out.println("Forgotten Page validated");
	}

}
