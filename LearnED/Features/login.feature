Feature: Login

@sanity
Scenario: successful login with valid credentials
    Given user launch chrome browser
    When user opens URL "https://d1if2pjtoq2sst.cloudfront.net/"
    And user Enters Email Id as "prasanna@enhanzed.com" And password as "qwerty@1"
    And click on login
    Then page title should be "LearnED"
		When user click on logout button
    And close browser
    
@regression
Scenario Outline: login data driven
		Given user launch chrome browser
    When user opens URL "https://d1if2pjtoq2sst.cloudfront.net/"
    And user Enters Email Id as "<email>" And password as "<password>"
    And click on login
    Then page title should be "LearnED"
		When user click on logout button
    And close browser
    
    Examples:
    | email | password |
    | prajwal@enhanzed.com | qwerty@1 |
    |prasanna@gmail.com | qwerty@123 |
    