@PIZZABOT

Feature: My Pizza

  Background:
    Given I access the My Pizza Page
    When I click on Bot icon
    And Bot window should open
    And I click on Get Started Button

  Scenario Outline: Login validation on Pizza Bot
    And I click on enter First Name <firstName>
    And I click on enter Email <emailId>
    And I click on Next Button
    Then Enter text in commentBox <CommentBoxText>

    Examples:
    | firstName | emailId | CommentBoxText |
    | Test      | test@test.com | Validation pass |
    | NULL      | test1         | I want to Order var Pizza |


  Scenario Outline: Validate Order a Veg Pizza and provide positive feedback
    And I click on enter First Name <firstName>
    And I click on enter Email <emailId>
    And I click on Next Button
    And I want to Order Pizza
    And I select Veg Pizza
    And I select Cheese Toppings
    And I select Tomato Toppings
    And I click on Submit Toppings Button
    And I click on Thick Crust
    And I select Large Pizza
    And I confirm Order by clicking on Yes Button
    Then I submit positive feedback

    Examples:
      | firstName | emailId |
      | Test      | test@test.com |
