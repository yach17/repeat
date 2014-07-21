Feature: Create a repetition using a creation command
  As an external module or library
  I can issue a creation command
  In order to create a repetition

  Scenario:
    Given I am a user
    When I issue a command to create a repetition with the following configuration :
      | description | Clean the car       |
      | type        | periodic repetition |
      | config      | 6 months            |
    Then I have a periodic repetition "Clean the car" with a period of 6 months
