#Author: prasanna@enhanzed.com

Feature: FAQ Screen

  @tag1
  Scenario: UI Verification in FAQ Page
    Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "prasanna@enhanzed.com" And password as "qwerty@1"
    And click on login
    And User Click on FAQ Link
    Then Read the Titles of the table with Number Of Question in Student tab
    Then Read the Titles of the table with Number Of Question in Instructor tab
    Then Read the Titles of the table with Number Of Question in Program Coordinator tab
    Then Read the Titles of the table with Number Of Question in Admin tab 
    And close browser
  