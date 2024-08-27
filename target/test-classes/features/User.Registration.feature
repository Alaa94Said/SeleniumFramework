		Feature: User Registration
    I want to check that the user can register in our e-commerce website.
      
      
      Scenario Outline: User Registration
      
      Given the user in the home page
      When  I click on register link
      And   I enter "<firstname>" "<lastname>" "<email>" "<password>"
      Then the registraion page displayed succefully

			Examples:
			| firstname | lastname | email | password
			| Lilly | ab |dghuhij@gmail.com | 7265656
			| mohamed | ab |dghuhfdij@gmail.com | 7265656	
			| Boody | ab |dghusdhij@gmail.com | 7265656
			

