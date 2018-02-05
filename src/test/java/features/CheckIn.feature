Feature: Search for Hotel Availability

  Scenario: Go to the website of phptravels.net, enter hotelname,check in and check out dates and search

    Given I navigate to the website
      And I click on location menu and enter "Athens, Greece"
      And I click on Check In and set date "3/11/2018"
      And I click on Check Out and set date "10/11/2018"
      And I click on Adults and set "1"
      And I click search button
    Then I should see the page