Feature: SignUp


  Scenario:SignUp verification

    Given User in AH4R  homepage
    When User clicks on signUp button
    And User enters sigUp credentials and hits create button
    Then User should see congratulations confirmation message




