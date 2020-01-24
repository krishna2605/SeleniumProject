Feature: To test Manage loans functionality
@Manageloans

    Scenario:Check whether it is showing the loan details page or not
    Given Logged in as admin
    When Admin enters valid credentials
    Then Loan details of user should be displayed
    
    @Insufficient
    
    Scenario:Check whether insufficient balane showing or not
    Given user is logged in as admin
    When Click on member payment and enter details
    Then Insufficient amount is displayed

   