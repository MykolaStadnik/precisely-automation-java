package com.precisely.step_definitions;

import com.precisely.utilities.BrowserUtils;
import com.precisely.utilities.ConfigurationReader;
import com.precisely.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.time.Duration;

public class Hooks {
    /*
    In this class, we will be able to create "pre" and "post" condition
    for ALL the SCENARIOS and even STEPS.
    */

    @Before ("@ui")
    public void setupMethod() {
        Driver.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        Driver.getDriver().manage().window().maximize();
    }

    /*
    @After will be executed automatically after EVERY scenario in the project.
    */

    @After("@ui")
    public void teardownMethod(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        BrowserUtils.sleep(2);
        Driver.closeDriver();
    }
}
