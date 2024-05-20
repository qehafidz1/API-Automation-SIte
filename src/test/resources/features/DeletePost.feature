Feature: Delete a post
  As a user
  I can delete a post
  So that my post is removed

  Scenario: As a user I can delete a post with valid ID
    Given I set API endpoint for delete a post
    When I send request to delete a post
    Then I receive status code 200