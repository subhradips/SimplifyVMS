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

        Scenario: Add Job in system
        Given Click the second icon on the left navigation panel
        Then A flyout window will appear. Click on ""Create Job""
        Then On the job template field, enter the job title or look for the desired job title under "Recent Job Templates" or "Popular Job Templates"
        Then Select the job manager - work location will be auto populated; continue to select program industry
#        Then Add a job description
        Then Click on "Continue" button"

        Scenario: View Job Workflow on Job Requisition
        Given Once submitted, the user will be shown the details of the job created
        Then Click on the approvals tab on the job detatils page to view the approval workflow
        Then You should see the first level of approval as the Hiring Manager and the second level of approval as HM+1"


