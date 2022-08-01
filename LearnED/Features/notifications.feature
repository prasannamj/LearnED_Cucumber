Feature: Notification

 Background: Common steps for Every scenario
    Given user launch chrome browser
    When user opens URL "https://d1if2pjtoq2sst.cloudfront.net/"
    And user Enters Email Id as "prasanna@enhanzed.com" And password as "qwerty@1"
    And click on login


Scenario: Notification view and count
    Then page title should be "LearnED"
    When user click on notification icon
    Then count the number notification
		When user click on logout button
    And close browser