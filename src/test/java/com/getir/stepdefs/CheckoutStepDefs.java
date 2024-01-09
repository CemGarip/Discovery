package com.getir.stepdefs;

import com.getir.Pages;
import com.getir.utils.BasePage;
import cucumber.api.java.en.Then;

public class CheckoutStepDefs extends BasePage{
    Pages pages = new Pages();

    @Then("user fills payment address")
    public void userFillsPaymentAddress() {
        pages.checkoutPage().fillPaymentAddress();
    }

    @Then("user fills logIn credentials with Register Account option")
    public void userFillsLogInCredentials() {
        pages.checkoutPage().fillsLogInCredentials();
    }

    @Then("user selects shipping and payment method")
    public void userSelectsShippingAndPaymentMethod() {
        pages.checkoutPage().selectsShippingAndPaymentMethod();
    }

}
