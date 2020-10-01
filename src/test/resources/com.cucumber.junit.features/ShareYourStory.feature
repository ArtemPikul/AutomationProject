Feature: As a user I want to be able to submit my story to BBC

  Background:
    Given the user opens BBC website
    And the user goes to "News" page
    And the user goes to "Coronavirus" tab on "News" page
    And the user goes to "Share your story" page

  Scenario Outline: User's story should not be submitted if e-mail field contains invalid entry
    When the user enters the "<story>" in the story text form
    And the user enters the "<name>" in the name field
    And the user enters the "<email>" in email field
    And the user enters the "<number>" in contact number field
    And the user enters the "<location>" in location field
    And the user accepts terms of service
    And the user confirms that he is over sixteen years old
    And the user clicks on "Submit" button
    Then page with the link "<link>" remains displayed
    And the "Submit" button remains active
    Examples:
    | story       | name       | email         | number        | location | link                              |
    | Valid story | Valid name | Invalid email | +380631158582 | Kyiv     | https://www.bbc.com/news/10725415 |

  Scenario Outline: User's story should not be submitted if terms of service are not accepted
    When the user enters the "<story>" in the story text form
    And the user enters the "<name>" in the name field
    And the user enters the "<email>" in email field
    And the user enters the "<number>" in contact number field
    And the user enters the "<location>" in location field
    And the user confirms that he is over sixteen years old
    And the user clicks on "Submit" button
    Then page with the link "<link>" remains displayed
    And the "Submit" button remains active
    Examples:
      | story       | name       | email               | number        | location | link                              |
      | Valid story | Valid name | pikul.a@outlook.com | +380631158582 | Kyiv     | https://www.bbc.com/news/10725415 |

  Scenario Outline: User's story should not be submitted if over sixteen years old condition is not accepted
    When the user enters the "<story>" in the story text form
    And the user enters the "<name>" in the name field
    And the user enters the "<email>" in email field
    And the user enters the "<number>" in contact number field
    And the user enters the "<location>" in location field
    And the user accepts terms of service
    And the user clicks on "Submit" button
    Then page with the link "<link>" remains displayed
    And the "Submit" button remains active
    Examples:
      | story       | name       | email               | number        | location | link                              |
      | Valid story | Valid name | pikul.a@outlook.com | +380631158582 | Kyiv     | https://www.bbc.com/news/10725415 |