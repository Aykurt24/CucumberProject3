Feature: Order List Functionality

  @SmokeTest
  Scenario: Verify number of items on the order list
    Given Navigate to smartbearsoftware
    When Enter the username and password and click on login button
    Then Verify Number Of Items On the Order List
    Then Delete All items on The Order List and Verify no Items on the order List

