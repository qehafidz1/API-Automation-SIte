Feature: Update post
  As a user
  I want to update a post
  So that my post is updated

  Scenario: As a user I can update a post with valid inputs
    Given I set API endpoint for update a post
    When I send request to update a post
    Then I receive status code 200
    And I receive valid data for updated post