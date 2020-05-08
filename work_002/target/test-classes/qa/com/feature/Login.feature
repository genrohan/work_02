Feature: Login Page of flipkart.com

@Positive
Scenario Outline: Verifying login of the user
Given User is on "https://www.flipkart.com" HomePage
#When User clicks on Login
When User enters "<mail/phn>" and "<password>"
And User clicks on final Login
Then Verify "<user>" is logged in
Examples:
		| 	mail/phn	 |  password  |		user	|
		|			 				|						|					|

@Negative
Scenario Outline: verifying negative login condition
Given User is on "https://www.flipkart.com" HomePage
#When User clicks on Login
When User enters wrong "<mail/phn>" and "<password>"
And User clicks on final Login
Then User can see error message
Examples:
		| 	mail/phn	 |  password  	 |ername	|
		| 	abc123 	 |	 	12345  |	ABC	|
		| 7872125565 | 	12345 	 |	Rohan	|


@JSON
Scenario: checking user data
Given User is on "https://www.flipkart.com" HomePage
Then User verifies login credentials from a json file