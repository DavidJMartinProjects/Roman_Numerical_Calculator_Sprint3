#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: As a Roman Bookkeeper, I want to add Roman numbers because doing it manually is too tedious
  When the user enters roman numerals LX and XIV and chooses the addition operation, the result shall be LXXIV 
  When the user enters roman numerals LX and XIV and chooses the subtraction operation, the result shall be XLVI

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
    
  Scenario: the user enters roman numerals LX and XIV and chooses the divide operation, the result shall be XLVI
    Given The browser is on the homepage
    When The input fields are populated with roman numerals LX and XIV 
    And The divide operation is selected
    And The calculate button is clicked
    Then The correct result of the Division calculation shall be displayed : VI
    
  Scenario: the user enters roman numerals LX and XIV and chooses the multiply operation, the result shall be XLVI
    Given The browser is on the homepage
    When The input fields are populated with roman numerals LX and XIV 
    And The multiply operation is selected
    And The calculate button is clicked
    Then The correct result of the Multiplication calculation shall be displayed : DCCCXL