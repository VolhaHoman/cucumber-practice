package com.cucumber.practice.pages;

import com.cucumber.practice.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static java.lang.String.format;

public class HomePage extends BasePage {

    private static final String CUCUMBER_URL = "https://cucumber.io/";
    private static final String TEXT_PATTERN = "%s[contains(text(),'%s')]";
    private static final String MENU_SECTION = "//*[contains(@class, 'nav-link')]" ;
    private static final String CHILD_MENU_ITEM = "//*[contains(@class, 'dropdown')]//*[contains(@class, 'item')]";
    private static final String COOKIES_DIALOG_BTN = "//*[@role='dialog']//button[contains(@class, 'ch2-btn-primary') and contains(text(), 'Allow all cookies')]";
    private static final String SEARCH_BUTTON = "//a/*[contains(@class,'fa-search')]";


    public void openCucumberWebSite() {
        DriverManager.getDriver().get(CUCUMBER_URL);
    }

    public WebElement menuSection(String linkText) {
        return findElement(By.xpath(format(TEXT_PATTERN, MENU_SECTION, linkText)));
    }

    public WebElement menuChildItem(String linkText) {
        return findElement(By.xpath(format(TEXT_PATTERN, CHILD_MENU_ITEM, linkText)));
    }

    public WebElement cookiesDialog(String linkText) {
        return findElement(By.xpath(COOKIES_DIALOG_BTN));
    }

    public WebElement searchButton(String button) {
        return findElement(By.xpath(SEARCH_BUTTON));
    }
}
