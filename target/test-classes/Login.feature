Feature: Verify the login functionality of the facebook

Background: User is on facebook login page

  Scenario: Validate the login functionality of the facebook
    Given user is on facebook login page
    When user enters the invalid username and invalid password
    Then user clicks on the login button
    And user verifies the login functionality

    
    Scenario: Verifying the forgot password page
    When user clicks on the forgot password link
    Then user enters the mobile number for the password recovery
    And user validates the forgot password page
