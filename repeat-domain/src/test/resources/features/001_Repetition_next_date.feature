Feature: : Create a repetition
  As a person with a tiny brain
  I want to create a new repetition
  In order not to forget it

  Scenario: Create a yearly repetition
    Given I have a yearly repetition
    When I set the start date to today
    Then the next date is next year

  Scenario: Create a monthly repetition
    Given I have a monthly repetition
    When I set the start date to today
    Then the next date is next month

  Scenario: Create a monthly repetition on the last day of the month
    Given I have a monthly repetition
    When I set the start date to "31/01/2025"
    Then the next date is "28/02/2025"

  Scenario: Create a repetition with any period
    Given I have a repetition with a period of 10 days
    When I set the start date to "01/01/2025"
    Then the next date is "11/01/2025"

  Scenario Template: Create an end of month repetition at the start of the month
    Given I have an end of month repetition <number_of_days> days before the end of the month
    When I set the start date to "<start_date>"
    Then the next date is "<expected_next_date>"
  Examples:
    | number_of_days | start_date | expected_next_date |
    | 5              | 01/01/2025 | 26/01/2025         |
    | 5              | 28/01/2025 | 23/02/2025         |
    | 0              | 28/02/2025 | 31/03/2025         |