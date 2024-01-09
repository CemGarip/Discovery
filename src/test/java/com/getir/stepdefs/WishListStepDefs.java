package com.getir.stepdefs;

import com.getir.Pages;
import com.getir.utils.BasePage;
import cucumber.api.java.en.Then;

public class WishListStepDefs extends BasePage{
    Pages pages = new Pages();
    @Then("user checks model order is alphabetical in wishlist table")
    public void userChecksModelOrderIsAlphabeticalInWishlistTable() {
        pages.wishListPage().checksModelOrderIsAlphabetical();
    }

    @Then("user checks wishlist is empty")
    public void userChecksWishlistIsEmpty() {
        pages.wishListPage().checkWishlistEmpty();
    }

    @Then("user chose cheaper product and adds to cart")
    public void userChoseCheaperProductAndAddsToCart() {
        pages.wishListPage().choseCheaperProductAndAddsToCart();
    }

    @Then("user fills gift certificate purchase fields")
    public void userFillsGiftCertificatePurchaseFields() {
        pages.wishListPage().fillsGiftCertificatePurchaseFields();
    }
}
