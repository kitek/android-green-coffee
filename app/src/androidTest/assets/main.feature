Feature: Awesome screen
  In order to see the awesome screen
  As a user of the app
  I want to access the contact awesome screen

  Scenario: Show awesome message
    Given there is a message: "Hello world"
    When the app has launched
    Then I should see message: "Hello world"
