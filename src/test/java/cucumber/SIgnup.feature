Feature: User account management

  Scenario: Create new account
    Given I navigate to the "Create Account" page
    When I enter valid account details
    And I click the "Create an Account" button
    Then I should see a success message  as "Thank you for registering with Main Website Store."
    And I should be redirected to the account dashboard


  Scenario Outline: Sign in with valid credentials
    Given I navigate to the "Sign In" page
    When I enter username "<username>" and password "<password>"
    And I click the "Sign In" button
    Then I should be redirected to the account dashboard
    Examples:
      | username                     | password  |
      | ayushiagarwal.1804@gmail.com | Ayushi@18 |


  Scenario: Sign in with invalid credentials
    Given I navigate to the "Sign In" page
    When I enter invalid credentials
    And I click the "Sign In" button
    Then I should see an error message