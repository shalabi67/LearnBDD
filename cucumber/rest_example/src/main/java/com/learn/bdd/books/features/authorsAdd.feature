@authors
Feature: Authors
  Adding, deleting, changing and listing authors

  Background:
    Given authors system is started

  @authorAdd @main
  Scenario Outline: Add Author
    When user provides author information <firstName>, <lastName> and <email>
    Then system validate author email
    And system validate author first name
    And system validate author last name
    And system add user
    Examples:
      | firstName | lastName | email |
      | Mohammad  | Shalabi | shalabi@gmail.com |
      | Samer     | Shalabi | samer@gmail.com |

  @authorAdd @alternative
  Scenario Outline: Add Author without email
    When user provides missing author information <firstName> and <lastName>
    Then System returns Invalid or missing email
    Examples:
      | firstName | lastName |
      | mohammad | shalabi |
      | kamal | kameel |


