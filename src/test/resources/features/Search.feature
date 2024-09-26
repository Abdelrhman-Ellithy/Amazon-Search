Feature: Search
  Scenario: The user searches for Items and save their names and prices
    Given the user in the search page
      And the user types Monitor in the search bar
    When the user clicks the search button
    Then relevant items is returned