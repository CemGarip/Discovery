package com.getir.stepdefs;

import com.getir.Pages;
import com.getir.utils.BasePage;
import com.getir.utils.objects.User;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class LoginStepDefs extends BasePage{

	Pages pages = new Pages();
	@Given("log in with user {string}")
	public void loginWithEmail(String userKeyword){
		pages.loginPage().login(new User(userKeyword));
	}
	@And("log out")
	public void logOut(){
		pages.headerSection().logOut();
	}

    @Then("user clicks forgotten password and try to change password with invalid email")
    public void userClicksForgottenPasswordAndTryToChangePasswordWithInvalidEmail() {
		pages.loginPage().clicksForgottenPasswordAndTryToChangePasswordWithInvalidEmail();
    }

	@Then("user tries to login with invalid user")
	public void userTriesToLoginWithInvalidUser() {
		pages.loginPage().loginWithInvalidUser();
	}

	@Then("user checks blank field errors")
	public void userChecksBlankFieldErrors() {
		pages.loginPage().checksBlankFieldErrors();
	}

	@Then("user fills register account fields")
	public void userFillsRegisterAccountFields() {
		pages.loginPage().fillsRegisterAccountFields();
	}
}
