package com.getir.utils;

import com.getir.Pages;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.Arrays;
import java.util.Random;


public abstract class BasePage {

	public static final Logger logger = LogManager.getLogger();
	public final Pages pages = new Pages();
	@FindBy(xpath = "//div[@id='content']//li/a[text()='Edit your account information']")
	public WebElement txt_WelcomeMessage_Header;

	public static String randomString(int stringLength){

		Random random = new Random();
		char[] chars = "ABCDEFGHIJKLMNOPQRSTUWVXYZabcdefghijklmnopqrstuwvxyz0123456789".toCharArray();
		String stringRandom = "";
		for (int i = 0; i < stringLength; i++) {

			stringRandom = stringRandom + String.valueOf(chars[random.nextInt(chars.length)]);
		}
		return stringRandom;
	}

	public static void log(String text,String... params){
		logger.printf(Level.INFO,text, Arrays.stream(params).toArray());
	}
}
