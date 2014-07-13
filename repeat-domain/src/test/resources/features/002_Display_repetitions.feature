Feature: Display a user's list of repetitions
  As a user
  I can display my list of repetitions along with their next date
  In order to see what my next deadlines are

  Scenario: Display my repetitions
    Given I am a user
    And I create the following periodic repetitions
      | description            | period | start date |
      | répétition de 10 jours | 10     | 01/01/2020 |
      | répétition de 5 jours  | 5      | 01/01/2020 |
      | répétition de 2 jours  | 2      | 02/01/2020 |
    And I create the following end of month repetitions
      | description                      | number of days before the end of the month |
      | répétition 3j avant fin du mois  | 3                                          |
      | répétition 24j avant fin du mois | 24                                         |
    And today is the  "03/01/2020"
    When I list my repetitions ordered by next date
    Then I get the following list of repetitions :
      | description                      |
      | répétition de 2 jours            |
      | répétition de 5 jours            |
      | répétition 24j avant fin du mois |
      | répétition de 10 jours           |
      | répétition 3j avant fin du mois  |
