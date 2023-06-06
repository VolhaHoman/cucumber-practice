package com.cucumber.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class ResultsPage extends BasePage {

    private static final String PAGE_TITLE = "//*[contains(@class,'hero-header')]";
    private static final String TEXT_PATTERN = "%s[contains(text(),'%s')]";

    public WebElement pageResultTitle(String linkText) {
        return findElement(By.xpath(format(TEXT_PATTERN, PAGE_TITLE, linkText)));
    }

    public boolean isPageWithTitleDisplayed(String title) {
        return isElementDisplayed(By.xpath(format(TEXT_PATTERN, PAGE_TITLE, title)));
    }
}
