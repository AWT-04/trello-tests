Feature: Card feature
  As owner, I want to add, delete and update a card, so that I can verify the UI board

  Background:
    Given I log in with the user "owner"
    And I navigate to created board

  @createBoard @deleteBoard
  Scenario: Verify the cards creation in list
    When I create the following card:
      | Name | Selenium tasks |
    Then I should see "Selenium tasks" in the list of cards
#    And I should see "Selenium tasks" in the menu of activity
    And I select the card "Selenium tasks"
#    And I should see "Selenium tasks" in the title after selecting card
    And I should see "Selenium tasks" in the page title

  @createBoard @deleteBoard
  Scenario: Delete a card in boards
    When I create the following card:
      | Name | Selenium tasks |
    When I delete "Selenium tasks" card
    Then I should NOT see "Selenium tasks" in the list of cards

#  @createBoard @deleteBoard
#  Scenario: Update card name in board from the card form
#    When I create the following card:
#      | Name | Selenium tasks |
#    And I modify card "Selenium tasks" with the following data:
#      | Name        | New Selenium 3.0           |
#      | Description | Tasks for writing more tests |
#      | Comment     | Should be done today         |
#    And I close the card form
#    Then I should see "New Selenium 3.0" in the list of cards
##    And I should see "New Selenium 3.0" in the menu of activity
#    And I select the card "New Selenium 3.0"
#    And I should see "New Selenium 3.0" in the title after selecting card
#    And I should see "New Selenium 3.0" in the page title

  @createBoard @deleteBoard
  Scenario: Update card name in board
    When I create the following card:
      | Name | Selenium tasks |
    And I modify the name of card "Selenium tasks" to "New Selenium 3.0"
    Then I should see "New Selenium 3.0" in the list of cards
#    And I should see "New Selenium 3.0" in the menu of activity
    And I select the card "New Selenium 3.0"
#    And I should see "New Selenium 3.0" in the title after selecting card
    And I should see "New Selenium 3.0" in the page title
    And I close the card form
#    And I should see "New Selenium 3.0" in the page title
