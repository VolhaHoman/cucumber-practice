package com.cucumber.practice.steps;

import com.cucumber.practice.pages.DocsPage;
import com.cucumber.practice.pages.HomePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class MenuSteps {

    private HomePage homePage = new HomePage();
    private DocsPage docsPage = new DocsPage();

    @When("the user opens Cucumber website")
    public void opensCucumberWebsite() {
        homePage.openCucumberWebSite();
    }

    @When("the user clicks on the {string} section")
    public void clickOnSection(String section) {
        homePage.menuSection(section).click();
    }

    @When("the user clicks the {string} item")
    public void clickOnItem(String item) {
        homePage.menuChildItem(item).click();
    }

    @Then("page with title {string} is displayed")
    public void verifyPageTitlePresence(String pageTitle) {
        assertThat(docsPage.isPageWithTitleDisplayed(pageTitle))
                .overridingErrorMessage("page with title '%s' is not displayed", pageTitle)
                .isTrue();
    }

    @When("the user clicks on {string} button")
    public void acceptAllCookies(String dialog) {
        homePage.cookiesDialog(dialog).click();
    }
}
