Feature: Login

#Background: Common steps for Every scenario
   
   
   Scenario: login with invalid Email ID
 Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "learnedUser@" And password as "qwerty@1"
    And click on login
    And close browser
    
     Scenario: login with invalid password
 Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "prasanna@enhanzed.com" And password as "qwerty"
    And click on login
    And close browser

    
    Scenario: login with invalid user Credentails
 Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as " prasannamj003@gmail.com " And password as " qwerty@1 "
    And click on login
    And close browser
    
     Scenario: login with blank data
 Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "" And password as ""
    And click on login
    And close browser

@regression
Scenario Outline: login data driven
 Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "<email>" And password as "<password>"
    And click on login
    #Then page title should be "LearnED"
		When user click on logout button
    And close browser
    
    Examples:
    | email | password |
    | prasanna@enhanzed.com | qwerty@1 |