Feature:Dog API


@wip
  Scenario: Get list of breeds
    Given Accept header is "application/json"
    When I send GET request to "/breeds" endpoint
    Then status code should be 200
    And Response Content type is "application/vnd.api+json; charset=utf-8"
    And the field value for "data[0].type" path should be equal to "breed"
