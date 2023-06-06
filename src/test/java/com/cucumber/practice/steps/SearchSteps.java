package com.cucumber.practice.steps;

import com.cucumber.practice.pages.HomePage;
import com.cucumber.practice.pages.ResultsPage;
import com.cucumber.practice.pages.SearchPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class SearchSteps {

    private HomePage homePage = new HomePage();
    private SearchPage searchPage = new SearchPage();
    private ResultsPage resultPage = new ResultsPage();
    @When("the user clicks on the {string} button")
    public void theUserClicksOnTheButton(String button) {
        homePage.searchButton(button).click();
    }

    @When("the user enters {string} word in the search field")
    public void theUserEntersInTheSearchField(String word) {
        searchPage.searchField().sendKeys(word);
    }

    @When("the user filters search results by parameter {string}")
    public void theUserFiltersSearchResultsByParameter(String parameter) {
        searchPage.filterItemName(parameter).click();
    }

    @When("the user clicks the first search result link with title containing {string}")
    public void theUserClicksTheFirstSearchResultLinkWithTitleContaining(String result) {
        searchPage.firstSearchResult(result).click();
    }

    @Then("page with title containing {string} is displayed")
    public void pageWithTitleContainingIsDisplayed(String expectedTitle) {
        assertThat(resultPage.isPageWithTitleDisplayed(expectedTitle))
                .as("Page title is not as expected")
                .overridingErrorMessage("page with title '%s' is not displayed", expectedTitle)
                .isTrue();
    }
}
