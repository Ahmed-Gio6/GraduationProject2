Feature: Login Functionality

  Scenario: Validate That User Can Login With Valid Data
    Given User navigate to login page
    When  User go to login page
    And   User enter valid email "ahmedshanb@gmail.com"
    And   User enter valid password "1234"
    And   User click button
    Then  User should login successfully

  Scenario Outline: Validate That User Can Login With Valid Data
    Given User navigate to login page
    When  User go to login page
    And   User enter valid email "<Email>"
    And   User enter valid password "<password>"
    And   User click button
    Then  Error message should be displayed

    Examples:
      | Email                    | password |
      | ahmedshanb@gmail.com     | test123  |
      | AhmedSaadShanb@gmail.com | 1234     |
      | test2@gmail.com          | test123  |
      |                          | 1234     |
      | ahmedshanb@gmail.com     |          |
      |                          |          |

