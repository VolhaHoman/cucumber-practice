Feature: As a user I want to get ability to use menu sections

  Scenario Outline: Docs sections should contain appropriate columns
    Given the user opens Cucumber website
    And the user clicks on "Accept all cookies" button
    When the user clicks on the "Docs" section
    And the user clicks the "<title>" item
    Then page with title "<title>" is displayed
    Examples:
      | title          |
      | Gherkin Syntax |
      | Installation   |