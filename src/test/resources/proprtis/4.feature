Feature: Login
Scenario Outline: validate uid field
Given launch site
When enter uid as "<u>"
And click uid next button
Then check uid outcome with "<uc>" criteria
When close site

Examples: 
      |       u        | uc          |
      | harryharish81  | uid-valid   |
      |                | uid-invalid |
      | harryharish819 | uid-invalid |

Scenario Outline: validate pwd field
Given launch site
When enter uid as "harryharish81"
And click uid next button
And enter pwd as "<p>"
And click pwd next button
Then click pwd outcome with "<pc>" criteria
When close site

Examples:
      | p              | pc          |
      | BL@CKberryz10  | pwd-valid   |
      |                | pwd-invalid |
      | harryharish819 | pwd-invalid |
