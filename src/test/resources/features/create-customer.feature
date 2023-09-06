Feature: Create a new customer

    Scenario: Create a customer via POST
        Given receiver a Post Request with the following data:
            | Name                             | Document Number   | Person Type | Birth Day   | Membership Number | Active |
            | Alexandre Bezerra de Queiroz     | 033968855612      | INDIVIDUAL  | 2020-01-01  | 1                 | true   |

        When the customer is created via POST
        Then the HTTP response is 200 OK
        And the customer is saved in the database
