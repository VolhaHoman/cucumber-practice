package com.cucumber.practice.hooks;

import com.cucumber.practice.driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DriverHooks {

    public static final String PNG_FILE_EXTENSION = "image/png";

    @Before
    public void setupDriver() throws InterruptedException {
        DriverManager.setupDriver();
    }

    @After
    public void quitDriver(Scenario scenario) {
        takeScreenshot(scenario);
        DriverManager.quitDriver();
    }

    private void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed() || true) {
            if (DriverManager.getDriver() instanceof TakesScreenshot) {
                try {
                    byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
                    Path of = Path.of(getFileName(scenario));
                    Files.createFile(of);
                    Files.write(of, screenshot);
                    scenario.attach(screenshot, PNG_FILE_EXTENSION,
                            scenario.getName());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    private String getFileName(Scenario sc) {
        return sc.getName() + "-" +
                DateTimeFormatter.ofPattern("ddMMyyyyHHmmss").format(LocalDateTime.now())
                + ".png";
    }
}
