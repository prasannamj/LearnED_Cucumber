Feature: ForgotPassword


Scenario Outline: Forgot Password Data Driven
Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Click on ForgotPassword link
    And user Enters Email Id as "<email>" 
    And click on Next Button
    And verify Forgot Passowrd page Error Messages 
    And close browser
    
    Examples:
    | email |
    |       |
    |Prasanna@gmail.com|
   
