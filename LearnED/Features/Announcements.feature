#Author: prasanna@enhanzed.com


Feature: DashBoard program Announcements
  
  Scenario: Getting All announcements
   Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "meghana.enhanzed@gmail.com" And password as "qwerty@1"
    And click on login
    And click on program name in Announcements
    And close browser
 
