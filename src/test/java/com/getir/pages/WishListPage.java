package com.getir.pages;

import com.github.javafaker.Faker;
import com.getir.Pages;
import com.getir.utils.BasePage;
import com.getir.utils.Driver;
import com.getir.utils.WaitUtils;
import com.getir.utils.manipulators.HtmlManipulator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WishListPage extends BasePage {
    Faker faker = new Faker();
    Pages pages = new Pages();
    @FindBy(css = "#wishlist")
    public WebElement txt_Wishlist_Information;
    @FindBy(xpath = "//td[@class='text-center'][1]//button[text()='Add to Cart']")
    public WebElement button_First_Product_Add_Cart_ComparePage;
    @FindBy(xpath = "//div[1]/label[contains(text(),'Recipient')]/..//input")
    public WebElement input_Recipient_Name_GiftCertificatePage;
    @FindBy(xpath = "//div[2]/label[contains(text(),'Recipient')]/..//input")
    public WebElement input_Recipient_Email_GiftCertificatePage;
    @FindBy(xpath = "//label[contains(text(),'Gift ')]/..//input[@value='7']")
    public WebElement cb_Gift_Theme_GiftCertificatePage;

    public void checkIsExist(String field, String isExist) {
        WaitUtils.waitFor(2);
        String checkingField = String.format("//table[@class='table table-sm table-striped']/tbody/tr/td/a[text()='%s']", field);

        if (isExist.equalsIgnoreCase("exist")) {
            WebElement checkingElement = HtmlManipulator.findElementByXpath(checkingField);
            Assert.assertTrue(HtmlManipulator.doesElementExist(checkingElement));
        } else {
            List<WebElement> fields = Driver.getDriver().findElements(By.xpath(checkingField));
            Assert.assertTrue(fields.isEmpty());
        }
        logger.info("Product {} exist", field);
    }

    public void checksModelOrderIsAlphabetical() {
        ArrayList<String> obtainedList = new ArrayList<>();
        WaitUtils.waitFor(1);
        List<WebElement> elementList = Driver.getDriver().findElements(By.xpath("//tbody/tr/td[3][@class='text-start']"));
        for (WebElement webEl : elementList) {
            obtainedList.add(webEl.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String sortEl : obtainedList) {
            sortedList.add(sortEl);
        }
        Collections.sort(sortedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
        logger.info("Model order in alphabetical checked.");
    }

    public void checkWishlistEmpty() {
        String textActual = txt_Wishlist_Information.getText();
        Assert.assertEquals("Your wish list is empty.", textActual);
        logger.info("Account wishlist empty.");
    }

    public void clicksOnHyperlinkTextFromAlertPopUp(String hrefAlert) {
        By hrefLocator = By.xpath("//div[@class='alert alert-success alert-dismissible']//a[text()=\"" + hrefAlert + "\"]");
        WebElement hrefElement = WaitUtils.waitForClickability(hrefLocator);
        WaitUtils.waitElementInteractableWithClicking(hrefElement);
        logger.info("User clicked {} part in the alert.", hrefAlert);
    }

    public void choseCheaperProductAndAddsToCart() {
        WaitUtils.waitElementInteractableWithClicking(button_First_Product_Add_Cart_ComparePage);
        logger.info("Cheaper product selected.");
    }

    public void navigatePageFromBottomOfThePage(String containerNavigator) {
        By containerLocator = By.xpath("//div[@class='container']//a[text()=\"" + containerNavigator + "\"]");
        WebElement containerElement = WaitUtils.waitForClickability(containerLocator);
        WaitUtils.waitElementInteractableWithClicking(containerElement);
        logger.info("{} clicked from bottom navigator.", containerNavigator);
    }

    public void fillsGiftCertificatePurchaseFields() {
        WaitUtils.waitElementInteractableWithSendKeys(input_Recipient_Name_GiftCertificatePage).sendKeys("GetirGift");
        WaitUtils.waitElementInteractableWithSendKeys(input_Recipient_Email_GiftCertificatePage).sendKeys("gift@mail.com");
        WaitUtils.waitElementInteractableWithClicking(cb_Gift_Theme_GiftCertificatePage);
        HtmlManipulator.clickOnButton("Continue");
        logger.info("Gift Certificate purchased.");
    }
}
