#Author: david.martin@ericsson.com

Feature: As a User of the calculator, I want to ensure that the correct error messages are displayed when I enter invalid inputs
  When As a User of the calculator, I want to ensure that the correct message is displayed when I attempt to subtract a large number from a small number

@tag1
Scenario: As a User of the calculator, I want to ensure that the correct message is displayed when I attempt to subtract a large number from a small number
    Given The browser is on the homepage
    When Input field one is populated with roman numeral XX
    And Input field two is populated with roman numeral II
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : XXII

@tag2
Scenario Outline: Title of your scenario outline
Given I want to write a step with <name>
When I check for the <value> in step
Then I verify the <status> in step

Examples:
    | name  |value | status |
    | name1 |  5   | success|
    | name2 |  7   | Fail   |
