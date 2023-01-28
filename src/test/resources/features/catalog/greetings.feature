Feature: Greetings

  Scenario: Receive greeting as guest user
    Given I am a guest user
    When I ask for greetings
    Then I receive a warm welcome
