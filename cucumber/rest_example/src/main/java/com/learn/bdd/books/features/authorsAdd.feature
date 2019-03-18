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

  @authorAdd @alternative @invalid
  Scenario Outline: Add Author without email
    When user provides missing author information <firstName> and <lastName>
    Then System returns Invalid or missing email
    Examples:
      | firstName | lastName |
      | mohammad | shalabi |
      | kamal | kameel |


  @authorAdd @alternative @invalid
  Scenario Outline: Add Author with invalid email
    When user provides invalid email <firstName>, <lastName> and <email>
    Then System returns Invalid or missing email
    Examples:
      | firstName | lastName | email |
      | Mohammad  | Shalabi | shalabigmail.com |
      | Samer     | Shalabi | samer@@gmail.com |
      | Samer     | Shalabi | samer@gmail..com |

  @authorAdd @alternative @invalid
  Scenario Outline: Add Author with missing first name
    When user provides author information <email> and <lastName> with missing first name
    Then System returns Invalid or missing first name
    Examples:
      | email | lastName |
      | shalabi@gmail.com | shalabi |
      | samer@gmail.com | kameel |

