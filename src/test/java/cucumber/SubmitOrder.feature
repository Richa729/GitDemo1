@tag
Feature: Purchase the order from Ecommerce Website
  I want to use this template for my feature file

Background:
Given I landed on Ecommerce page
  @Regression
  Scenario Outline: Positive Test for submitting the order
    Given Logged in with username<name> and password<password>
    When I add product<productName> from cart
    And Checkout<productName> and submit the order
    Then Confirmation<Confirmation> message is displayed

    Examples: 
      | name                    | password  | productName | Confirmation           |
      | richaprakash90@gmail.com| Test@123  | ZARA COAT 3 | THANKYOU FOR THE ORDER.|
      
