package com.getir.pages;

import com.github.javafaker.Faker;
import com.getir.Pages;
import com.getir.utils.BasePage;
import com.getir.utils.manipulators.HtmlManipulator;
import com.getir.utils.Driver;
import com.getir.utils.WaitUtils;
import com.getir.utils.objects.User;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

	public static User user;
	Faker faker = new Faker();
	Pages pages = new Pages();
	@FindBy(css = "a img[alt=\"iPhone 6\"]")
	public WebElement img_OpenCartLogo_LoginPage;
	@FindBy(xpath = "//span[text()='My Account']")
	public WebElement txt_MyAccount_TopText;
	@FindBy(xpath = "//a[text()='Login']")
	public WebElement txt_Login_TopText;
	@FindBy(xpath = "//a[text()='Logout']")
	public WebElement txt_Logout_TopText;
	@FindBy(xpath = "//label[text()='E-Mail Address']/..//input")
	public WebElement input_EmailAdress;
	@FindBy(xpath = "//label[text()='Password']/..//input")
	public WebElement input_Password;
	@FindBy(xpath = "//button[text()='Login']")
	public WebElement button_Login;
	@FindBy(xpath = "//label[@for='input-password']/../a[text()='Forgotten Password']")
	public WebElement txt_Forgotten_Password_LoginPage;
	@FindBy(css = "#error-firstname")
	public WebElement txt_Error_FirstName_RegisterPage;
	@FindBy(css = "#error-lastname")
	public WebElement txt_Error_LastName_RegisterPage;
	@FindBy(css = "#error-email")
	public WebElement txt_Error_Email_RegisterPage;
	@FindBy(css = "#error-password")
	public WebElement txt_Error_Password_RegisterPage;
	@FindBy(xpath = "//input[@type='checkbox']")
	public WebElement cb_Privacy_Policy_RegisterPage;

	public void waitForLogo(){
		WaitUtils.waitUntilCondition(() -> img_OpenCartLogo_LoginPage.isDisplayed());
	}

	public LoginPage(){
		PageFactory.initElements(Driver.getDriver(), this);
	}
	public void login(User user){
		/* Precondition */
		waitForLogo();
		logger.info("Homepage image is visible.");

		LoginPage.user = user;
		WaitUtils.waitElementInteractableWithClicking(txt_MyAccount_TopText);
		WaitUtils.waitElementInteractableWithClicking(txt_Login_TopText);
		WaitUtils.waitElementInteractableWithSendKeys(input_EmailAdress).sendKeys(user.email);

		WaitUtils.waitElementInteractableWithSendKeys(input_Password).sendKeys(user.password);
		WaitUtils.waitElementInteractableWithClicking(button_Login);

		verifyUserIsLoggedIn(user);
	}
	private void verifyUserIsLoggedIn(User user){
		WaitUtils.waitUntilCondition(() -> txt_WelcomeMessage_Header.isDisplayed());
		HtmlManipulator.assertContains("Edit your account information", txt_WelcomeMessage_Header.getText());
		logger.info("Log in as {} is success", user.keyword);
	}
	public void clicksForgottenPasswordAndTryToChangePasswordWithInvalidEmail() {
		WaitUtils.waitElementInteractableWithClicking(txt_Forgotten_Password_LoginPage);
		WaitUtils.waitElementInteractableWithClicking(input_EmailAdress);
		WaitUtils.waitElementInteractableWithSendKeys(input_EmailAdress).sendKeys("invalid@gmail.com");
		HtmlManipulator.clickOnButton("Continue");
		logger.info("New password requested.");
	}
	public void loginWithInvalidUser() {
		WaitUtils.waitElementInteractableWithSendKeys(input_EmailAdress).sendKeys("invalid@gmail.com");
		WaitUtils.waitElementInteractableWithSendKeys(input_Password).sendKeys("123123");
		WaitUtils.waitElementInteractableWithClicking(button_Login);
		logger.info("Invalid User error.");
	}
	public void checksBlankFieldErrors() {
		HtmlManipulator.clickOnButton("Continue");

		String errorFirstNameActual = txt_Error_FirstName_RegisterPage.getText();
		Assert.assertEquals("First Name must be between 1 and 32 characters!",errorFirstNameActual);

		String errorLastNameActual = txt_Error_LastName_RegisterPage.getText();
		Assert.assertEquals("First Name must be between 1 and 32 characters!",errorLastNameActual);

		String errorEmailActual = txt_Error_Email_RegisterPage.getText();
		Assert.assertEquals("E-Mail Address does not appear to be valid!",errorEmailActual);

		String errorPasswordActual = txt_Error_Password_RegisterPage.getText();
		Assert.assertEquals("Password must be between 4 and 20 characters!",errorPasswordActual);

		logger.info("Blank field checked.");
	}

	public void fillsRegisterAccountFields() {
		String firstName = faker.name().firstName();
		WaitUtils.waitElementInteractableWithSendKeys(pages.checkoutPage().input_FirstName_Your_Personal_Details).sendKeys(firstName);

		String lastName = faker.name().lastName();
		WaitUtils.waitElementInteractableWithSendKeys(pages.checkoutPage().input_LastName_Your_Personal_Details).sendKeys(lastName);

		String emailName = faker.internet().emailAddress();
		WaitUtils.waitElementInteractableWithSendKeys(pages.checkoutPage().input_Email_Your_Personal_Details).sendKeys(emailName);

		String password = faker.gameOfThrones().character();
		WaitUtils.waitElementInteractableWithSendKeys(pages.checkoutPage().input_Password_Your_Password_CheckoutPage).sendKeys(password);
		WaitUtils.waitElementInteractableWithClicking(cb_Privacy_Policy_RegisterPage);
		logger.info("New account has been created.");
	}
}
