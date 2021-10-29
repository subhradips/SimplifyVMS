Feature: Spring 1 SimplifyVMS project scenario

        Scenario: Verify whether User is able to access  -  VMS Application MSP User
        Given Enter application URL in address bar
        When  Enter Username
        Then  Enter Password
        And   Click Sing_In

#        Scenario: Verify the default screen displayed for Client User MSP User
#        Given Check the default screen after log in
#
#        Scenario: Adjust Dashboard MSP User
#        Given In Dashboard, click the Setting Icon in the top right hand corner
##      Then  User can move dashboard items around, and expand/contract them
#        Then User can Add New Widget, Save dashboard configuration, empty dashboard and close editing
#
#        Scenario: View and Adjust User Settings MSP User
#        Given In Dashboard, click user icon picture in bottom left corner; a flyout window will open and click on ""Account Settings""
#        When User can change specific items on user, including user photo
#        Then If changes made, click ""Save"""
##
#        Scenario: Add Job in system MSP User
#        Given Click the second icon on the left navigation panel
#        Then A flyout window will appear. Click on ""Create Job""
#        Then On the job template field, enter the job title or look for the desired job title under "Recent Job Templates" or "Popular Job Templates"
#        Then Select the job manager - work location will be auto populated; continue to select program industry
##        Then Add a job description
#        Then Click on "Continue" button"
#
#        Scenario: Add Job in system MSP User
#        Given In second page of Add Job, selected the estimated started and end dates of the Job,number of positions, expense allowed, Currency, Unit of Measure, Min and Max Bill Rate, and Over time exempt
#        Then Post entry, scroll down to end of page to view the budget
#        Then Click "view detailed estimate" to view the components that add up to create the budget; change details as needed
#        Then Click "Continue"
#
#        Scenario: Add Job in system MSP User
#        Given The foundational data will be defaulted based on the selection made . Click each field to make changes if necessary
#        Then Click "Submit" to create the job
#
#        Scenario: View Job Workflow on Job Requisition MSP User
#        Given Once submitted, the user will be shown the details of the job created
#        Then Click on the approvals tab on the job detatils page to view the approval workflow
#        Then You should see the first level of approval as the Hiring Manager and the second level of approval as HM+1"
#
#        Scenario: Approve Step 1 of Job Requisition Client User/HM
#        Given Login as Hiring manager using the credentials for the Hiring Manager
#        Then From the dashboard under pending actions widget, click on jobs pending approval
#        Then Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.
#        Then Click on approve
#
#        Scenario: Approve Step 2 of Job Requisition Client User/HM
#        Given Login as Hiring manager+1 using the credentials for the Hiring Manager+1
#        Then  From the dashboard under pending actions widget, click on jobs pending approval
#        Then Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.
#        Then Click on approve

#        Scenario: Release Job to supplier/s MSP User
#        Given Log back in as the MSP User, click on the briefcase icon on the left navigation panel and from the flyout window select View All jobs
#        Then Click on the Job title of the Job you're working on
#        Then Job Details should open and you will find an actions button on the top right corner of the screen;
#        Then select Distribute
#        Then This will bring the user to the distribute tab and the user can type to search the vendors
#        Then Once added, Click on Enbale Submission Limit toggle to set it ON or OFF
#        Then Click on Distribute

        Scenario: Create and Submit Candidate as Vendor
        Given Login as Supplier to which job was distributed
        Then In the user's dashboard, from "Pending Actions" widgets click on "New Job Requests"
        Then This will open Jobs needing submittal
        Then Click on the job you created; this will redirect you to "Job Details" Section
        Then Click on the actions button on the top right corner and select
        And add & submit candidate to create and submit candidate
        And Submit candidate to select candidates from the list of available candidates
        Then Fill in the necessary details and click on submit candidate