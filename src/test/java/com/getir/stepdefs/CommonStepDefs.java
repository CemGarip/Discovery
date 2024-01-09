package com.getir.stepdefs;

import com.getir.Pages;
import com.getir.utils.BasePage;
import com.getir.utils.WaitUtils;
import com.getir.utils.manipulators.HtmlManipulator;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class CommonStepDefs extends BasePage{

	Pages pages = new Pages();


	@Given("user hovers {string} tab and selects {string} option")
	public void followThePath(String subTabName,String option){
		pages.headerSection().navigateSubTab(subTabName,option);
	}

//	@And("verify there is a popup with text {string} and click on {string}")
//	public void verifyThereIsAPopupWithTextAndClickOn(String popupText, String button){
//		pages.headerSection().verifyPopup(popupText);
//		if(!button.equals(Constants.NONEACTIONTEXT))
//			HtmlManipulator.clickOnButton(button);
//	}
	@And("user clicks {string} button")
	public void userClickButton(String button){
			HtmlManipulator.clickOnButton(button);
	}

	@And("user waits {int} second")
	public void waitStep(int waitValue){
		WaitUtils.waitFor(waitValue);
	}
	@Then("user clicks {string} button from button group")
	public void userButtonOnThePage(String buttonName) {
		pages.shoppingPage().buttonOnPage(buttonName);
	}

	@Then("user checks alert {string} has message")
	public void userChecksAlertHasMessage(String message) {
		pages.shoppingPage().checksAlertHasMessage(message);
	}

	@Then("user navigates {string} page and selects {string} tab")
	public void userNavigatesPage(String pageValue,String ddTabValue) {
		pages.headerSection().navigatePage(pageValue,ddTabValue);
	}

	@Then("user checks bread crumbing trail is {string}")
	public void userChecksBreadCrumbingTrailIs(String breadCrumb) {
		pages.headerSection().breadCrumbingTrailIs(breadCrumb);
	}

	@Then("user clicks {string} product")
	public void userClicksProduct(String productName) {
		pages.shoppingPage().clickOnProduct(productName);
	}

	@Then("user checks {string} is {string}")
	public void userChecksIs(String field, String isExist) {
		pages.wishListPage().checkIsExist(field,isExist);
	}

	@Then("user clicks on hyperlink text {string} from alert pop up")
	public void userClicksOnHyperlinkTextFromAlertPopUp(String hrefAlert) {
		pages.wishListPage().clicksOnHyperlinkTextFromAlertPopUp(hrefAlert);
	}

	@Then("user navigates {string} page from bottom of the page")
	public void userNavigatesPageFromBottomOfThePage(String containerNavigator) {
		pages.wishListPage().navigatePageFromBottomOfThePage(containerNavigator);
	}
}
