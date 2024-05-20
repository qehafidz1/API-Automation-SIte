Feature: Get all posts
  As a user
  I want to get all posts
  So that I can view all posts

  Scenario: As a user I can get all posts
    Given I set API endpoint for get all posts
    When I send request to get all posts
    Then I receive status code 200
    And I receive valid posts data