Feature: End to End Order flow

@e2e
Scenario: User places order successfully
Given User opens Green Kart Page
When User adds vegetables to cart
 | Brocolli - 1 Kg|
 | Cucumber - 1 Kg|
 | Tomato - 1 Kg | 
And User proceeds to checkout
And User completes checkout
Then Order should be placed successfully

@negative
Scenario: User tries to checkout with empty cart
Given User opens Green Kart Page
When User clicks on checkout without adding items
Then User should see empty cart message

@excel
Scenario Outline: User places order successfully
Given User opens Green Kart Page
When User orders vegetables from excel "<testCaseId>"
And User proceeds to checkout
And User completes checkout
Then Order should be placed successfully
Examples: 
	|testCaseId|
	|TC01|
	|TC02|
	|TC03|

@json
Scenario: User places order successfully
Given User opens Green Kart Page
When User adds vegetables from json
And User proceeds to checkout
And User completes checkout
Then Order should be placed successfully

