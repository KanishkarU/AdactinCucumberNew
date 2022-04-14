Feature: Validating the login functionality
@smoke
Scenario: verifying the login functionalty with valid username and password 
Given user launches GC browser and enters adactin login page
When user enter the user name '6383184289'  and password 'Cricket@07'
And user clicks in login button
Then Validating user enters into search hotel page
And user print title of the search page 

