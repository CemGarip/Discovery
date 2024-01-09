package com.getir.utils;


import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
public class Hook {

    double startTime;
    double duration;
    //default HOOK runs for any scenario
    @Before
    public void setup(Scenario scenario){
        System.out.println(scenario.getSourceTagNames());
        System.out.println(scenario.getName());
        System.out.println("BEFORE");
        startTime = System.nanoTime();
        System.out.println("window size from hook -> " + Driver.getDriver().manage().window().getSize());
        WaitUtils.resetDriverImplicitTimeout();
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));

    }

    @After
    public void teardown(Scenario scenario){
        if(scenario.isFailed()){
            TakesScreenshot takesScreenshot = (TakesScreenshot) Driver.getDriver();
            byte[] image = takesScreenshot.getScreenshotAs(OutputType.BYTES);
            //will attach screenshot into report
            scenario.embed(image, "image/png");
        }
        Driver.closeDriver();
        System.out.println("AFTER");
        duration = (System.nanoTime() - startTime)/1000000000;
        System.out.println(duration);
    }

}
