
@tag @SmokeTests
Feature: CRUD test cases for computer management
  
  @SmokeTests
	Scenario Outline: Create a Computer
	Given When I am in Computer Home page
	When I add a new computer
	Then I will get success message
    Examples: 
      | CompName  | Intro | Disconn  | CompanyName |
      | ComputerOne |     03-07-2022 | 03-08-2022 | IBM |
			| Computertwo |     2022-07-30 | 04-08-2022 | IBM |
      | Comp_123@Test|     05-07-2022 | 05-08-2022 | IBM |
      | Comp    Test |     03-07-2022 | 03-08-2022 | IBM |
			|             001|     04-07-2022 | 04-08-2022 | IBM |
      | ____________  |     05-07-2022 | 05-08-2022 | IBM |     
      
Given when I Add a new computer
When I try to search for the newly created computer
Then 

  @tag1
  Scenario: Title of your scenario
    Given I want to write a step with precondition
    And some other precondition
    When I complete action
    And some other action
    And yet another action
    Then I validate the outcomes
    And check more outcomes

  @tag2
  Scenario Outline: Title of your scenario outline
    Given I want to write a step with <name>
    When I check for the <value> in step
    Then I verify the <status> in step

    Examples: 
      | name  | value | status  |
      | name1 |     5 | success |
      | name2 |     7 | Fail    |
