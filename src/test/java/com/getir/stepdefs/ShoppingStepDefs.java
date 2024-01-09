package com.getir.stepdefs;

import com.getir.Pages;
import com.getir.utils.BasePage;
import cucumber.api.java.en.Then;


public class ShoppingStepDefs extends BasePage{
    Pages pages = new Pages();

    @Then("user checks header cart {string}")
    public void userChecksHeaderCart(String headerField) {
        pages.shoppingPage().checkHeaderCart(headerField);
    }

    @Then("user checks payment table {string} field price is {string}")
    public void userChecksPaymentTableFieldPriceIs(String rowName, String priceValue) {
        pages.shoppingPage().checkPaymentTableFieldPriceIs(rowName,priceValue);
    }

    @Then("user edits quantity field as {string} and clicks {string}")
    public void userEditsQuantityFieldAsAndClicks(String quantity, String buttonName) {
        pages.shoppingPage().editQuantityFieldAsAndClick(quantity,buttonName);
    }

    @Then("user fills estimate shipping fields")
    public void userFillsEstimateShippingFields() {
        pages.shoppingPage().fillEstimateShippingFields();
    }

    @Then("user enters coupon code {string}")
    public void userEntersCouponCode(String couponCode) {
        pages.shoppingPage().enterCouponCode(couponCode);
    }

    @Then("user enters gift certificate code {string}")
    public void userEntersGiftCertificateCode(String giftCertificateCode) {
        pages.shoppingPage().enterGiftCertificateCode(giftCertificateCode);
    }

    @Then("user returns product with filling product return form")
    public void userReturnsProductWithFillingProductReturnForm() {
        pages.shoppingPage().returnsProductWithFillingProductReturnForm();
    }

    @Then("user sort by list {string}")
    public void userSortByList(String sortOption) {
        pages.shoppingPage().sortByList(sortOption);
    }

    @Then("user checks that the order of prices is correct")
    public void userChecksThatTheOrderOfPricesIsCorrect() {
        pages.shoppingPage().orderOfPricesIsCorrect();
    }
}
