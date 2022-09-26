Feature: Notification

 Background: Common steps for Every scenario
    Given user launch chrome browser
    When user opens URL "https://www.learned.cloud/"
    And user Enters Email Id as "prasanna@enhanzed.com" And password as "qwerty@1"
    And click on login


Scenario: Notification view and count
    When user click on notification icon
    Then count the number notification
		When user click on logout button
    And close browser