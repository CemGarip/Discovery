package com.getir.utils.manipulators;

import com.getir.utils.Driver;
import com.getir.utils.WaitUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

public class HtmlManipulator {
	private static final Logger logger = LogManager.getLogger();

	public static void hover(WebElement element){
		Actions actions = new Actions(Driver.getDriver());
		actions.moveToElement(element).build().perform();
	}


	public static boolean doesElementExist(WebElement element){
		Driver.getDriver().manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
		boolean elementFound = false;
		try {
			WaitUtils.waitFor(1);
			element.getText();
			System.out.println(element.getText());
			elementFound = true;
		} catch (NoSuchElementException | StaleElementReferenceException ex) {

		}
		WaitUtils.resetDriverImplicitTimeout();
		return elementFound;
	}

	public static boolean doesElementExist(By byLocator){
		Driver.getDriver().manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		List<WebElement> list = Driver.getDriver().findElements(byLocator);
		WaitUtils.resetDriverImplicitTimeout();
		return list.size() > 0;
	}

	public static void assertContains(String expected, String actual){
		String errorText = String.format("\nExpected: %s\nActual: %s\nContains assertion failed", expected, actual);
		assertTrue(errorText, actual.contains(expected));
	}

	public static void clickOnButton(String buttonText){
		WaitUtils.waitElementInteractableWithClicking(findElementByXpath("//*[self::a|self::button][.='" + buttonText + "']"));
	}


	public static WebElement findElementByCss(String css){
		return By.cssSelector(css).findElement(Driver.getDriver());
	}

	public static WebElement findElementByXpath(String xpath){
		return By.xpath(xpath).findElement(Driver.getDriver());
	}

	public static WebElement findElementById(String id){
		return By.id(id).findElement(Driver.getDriver());
	}


}