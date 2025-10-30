Feature: Tour login
This feature deals with the login functionality.

Background:
	Given I navigated to login page
	
@TC1
Scenario: Login with the correct username and correct password

	#Given I navigated to login page
	And I entered the username and password
	And I clicked the signin button
	Then Its navigated to the HomePage correctly
	
@TC2
Scenario: Login with the correct username and wrong password
 
	#Given I navigated to login page
	And I entered the username and password
	But Invalid password
	And I clicked the signin button
	Then It navigates to the Error Page
	
	

	
@TC3
Scenario: Running login using datatable 

	#Given I navigated to login page
	When I entered following details
	| userName | password |
	| mercury  | mercury  |
	|mercury   | 12345678 |
	And I clicked the signin button
	Then Its navigated to the HomePage correctly
	
@TC4
Scenario Outline: Data driven testing using Scenarion Outline
 
	#Given I navigated to login page
	#And I entered username and password
	When I insert "<userName>" and "<passWord>"
	And I clicked the signin button
	#Then Its navigated to the HomePage correctly
	Then Its navigated to the "<expectedResult>"
	
	Examples:
	| userName | passWord | expectedResult |
	| mercury    | mercury | Login Successfully |
	| mercury    | aaa | Enter your userName and password correct |
	| bbb    | mercury | Enter your userName and password correct |
	
	