package demo.stepdefs;

import demo.SimplifyVMSBase;
import demo.SimplifyVMSConstants;
import demo.pageObject.dashBoardXpath;
import demo.pageObject.screenshot_File;
import demo.pageObject.xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.apache.tools.ant.helper.ProjectHelper2;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.util.List;

import static demo.pageObject.removerSpace.removeSpaces;
import static java.lang.String.valueOf;
import static org.junit.Assert.assertEquals;
/*
*  Autor: Subhradip Sinha
*  Date: 26-10-2021
* */

public class loginStepdefination extends SimplifyVMSBase {
    demo.pageObject.dashBoardXpath dashBoardXpath = new dashBoardXpath(driver);
    xls_Reader reader = new xls_Reader("./src/test/resources/Data.xlsx");


    @Given("Enter application URL in address bar")
    public void enter_application_url_in_address_bar() throws Exception {
        driver.get(prop.getPropValues(SimplifyVMSConstants.URL));
        Thread.sleep(3000);
    }

    @When("Enter Username")
    public void enter_username() throws Exception {
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 2));
        Thread.sleep(3000);
        System.out.println("   Enter UserName is:  " + reader.getCellData("SimplifyVMS", "UserName", 2));
    }

    @Then("Enter Password")
    public void enter_password() throws Exception {
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
        Thread.sleep(3000);
        System.out.println(" Enter The Password is: " + reader.getCellData("SimplifyVMS", "Password", 2));
    }

    @Then("Click Sing_In")
    public void click_sing_in() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        screenshot_File.goya(driver,"Sing_In");
        System.out.println("************Click The Sing_In Button************");
        Thread.sleep(15000);
        String title = driver.getTitle();
        if (title.equals("Simplify VMS 2.0")) {
            System.out.println("************ Login Successful**************");
        }

    }

    @Given("Check the default screen after log in")
    public void check_the_default_screen_after_log_in() throws Exception {
        WebElement My_DashBoard = dashBoardXpath.Display_My_DashBoard;
        if (My_DashBoard.isDisplayed()) {
            String title = My_DashBoard.getText();
            assertEquals("> My Dashboard", title);
            System.out.println("********DashBoard showing*************" + title);
            Thread.sleep(3000);
        }
        WebElement DashBoard_Add_Job = dashBoardXpath.DashBoard_Add_Job_value;
        assertEquals("Add Job", DashBoard_Add_Job.getText());
        System.out.println("DashBoard_Add_Job Tab Click: " + DashBoard_Add_Job.getText());
        dashBoardXpath.clickOn(dashBoardXpath.DashBoard_Add_Job_value);
        Thread.sleep(15000);
        driver.navigate().back();
        Thread.sleep(15000);
        driver.navigate().refresh();
        Thread.sleep(5000);


        WebElement Active_Job = dashBoardXpath.Dashboard_Active_job;
        System.out.println("Dashboard_Active_job Tab click: " + Active_Job.getText());
        Active_Job.click();
        Thread.sleep(15000);
        driver.navigate().back();
        Thread.sleep(15000);
        driver.navigate().refresh();
        Thread.sleep(5000);

        WebElement Head_Count = dashBoardXpath.DashBoard_Head_Count;
        System.out.println("DashBoard_Head_Count Tab Click:  " + Head_Count.getText());
        Head_Count.click();
        Thread.sleep(15000);
        driver.navigate().back();
        Thread.sleep(5000);

        WebElement Contact_Support = dashBoardXpath.DashBoard_Contact_Support;
        System.out.println("Contact_Support Tab Click: " + Contact_Support.getText());
        Contact_Support.click();
        Thread.sleep(15000);
        driver.navigate().back();
        Thread.sleep(5000);

        List<WebElement> pending_action = dashBoardXpath.pending_action;
        if (pending_action.size() > 0) {
            for (int iLoop = 0; iLoop < pending_action.size(); iLoop++) {
                System.out.println("Column " + iLoop + " : '" + pending_action.get(iLoop).getText() + "'");
            }
        }
    }

    // Click Setting button
    @Given("In Dashboard, click the Setting Icon in the top right hand corner")
    public void in_dashboard_click_the_setting_icon_in_the_top_right_hand_corner() throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Settings);
        Thread.sleep(3000);
        System.out.println("Settings button click");
    }

    @Then("User can move dashboard items around, and expand\\/contract them")
    public void user_can_move_dashboard_items_around_and_expand_contract_them() {

    }

    @Then("User can Add New Widget, Save dashboard configuration, empty dashboard and close editing")
    public void user_can_add_new_widget_save_dashboard_configuration_empty_dashboard_and_close_editing() throws Exception {
        // Add New Widget Tab click
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_New_Widget);
        Thread.sleep(3000);
        System.out.println("Add_New_Widget Tab Click");
        // Add to cart tab click
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_Job);
        Thread.sleep(3000);
        System.out.println("Add_Job Tab Click");

        // given value WIDGET_LABEL
        WebElement value = dashBoardXpath.WIDGET_LABEL;
        value.clear();
        if (value.isDisplayed()) {
            value.sendKeys(reader.getCellData("SimplifyVMS", "WIDGET LABEL", 2));
            System.out.println(reader.getCellData("SimplifyVMS", "WIDGET LABEL", 2));
            Thread.sleep(3000);
        }

        WebElement Update_Widget = dashBoardXpath.Update_Widget;
        if (Update_Widget.isDisplayed()) {
            dashBoardXpath.Update_Widget.click();
            Thread.sleep(3000);
        }
        WebElement pop_Up_close = dashBoardXpath.close_pop_up;
        if (pop_Up_close.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.close_pop_up);
            Thread.sleep(3000);
        }
        WebElement dots = dashBoardXpath.dots_Click;
        if (dots.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.dots_Click);
            Thread.sleep(3000);
            System.out.println("************* 3dots Tab click***********");
            WebElement reset = dashBoardXpath.reset;
            if (reset.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.reset);
                System.out.println("************* Reset Tab Click**********");
                Thread.sleep(3000);
            }
            WebElement Pop_Up = dashBoardXpath.Pop_Up_reset;
            if (Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.Pop_Up_reset);
                System.out.println("Pop Up button Reset");
                Thread.sleep(5000);
                driver.navigate().refresh();
                Thread.sleep(10000);
            }
        }
    }

    @Given("In Dashboard, click user icon picture in bottom left corner; a flyout window will open and click on \"\"Account Settings\"\"")
    public void in_dashboard_click_user_icon_picture_in_bottom_left_corner_a_flyout_window_will_open_and_click_on_account_settings() throws InterruptedException {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println("MSP_UserAccount Account Click");
            Thread.sleep(3000);

            WebElement Account = dashBoardXpath.AccountSettings;
            if (Account.isDisplayed()) {
                dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.AccountSettings);
                System.out.println("AccountSettings Tab Click");
                Thread.sleep(3000);
            }
        }

    }

    @When("User can change specific items on user, including user photo")
    public void user_can_change_specific_items_on_user_including_user_photo() throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Upload_pic);
        Thread.sleep(3000);
        Runtime.getRuntime().exec("./autoIt/picUpload.exe");
        Thread.sleep(5000);
        System.out.println("************* Photo Upload************");
        driver.navigate().refresh();
        Thread.sleep(5000);
    }

    @Then("If changes made, click \"\"Save\"\"\"")
    public void if_changes_made_click_save() throws Exception {
        WebElement EditProfile = dashBoardXpath.EditProfile;
        if (EditProfile.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.EditProfile);
            System.out.println("*********Edit profile Display **********" + EditProfile.getText());
            Thread.sleep(5000);
            dashBoardXpath.clickOn(dashBoardXpath.SubmitButton);
            System.out.println("*********Edit Submit button click*******");
            Thread.sleep(15000);
            driver.navigate().refresh();
            Thread.sleep(15000);
        }
    }

    @Given("Once submitted, the user will be shown the details of the job created")
    public void once_submitted_the_user_will_be_shown_the_details_of_the_job_created() throws Exception {
        WebElement Action = dashBoardXpath.Action;
        if (Action.isDisplayed()) {
            Thread.sleep(5000);
            String action = Action.getText();
            System.out.println("Action Tab Show:  " + action);
        }

    }

    @Then("Click on the approvals tab on the job detatils page to view the approval workflow")
    public void click_on_the_approvals_tab_on_the_job_detatils_page_to_view_the_approval_workflow() throws InterruptedException {
        WebElement Action = dashBoardXpath.Action;
        if (Action.isDisplayed()) {
            Action.click();
            Thread.sleep(3000);
            System.out.println("Approve Tab Show: " + dashBoardXpath.Approve.getText());
            dashBoardXpath.clickOn(dashBoardXpath.Approve);
            System.out.println("******Approve button click*********** ");
        }
    }

    @Then("You should see the first level of approval as the Hiring Manager and the second level of approval as HM+{int}\"")
    public void you_should_see_the_first_level_of_approval_as_the_hiring_manager_and_the_second_level_of_approval_as_hm(Integer int1) {
        WebElement Pending = dashBoardXpath.PendingApproval_massage;
        Pending.getText();
        if (Pending.isDisplayed()) {
            System.out.println(Pending.getText());
            assertEquals(" Pending Approval ", Pending.getText());

        }
    }

    @Given("Click the second icon on the left navigation panel")
    public void click_the_second_icon_on_the_left_navigation_panel() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Briefacse);
        Thread.sleep(10000);
        System.out.println("****Briefcase button click**");

    }

    @Then("A flyout window will appear. Click on \"\"Create Job\"\"")
    public void a_flyout_window_will_appear_click_on_create_job() throws Exception {

        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Addjob);
        System.out.println("***Create Job Tab Click*******");
        Thread.sleep(10000);

    }

    @Then("On the job template field, enter the job title or look for the desired job title under {string} or {string}")
    public void on_the_job_template_field_enter_the_job_title_or_look_for_the_desired_job_title_under_or(String string, String string2) throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Software_Engineer);
        System.out.println("****Template click**");
        Thread.sleep(10000);
    }

    @Then("Select the job manager - work location will be auto populated; continue to select program industry")
    public void select_the_job_manager_work_location_will_be_auto_populated_continue_to_select_program_industry() throws InterruptedException, IOException {
        WebElement dwn = dashBoardXpath.Job_Manager;
        dwn.click();
        dashBoardXpath.HM_Name_Select.click();
        Thread.sleep(3000);
    }

    @Then("Add a job description")
    public void add_a_job_description() throws Exception {
        WebElement jb = dashBoardXpath.Job_Description;
        Thread.sleep(2000);
        jb.sendKeys(Keys.CONTROL + "a");
        Thread.sleep(2000);
        jb.sendKeys(prop.getPropValues(SimplifyVMSConstants.Message));
        Thread.sleep(5000);

    }

    @Then("Click on {string} button\"")
    public void click_on_button(String string) throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(10000);
    }
    /*
     * Name - Nirmalya Sarkar
     * Date - 27.10.2021*/

    @Given("The foundational data will be defaulted based on the selection made . Click each field to make changes if necessary")
    public void the_foundational_data_will_be_defaulted_based_on_the_selection_made_click_each_field_to_make_changes_if_necessary() throws InterruptedException {
        //Select on GL Location and Click on 2nd Element
        Thread.sleep(3000);
        dashBoardXpath.Select_GL_Location.click();
        System.out.println("Gl_location");
        Thread.sleep(5000);
        dashBoardXpath.First_Location.click();
        Thread.sleep(3000);
        System.out.println("Select_GL_Location Select value");


        dashBoardXpath.select_Legal_Entity.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Legal_Entity.click();
        Thread.sleep(3000);
        System.out.println("Legal_Entity service department");

        dashBoardXpath.select_Service_Department.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Service_Department.click();
        Thread.sleep(3000);
        System.out.println("select_Service_Department");

        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 150)");

        dashBoardXpath.select_Cost.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Cost.click();
        System.out.println("First_Cost.click");
        Thread.sleep(3000);

        dashBoardXpath.Create_Job.click();
        Thread.sleep(5000);
        System.out.println("Create_Job.click");

        // select on Business unit and click on 2nd element
        dashBoardXpath.select_Business_Unit.click();
        Thread.sleep(5000);
        System.out.println("Business unit");

        WebElement test = dashBoardXpath.First_Business;
        if (test.isDisplayed()) {
            dashBoardXpath.First_Business.click();
            System.out.println("First_Business.click");
            Thread.sleep(3000);
        } else {
            System.out.println("First_Business.click not showing");
            Thread.sleep(3000);
        }
        // select on GL Account and click on the element
        dashBoardXpath.select_GL_Account.click();
        Thread.sleep(3000);
        System.out.println("select_GL_Account.click");
        dashBoardXpath.First_GL_Account.click();
        Thread.sleep(3000);
        // click on submit message
        System.out.println("submit");

//        // Select select1 = new Select(dashBoardXpath.First_Location);

    }

    @Then("Click {string} to create the job")
    public void click_to_create_the_job(String string) throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Create_Job);
        Thread.sleep(3000);
        System.out.println("Successfully click on submit to create the job");
    }

    @Given("In second page of Add Job, selected the estimated started and end dates of the Job,number of positions, expense allowed, Currency, Unit of Measure, Min and Max Bill Rate, and Over time exempt")
    public void in_second_page_of_add_job_selected_the_estimated_started_and_end_dates_of_the_job_number_of_positions_expense_allowed_currency_unit_of_measure_min_and_max_bill_rate_and_over_time_exempt() throws InterruptedException {
        dashBoardXpath.Start_Date.click();
        Thread.sleep(2000);
        dashBoardXpath.Select_Start_Date.click();
        Thread.sleep(2000);
        dashBoardXpath.End_Date.click();
        Thread.sleep(2000);
        dashBoardXpath.Select_End_Date.click();
        Thread.sleep(2000);
        System.out.println("Number of Positions");
        WebElement no = dashBoardXpath.position;
        no.sendKeys(Keys.CONTROL + "a");
        no.sendKeys("1");
        Thread.sleep(2000);
        System.out.println("Expense Allowed");
        dashBoardXpath.Expense_Allowed.click();
        Thread.sleep(2000);
        System.out.println("Min Pay Rate");
        WebElement min = dashBoardXpath.Min;
        Thread.sleep(2000);
        min.sendKeys(Keys.CONTROL + "a");
        min.sendKeys("100");
        Thread.sleep(2000);
        System.out.println("Max Pay Rate");
        WebElement max = dashBoardXpath.Max;
        max.sendKeys(Keys.CONTROL + "a");
        max.sendKeys("200");
        Thread.sleep(2000);
        System.out.println("Overtime Exempt");
        dashBoardXpath.overtime.click();

    }

    @Then("Post entry, scroll down to end of page to view the budget")
    public void post_entry_scroll_down_to_end_of_page_to_view_the_budget() throws InterruptedException {

        Thread.sleep(4000);
        System.out.println("view Details estimated");
        dashBoardXpath.view_Estimate.click();
    }

    @Then("Click {string} to view the components that add up to create the budget; change details as needed")
    public void click_to_view_the_components_that_add_up_to_create_the_budget_change_details_as_needed(String string) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Update");
        dashBoardXpath.update.click();

    }

    @Then("Click {string}")
    public void click(String string) throws InterruptedException {
        Thread.sleep(4000);
        System.out.println("Continue");
        dashBoardXpath.Continue.click();
    }

    @Given("Login as Hiring manager using the credentials for the Hiring Manager")
    public void login_as_hiring_manager_using_the_credentials_for_the_hiring_manager() throws Exception {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 4));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 4));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 4));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 4));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Then("From the dashboard under pending actions widget, click on jobs pending approval")
    public void from_the_dashboard_under_pending_actions_widget_click_on_jobs_pending_approval() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Pending);
        Thread.sleep(5000);
    }

    @Then("Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.")
    public void select_the_job_created_and_either_click_on_the_approval_tab_or_on_the_pending_approval_button_on_the_top_right_corner_of_the_screen() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.job_search);
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "Job Profile", 2));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        System.out.println("***********dashBoardXpath.search_button click************");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Value_Click);
        System.out.println("***********dashBoardXpath.Value_Click successfully*********");
        Thread.sleep(3000);
    }

    @Then("Click on approve")
    public void click_on_approve() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Action);
        Thread.sleep(3000);
        System.out.println("****************dashBoardXpath.Action tab click*************");
        dashBoardXpath.clickOn(dashBoardXpath.Approve);
        Thread.sleep(3000);
        System.out.println("********************dashBoardXpath.Approve tab click*************");
        Thread.sleep(3000);
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement Approval_Details = dashBoardXpath.Approval_Details;
        js.executeScript("arguments[0].scrollIntoView();", Approval_Details);
        if (Approval_Details.isDisplayed()) {
            Approval_Details.getText();
            System.out.println("************Approval_Details showing:***********" + Approval_Details.getText());
        }

        WebElement Approve_Request = dashBoardXpath.approve_request;
        if (Approve_Request.isDisplayed()) {
            dashBoardXpath.moveToElementAndCLikOn(Approve_Request);
            Thread.sleep(3000);
            System.out.println("Approve_Request.isDisplayed() and click successfully");
        }

        WebElement ApproveRequest = dashBoardXpath.approve_request1;
        if (ApproveRequest.isDisplayed()) {
            dashBoardXpath.moveToElementAndCLikOn(ApproveRequest);
            Thread.sleep(3000);
            System.out.println("ApproveRequest1.isDisplayed() and click successfully");
        }

    }

    @Given("Login as Hiring manager+{int} using the credentials for the Hiring Manager+{int}")
    public void login_as_hiring_manager_using_the_credentials_for_the_hiring_manager(Integer int1, Integer int2) throws Exception {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 5));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 5));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 5));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 5));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Given("Log back in as the MSP User, click on the briefcase icon on the left navigation panel and from the flyout window select View All jobs")
    public void log_back_in_as_the_msp_user_click_on_the_briefcase_icon_on_the_left_navigation_panel_and_from_the_flyout_window_select_view_all_jobs() throws Exception {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 2));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 2));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 2));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);

        WebElement MSP_User1 = dashBoardXpath.Dashboard_Briefacse;
        if (MSP_User1.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Dashboard_Briefacse);
            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
            Thread.sleep(5000);
        }
        WebElement View = dashBoardXpath.view_all_jobs;
        if (View.isDisplayed()) {
            Thread.sleep(3000);
            dashBoardXpath.clickOn(dashBoardXpath.view_all_jobs);
            System.out.println("*********dashBoardXpath.view_all_jobs is Displayed***********");
            Thread.sleep(3000);
        }
    }

    @Then("Click on the Job title of the Job you're working on")
    public void click_on_the_job_title_of_the_job_you_re_working_on() throws Exception {
        /*Sourcing click
         * Name - Nirmalya Sarkar
         * Date - 29.10.2021*/

        dashBoardXpath.clickOn(dashBoardXpath.job_search);
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "Job Profile", 2));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        System.out.println("***********dashBoardXpath.search_button click************");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Value_Click);
        System.out.println("***********dashBoardXpath.Value_Click successfully*********");
        Thread.sleep(3000);
    }

    @Then("Job Details should open and you will find an actions button on the top right corner of the screen;")
    public void job_details_should_open_and_you_will_find_an_actions_button_on_the_top_right_corner_of_the_screen() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Action);
        Thread.sleep(5000);
        System.out.println("****************dashBoardXpath.Action tab click*************");

    }

    @Then("select Distribute")
    public void select_distribute() throws Exception {
        WebElement distribute_tab = dashBoardXpath.Distribute;
        if (distribute_tab.isDisplayed()) {
            distribute_tab.click();
            Thread.sleep(5000);
            System.out.println("*****************select_distribute button view and click**********");
            Thread.sleep(5000);

            String dash = driver.findElement(By.xpath("//header/div[1]/p[1]")).getText();
            String msg = dash.substring(6, 28);
            System.out.println("Job Created ID: " + msg);
            reader.setCellData("SimplifyVMS", "Project ID", 2, msg);
//            System.out.println("Job Created ID: "+m);
            Thread.sleep(5000);

        }
    }

    @Then("This will bring the user to the distribute tab and the user can type to search the vendors")
    public void this_will_bring_the_user_to_the_distribute_tab_and_the_user_can_type_to_search_the_vendors() throws Exception {
        WebElement ele = dashBoardXpath.Search_vendors;
        ele.click();
        ele.sendKeys(reader.getCellData("SimplifyVMS", "Vendors", 2));
        System.out.println(" Inpute value to search:   " + reader.getCellData("SimplifyVMS", "Vendors", 2));
        Thread.sleep(5000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_Distribute1);
        System.out.println("First dashBoardXpath.MSP_Distribute1 click ");
        Thread.sleep(10000);
        driver.navigate().back();
//        dashBoardXpath.clickOn(dashBoardXpath.Back_to_Jobs);
//        Thread.sleep(5000);
        System.out.println("dashBoardXpath.Back_to_Jobs");
        Thread.sleep(3000);


    }

    @Then("Once added, Click on Enbale Submission Limit toggle to set it ON or OFF")
    public void once_added_click_on_enbale_submission_limit_toggle_to_set_it_on_or_off() throws Exception {

        dashBoardXpath.Action.click();
        Thread.sleep(5000);
        dashBoardXpath.Distribute.click();
        Thread.sleep(5000);

        WebElement ele1 = dashBoardXpath.Search_vendors;
        ele1.click();
        ele1.sendKeys(reader.getCellData("SimplifyVMS", "Vendors", 2));
        System.out.println(" Inpute value to search 2nd time:   " + reader.getCellData("SimplifyVMS", "Vendors", 2));
        Thread.sleep(5000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_Distribute1);
        System.out.println("First dashBoardXpath.MSP_Distribute1 click 2nd time ");
        Thread.sleep(8000);
//        dashBoardXpath.clickOn(dashBoardXpath.toggle_to_set);
//        Thread.sleep(5000);
    }

    @Then("Click on Distribute")
    public void click_on_distribute() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.MSP_Distribute);
        System.out.println("MSP_Distribute Button Click 3rd time");
        Thread.sleep(5000);


    }

    //
//    /*
//    * Name - Nirmalya Sarkar
//    * Date - 28.10.2021
//    * */
//
    @Given("Login as Supplier to which job was distributed")
    public void login_as_supplier_to_which_job_was_distributed() throws InterruptedException, IOException {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 3));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 3));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 3));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 3));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Then("In the user's dashboard, from {string} widgets click on {string}")
    public void in_the_user_s_dashboard_from_widgets_click_on(String string, String string2) throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Briefacse1);
        Thread.sleep(10000);
        System.out.println("****Briefcase button click**");

    }

    @Then("This will open Jobs needing submittal")
    public void this_will_open_jobs_needing_submittal() throws Exception {
        WebElement View = dashBoardXpath.view_all_jobs1;
        if (View.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.view_all_jobs1);
            System.out.println("*********dashBoardXpath.view_all_jobs is Displayed***********");
            Thread.sleep(3000);
        }
    }

    @Then("Click on the job you created; this will redirect you to {string} Section")
    public void click_on_the_job_you_created_this_will_redirect_you_to_section(String string) throws Exception {

        dashBoardXpath.Vendor_Active_Jobs.click();
        Thread.sleep(3000);
        System.out.println("Vendor_Active_Jobs.click");
        driver.navigate().refresh();
        Thread.sleep(5000);
        String acctualFinalMessage = reader.getCellData("SimplifyVMS", "Project ID", 2).trim();
        dashBoardXpath.enterValue(dashBoardXpath.job_search, acctualFinalMessage);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        Thread.sleep(5000);
        System.out.println("dashBoardXpath.search_button");
        dashBoardXpath.clickOn(dashBoardXpath.Value_Click);
        System.out.println("***********dashBoardXpath.Value_Click successfully*********");
        Thread.sleep(3000);

    }


    @Given("Login as the Vendor of the candidate Accept Interview")
    public void Login_as_the_Vendor_of_the_candidate()throws Exception {
        System.out.println("Logout MSP user------");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;


        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if(LogOut.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("***LogOut Button Click:*** "+LogOut.isDisplayed());
            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()){
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        System.out.println("Login Vendor User");

        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",3));
        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",3));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",3));
        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",3));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Then("click the pending action")
    public void Login_as_the_Vendor_of_the_candidate_pending_action() throws InterruptedException
    {
        System.out.println("Pending Interview");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Pending_interview);
        Thread.sleep(6000);

    }
    @Then("Select the candidate you were working on and click on the candidates name")
    public  void Select_the_candidate_you_were_working_on_and_click_on_the_candidate_name() throws InterruptedException
    {
        System.out.println("click name");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Click_name);
        Thread.sleep(3000);

    }
    @Then("Accept_button")
    public void Accept_button() throws InterruptedException {
        System.out.println("click Accept");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept);
        Thread.sleep(3000);
        System.out.println("check interview date");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.check_interview_date);
        Thread.sleep(3000);
        System.out.println("Enter phone number");
        WebElement phn_no =dashBoardXpath.phone_number;
        Thread.sleep(2000);
        phn_no.sendKeys(Keys.CONTROL + "a");
        phn_no.sendKeys(reader.getCellData("SimplifyVMS","Phone Number",2));
        System.out.println("phone number Accepted"+reader.getCellData("SimplifyVMS","Phone Number",2));
    }
    @Then("interview_and_select_Accept")
    public void interview_and_select_Accept()throws InterruptedException {
        System.out.println("Accept Interview");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept_interview);
        System.out.println("Accept Interview complete");
        System.out.println("Logout Vendor credentials");


        WebElement My_DashBoard = dashBoardXpath.Display_My_DashBoard;
        if (My_DashBoard.isDisplayed()) {
            String title = My_DashBoard.getText();
            assertEquals("> My Dashboard", title);
            System.out.println("**DashBoard showing*" + title);
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**LogOut Button Click:** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*Log_out_Pop_Up.isDisplayed:** ");
                Thread.sleep(3000);
            }
        }
    }

    @Then("In Pending Actions click on Resumes to Review. Alternatively, navigate to the job from the left navigation pane and click on the job you are working on. You should be able to see a tab named Submitted Candidates")
    public void in_pending_actions_click_on_resumes_to_review_alternatively_navigate_to_the_job_from_the_left_navigation_pane_and_click_on_the_job_you_are_working_on_you_should_be_able_to_see_a_tab_named_submitted_candidates() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Job);
        Thread.sleep(10000);
        System.out.println("****Job button click**");

    }

    @Then("This will bring up list of all submitted candidates. You can either review each one by clicking the Candidate's name")
    public void this_will_bring_up_list_of_all_submitted_candidates_you_can_either_review_each_one_by_clicking_the_candidate_s_name() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Submission);
        Thread.sleep(10000);
        dashBoardXpath.enterValue(dashBoardXpath.Dashboard_SearchBy_Job_id, reader.getCellData("SimplifyVMS", "Project ID", 2));
        dashBoardXpath.clickOn(dashBoardXpath.Dasboard_Search);
        Thread.sleep(10000);
    }

    @Then("Review the candidate details. Click on {string} to review Rejection reasons in module; for this exercise, click {string}")
    public void review_the_candidate_details_click_on_to_review_rejection_reasons_in_module_for_this_exercise_click(String string, String string2) throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Job_clk);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Submitted_Candidate);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Candidate_Click);
        Thread.sleep(5000);
    }

    @Given("Login as the MSP user")
    public void login_as_the_msp_user()throws Exception {

        Thread.sleep(5000);
        WebElement Action = dashBoardXpath.Action;
        if (Action.isDisplayed()) {
            Thread.sleep(5000);
            String action = Action.getText();
            System.out.println("Action Tab Show:  " + action);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        Thread.sleep(5000);
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 2));
        Thread.sleep(3000);
        System.out.println("   Enter UserName is:  " + reader.getCellData("SimplifyVMS", "UserName", 2));
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
        Thread.sleep(3000);
        System.out.println(" Enter The Password is: " + reader.getCellData("SimplifyVMS", "Password", 2));
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        System.out.println("************Click The Sing_In Button************");
        Thread.sleep(15000);
        String title = driver.getTitle();
        if (title.equals("Simplify VMS 2.0")) {
            System.out.println("************ Login Successful**************");
        }


    }


    @Then("Click on the actions button on the top right corner and select")
    public void click_on_the_actions_button_on_the_top_right_corner_and_select() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Action);
        Thread.sleep(5000);
        System.out.println("****************dashBoardXpath.Action tab click*************");

    }

    @Then("add & submit candidate to create and submit candidate")
    public void add_submit_candidate_to_create_and_submit_candidate() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.click_Add_And_Submit_Candidate);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.click_On_ResumeButton);
        Thread.sleep(5000);
        System.out.println("dashBoardXpath.click_On_ResumeButton");
        Thread.sleep(5000);

//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Upload_pic);
//        Thread.sleep(3000);
        Runtime.getRuntime().exec("./autoIt/biodata_update_doc.exe");
        Thread.sleep(7000);
        System.out.println("************* Resume Upload************");
        //driver.navigate().refresh();
        //Thread.sleep(5000);
        WebElement Autofill = dashBoardXpath.Check_AutoFill_Candidate;
        String Check_Autofill = Autofill.getText();
        Thread.sleep(5000);
        System.out.println("want to Auto-Fill the Candidate Details from the Resume");
        if (Autofill.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.click_On_ResumeYes);
            Thread.sleep(5000);
        }
        JavascriptExecutor jse2 = (JavascriptExecutor) driver;
        jse2.executeScript("scroll(150, 250)");
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_AddCandidate_MM_DD1);
        Thread.sleep(5000);


        dashBoardXpath.clickOn(dashBoardXpath.Select_AddCandidate_MM_DD);
        Thread.sleep(5000);
        System.out.println("Select_AddCandidate_MM_DD click");

//        dashBoardXpath.clickOn(dashBoardXpath.Add_Candidate_Date);
//        Thread.sleep(5000);
//        System.out.println("Add_Candidate_Date click");

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.SelectCountry);
        Thread.sleep(3000);
        System.out.println("dashBoardXpath.SelectCountry click");
        dashBoardXpath.clickOn(dashBoardXpath.Click_on_ContryName);
        Thread.sleep(5000);
        System.out.println("dashBoardXpath.Click_on_ContryName click");
//        dashBoardXpath.clickOn(dashBoardXpath.Select_stateID);
//        Thread.sleep(5000);
        System.out.println("dashBoardXpath.Select_stateID");
        dashBoardXpath.enterValue(dashBoardXpath.Select_stateID, reader.getCellData("SimplifyVMS", "State-ID", 2));
        System.out.println("Put the required stateID:   " + reader.getCellData("SimplifyVMS", "State-ID", 2));
        Thread.sleep(5000);

        JavascriptExecutor jse3 = (JavascriptExecutor) driver;
        jse3.executeScript("scroll(350, 450)");

        dashBoardXpath.Select_AddCandidate_email.clear();
        Thread.sleep(5000);
        dashBoardXpath.enterValue(dashBoardXpath.Select_AddCandidate_email, reader.getCellData("SimplifyVMS", "Add Candidate Mail ID", 2));
        System.out.println("Put the required Add candidate mail id:  " + reader.getCellData("SimplifyVMS", "Add Candidate Mail ID", 2));
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Click_on_createCandidate);
        System.out.println("dashBoardXpath.Click_on_createCandidate");
        Thread.sleep(5000);
        JavascriptExecutor jse1 = (JavascriptExecutor) driver;
        jse1.executeScript("scroll(251,350 )");

        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Candidate_Start_date);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Add_Startdate);
        Thread.sleep(3000);
        System.out.println("dashBoardXpath.Select_Candidate_Start_date");

        dashBoardXpath.clickOn(dashBoardXpath.Select_Candidate_End_date);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Add_Enddate);
        System.out.println("Select_Candidate_End_date");
        Thread.sleep(5000);

        /*
         * Name - Nirmalya Sarkar
         * Date - 02.11.2021*/

        WebElement Uni_id = dashBoardXpath.Unique_ID;
        String un_id = Uni_id.getAttribute("value");
        System.out.println("Successfully written the unique id " + un_id);
        reader.setCellData("SimplifyVMS", "UniqueID", 2, un_id);
        Thread.sleep(3000);

        dashBoardXpath.Select_candidatePayRate.click();
        dashBoardXpath.enterValue(dashBoardXpath.Select_candidatePayRate, reader.getCellData("SimplifyVMS", "Add Candidate Pay Rate", 2));
        System.out.println("Select_candidatePayRate:  " + reader.getCellData("SimplifyVMS", "Add Candidate Pay Rate", 2));
        Thread.sleep(3000);
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("scroll(451, 600)");
        Thread.sleep(5000);

        dashBoardXpath.clickOn(dashBoardXpath.Submit_and_Candidate);
        Thread.sleep(3000);
        System.out.println("dashBoardXpath.Submit_and_Candidate");
    }


    @Then("Submit candidate to select candidates from the list of available candidates")
    public void submit_candidate_to_select_candidates_from_the_list_of_available_candidates() throws Exception {
        JavascriptExecutor jse4 = (JavascriptExecutor) driver;
        jse4.executeScript("scroll(150, 250 )");
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Clickon_availableCandidate);
        Thread.sleep(2000);
        String acctualFinalMessage = reader.getCellData("SimplifyVMS", "Project ID", 2).trim();
        dashBoardXpath.enterValue(dashBoardXpath.job_search, acctualFinalMessage);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        Thread.sleep(2000);


    }

    @Then("Fill in the necessary details and click on submit candidate")
    public void fill_in_the_necessary_details_and_click_on_submit_candidate() throws Exception {
        dashBoardXpath.enterValue(dashBoardXpath.Dasboard_Search, reader.getCellData("SimplifyVMS", "UniqueID", 2).trim());
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Candidate_Name);
        Thread.sleep(3000);

    }


    /*
     * Scenario : Enter Time By Worker
     * Name - Nirmalya Sarkar
     * Date - 03.11.2021*/

    @Given("Log in as Worker")
    public void log_in_as_worker() throws Exception {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 3));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 3));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 3));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 3));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Then("Click {string} for worker from the dashboard")
    public void click_for_worker_from_the_dashboard(String string) throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Switch_menu);
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Time_and_Expense);
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.View_Timesheets);
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Create_Timesheet);
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Worker_field);
        Thread.sleep(4000);
        dashBoardXpath.Select_Worker_field.sendKeys("Jake vic");
        dashBoardXpath.clickOn(dashBoardXpath.Select_Worker_Name);
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.AfterWorkerName_ClickContinue);
        Thread.sleep(4000);


    }

    @Then("Once your time per hour or day is entered, you can Save and then Submit or Delete Timesheet")
    public void once_your_time_per_hour_or_day_is_entered_you_can_save_and_then_submit_or_delete_timesheet() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Select_project);
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_project_value);
        Thread.sleep(4000);
        dashBoardXpath.Select_Monday.click();
        dashBoardXpath.Select_Monday.clear();
        Thread.sleep(2000);
        dashBoardXpath.Select_Monday.sendKeys("08:00");
        dashBoardXpath.Select_Tuesday.click();
        dashBoardXpath.Select_Tuesday.clear();
        Thread.sleep(2000);
        dashBoardXpath.Select_Tuesday.sendKeys("08:00");
        dashBoardXpath.Select_Wednesday.click();
        dashBoardXpath.Select_Wednesday.clear();
        Thread.sleep(2000);
        dashBoardXpath.Select_Wednesday.sendKeys("08:00");
        dashBoardXpath.Select_Thursday.click();
        dashBoardXpath.Select_Thursday.clear();
        Thread.sleep(2000);
        dashBoardXpath.Select_Thursday.sendKeys("08:00");
        dashBoardXpath.Select_Friday.click();
        dashBoardXpath.Select_Friday.clear();
        Thread.sleep(2000);
        dashBoardXpath.Select_Friday.sendKeys("08:00");
        dashBoardXpath.Clickon_Saturday.click();
    }

    @Then("Submit the Timesheet")
    public void submit_the_timesheet() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Submit_timesheet);
        Thread.sleep(3000);
        WebElement Subtimesheet = dashBoardXpath.Are_you_sure_submit_timesheet;
        if(Subtimesheet.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.clickon_yes_submit_timesheet);
        }

    }
     /*
     * Name - Arijit Chowdhury*/

    @Given("On the candidate details page, after reviewing the candidate - click on Schedule Interview on the right side of the page")
    public void on_the_candidate_details_page_after_reviewing_the_candidate_click_on_schedule_interview_on_the_right_side_of_the_page() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Schedule_interview);
        System.out.println("dashBoardXpath.Schedule_interview");
    }
    @Given("This will redirect to the schedule interview page.")
    public void this_will_redirect_to_the_schedule_interview_page() throws InterruptedException {
        System.out.println("Redirect");
        Thread.sleep(20000);
    }
    @Given("Fill in the relevant details and click on schedule interview")
    public void fill_in_the_relevant_details_and_click_on_schedule_interview() throws InterruptedException {
        Thread.sleep(10000);
        dashBoardXpath.clickOn(dashBoardXpath.Interviewer);
        Thread.sleep(10000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Interview);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Interview_Type);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_int_Type);
        Thread.sleep(5000);
        dashBoardXpath.enterValue(dashBoardXpath.Interview_Location, "London, UK"+"\n");
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Timezone);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Timezon);
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Duration);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Duration);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Choose_Date);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Date);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Time_Slot);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Time_Slot);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.schedule);
    }

    /*
     * Scenario : Approve Timesheet
     * Name - Anup Ghosh*/
    @Given("Log in as Hiring Manager")
    public void Approve_Timesheet() throws Exception {
        System.out.println("****** Logout ******");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;

        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
            Thread.sleep(3000);
        }
        System.out.println("*** Logout Hiring Manager *****");
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**LogOut Button Click:** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*Log_out_Pop_Up.isDisplayed:** ");
                Thread.sleep(3000);
            }
            System.out.println("*** Hiring Manager Logout Successfully ***");
            driver.navigate().refresh();
            Thread.sleep(5000);
        }

        System.out.println("*** Login Hiring Manager ***");
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 4));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 4));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 4));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 4));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }
    @Then("Click Timesheet Pending Approval under Pending Actions")
    public void Click_Timesheet()throws InterruptedException
    {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Timesheets_pending_approval);
        System.out.println("Click into Timesheet pending Approval");
        Thread.sleep(5000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.checkmark_timesheet);
        System.out.println("Click into check mark");
        Thread.sleep(4000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Worker_name);
        System.out.println("Click into Worker Name");
        Thread.sleep(6000);

    }
    @Then("You can open up the Timesheet and view details of the timesheet and click on approve")
    public void click_on_timesheet_approve()throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Approve_Timesheet);
        System.out.println("click into Approve");
        Thread.sleep(4000);
        //dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.confirmation_message_for_approve_timesheet);
        WebElement approve_timesheet_popup = dashBoardXpath.confirmation_message_for_approve_timesheet;
        System.out.println("Confirmation message for approve Timesheet:::::--" + approve_timesheet_popup);
        if (approve_timesheet_popup.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_ok);
            System.out.println("Approve finally");
            Thread.sleep(4000);
        }
    }
    @Given("Navigate to the job from the left navigation pane and click on the job you are working on")
    public void Navigate_to_the_job_from_the_left_navigation_pane_and_click_on_the_job_you_are_working_on() throws  InterruptedException
    {


        System.out.println("Login MSP Credentials");

        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",2));
        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",2));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",2));
        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",2));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);

        Thread.sleep(4000);
        System.out.println("Click on job");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_job);
        Thread.sleep(3000);
        System.out.println("click into subsmission");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_submission);
        Thread.sleep(6000);
        System.out.println("click into submitted candidate");


    }
    @Then("This will bring up list of all submitted candidatesYou can either review each one by clicking the Candidate's name")
    public  void submitted_Candidate_name()throws InterruptedException{
//        String status=dashBoardXpath.getStatusText(dashBoardXpath.submitted_candidate_name);
//        System.out.println("Enter next Step:"+status);
//
//        if(status.contains("Submitted")){
//            System.out.println("Enter next Step:");
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submitted_candidate_name_onclick);
//
//
//        }else{
//            System.out.println("Status not matched");
//        }
        Thread.sleep(8000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submitted_candidate_Name);

    }
    @Then("Click on the candidate you wish to create offer for and head to offers tab in the candidates detail page")
    public void Click_on_the_candidate_you_wish_to_create_offer()throws InterruptedException
    {
        System.out.println("click into offer button");
        Thread.sleep(8000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_button);
        Thread.sleep((2000));
        System.out.println("click into Create offer");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.create_offer);
        Thread.sleep(4000);
        System.out.println("Click into Final Create offer");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.final_Create_offer);


    }
    @Then("Fill in all the relevant details")
    public void Fill_in_all_the_relevant_details()throws InterruptedException
    {
//        JavascriptExecutor js = (JavascriptExecutor) driver;
//        js.executeScript("scroll(0, -250);");

        //Thread.sleep(5000);
        Thread.sleep(10000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Timesheet);
        System.out.println("After Click into Timesheet");
        // driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS) ;
        System.out.println("click into choose TimeSheet");
        Thread.sleep(12000);

////        JavascriptExecutor js = (JavascriptExecutor) driver;
////        js.executeScript("scroll(0, -250);");
//        Thread.sleep(5000);
//        //Select time = new Select(dashBoardXpath.Timesheet);
////        //time.selectByVisibleText("Banana");
////        time.selectByIndex(0);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.choose_timesheet);
        System.out.println("after choose Time sheet");
        Thread.sleep(2000);
        System.out.println("Click into Assignment Active button");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Assignment_active_upon);
        Thread.sleep(3000);
        System.out.println("click into choose assignment");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Choose_assignment);
        System.out.println("candidate pay rate");
        Thread.sleep(3000);
        WebElement pay_rate=dashBoardXpath.candidate_pay_rate;
        pay_rate.sendKeys(Keys.CONTROL + "a");
        pay_rate.sendKeys("100");
        Thread.sleep(5000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Release_offer);
    }
    @Given("Log in as Supplier you are using")
    public void Log_in_as_Supplier_you_are_using() throws InterruptedException {
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;


        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if(LogOut.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("***LogOut Button Click:*** "+LogOut.isDisplayed());
            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()){
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }

        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",3));
        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",3));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",3));
        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",3));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Then ("Click on Pending Offers under Pending Actions")
    public void Click_on_Pending_Offers_under_Pending_Actions()throws InterruptedException
    {
        Thread.sleep(4000);
        System.out.println("pending offer");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_offers);
        Thread.sleep(3000);

    }
    @Then("Click on Candidate name for whom the offer was created in step 15")
    public void Click_on_Candidate_name_for_whom_the_offer_was_created_in_step_15()
    {
        System.out.println("click on candidate name");
        String status=dashBoardXpath.getStatusText(dashBoardXpath.click_released);
        System.out.println("Enter next Step:"+status);

        if(status.contains("Released")){
            System.out.println("Enter next Step:");
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_name);


        }else{
            System.out.println("Status not matched");
        }
    }
    @Then("Click on Reject Offer or click Accept Offer")
    public void click_accept_offer() throws InterruptedException
    {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_status_check);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_accept);
        System.out.println("Add offer acceptance reason");
        WebElement note=dashBoardXpath.offer_acceptance_reason;
        note.sendKeys(Keys.CONTROL + "a");
        note.sendKeys("Good Knowledge");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept_offer);
        screenshot_File.goya(driver,"Accept_offer");

    }


}