#language:en

@UserCreation @User
@WebService
Feature: User Creation
  The Web Service must be able to handle requests to create user data

  Background:
    Given I use user creation service

  Scenario: Add user with job
    When I set name "Toy"
    And I set job "Singer"
    Then I validate my response is correct

  Scenario: Delete user
    Then I validate the user was deleted

  Scenario: Submit a new register without password
    When I post a request with a new register without password
      | email    | challenge@automation.com |
    Then I validate that is not possible to submit a register without password
