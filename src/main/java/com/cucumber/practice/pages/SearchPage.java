package com.cucumber.practice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;

import static java.lang.String.format;

public class SearchPage extends BasePage {

    private static final String SEARCH_FIELD = "//input[@placeholder='Search...']";
    private static final String TEXT_PATTERN = "%s[contains(text(),'%s')]";
    private static final String FILTER_ITEM_NAME = "//*[contains(@class,'filter-item-name')]";
    private static final String FIRST_SEARCH_RESULT = "(//a[@class='link']/*[contains(@class,'item')])[1]";

    public WebElement searchField() {
        return findElement(Duration.ofSeconds(10),
                ExpectedConditions.presenceOfElementLocated(By.xpath(SEARCH_FIELD)));
    }

    public WebElement filterItemName(String linkText) {
        return findElement(Duration.ofSeconds(10),
                ExpectedConditions.presenceOfElementLocated(By.xpath(format(TEXT_PATTERN, FILTER_ITEM_NAME, linkText))));
    }

    public WebElement firstSearchResult(String result) {
        return findElement(By.xpath(FIRST_SEARCH_RESULT));
    }
}
