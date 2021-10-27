Feature: Spring 1 SimplifyVMS project scenario

        Scenario: Verify whether User is able to access  -  VMS Application
        Given Enter application URL in address bar
        When  Enter Username
        Then  Enter Password
        And   Click Sing_In
#
#        Scenario: Verify the default screen displayed for Client User
#        Given Check the default screen after log in
#
#        Scenario: Adjust Dashboard
#        Given In Dashboard, click the Setting Icon in the top right hand corner
##      Then  User can move dashboard items around, and expand/contract them
#        Then User can Add New Widget, Save dashboard configuration, empty dashboard and close editing
#
#        Scenario: View and Adjust User Settings
#        Given In Dashboard, click user icon picture in bottom left corner; a flyout window will open and click on ""Account Settings""
#        When User can change specific items on user, including user photo
#        Then If changes made, click ""Save"""
#
#        Scenario: Add Job in system
#        Given Click the second icon on the left navigation panel
#        Then A flyout window will appear. Click on ""Create Job""
#        Then On the job template field, enter the job title or look for the desired job title under "Recent Job Templates" or "Popular Job Templates"
#        Then Select the job manager - work location will be auto populated; continue to select program industry
##        Then Add a job description
#        Then Click on "Continue" button"
#
#        Scenario: Add Job in system
#        Given In second page of Add Job, selected the estimated started and end dates of the Job,number of positions, expense allowed, Currency, Unit of Measure, Min and Max Bill Rate, and Over time exempt
#        Then Post entry, scroll down to end of page to view the budget
#        Then Click "view detailed estimate" to view the components that add up to create the budget; change details as needed
#        Then Click "Continue"
#
#        Scenario: Add Job in system
#        Given The foundational data will be defaulted based on the selection made . Click each field to make changes if necessary
#        Then Click "Submit" to create the job
#
#        Scenario: View Job Workflow on Job Requisition
#        Given Once submitted, the user will be shown the details of the job created
#        Then Click on the approvals tab on the job detatils page to view the approval workflow
#        Then You should see the first level of approval as the Hiring Manager and the second level of approval as HM+1"

        Scenario: Approve Step 1 of Job Requisition
        Given Login as Hiring manager using the credentials for the Hiring Manager
        Then From the dashboard under pending actions widget, click on jobs pending approval
        Then Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.
        Then Click on approve
