#language:en

@SubscriptionSimulation @Product
@Browser @Chrome
Feature: Subscription Simulation
  As a Standard User of the application
  I want to simulate subscription of products

  Background:
    Given I open Chrome and launch the application

  Scenario: Full special support plan for 6 months simulation
    When I select type "Special"
    And I select support plan "Full"
    And I write monthly duration of "6"
    And I click in calculate price button
    Then I validate price is "2249.10 $"
