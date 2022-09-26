Feature: ResetPassword

Scenario: Forgot Password with valid Email
Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Click on ForgotPassword link
    And user Enters Email Id as "prasanna@enhanzed.com" 
    And click on Next Button
    And verify Reset password page Displayed or not  
    And verify Reset password page UI
    And verify Reset password page Error messages
    And Check Reset password Functionality
    And close browser