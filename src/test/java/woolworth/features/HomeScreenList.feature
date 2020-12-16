Feature: List Screen -Shopping  list functionalities
  As a valid user I want to validate all shopping list functionalities of the list page

  Background:
    Given that the application has loaded

  @regression
  Scenario Outline: As a user I need to add a time to the list and see
    Given I tap "List"
    When I tap add item button
    And I add "<Item>" to the list
    Then I can see "<Item>" in the list

    Examples:
      | Item  |
      | Bread |
      | Milk  |

  @smoke
  Scenario: As a user I need to add a time to the list and see
    Given I tap "List"
    When I tap add item button
    And I add "Bread","Milk" to the list
    Then I can see "Bread","Milk" in the list



