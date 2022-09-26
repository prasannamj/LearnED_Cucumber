#Author: prasanna@enhanzed.com
Feature: Course details
 
  Scenario: Click on program in program list
   Given user launch chrome browser
    When user opens URL "https://www.learned.cloud"
    And user Enters Email Id as "prasanna@enhanzed.com" And password as "qwerty@1"
    And click on login
    Then click on program
    Then Select Course
    And View course content
    


  