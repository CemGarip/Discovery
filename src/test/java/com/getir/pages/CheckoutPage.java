package com.getir.pages;
import com.github.javafaker.Faker;
import com.getir.utils.BasePage;
import com.getir.utils.Driver;
import com.getir.utils.WaitUtils;
import com.getir.utils.manipulators.HtmlManipulator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
public class CheckoutPage extends BasePage{
    Faker faker = new Faker();
    @FindBy(xpath = "//legend[text()='Your Personal Details']/..//label[text()='First Name']/..//input")
    public WebElement input_FirstName_Your_Personal_Details;
    @FindBy(xpath = "//legend[text()='Your Personal Details']/..//label[text()='Last Name']/..//input")
    public WebElement input_LastName_Your_Personal_Details;
    @FindBy(xpath = "//legend[text()='Your Personal Details']/..//label[text()='E-Mail']/..//input")
    public WebElement input_Email_Your_Personal_Details;
    @FindBy(xpath = "//legend[text()='Your Password']/..//label[text()='Password']/..//input")
    public WebElement input_Password_Your_Password_CheckoutPage;
    @FindBy(xpath = "//label[text()='I have read and agree to the ']/..//input")
    public WebElement checkbox_Agree_Privacy_Policy_CheckoutPage;
    @FindBy(xpath = "//select[@name='shipping_method']/optgroup/option")
    public WebElement dd_Shipping_Method_Option_CheckoutPage;
    @FindBy(xpath = "//select[@name='payment_method']/option[@value='']")
    public WebElement dd_Payment_Method_Option_CheckoutPage;
    @FindBy(xpath = "//select[@name='shipping_method']")
    public WebElement dd_Shipping_Method_CheckoutPage;
    @FindBy(xpath = "//select[@name='payment_method']")
    public WebElement dd_Payment_Method_CheckoutPage;
    @FindBy(xpath = "//legend[text()='Payment Address']/..//label[text()='Address 1']/..//input")
    public WebElement input_Address1_Payment_Address;
    @FindBy(xpath = "//legend[text()='Payment Address']/..//label[text()='Address 2']/..//input")
    public WebElement input_Address2_Payment_Address;
    @FindBy(xpath = "//legend[text()='Payment Address']/..//label[text()='Company']/..//input")
    public WebElement input_Company_Payment_Address;

    @FindBy(xpath = "//legend[text()='Payment Address']/..//label[text()='City']/..//input")
    public WebElement input_City_Payment_Address;

    @FindBy(xpath = "//legend[text()='Payment Address']/..//label[text()='Post Code']/..//input")
    public WebElement input_PostCode_Payment_Address;

    public static String autoRandomCompanyName;
    public static String autoRandomAddress1Name;
    public static String autoRandomAddress2Name;
    public static String autoRandomCityName;
    public static String autoRandomPostCode;
    public static String autoRandomFirstName;
    public static String autoRandomLastName;
    public static String autoRandomEmail;
    public static String autoRandomPassword;


    public void fillPaymentAddress() {
        autoRandomCompanyName = faker.company().name();
        autoRandomAddress1Name = faker.address().fullAddress();
        autoRandomAddress2Name = faker.address().secondaryAddress();
        autoRandomCityName = faker.address().cityName();
        autoRandomPostCode = faker.address().zipCode();

        WaitUtils.waitElementInteractableWithSendKeys(input_Company_Payment_Address).sendKeys(autoRandomCompanyName);
        WaitUtils.waitElementInteractableWithSendKeys(input_Address1_Payment_Address).sendKeys(autoRandomAddress1Name);
        WaitUtils.waitElementInteractableWithSendKeys(input_Address2_Payment_Address).sendKeys(autoRandomAddress2Name);
        WaitUtils.waitElementInteractableWithSendKeys(input_City_Payment_Address).sendKeys(autoRandomCityName);
        WaitUtils.waitElementInteractableWithSendKeys(input_PostCode_Payment_Address).sendKeys(autoRandomPostCode);

        //Select Country
        String country = faker.address().country();
        WaitUtils.waitForVisibility(By.xpath("//select[@name='payment_country_id']/option[text()=\"+country+\"]"));
        Driver.getDriver().findElement(By.xpath("//select[@name='payment_country_id']/option[text()="+country+"]")).click();

        //Select Region
        WaitUtils.waitForVisibility(By.xpath("//select[@name='payment_country_id']/option[@value='2']"));
        Driver.getDriver().findElement(By.xpath("//select[@name='payment_country_id']/option[@value='2']")).click();

        logger.info("Payment address filled.");
    }

    public void fillsLogInCredentials() {
        autoRandomFirstName = faker.superhero().name();
        autoRandomLastName = faker.superhero().power();
        autoRandomEmail = faker.internet().emailAddress();
        autoRandomPassword = faker.lordOfTheRings().location();
        WaitUtils.waitElementInteractableWithSendKeys(input_FirstName_Your_Personal_Details).sendKeys(autoRandomFirstName);
        WaitUtils.waitElementInteractableWithSendKeys(input_LastName_Your_Personal_Details).sendKeys(autoRandomLastName);
        WaitUtils.waitElementInteractableWithSendKeys(input_Email_Your_Personal_Details).sendKeys(autoRandomEmail);
        //If we click guest checkout this field disappears
        String password = randomString(6);
        WaitUtils.waitElementInteractableWithSendKeys(input_Password_Your_Password_CheckoutPage).sendKeys(password);
        WaitUtils.waitElementInteractableWithClicking(checkbox_Agree_Privacy_Policy_CheckoutPage);
        //If user click Continue button in this state. Confirm Order and Payment Method fields not clickable.
        HtmlManipulator.clickOnButton("Continue");
        logger.info("Login credentials filled.");
    }

    public void selectsShippingAndPaymentMethod() {
        WaitUtils.waitElementInteractableWithClicking(dd_Shipping_Method_CheckoutPage);
        WaitUtils.waitElementInteractableWithClicking(dd_Shipping_Method_Option_CheckoutPage);
        logger.info("Shipping method selected.");

        WaitUtils.waitElementInteractableWithClicking(dd_Payment_Method_CheckoutPage);
        WaitUtils.waitElementInteractableWithClicking(dd_Payment_Method_Option_CheckoutPage);
        logger.info("Payment method selected.");

    }
}
