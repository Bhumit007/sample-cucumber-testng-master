@regression
Feature: Login to orangeHRM Application
  Scenario: Check orangeHRM positive cases
    Then I go to OrangeHRM Home page.
    When I enter username and password.
    And I navigate to PIM tab and click on add employee.
    And I enter employee details and save it.
