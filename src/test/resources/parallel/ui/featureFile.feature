Feature:  test

  Background: Precondition for Google Chrome
    Given  Accept terms of use
    When   Decline data sync
    And    Go to "https://www.unibet.co.uk/blog"
    And    Close the overlay if it appears
    And    Click on the Blog


  Scenario Outline: Blog search interaction check
    When   Input "<string>" string into the search bar
    Then   Check if the search bar contains "<string>" string
    Examples:
      | string             |
      | characters         |
      | special characters |
      | numbers            |
      | combinations       |

  @Smoke
  Scenario Outline: Check the redirection after confirming input in search bar
    When   Input "<string>" string into the search bar and confirm input
    Then   Check redirection for "<string>" type of input

    Examples:
      | string           |
      | valid            |
      | no search result |
      | numbers          |
      | combinations     |
