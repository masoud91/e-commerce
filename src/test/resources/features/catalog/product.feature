Feature: product management

  Scenario: should add a new product
    Given I am an admin
    When I add the book with following details
      | name          | Whey Protein Powder     |
      | price         | 44.99                   |
      | stock_count   | 18                      |
    Then I have the added product available
