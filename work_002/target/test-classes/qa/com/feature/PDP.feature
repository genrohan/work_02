Feature: Searching for a product on Amazon.in and storing its details

@ProductDetails
Scenario Outline: User wants to store the details of the product
Given User is on "https://www.amazon.in" Home page
When User search for "<product>"
And User is on the product detail page
Then User stores data in a notepad file with path
And User stores data in a excel file with path
Examples:
		| product |
		| one plus7T |
		| MacBook Air |