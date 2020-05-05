Feature: Searching for a produc and storing its details

Scenario: User wants to store the details of the product
Given User is on Amazon Home page
When User search for "one plus7T"
And User is on the product detail page
Then User stores data in a notepad file with path 
And User stores data in a excel file with path