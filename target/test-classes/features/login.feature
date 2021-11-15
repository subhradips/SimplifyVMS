@SimplifyVMS_Login
Feature: Spring 1 SimplifyVMS project scenario

        Scenario: Verify whether User is able to access  -  VMS Application MSP User
                Given Enter application URL in address bar
                When  Enter Username
                Then  Enter Password
                And   Click Sing_In

#        Scenario: Verify the default screen displayed for Client User MSP User
#                Given Check the default screen after log in

        Scenario: Adjust Dashboard MSP User
                Given In Dashboard, click the Setting Icon in the top right hand corner
#      Then  User can move dashboard items around, and expand/contract them
                Then User can Add New Widget, Save dashboard configuration, empty dashboard and close editing

        Scenario: View and Adjust User Settings MSP User
                Given In Dashboard, click user icon picture in bottom left corner; a flyout window will open and click on ""Account Settings""
                When User can change specific items on user, including user photo
                Then If changes made, click ""Save"""

        Scenario: Add Job in system MSP User
                Given Click the second icon on the left navigation panel
                Then A flyout window will appear. Click on ""Create Job""
                Then On the job template field, enter the job title or look for the desired job title under "Recent Job Templates" or "Popular Job Templates"
                Then Select the job manager - work location will be auto populated; continue to select program industry
#          Then Add a job description
                Then Click on "Continue" button"

        Scenario: Add Job in system MSP User
                Given In second page of Add Job, selected the estimated started and end dates of the Job,number of positions, expense allowed, Currency, Unit of Measure, Min and Max Bill Rate, and Over time exempt
                Then Post entry, scroll down to end of page to view the budget
                Then Click "view detailed estimate" to view the components that add up to create the budget; change details as needed
                Then Click "Continue"

        Scenario: Add Job in system MSP User
                Given The foundational data will be defaulted based on the selection made . Click each field to make changes if necessary
                Then Click "Submit" to create the job

        Scenario: View Job Workflow on Job Requisition MSP User
                Given Once submitted, the user will be shown the details of the job created
                Then Click on the approvals tab on the job detatils page to view the approval workflow
                Then You should see the first level of approval as the Hiring Manager and the second level of approval as HM+1"

        Scenario: Approve Step 1 of Job Requisition Client User/HM
                Given Login as Hiring manager using the credentials for the Hiring Manager
                Then From the dashboard under pending actions widget, click on jobs pending approval
                Then Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.
                Then Click on approve
#
        Scenario: Approve Step 2 of Job Requisition Client User/HM
                Given Login as Hiring manager+1 using the credentials for the Hiring Manager+1
                Then  From the dashboard under pending actions widget, click on jobs pending approval
                Then Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.
                Then Click on approve

        Scenario: Release Job to supplier/s MSP User
                Given Log back in as the MSP User, click on the briefcase icon on the left navigation panel and from the flyout window select View All jobs
                Then Click on the Job title of the Job you're working on
                Then Job Details should open and you will find an actions button on the top right corner of the screen;
                Then select Distribute
                Then This will bring the user to the distribute tab and the user can type to search the vendors
                Then Once added, Click on Enbale Submission Limit toggle to set it ON or OFF
                Then Click on Distribute

        Scenario: Create and Submit Candidate as Vendor
                Given Login as Supplier to which job was distributed
                Then In the user's dashboard, from "Pending Actions" widgets click on "New Job Requests"
                Then This will open Jobs needing submittal
                Then Click on the job you created; this will redirect you to "Job Details" Section
                Then Click on the actions button on the top right corner and select
                And add & submit candidate to create and submit candidate
                And Submit candidate to select candidates from the list of available candidates
                Then Fill in the necessary details and click on submit candidate

        Scenario: Shortlist candidate/s as Program MSP user
                Given Login as the MSP user
                Then In Pending Actions click on Resumes to Review. Alternatively, navigate to the job from the left navigation pane and click on the job you are working on. You should be able to see a tab named Submitted Candidates
                Then This will bring up list of all submitted candidates. You can either review each one by clicking the Candidate's name
                Then Review the candidate details. Click on "Reject" to review Rejection reasons in module; for this exercise, click "Shortlist"

        Scenario:Schedule Interview MSP user
                Given On the candidate details page, after reviewing the candidate - click on Schedule Interview on the right side of the page
                Then This will redirect to the schedule interview page.
                Then Fill in the relevant details and click on schedule interview

        Scenario: Accept Interview MSP user
                Given Login as the Vendor of the candidate Accept Interview
                Then click the pending action
                Then Select the candidate you were working on and click on the candidates name
                Then  Accept_button
                Then  interview_and_select_Accept

        Scenario: Create Offer for Candidate MSP user
                Given Navigate to the job from the left navigation pane and click on the job you are working on
                Then  This will bring up list of all submitted candidatesYou can either review each one by clicking the Candidate's name
#         Then  You can either review each one by clicking the Candidate name
                Then  Click on the candidate you wish to create offer for and head to offers tab in the candidates detail page
                Then  Fill in all the relevant details

        Scenario: Accept Offer as Supplier Client Vendor
                Given Log in as Supplier you are using
                Then Click on Pending Offers under Pending Actions
                Then Click on Candidate name for whom the offer was created in step 15
                Then  Click on Reject Offer or click Accept Offer

#        Scenario: Enter Time by Worker MSP user
#                Given  Log in as Worker
#                Then Click "Add Timesheet" for worker from the dashboard
#                Then Once your time per hour or day is entered, you can Save and then Submit or Delete Timesheet
#                Then Submit the Timesheet

        Scenario: Approve Timesheet Client User/HM
                Given Log in as Hiring Manager
                Then  Click Timesheet Pending Approval under Pending Actions
                Then You can open up the Timesheet and view details of the timesheet and click on approve

#        Scenario: Modify Timesheet -MSP User/Vendor
#                Given Login as MSP,Vendor using the credentials for the MSP,Vendor
#                When User Open menu on the left hand side of screen
#                And User open Time and Expense
#                And click View Timesheet
##        Then User will landed on Timesheet List page
#                When User Open a Timesheet that has been Pending for approval
#                And Can click one candidate
#                Then User will landed on Candidate profile page
#                When User can withdraw Timesheet by clicking withdraw button
#                Then Modify withdrawn page will come
#                Then user will choose data in withdraw reason field with notes
#                Then  click withdraw
##        Then particular Timesheet will be withdrawn
#                When user click on Approved Timesheet
#                And Can click one candidate
##                Then User will landed on Candidate profile page
#                When user click Modify Timesheet  at top right corner
##                And Modify Timesheet page will be open
#                Then User can put data on Reason for modify fields with notes
#                And Click Modify Button
#                Then Click Save button  for the modification Timesheet
#                Then Log in as Hiring Manager to approve Modification


        Scenario: Enter Expense by Worker- Candidate(Vendor)
                Given Log in as Worker Vendor
                Then Click on the second icon clock icon on the eft navigation pane and click on View General Expenses
                Then Click on the blue + icon near the Expense list
                Then Select the assignment you wish to add the expense for and click Continue
                Then Click on Add expense
                Then Select the Day for the Expense, Expense Type, Amount, and Receipt attachment - click Add Expense
                Then You can add more expenses for the Expense Sheet by clicking Add Expense. Once you are finished, click Submit for Approval

#        Scenario: MSP User Change Cost Center TS approver
#                Given Log in as MSP User Update Assignment
#                Then Open menu on the left hand side of screen open Assignments and click View Assignments
#                Then Select one of the Contracts you created
#                Then Select Update Assignment


        Scenario: MSP User/Vendor Modify Expense
                Given Log in as MSP User or Vendor
                Then Msp View General Expenses
                Then Open an Expense that is pending for approval and Withdrawn
                Then You can adjust the Expense entered then select the Reasons for Modification and click

#        Scenario: Hiring Manager Modify Expense
#                Given Log in as HM User
#                Then hm user time expense
