Feature: post user features

  Scenario: add user by post method
    Given base URI, ContentType and body
    When user provide resource and parameter along with POST method
    Then user should be able to see status code, content type, response body as per requirement