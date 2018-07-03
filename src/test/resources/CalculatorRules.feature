#Author: david.martin@ericsson.com

Feature: As a User of the calculator, I want to ensure that the roman numeral calculator works as intended
  When As a User of the calculator, I want to ensure that roman numerals can be concatenated to form a larger numeral (XX+II=XXII)
  When As a User of the calculator, I want to ensure that if a lesser roman numeral is put before a bigger it means subtraction of the lesser from the bigger (III+I=IV)
  When As a User of the calculator, I want to ensure that if a lesser roman numeral is put before a bigger it means subtraction of the lesser from the bigger (D+ID=CM)
  When As a User of the calculator, I want to ensure that if the numeral is I, X or C that you cant have more than three (II+II=IV)
  When As a User of the calculator, I want to ensure that if the numeral is I, X or C that you cant have more than three (XX+XX=XL)
  When As a User of the calculator, I want to ensure that if the numeral is I, X or C that you cant have more than three (CC+CC=CD)
  When As a User of the calculator, I want to ensure that if the numeral is V, L or D that you cant have more than one (V+V=X)
  When As a User of the calculator, I want to ensure that if the numeral is V, L or D that you cant have more than one (L+L=C)
  When As a User of the calculator, I want to ensure that if the numeral is V, L or D that you cant have more than one (D+D=M)

  Scenario: As a User of the calculator, I want to ensure that roman numerals can be concatenated to form a larger numeral
    Given The browser is on the homepage
    When Input field one is populated with roman numeral XX
    And Input field two is populated with roman numeral II
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : XXII

  Scenario: When As a User of the calculator, I want to ensure that if a lesser roman numeral is put before a bigger it means subtraction of the lesser from the bigger III+I=IV
    Given The browser is on the homepage
    When Input field one is populated with roman numeral III
    And Input field two is populated with roman numeral I
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : IV

  Scenario: When As a User of the calculator, I want to ensure that if a lesser roman numeral is put before a bigger it means subtraction of the lesser from the bigger D+ID=CM
    Given The browser is on the homepage
    When Input field one is populated with roman numeral D
    And Input field two is populated with roman numeral CD
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : CM

  Scenario: As a User of the calculator, I want to ensure that if the numeral is I, X or C that you cant have more than three II+II=IV
    Given The browser is on the homepage
    When Input field one is populated with roman numeral XX
    And Input field two is populated with roman numeral XX
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : XL

  Scenario: As a User of the calculator, I want to ensure that if the numeral is I, X or C that you cant have more than three XX+XX=XL
    Given The browser is on the homepage
    When Input field one is populated with roman numeral II
    And Input field two is populated with roman numeral II
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : IV

  Scenario: As a User of the calculator, I want to ensure that if the numeral is I, X or C that you cant have more than three CC+CC=CD
    Given The browser is on the homepage
    When Input field one is populated with roman numeral CC
    And Input field two is populated with roman numeral CC
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : CD

  Scenario: As a User of the calculator, I want to ensure that if the numeral is V, L or D that you cant have more than one V+V=X
    Given The browser is on the homepage
    When Input field one is populated with roman numeral V
    And Input field two is populated with roman numeral V
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : X

  Scenario: As a User of the calculator, I want to ensure that if the numeral is V, L or D that you cant have more than one L+L=C
    Given The browser is on the homepage
    When Input field one is populated with roman numeral L
    And Input field two is populated with roman numeral L
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : C

  Scenario: As a User of the calculator, I want to ensure that if the numeral is V, L or D that you cant have more than one D+D=M
    Given The browser is on the homepage
    When Input field one is populated with roman numeral D
    And Input field two is populated with roman numeral D
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the calculation shall be displayed : M
