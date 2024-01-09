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
import org.openqa.selenium.support.PageFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
public class ShoppingPage extends BasePage {

    Faker faker = new Faker();
    Pages pages = new Pages();

    @FindBy(css = ".alert")
    public WebElement txt_Alert_Success;
    @FindBy(xpath = "//button[@data-bs-toggle='dropdown']")
    public WebElement button_Header_Cart;
    @FindBy(css = "li .text-center")
    public WebElement txt_Header_Cart_Empty;
    @FindBy(css = "li .text-start")
    public WebElement txt_Header_Cart_Has_Product;
    @FindBy(css = "tbody .input-group input[name='quantity']")
    public WebElement input_Quantity_ShoppingCartPage;
    @FindBy(xpath = "//td//button[@class='btn btn-primary']")
    public WebElement button_Update_ShoppingCartPage;
    @FindBy(xpath = "//td//button[@class='btn btn-danger' and @formaction]")
    public WebElement button_Remove_ShoppingCartPage;
    @FindBy(xpath = "//select[@name='country_id']")
    public WebElement dd_Country_ShoppingCartPage;
    @FindBy(xpath = "//select[@name='country_id']/option[@value='3']")
    public WebElement dd_Country_Option_ShoppingCartPage;
    @FindBy(xpath = "//select[@name='zone_id']")
    public WebElement dd_Region_ShoppingCartPage;
    @FindBy(xpath = "//select[@name='zone_id']/option[@value='3']")
    public WebElement dd_Region_Option_ShoppingCartPage;
    @FindBy(xpath = "//label[text()='Post Code']/..//input")
    public WebElement input_Post_Code_ShoppingCartPage;
    @FindBy(xpath = "//label[text()='Enter your coupon here']/..//input")
    public WebElement input_Coupon_Code_ShoppingCartPage;
    @FindBy(xpath = "//label[text()='Enter your gift certificate code here']/..//input")
    public WebElement input_Gift_Certificate_Code_ShoppingCartPage;
    @FindBy(css = ".text-end #button-quote")
    public WebElement button_Get_Quotes_ShoppingCartPage;
    @FindBy(css = ".form-check input")
    public WebElement cb_Flat_Rate_ShoppingCartPage;
    @FindBy(css = ".text-end #button-shipping")
    public WebElement button_Apply_Shipping_ShoppingCartPage;
    @FindBy(css = ".btn.btn-info")
    public WebElement button_View_OrderHistoryPage;
    @FindBy(css = "a[data-bs-original-title='Return']")
    public WebElement button_Return_OrderInformationPage;
    @FindBy(xpath = "//label[@for='input-firstname']/..//input")
    public WebElement input_FirstName_ProductReturnsPage;
    @FindBy(xpath = "//label[@for='input-lastname']/..//input")
    public WebElement input_LastName_ProductReturnsPage;
    @FindBy(xpath = "//label[@for='input-telephone']/..//input")
    public WebElement input_Telephone_ProductReturnsPage;
    @FindBy(xpath = "//div[@id='input-reason']/..//input[@value='3']")
    public WebElement checkbox_Reason_Return_ProductReturnsPage;

    public ShoppingPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void buttonOnPage(String buttonName) {
        By buttonLocator = By.xpath("//button[@aria-label=\""+buttonName+"\"]");
        WebElement buttonElement = WaitUtils.waitForClickability(buttonLocator);
        WaitUtils.waitElementInteractableWithClicking(buttonElement);
        logger.info("This {} button clicked.",buttonName);

    }
    public void checksAlertHasMessage(String message) {
        WaitUtils.waitFor(2);
        String alertMessageActual = txt_Alert_Success.getText();
        Assert.assertEquals(message,alertMessageActual);
        logger.info("This {} alert message appeared.",message);
    }
    public void checkHeaderCart(String headerField) {
        if (headerField.equalsIgnoreCase("empty")){
            WaitUtils.waitFor(10);
            WaitUtils.waitElementInteractableWithClicking(button_Header_Cart);
            String headerCartMessageActual = txt_Header_Cart_Empty.getText();
            Assert.assertEquals("Your shopping cart is empty!",headerCartMessageActual);
            logger.info("Header cart empty.");
        }
        if (headerField.equalsIgnoreCase("has iMac")){
            WaitUtils.waitElementInteractableWithClicking(button_Header_Cart);
            String headerCartMessageActual = txt_Header_Cart_Has_Product.getText();
            Assert.assertEquals("iMac",headerCartMessageActual);
            logger.info("iMac selected");
        }
    }
    public void checkPaymentTableFieldPriceIs(String rowName, String priceValue) {
        String rowNameActual = Driver.getDriver().findElement(By.xpath("//div[@class='table-responsive']//strong[text()=\""+rowName+"\"]")).getText();
        Assert.assertEquals(rowName,rowNameActual);

        String priceValueActual = Driver.getDriver().findElement(By.xpath("//div[@class='table-responsive']//strong[text()=\""+rowName+"\"]/../../td[2]")).getText();
        Assert.assertEquals(priceValue,priceValueActual);

        logger.info("Price value {} checked.",priceValue);
    }
    public void clickOnProduct(String productName) {
        By productLocator = By.xpath("//div/h4/a[contains(text(),\""+productName+"\")]");
        WebElement productElement = WaitUtils.waitForClickability(productLocator);
        WaitUtils.waitElementInteractableWithClicking(productElement);
        logger.info("Product {} clicked.",productName);

    }
    public void editQuantityFieldAsAndClick(String quantity, String buttonName) {
        WaitUtils.waitElementInteractableWithClicking(input_Quantity_ShoppingCartPage);
        input_Quantity_ShoppingCartPage.clear();
        input_Quantity_ShoppingCartPage.sendKeys(quantity);

        if (buttonName.equalsIgnoreCase("update button")){
            WaitUtils.waitElementInteractableWithClicking(button_Update_ShoppingCartPage);
        } else if (buttonName.equalsIgnoreCase("remove button")) {
            WaitUtils.waitElementInteractableWithClicking(button_Remove_ShoppingCartPage);
        }
        logger.info("Quantity value set as {}",quantity);
    }
    public void fillEstimateShippingFields() {
        WaitUtils.waitElementInteractableWithClicking(dd_Country_ShoppingCartPage);
        WaitUtils.waitElementInteractableWithClicking(dd_Country_Option_ShoppingCartPage);
        WaitUtils.waitElementInteractableWithClicking(dd_Region_ShoppingCartPage);
        WaitUtils.waitElementInteractableWithClicking(dd_Region_Option_ShoppingCartPage);
        WaitUtils.waitElementInteractableWithSendKeys(input_Post_Code_ShoppingCartPage).sendKeys("414141");
        WaitUtils.waitElementInteractableWithClicking(button_Get_Quotes_ShoppingCartPage);
        WaitUtils.waitElementInteractableWithClicking(cb_Flat_Rate_ShoppingCartPage);
        WaitUtils.waitElementInteractableWithClicking(button_Apply_Shipping_ShoppingCartPage);
        logger.info("Shipping fields filled");
    }
    public void enterCouponCode(String couponCode) {
        WaitUtils.waitElementInteractableWithSendKeys(input_Coupon_Code_ShoppingCartPage).sendKeys(couponCode);
        logger.info("Coupon code entered");
    }
    public void enterGiftCertificateCode(String giftCertificateCode) {
        WaitUtils.waitElementInteractableWithSendKeys(input_Gift_Certificate_Code_ShoppingCartPage).sendKeys(giftCertificateCode);
        logger.info("Gift Certificate code entered");
    }
    public void returnsProductWithFillingProductReturnForm() {
        WaitUtils.waitElementInteractableWithClicking(button_View_OrderHistoryPage);
        WaitUtils.waitElementInteractableWithClicking(button_Return_OrderInformationPage);
        //Product Return Form Fill
        WaitUtils.waitElementInteractableWithSendKeys(input_FirstName_ProductReturnsPage).sendKeys("Cem");
        WaitUtils.waitElementInteractableWithSendKeys(input_LastName_ProductReturnsPage).sendKeys("Garip");
        WaitUtils.waitElementInteractableWithSendKeys(input_Telephone_ProductReturnsPage).sendKeys("0434323332");
        WaitUtils.waitElementInteractableWithClicking(checkbox_Reason_Return_ProductReturnsPage);
        HtmlManipulator.clickOnButton("Submit");
        HtmlManipulator.clickOnButton("Continue");
        //Return Homepage check
        WaitUtils.waitUntilCondition(() -> pages.loginPage().img_OpenCartLogo_LoginPage.isDisplayed());
        logger.info("Return product form filled.");
    }
    public void sortByList(String sortOption) {
        Driver.getDriver().findElement(By.xpath("//select[@id='input-sort']")).click();
        By sortLocator = By.xpath("//select[@id='input-sort']/option[text()=\""+sortOption+"\"]");
        WebElement sortElement = WaitUtils.waitForClickability(sortLocator);
        WaitUtils.waitElementInteractableWithClicking(sortElement);
        logger.info("List set as {}",sortOption);
    }
    public void orderOfPricesIsCorrect() {
        //List Style select
        WaitUtils.waitFor(2);
        Driver.getDriver().findElement(By.cssSelector(".btn-group #button-list")).click();
        ArrayList<String> obtainedList = new ArrayList<>();
        WaitUtils.waitFor(1);
        List<WebElement> elementList = Driver.getDriver().findElements(By.cssSelector(".price-new"));
        for (WebElement webEl:elementList){
            obtainedList.add(webEl.getText());
        }
        ArrayList<String> sortedList = new ArrayList<>();
        for (String sortEl:obtainedList){
            sortedList.add(sortEl);
        }
        Collections.sort(sortedList);
        System.out.println(sortedList);
        System.out.println("----------------");
        System.out.println(obtainedList);
        Assert.assertTrue(sortedList.equals(obtainedList));
        logger.info("Price values sorted.");
    }
    }
