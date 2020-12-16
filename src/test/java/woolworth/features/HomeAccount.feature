Feature: List Screen -Account functionalities
  As a valid user I want to validate all  functionalities in the account tab

  Background:
    Given that the application has loaded

@smoke @regression
  Scenario: As a user I need to add a time to the list and see
    Given I tap "Account"
    When I scroll down to see the "Contact us"
    Then I can see "onlineshop@countdown.co.nz" email address


