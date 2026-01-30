# Testing Login Functionality

Feature: Login using DI + Context (PicoContainer)

  Scenario: Successful login should show secure area message
    Given I am on the Internet login page
    When I login with valid credentials
    Then I should see the secure area success message