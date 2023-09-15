Feature: User Registration

Scenario: Successful user registration
Given User on the Home page
When User click on Rigster button
And User fill in the personal details
And User click on the Register button
And User should see a Register message
And User click on Continue
Then User should be redirected to the homepage
