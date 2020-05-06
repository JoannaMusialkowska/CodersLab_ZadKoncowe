Feature: final exercise
  Scenario Outline:
    Given open browser with https://prod-kurs.coderslab.pl page open
    When user clicks SIGN IN button
    And user is logged as <username>
    And with password <password>
    And chooses addresses section
    And clicks CREATE NEW ADDRESS button
    And enters new alias <alias>
    And enters new address <address>
    And enters new city <city>
    And enters new zip/postal code <postal>
    And enters new phone <phone>
    And clicks SAVE button
    Then checks if entered data is appropriate
    And close browser
    Examples:
      |username                   | password     | alias       | address     |  city     | postal     | phone      |
      |joanna_musialkowska@tlen.pl| 123CodersLab | Zuzek       | Dzika 7     |  Uć       | 020406     | 6078090    |





