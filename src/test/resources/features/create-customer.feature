Feature: Create Customer

Scenario: Create a new Customer
    Given no one customer is registered
    When send a valid request to POST/ customer
    Then response with a SUCCESS 200