package com.getir.utils;

import org.openqa.selenium.chrome.ChromeOptions;

public class TestConfiguration {
    private static final String headlessArgument = "headless";
    private static final String ScreenWidthArgument = "width";
    private static final String ScreenHeightArgument = "height";

    public static void configureChromeOptions(ChromeOptions options ) {
        final String headlessOption = System.getProperty(headlessArgument);
        if ("true".equals(headlessOption)) {
            options.addArguments("--headless");
        }

        final String screenWidth = System.getProperty(ScreenWidthArgument);
        final String screenHeight = System.getProperty(ScreenHeightArgument);
        if (isInt(screenWidth) && isInt(screenHeight)) {
            options.addArguments(String.format("window-size=%s,%s", screenWidth, screenHeight));
        }
    }

    private static boolean isInt(String intParameter) {
        if (intParameter == null) {
            return false;
        }
        try {
            Integer.parseInt(intParameter);
            return true;
        } catch (Throwable t) {
            return false;
        }
    }

}
