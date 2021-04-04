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
