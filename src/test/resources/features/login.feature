Feature: Spring 1 SimplifyVMS project scenario

        Scenario: Verify whether User is able to access  -  VMS Application
        Given Enter application URL in address bar
        When  Enter Username
        Then  Enter Password
        And   Click Sing_In

        Scenario: Verify the default screen displayed for Client User
        Given Check the default screen after log in

        Scenario: Adjust Dashboard
        Given In Dashboard, click the Setting Icon in the top right hand corner
#      Then  User can move dashboard items around, and expand/contract them
        Then User can Add New Widget, Save dashboard configuration, empty dashboard and close editing

        Scenario: View and Adjust User Settings
        Given In Dashboard, click user icon picture in bottom left corner; a flyout window will open and click on ""Account Settings""
        When User can change specific items on user, including user photo
        Then If changes made, click ""Save"""
