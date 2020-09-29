Feature: As a user I want to see the articles on "News" page

  Scenario: The latest posted article headline should be displayed on the page
    Given the user opens BBC website
    And the user goes to "News" page
    Then the latest posted article is "Covid deaths cross 'agonising' 1m milestone"
