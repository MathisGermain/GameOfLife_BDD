Feature: Finding next state of a living cell
  As a player
  I want to find the next state of a living cell

  Scenario: living cell in center has no living neighbour cell
    Given the following grid
      | . | . | . |
      | . | X | . |
      | . | . | . |
    When player start next generation
    Then cell in center should be '.'

  Scenario: living cell in center has 1 living neighbour cell
    Given the following grid
      | . | X | . |
      | . | X | . |
      | . | . | . |
    When player start next generation
    Then cell in center should be '.'

  Scenario: living cell in center has 2 living neighbours cell
    Given the following grid
      | . | X | . |
      | . | X | X |
      | . | . | . |
    When player start next generation
    Then cell in center should be 'X'

  Scenario: living cell in center has 3 living neighbours cell
    Given the following grid
      | . | X | X |
      | . | X | X |
      | . | . | . |
    When player start next generation
    Then cell in center should be 'X'

  Scenario: living cell in center has 4 living neighbours cell
    Given the following grid
      | . | X | . |
      | X | X | X |
      | . | X | . |
    When player start next generation
    Then cell in center should be '.'

  Scenario: living cell in center has 5 living neighbours cell
    Given the following grid
      | . | X | . |
      | X | X | X |
      | . | X | X |
    When player start next generation
    Then cell in center should be '.'

  Scenario: living cell in center has 6 living neighbours cell
    Given the following grid
      | . | X | X |
      | X | X | X |
      | . | X | X |
    When player start next generation
    Then cell in center should be '.'

  Scenario: living cell in center has 7 living neighbours cell
    Given the following grid
      | X | . | X |
      | X | X | X |
      | X | X | X |
    When player start next generation
    Then cell in center should be '.'

  Scenario: living cell in center has 8 living neighbours cell
    Given the following grid
      | X | X | X |
      | X | X | X |
      | X | X | X |
    When player start next generation
    Then cell in center should be '.'
