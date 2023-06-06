package com.cucumber.practice.pages;

import com.cucumber.practice.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.function.Function;

public abstract class BasePage {

    private WebDriverWait wait;
    public BasePage() {
        wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(5));
        PageFactory.initElements(DriverManager.getDriver(), this);
    }

    public WebElement findElement(By by) {
        return DriverManager.getDriver().findElement(by);
    }

    public WebElement findElement(Duration timeout, Function<? super WebDriver, WebElement> fn) {
        return wait.withTimeout(timeout)
                .until(fn);
    }

    public List<WebElement> findElements(By by) {
        return DriverManager.getDriver().findElements(by);
    }

    public boolean isElementDisplayed(By by) {
        return !findElements(by).isEmpty();
    }
}
