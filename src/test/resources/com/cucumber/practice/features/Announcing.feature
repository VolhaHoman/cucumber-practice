Feature: As a user I want to find an article and open it

  @smoke
  Scenario: Perform search from Cucumber start page
    Given the user opens Cucumber website
    And the user clicks on "Accept all cookies" button
    When the user clicks on the "Search" button
    And the user enters "Announcing" word in the search field
    And the user filters search results by parameter "Blog"
    And the user clicks the first search result link with title containing "Announcing"
    Then page with title containing "Announcing" is displayed
