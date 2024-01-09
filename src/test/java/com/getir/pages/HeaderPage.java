package com.getir.pages;

import com.getir.utils.BasePage;
import com.getir.utils.Driver;
import com.getir.utils.WaitUtils;
import com.getir.utils.manipulators.HtmlManipulator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import static com.getir.utils.manipulators.HtmlManipulator.hover;

public class HeaderPage extends BasePage {
	@FindBy(css = "section#alertify:not(.alertify-hide) p.alertify-message")
	public WebElement txt_Popup_HeaderPage;

	public HeaderPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	public void navigateSubTab(String subTabName,String option){
		By subTabLocator = By.xpath("//div[contains(@class,'navbar')]//a[contains(.,\""+subTabName+"\")]");
		WebElement tabElement = WaitUtils.waitForClickability(subTabLocator);
		hover(tabElement);
		By optionLocator = By.xpath("//li//a[contains(text(),\""+option+"\")]");
		WebElement optionElement = WaitUtils.waitForClickability(optionLocator);
		WaitUtils.waitElementInteractableWithClicking(optionElement);
		WaitUtils.waitForPageToLoad(5);
		logger.info("Navigated To " + subTabName +" and "+option+" tab");
	}
	public void logOut(){
		pages.loginPage().txt_MyAccount_TopText.click();
		pages.loginPage().txt_Logout_TopText.click();
		logger.info("User logs out");
	}
	public void verifyPopup(String popupText){
		WaitUtils.waitUntilCondition(()->txt_Popup_HeaderPage.isDisplayed());
		String actual = txt_Popup_HeaderPage.getText();
		Assert.assertEquals(popupText,actual);
		log("Popup text confirmed as -> %s",popupText);
	}
	public void navigatePage(String pageValue,String ddTabValue) {
		if (pageValue.equalsIgnoreCase("My Account")){
			By pageLocator = By.xpath("//a//span[contains(text(),\""+pageValue+"\")]");
			WebElement pageElement = WaitUtils.waitForClickability(pageLocator);
			WaitUtils.waitElementInteractableWithClicking(pageElement);

			By tabLocator = By.xpath("//li[@class='list-inline-item']//a[text()=\""+ddTabValue+"\"]");
			WebElement tabElement = WaitUtils.waitForClickability(tabLocator);
			WaitUtils.waitElementInteractableWithClicking(tabElement);
		}
		By pageLocator = By.xpath("//a//span[contains(text(),\""+pageValue+"\")]");
		WebElement pageElement = WaitUtils.waitForClickability(pageLocator);
		WaitUtils.waitElementInteractableWithClicking(pageElement);
		logger.info("Navigated To " + pageValue +" and "+ddTabValue+" tab");
	}
	public void breadCrumbingTrailIs(String breadCrumb) {
		String breadCrumbTrailActual = Driver.getDriver().findElement(By.xpath("//li[@class='breadcrumb-item']/a[text()='\""+breadCrumb+"\"]")).getText();
		HtmlManipulator.assertContains(breadCrumb,breadCrumbTrailActual);
		logger.info("Navigated To " + breadCrumb);
	}
}
