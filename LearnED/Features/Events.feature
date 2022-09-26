#Author: prasanna@enhanzed.com
Feature: DashBoard Events feature
  

   Scenario: Getting All Events
   Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "meghana.enhanzed@gmail.com" And password as "qwerty@1"
    And click on login
    And Read all events
    And close browser
