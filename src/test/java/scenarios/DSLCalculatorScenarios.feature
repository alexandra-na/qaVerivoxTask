@DSLCalculator

Feature: AS A User
         I WANT TO use the DSL Calculator
         SO THAT I am able to select the best possible tariff for me

   Scenario: DSL Result List - verify result list
    Given the User is on www.verivox.de
    When he is on the DSL calculator
    And he enters prefix/code “Ihre Vorwahl” as 030 with 16 Mbit/s bandwidth selection
    And clicks on the button labeled as "JETZT VERGLEICHEN"
    Then he should be able see the Result List page with all the available Tariffs

  Scenario: Result List - verify Offer detail page
    Given the User is on the DSL Result List
    When he selects one of the listed Tariffs
    Then he should be able see the details of the selected Tariff
    And he should also see a button labeled as "In 5 Minuten online wechseln"

  Scenario: Lazy loading/pagination for loading the Result List
    Given the User is on the DSL Result List
    When there are more than 20 tariffs available for the provided Vorwahl and bandwidth
    And the User should see button labeled as "20 weitere laden"
    And he clicks on this button
    Then the list should be appended with next 20 tariffs and so on until all Tariffs are loaded