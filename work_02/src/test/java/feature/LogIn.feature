Feature: Login Page of flipkart.com

Scenario: Verifying login of the user
Given User is on "https://www.flipkart.com" HomePage
#When User clicks on Login
When User enters details
And User clicks on final Login
Then Verify user is logged in

Scenario: verifu=ying negative login condition
Given User is on "https://www.flipkart.com" HomePage
#When User clicks on Login
When User enters wrong details
And User clicks on final Login
Then User can see error message

Scenario: checking user data
Given User is on "https://www.flipkart.com" HomePage
Then User verifies login credentials from a json file