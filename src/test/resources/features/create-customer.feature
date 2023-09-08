Feature: Create a new customer

    Scenario: Create a customer via POST
        Given receiver a Post Request with the following data:
            | Name                             | Document Number   | Person Type | Birth Day   | Membership Number | Active |
            | Alexandre Bezerra de Queiroz     | 033968855612      | INDIVIDUAL  | 2020-01-01  | 1                 | true   |

        When the customer is sent via POST
        Then the HTTP should be 200 OK
        And the customer should be saved in the database
