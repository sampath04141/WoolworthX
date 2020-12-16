Feature: Home Screen -Shop online functionalities
  As a valid user I want to validate all functionalities of the online shopping block

  Background:
    Given that the application has loaded

  @smoke @regression
    Scenario: As a user I need to validate front tile display text
      When I tap "Home"
      Then I can see "Shop Online" text
      And I can see "What’s your way?" text
      And I can see "Delivery" text
      And I can see "Pick up" text