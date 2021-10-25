Feature: Spring 1 SimplifyVMS project scenario

  Scenario: Verify whether User is able to access  -  VMS Application
  Given Enter application URL in address bar
  When  Enter Username
  Then  Enter Password
  And   Click Sing_In

  Scenario: Verify the default screen displayed for Client User
  Given Check the default screen after log in


