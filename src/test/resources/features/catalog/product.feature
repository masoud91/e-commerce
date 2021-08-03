Feature: product management

  Scenario: adding a new product
    Given I am an admin
    When I add a product with following details
      | attribute     | value                   |
      | name          | Whey Protein Powder     |
      | price         | 44.99                   |
      | stockCount    | 18                      |
    Then I have the added product available
