Feature: Precisely product help feature
  Agile story: As a user, when I am on the Precisely page
  I should be able to find product help and see different options
  @smoke @ui
  Scenario: Product help feature
    When user is on the home page of Precisely
    Then user should see title "Precisely - Your data is meant to be loved."
    And user clicks menu option "Support"
    Then new browser window appears with title "Precisely Support"
    And user selects "Product Help" support option
    Then filter by name option is enabled