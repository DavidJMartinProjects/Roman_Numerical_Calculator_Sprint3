#Author: david.martin@ericsson.com

Feature: As a Roman Bookkeeper, I want to add Roman numbers because doing it manually is too tedious
  When the user enters roman numerals LX and XIV and chooses the addition operation, the result shall be LXXIV 
  When the user enters roman numerals LX and XIV and chooses the subtraction operation, the result shall be XLVI
  When the user enters roman numerals LX and XIV and chooses the divide operation, the result shall be XLVI
  When the user enters roman numerals LX and XIV and chooses the multiply operation, the result shall be DCCCXL

  Scenario: the user enters roman numerals LX and XIV and chooses the addition operation, the result shall be LXXIV 
    Given The browser is on the homepage
    When The input fields are populated with roman numerals LX and XIV 
    And The addition operation is selected
    And The calculate button is clicked
    Then The correct result of the Addition calculation shall be displayed : LXXIV
    
  Scenario: the user enters roman numerals LX and XIV and chooses the subtract operation, the result shall be XLVI
    Given The browser is on the homepage
    When The input fields are populated with roman numerals LX and XIV 
    And The subtract operation is selected
    And The calculate button is clicked
    Then The correct result of the Subtraction calculation shall be displayed : XLVI
    
  Scenario: the user enters roman numerals LX and XIV and chooses the divide operation, the result shall be VI
    Given The browser is on the homepage
    When The input fields are populated with roman numerals LX and XIV 
    And The divide operation is selected
    And The calculate button is clicked
    Then The correct result of the Division calculation shall be displayed : IV
    
  Scenario: the user enters roman numerals LX and XIV and chooses the multiply operation, the result shall be DCCCXL
    Given The browser is on the homepage
    When The input fields are populated with roman numerals LX and XIV 
    And The multiply operation is selected
    And The calculate button is clicked
    Then The correct result of the Multiplication calculation shall be displayed : DCCCXL