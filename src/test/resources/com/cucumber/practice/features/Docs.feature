Feature: As a user I want to get ability to use Docs pages

  Scenario: Docs sections should contain appropriate columns
    Given the user opens Cucumber website
    And the user clicks on "Accept all cookies" button
    When the user clicks on the "Docs" section
    And the user clicks the "Installation" item
    Then there are items 11 in the left-side menu
    And left-side menu contains the following links
      | Installation                 |
      | Guides                       |
      | Professional Services        |
      | Cucumber                     |
      | Gherkin Syntax               |
      | Behaviour-Driven Development |
      | Community                    |
      | Sponsors                     |
      | Tools                        |
      | Terminology                  |

