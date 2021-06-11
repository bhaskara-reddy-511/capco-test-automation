Feature: Searching for flights with from and to airports with date range and max price

  Scenario Outline: Searching round trip flights and make sure all search results are returned round trips
    Given I am on home page "https://www.kayak.co.uk/flights"
    When I enter From "<from_airport>" and To "<to_airport>" airports
    And I enter From Date "<from_date>" and To Date "<to_date>"
    And click on Search Button
    Then Verify Search Results returned round trip
    Examples:
    |from_airport    | to_airport  |from_date      | to_date       |
    |London Heathrow | Chennai     | 10 July, 2021 | 14 July, 2021 |

