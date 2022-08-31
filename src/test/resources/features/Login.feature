Feature: Login feature

  @smoke @sprint29
  Scenario: Valid admin login
    #Given user is navigated to HRMS application
    When user enters valid admin username and password
    And user clicks on login button
    Then admin user is successfully logged in

  @regression @sprint31 @arif
  Scenario: Valid ess login
    #Given user is navigated to HRMS application
    When user enters ess username and password
    And user clicks on login button
    Then ess user is successfully logged in

  @regression
  Scenario: Invalid login
    #Given user is navigated to HRMS application
    When user enter invalid username and password
    And user clicks on login button
    Then user is able to see error message

    @login
    Scenario Outline: Negative login test
      When user enters different "<username>" and "<password>" and verify the "<error>"
      Examples:
        | username | password | error |
        |admin     |xyz       |Invalid credentials|
        |cristiano |Hum@n     |Invalid credentials|
        |          |Hum@nhrm123|Username cannot be empty|
        |admin     |           |Password cannot be empty|
