Feature: Get and Put All Brands List
	Scenario: Retrieve all brands
		Given I have the API endpoint "https://automationexercise.com/api"
		When I send a GET request to the endpoint "/brandsList"
		Then the response code should be 200
		And the response JSON should contain all brands list
	
	Scenario: Attempt to put to brands list
		Given I have the API endpoint "https://automationexercise.com/api"
		When I send a PUT request to the endpoint "/brandsList"
		Then the response code should be 405
		And the response message should be "This request method is not supported."