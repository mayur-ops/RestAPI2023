Feature: Requres methods automation


  Scenario: list of user
    Given base URI
    When user use get method resource
    Then user should able to see response status code 200


