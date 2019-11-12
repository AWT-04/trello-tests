Feature: Create new board in Trello
  As a owner, I want create a new board, so that I can verify in the UI board.

  Background:
    Given I log in with the user "owner"

  Scenario: Create new board with boards page
    When I create new board from "boards page" with a:
      | Title | Fernando |
    Then I should see the board



