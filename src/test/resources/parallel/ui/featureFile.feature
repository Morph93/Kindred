Feature:  Kindred Search Feature tests

  Background: Precondition for Google Chrome
    Given  Accept terms of use
    When   Decline data sync
    And    Go to "https://www.unibet.co.uk/blog"
    And    Close the overlay if it appears
    And    Click on the Blog

  @Kindred
  Scenario Outline: Blog search interaction check
    When   Input "<string>" string into the search bar
    Then   Check if the search bar contains "<string>" string

    Examples:
      | string             |
      | characters         |
      | special characters |
      | numbers            |
      | combinations       |

  @Kindred
  Scenario Outline: Check the redirection after confirming input in search bar
    When   Input "<string>" string into the search bar and confirm input
    Then   Check redirection for "<string>" type of input

    Examples:
      | string           |
      | valid            |
      | no search result |
      | numbers          |
      | combinations     |

  @Kindred
  Scenario Outline: Check if autosuggestion works when doing search
    When   Input "<string>" string into the search bar and confirm input
    And    Type "basketball" into new search bar on the page
    Then   Check if autosuggestion works

    Examples:
      | string |
      | empty  |

  @Kindred
  Scenario Outline: Check if X removes input from search bar
    When   Input "<string>" string into the search bar and confirm input
    And    Type "basketball" into new search bar on the page
    And    Click on X to delete input
    Then   Check if the input has been deleted

    Examples:
      | string |
      | empty  |