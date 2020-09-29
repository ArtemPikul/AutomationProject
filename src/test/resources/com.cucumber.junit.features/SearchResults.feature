Feature: As a user I want to be able to search for a specific category of news

  Scenario: Search results should show the articles with a search word in the title
    Given the user opens BBC website
    And the user goes to "News" page
    When the user searches for a category of headline article using search bar
    Then the first article found contains the search keyword