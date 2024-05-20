Feature: Create a post
  As a user
  I want to create a post
  So that my post is published

  Scenario: As a user I can create a new post with valid inputs
    Given I set API endpoint for create a new post
    When I send request to create a new post
    Then I receive status code 201
    And I receive valid data for created post

  Scenario: As a user I cannot create a new post with invalid inputs
    Given I set API endpoint for create a new post
    When I send request to create a new post with invalid inputs
    Then I receive status code 400