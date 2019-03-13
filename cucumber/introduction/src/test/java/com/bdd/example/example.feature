@example @billing
Feature: Example
  #These steps in the background will run for every scenario.
  Background:
    Given The example system is started

  @example @main
  Scenario: Example One
    When user do an action
    Then System do something

    #example of regular expressions
  @example @main
  Scenario: Show name
    When user do provide "mohammad"
    Then System shows "welcome, mohammad"


    #Data tables example: notice when using data tables the systzem will run all test cases as single test cases
  #and it is the developer responsibility on manipulated data, which the oposit of the case od Scenario Outline
  @example @user @main
    Scenario: add valid user
    Given user add page is called
    When user provide user details
    #| user name | password | email | first name | last name |
    | shalabi67 | 123      | shalabi67@qw.com | mohammad | shalabi |
    | shalabi68 | 456      | shalabi68@qw.com | mai | shalabi |
    | shalabi69 | 789      | shalabi69@qw.com | malath | shalabi |
    Then system log user in

  #In this example we will show how to have parameters. notice that every row will be treated as a separate test run
  @example @billing @sum @main
  Scenario Outline: Sum Example
    When <value1> + <value2> the result is <result>
    Examples:
      |  value1 | value2 | result |
      |  5 | 10 | 15 |
      |  2 | 10 | 12 |
      |  5 | 5 | 10 |
