@Regression @smoke @login
Feature: Library app login feature
  User Story:
  As a user, I should be able to login with correct credentials to
  different accounts. And dashboard should be displayed.

  Accounts are: librarian, student, admin

  Background: For the scenarios in the feature file, user is expected to be on login page
    Given user in on the library login page

  @librarian @employee #@wip # wip stands for "work in progress", we can use this way @wip_ismail
  Scenario: Login as librarian
    #Given user in on the library login page ---> it is not needed anymore
    When user enters librarian username
    And user enters librarian password
    Then user should see the dashboard

  @student @db
  Scenario: Login as student
    #Given user in on the library login page
    When user enters student username
    And user enters student password
    Then user should see the dashboard

  @admin @employee
  Scenario: Login as admin
    #Given user in on the library login page
    When user enter admin username
    And user enter admin password
    Then user should see the dashboard

# this is how we add comments in feature file