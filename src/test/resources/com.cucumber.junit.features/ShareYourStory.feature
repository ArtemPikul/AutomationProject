Feature: As a user I want to be able to submit my story to BBC

  Scenario: User's story should not be submitted if e-mail field contains invalid entry
    Given the user opens BBC website
    And the user goes to "News" page
    And the user goes to "Coronavirus" tab on "News" page
    And the user goes to "Share your story" page
    When the user enters the "Valid story" in the story text form
    And the user enters the "Valid name" in the name field
    And the user enters the "Invalid email" in email field
    And the user enters the "+380631158582" in contact number field
    And the user enters the "Kyiv" in location field
    And the user accepts terms of service
    And the user confirms that he is over sixteen years old
    And the user clicks on "Submit" button
    Then page with the link "https://www.bbc.com/news/10725415" remains displayed
    And the "Submit" button remains active

  Scenario: User's story should not be submitted if terms of service are not accepted
    Given the user opens BBC website
    And the user goes to "News" page
    And the user goes to "Coronavirus" tab on "News" page
    And the user goes to "Share your story" page
    When the user enters the "Valid story" in the story text form
    And the user enters the "Valid name" in the name field
    And the user enters the "Invalid email" in email field
    And the user enters the "+380631158582" in contact number field
    And the user enters the "Kyiv" in location field
    And the user confirms that he is over sixteen years old
    And the user clicks on "Submit" button
    Then page with the link "https://www.bbc.com/news/10725415" remains displayed
    And the "Submit" button remains active

  Scenario: User's story should not be submitted if over  are not accepted
    Given the user opens BBC website
    And the user goes to "News" page
    And the user goes to "Coronavirus" tab on "News" page
    And the user goes to "Share your story" page
    When the user enters the "Valid story" in the story text form
    And the user enters the "Valid name" in the name field
    And the user enters the "Invalid email" in email field
    And the user enters the "+380631158582" in contact number field
    And the user enters the "Kyiv" in location field
    And the user confirms that he is over sixteen years old
    And the user clicks on "Submit" button
    Then page with the link "https://www.bbc.com/news/10725415" remains displayed
    And the "Submit" button remains active