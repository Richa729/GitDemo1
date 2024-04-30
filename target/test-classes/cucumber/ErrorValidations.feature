@tag
Feature: Error Validation
  I want to use this template for my feature file



  @ErrorValidations
  Scenario Outline: Error Validation of the ecommerce page
    Given I landed on Ecommerce page
    When Logged in with username<name> and password<password>
    Then "Incorrect email or password." message is displayed

    Examples: 
      | name                    | password |
      | richaprakash9@gmail.com | test@123 | 
   
