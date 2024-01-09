package com.getir.utils;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.function.Supplier;


public class WaitUtils {

    public static final int ITERATION_COUNT_MAX = 20;
    public static final int WAIT_AMOUNT_MILLISECOND = 100;
    private static final Logger logger = LogManager.getLogger();
    public static final int SHORT_WAIT = Integer.parseInt(ConfigurationReader.getProperty("SHORT_WAIT"));
    public static final int TIMEOUT = 20;

    public WaitUtils() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public static WebDriverWait getWaiter(long seconds){
        return new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(seconds));
    }

    public static WebDriverWait getWaiter(){
        return new WebDriverWait(Driver.getDriver(),Duration.ofSeconds(TIMEOUT));
    }

    public static void waitByMilliSeconds(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void waitFor(int seconds) {
        waitByMilliSeconds(Duration.ofSeconds(seconds).toMillis());
    }
    public static WebElement waitForVisibility(By locator) {
        return getWaiter().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public static WebElement waitForClickability(By locator) {
        return getWaiter().until(ExpectedConditions.elementToBeClickable(locator));
    }

    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
        try {
            getWaiter(timeOutInSeconds).until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }

    public static WebElement waitElementInteractableWithSendKeys(WebElement element) {
        int loopCount = 0;
        String message="";
        while (loopCount < ITERATION_COUNT_MAX) {
            try {
                element.sendKeys("");
                return element;
            } catch (WebDriverException e) {
                message=e.getMessage();
            }
            loopCount++;
            waitByMilliSeconds(WAIT_AMOUNT_MILLISECOND);
        }
        Assert.fail("Element: '" + element + "' is NOT interactable with "+message);
        throw new RuntimeException();
    }

    public static WebElement waitElementInteractableWithClicking(WebElement element) {
        int loopCount = 0;
        String message="";
        while (loopCount < ITERATION_COUNT_MAX) {
            try {
                element.click();
                return element;
            } catch (WebDriverException e) {
                message=e.getMessage();
            }
            loopCount++;
            waitByMilliSeconds(WAIT_AMOUNT_MILLISECOND);
        }
        Assert.fail("Element: '" + element + "' is NOT interactable with "+message);
        return null;
    }
    public static void resetDriverImplicitTimeout(){
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(SHORT_WAIT));
    }
    public static void waitUntilCondition(Supplier<Boolean> function) {
        int timeout = TIMEOUT;

        while (!function.get() && timeout > 0) {
            WaitUtils.waitFor(1);
            timeout--;
        }

        if (timeout <= 0 && !function.get())
            Assert.fail("Condition failed");

    }
}
