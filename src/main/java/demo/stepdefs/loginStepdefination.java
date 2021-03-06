package demo.stepdefs;

import demo.SimplifyVMSBase;
import demo.SimplifyVMSConstants;
import demo.pageObject.dashBoardXpath;
import demo.pageObject.screenshot_File;
import demo.pageObject.xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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

import static org.junit.Assert.assertEquals;
/*
*  Autor: Subhradip Sinha
*  Date: 26-10-2021
* */

public class loginStepdefination extends SimplifyVMSBase {
    demo.pageObject.dashBoardXpath dashBoardXpath = new dashBoardXpath(driver);
  public static   xls_Reader reader = new xls_Reader("./src/test/resources/Data.xlsx");




    @Given("Enter application URL in address bar")
    public void enter_application_url_in_address_bar() throws Exception {
        driver.get(prop.getPropValues(SimplifyVMSConstants.URL));
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='email']")));
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
        WebElement SingIn = dashBoardXpath.Sing_In;
        if (SingIn.isDisplayed()){
        dashBoardXpath.clickOn(SingIn);
        System.out.println("************Click The Sing_In Button************");}
        else {
            screenshot_File.SimplifyVms(driver,"SingIn Releated_Issue");
            System.out.println("************Click The Sing_In Button Related Issue************");
        }

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
        dashBoardXpath.clickOn(Action);
        System.out.println("Action button click");
        Thread.sleep(2000);

    }

    @Then("Click on the approvals tab on the job detatils page to view the approval workflow")
    public void click_on_the_approvals_tab_on_the_job_detatils_page_to_view_the_approval_workflow() throws InterruptedException {
//        WebElement Action1 = dashBoardXpath.Dashboard_Addjob;
//        if (Action1.isDisplayed()) {
//            Action1.click();
//            Thread.sleep(3000);
//            System.out.println("Approve Tab Show: " + Action1.getText());
            dashBoardXpath.clickOn(dashBoardXpath.Approve);
            System.out.println("******Approve button click*********** ");

    }

    @Then("You should see the first level of approval as the Hiring Manager and the second level of approval as HM+{int}\"")
    public void you_should_see_the_first_level_of_approval_as_the_hiring_manager_and_the_second_level_of_approval_as_hm(Integer int1) {
        WebElement Pending = dashBoardXpath.PendingApproval_massage;
        Pending.getText();
        if (Pending.isDisplayed()) {
            System.out.println(Pending.getText());
            assertEquals(" Pending Approval ", Pending.getText());
            String dash = driver.findElement(By.xpath("//header/div[1]/p[1]")).getText();
            String msg = dash.substring(6, 28);
            System.out.println("Job Created ID: " + msg);
            System.out.println( reader.setCellData("SimplifyVMS", "Project ID", 2, msg));

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
//        Thread.sleep(3000);
//        dashBoardXpath.Select_GL_Location.click();
//        System.out.println("Select_GL_Location");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.First_Location);
//        Thread.sleep(3000);
//        System.out.println("First_Location");
//        dashBoardXpath.select_Legal_Entity.click();
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.First_Legal_Entity);
//        Thread.sleep(3000);
//        System.out.println("Legal_Entity service department");
//        dashBoardXpath.select_Service_Department.click();
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.First_Service_Department);
//        Thread.sleep(3000);
//        System.out.println("select_Service_Department");
//
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("scroll(0, 150)");
//
//        dashBoardXpath.select_Cost.click();
//        Thread.sleep(3000);
//        dashBoardXpath.First_Cost.click();
//        System.out.println("First_Cost.click");
//        Thread.sleep(3000);
//
//
//
//        // select on Business unit and click on 2nd element
//        dashBoardXpath.select_Business_Unit.click();
//        Thread.sleep(5000);
//        System.out.println("Business unit");
//
//        WebElement test = dashBoardXpath.First_Business;
//        if (test.isDisplayed()) {
//            dashBoardXpath.First_Business.click();
//            System.out.println("First_Business.click");
//            Thread.sleep(3000);
//        } else {
//            System.out.println("First_Business.click not showing");
//            Thread.sleep(3000);
//        }
//        // select on GL Account and click on the element
//        dashBoardXpath.select_GL_Account.click();
//        Thread.sleep(3000);
//        System.out.println("select_GL_Account.click");
//        dashBoardXpath.First_GL_Account.click();
//        Thread.sleep(3000);
        // click on submit message
        System.out.println("submit");

//        dashBoardXpath.Create_Job.click();
//        Thread.sleep(5000);
//        System.out.println("Create_Job.click");

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
        Thread.sleep(2000);
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "Project ID", 2));
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
            dashBoardXpath.clickOn(Approve_Request);
            Thread.sleep(3000);
            System.out.println("Approve_Request.isDisplayed() and click successfully:  "+Approve_Request.getText());
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
            dashBoardXpath.clickOnAfterElementIsVisible(MSP_User);
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
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "Project ID", 2));
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
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Vendor_name);
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_Distribute1);
        System.out.println("First dashBoardXpath.MSP_Distribute1 click ");
        Thread.sleep(5000);
        driver.navigate().back();
        Thread.sleep(3000);
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
        dashBoardXpath.clickOn(dashBoardXpath.Vendor_name);
        Thread.sleep(3000);
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
        WebElement emailID=dashBoardXpath.Select_AddCandidate_email;
        emailID.clear();
        String userName = ""+(int)(Math.random()*Integer.MAX_VALUE);
        String emailID2 = "User"+userName+"@gmail.com";
        emailID.sendKeys(emailID2);
        Thread.sleep(2000);
        JavascriptExecutor jse5 = (JavascriptExecutor) driver;
        jse5.executeScript("scroll(451,950 )");

        WebElement EducationButton=dashBoardXpath.Education_Button;
        if(EducationButton.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.default_Close_educationTab);
            System.out.println("default_Close_educationTab");
            Thread.sleep(2000);
            dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
            Thread.sleep(2000);
            System.out.println("default_Close_educationTab_popup");
            dashBoardXpath.clickOn(dashBoardXpath.Qualification_drpdwn);
            System.out.println("Qualification_drpdwn");
            Thread.sleep(2000);
            dashBoardXpath.clickOn(dashBoardXpath.education_tab);
            System.out.println("education_tab");
            Thread.sleep(2000);

            dashBoardXpath.clickOn(EducationButton);
            System.out.println(" dashBoardXpath.Education_Button show:   "+EducationButton.isDisplayed());
            Thread.sleep(3000);
            dashBoardXpath.clickOn(dashBoardXpath.Selectdrp_Education);
            Thread.sleep(3000);
            System.out.println("dashBoardXpath.Selectdrp_Education");
            dashBoardXpath.clickOn(dashBoardXpath.Subject_Name);
            System.out.println("dashBoardXpath.Subject_Name");
            Thread.sleep(3000);
            dashBoardXpath.clickOn(dashBoardXpath.Education_SubmitButton);
            System.out.println("dashBoardXpath.Education_SubmitButton");
            screenshot_File.SimplifyVms(driver,"Education_SubmitButton");
            Thread.sleep(3000);


        }


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
        Thread.sleep(2000);
//        dashBoardXpath.clickOn(dashBoardXpath.Clickon_availableCandidate);
//        System.out.println("dashBoardXpath.Clickon_availableCandidate");

        Thread.sleep(2000);
        String acctualFinalMessage = reader.getCellData("SimplifyVMS", "UniqueID", 2).trim();
        dashBoardXpath.enterValue(dashBoardXpath.job_search, acctualFinalMessage);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        Thread.sleep(2000);


    }

    @Then("Fill in the necessary details and click on submit candidate")
    public void fill_in_the_necessary_details_and_click_on_submit_candidate() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Candidate_Name);
        System.out.println("dashBoardXpath.Candidate_Name");
        Thread.sleep(3000);

    }

    /*
     * Scenario : Enter Time By Worker
     * Name - Nirmalya Sarkar
     * Date - 03.11.2021*/





    /*
     * Name - Arijit Chowdhury*/

    @Given("On the candidate details page, after reviewing the candidate - click on Schedule Interview on the right side of the page")
    public void on_the_candidate_details_page_after_reviewing_the_candidate_click_on_schedule_interview_on_the_right_side_of_the_page() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Schedule_interview);
        System.out.println("dashBoardXpath.Schedule_interview");
    }
    @Then("This will redirect to the schedule interview page.")
    public void this_will_redirect_to_the_schedule_interview_page() throws InterruptedException {
        System.out.println("Redirect");
        Thread.sleep(10000);
    }
    @Then("Fill in the relevant details and click on schedule interview")
    public void fill_in_the_relevant_details_and_click_on_schedule_interview() throws InterruptedException {
        Thread.sleep(5000);
        dashBoardXpath.clickOn(dashBoardXpath.Interviewer);
        System.out.println("dashBoardXpath.Interviewer");
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Interview);
        System.out.println("dashBoardXpath.Select_Interview");
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Interview_Type);
        System.out.println("dashBoardXpath.Interview_Type");
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_int_Type);
        System.out.println("dashBoardXpath.Select_int_Type");
        Thread.sleep(2000);
        dashBoardXpath.enterValue(dashBoardXpath.Interview_Location, "London, UK"+"\n");
        System.out.println("dashBoardXpath.Interview_Location");
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Timezone);
        System.out.println("dashBoardXpath.Timezone");
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Timezon);
        System.out.println("dashBoardXpath.Select_Timezon");
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Interview_Duration);
        Thread.sleep(2000);
//        dashBoardXpath.clickOn(dashBoardXpath.Duration);
//        System.out.println("dashBoardXpath.Duration");
//        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Duration);
        System.out.println("dashBoardXpath.Select_Duration");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Choose_Date);
        System.out.println("dashBoardXpath.Choose_Date");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Select_Date);
        System.out.println("dashBoardXpath.Select_Date");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Time_Slot);
        System.out.println("dashBoardXpath.Time_Slot");
        dashBoardXpath.clickOn(dashBoardXpath.Select_Time_Slot);
        System.out.println("dashBoardXpath.Select_Time_Slot");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.schedule);
        System.out.println("dashBoardXpath.schedule");
        Thread.sleep(3000);
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
            Thread.sleep(3000);
        }

        System.out.println("*** Login Hiring Manager ***");
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 4));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 4));
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 4));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 4));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(3000);
    }
    @Then("Click Timesheet Pending Approval under Pending Actions")
    public void Click_Timesheet()throws InterruptedException
    {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Timesheets_pending_approval);
        System.out.println("Click into Timesheet pending Approval");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.checkmark_timesheet);
        System.out.println("Click into check mark");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Worker_name);
        System.out.println("Click into Worker Name");
        Thread.sleep(3000);

    }
    @Then("You can open up the Timesheet and view details of the timesheet and click on approve")
    public void click_on_timesheet_approve()throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Approve_Timesheet);
        System.out.println("click into Approve");
        Thread.sleep(3000);
        //dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.confirmation_message_for_approve_timesheet);
        WebElement approve_timesheet_popup = dashBoardXpath.confirmation_message_for_approve_timesheet;
        System.out.println("Confirmation message for approve Timesheet:::::--" + approve_timesheet_popup);
        if (approve_timesheet_popup.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_ok);
            System.out.println("Approve finally");
            Thread.sleep(3000);
        }
    }
//    @Given("Navigate to the job from the left navigation pane and click on the job you are working on")
//    public void Navigate_to_the_job_from_the_left_navigation_pane_and_click_on_the_job_you_are_working_on() throws  InterruptedException
//    {
//        WebElement My_DashBoard = dashBoardXpath.MSP_UserAccount;
//        if (My_DashBoard.isDisplayed()) {
//            dashBoardXpath.clickOn(My_DashBoard);
//            System.out.println(My_DashBoard.getText());
//            Thread.sleep(2000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if (LogOut.isDisplayed()) {
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**LogOut Button Click:** " + LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()) {
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*Log_out_Pop_Up.isDisplayed:** ");
//                Thread.sleep(3000);
//            }
//        }
//        System.out.println("Login MSP Credentials");
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",2));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",2));
//        Thread.sleep(2000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",2));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",2));
//        Thread.sleep(2000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_job);
//        System.out.println("Click on job");
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_submission);
//        System.out.println("click into subsmission");
//        Thread.sleep(3000);
//
//    }
//    @Then("This will bring up list of all submitted candidatesYou can either review each one by clicking the Candidate's name")
//    public  void submitted_Candidate_name()throws InterruptedException{
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submitted_candidate_Name);
//        System.out.println("dashBoardXpath.submitted_candidate_Name");
//        Thread.sleep(2000);
//
//    }
//    @Then("Click on the candidate you wish to create offer for and head to offers tab in the candidates detail page")
//    public void Click_on_the_candidate_you_wish_to_create_offer()throws InterruptedException
//    {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_button);
//        System.out.println("click into offer button");
//        Thread.sleep((2000));
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.create_offer);
//        System.out.println("click into Create offer");
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.final_Create_offer);
//        System.out.println("Click into Final Create offer");
//        Thread.sleep(2000);
//
//
//    }
//    @Then("Fill in all the relevant details")
//    public void Fill_in_all_the_relevant_details()throws InterruptedException
//    {
//
//
//        //Thread.sleep(5000);
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Timesheet);
//        System.out.println("After Click into Timesheet");
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.choose_timesheet);
//        System.out.println("after choose Time sheet");
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Assignment_active_upon);
//        System.out.println("Click into Assignment Active button");
//        Thread.sleep(3000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Choose_assignment);
//        System.out.println("candidate pay rate");
//
//        Thread.sleep(3000);
//        WebElement pay_rate=dashBoardXpath.candidate_pay_rate;
//        pay_rate.sendKeys(Keys.CONTROL + "a");
//        pay_rate.sendKeys("100");
//        Thread.sleep(5000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Release_offer);
//        System.out.println("dashBoardXpath.Release_offer");
//        Thread.sleep(2000);
//    }
//    @Given("Log in as Supplier you are using")
//    public void Log_in_as_Supplier_you_are_using() throws InterruptedException {
//        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
//        if (vendor_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if(LogOut.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("***LogOut Button Click:*** "+LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()){
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",3));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",3));
//        Thread.sleep(3000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",3));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",3));
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(3000);
//    }
//
//    @Then ("Click on Pending Offers under Pending Actions")
//    public void Click_on_Pending_Offers_under_Pending_Actions()throws InterruptedException
//    {
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_offers);
//        Thread.sleep(3000);
//        System.out.println("pending offer");
//    }
//    @Then("Click on Candidate name for whom the offer was created in step 15")
//    public void Click_on_Candidate_name_for_whom_the_offer_was_created_in_step_15()
//    {
//        String status=dashBoardXpath.getStatusText(dashBoardXpath.click_released);
//        System.out.println("Enter next Step:"+status);
//
//        if(status.contains("Released")){
//            System.out.println("Enter next Step:");
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_name);
//
//
//        }else{
//            System.out.println("Status not matched");
//        }
//    }
//    @Then("Click on Reject Offer or click Accept Offer")
//    public void click_accept_offer() throws InterruptedException {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_status_check);
//        System.out.println("dashBoardXpath.offer_candidate_status_check");
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_accept);
//        System.out.println("dashBoardXpath.offer_candidate_accept");
//        Thread.sleep(2000);
//        WebElement note = dashBoardXpath.offer_acceptance_reason;
//        note.sendKeys(Keys.CONTROL + "a");
//        note.sendKeys("Good Knowledge");
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept_offer);
//        System.out.println("dashBoardXpath.Accept_offer");
//
//    }
//
//// 05/11/2021
//// Anup Ghosh
//    // Testcase -21 (Enter Expense by Worker )
//
//    @Given("Log in as Worker Vendor")
//    public void Login_worker_vendor()throws InterruptedException
//    {
//        System.out.println("*********** Logout *********");
//        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
//
//        if (vendor_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        System.out.println("******** Logout Hiring Manager **********");
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if(LogOut.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("***LogOut Button Click:*** "+LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()){
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
//                Thread.sleep(3000);
//            }
//            System.out.println("******** Hiring Manager Logout Successfully ********");
//            driver.navigate().refresh();
//            Thread.sleep(3000);
//        }
//
//        System.out.println("************* Login Vendor User **************");
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",3));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",3));
//        Thread.sleep(3000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",3));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",3));
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(3000);
//
//    }
//    @Then("Click on the second icon clock icon on the eft navigation pane and click on View General Expenses")
//    public void click_on_second_icon()throws InterruptedException
//    {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Time_Expense);
//        System.out.println("Click into Navigation Pane");
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense);
//        System.out.println("Click into View General Expense");
//    }
//    @Then("Click on the blue + icon near the Expense list")
//    public void click_blue_icon()throws InterruptedException
//    {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_add_general_expense);
//        System.out.println("Click into General Expense");
//        Thread.sleep(3000);
//    }
//    @Then("Select the assignment you wish to add the expense for and click Continue")
//    public void select_assignment()throws InterruptedException
//    {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.select_worker);
//        Thread.sleep(3000);
//        WebElement worker=dashBoardXpath.select_worker;
//        //worker.sendKeys(Keys.CONTROL+ "a");
//        //Select workr = new Select(worker);
//        //workr.selectByVisibleText("Jake vic");
//        worker.sendKeys("Jake vic");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.select_name_of_worker);
//        System.out.println("Select Worker Name");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.continue_expense);
//        System.out.println("Click Into Continue Expense");
//    }
//    @Then("Click on Add expense")
//    public void click_on_Add_Expense()throws InterruptedException
//    {
//
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_general_expense);
//        //dashBoardXpath.clickOn(dashBoardXpath.Add_general_expense);
//        System.out.println("Click Add General Expense");
//        // Thread.sleep(6000);
//        System.out.println("Expense category--------"+dashBoardXpath.expense_category.getText());
//
//    }
//    @Then("Select the Day for the Expense, Expense Type, Amount, and Receipt attachment - click Add Expense")
//    public void select_date()throws InterruptedException {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Date_Incurred);
//        System.out.println("Select Date");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.start_date_incurred);
//        System.out.println("click into start date incurred");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.end_date_incurred);
//        System.out.println("click into end date incurred");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.apply_date);
//        System.out.println("click into apply date approve");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.select_expense_type);
//        System.out.println("Select Expense Type");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.name_of_expense_type);
//        System.out.println("Select Expense Type");
//        Thread.sleep(3000);
//        WebElement amount = dashBoardXpath.toal_amount;
//        amount.sendKeys("100");
//        System.out.println("Total Amount");
//        Thread.sleep(2000);
//    }
//    @Then("You can add more expenses for the Expense Sheet by clicking Add Expense. Once you are finished, click Submit for Approval")
//    public void click_submit_approval()throws InterruptedException
//    {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submit_general_expense);
//        System.out.println("Submit General Expense");
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.final_submit_general_expense);
//        System.out.println("Final Submit General Expense");
//        Thread.sleep(3000);
//        WebElement message = dashBoardXpath.confirm_message;
//        if (message.isDisplayed()) {
//            System.out.println("Verified----------------------");
//            Thread.sleep(3000);
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submit_expense);
//            Thread.sleep(3000);
//
//        }
//    }
//
//// Debendra -------- 08-11-2021
//
//
//
//
//    @Given("Log in as MSP User Update Assignment")
//
//    public void log_msp_user_update_asssigment() throws  InterruptedException
//    {
//        System.out.println("**********Login Msp User***************");
//        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
//
//
//        if (vendor_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if(LogOut.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**********LogOut Button Click:********** "+LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()){
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",2));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",2));
//        Thread.sleep(3000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",2));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",2));
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(3000);
//
//    }
//
//    @Then("Open menu on the left hand side of screen open Assignments and click View Assignments")
//    public void click_view_Assignemnt() throws InterruptedException {
//        Thread.sleep(3000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Assignment_click);
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.views_Assignment);
//    }
//
//    @Then("Select one of the Contracts you created")
//    public void Select_one_the_contract_created() throws InterruptedException {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.views_Assignment_click_contact);
//        Thread.sleep(2000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.views_Assignment_click_action);
//
//    }
//    @Then("Select Update Assignment")
//    public void select_update_assigment() throws  InterruptedException {
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Update_Assignment_click);
//        Thread.sleep(2000);
//
//        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
//
//        Thread.sleep(2000);
//
//        WebElement gCost = dashBoardXpath.Assignment_change_cost;
//        gCost.clear();
//        gCost.sendKeys("71183 - 71183");
//        System.out.println("Expense Allowed");
//        WebDriverWait wait = new WebDriverWait(driver, 10);
//        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_change_cost_save));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
//
//        WebElement click_contienus = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue));
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_contienus);
//
//        Thread.sleep(1000);
//
//
////        effectiveDate.sendKeys("11/10/2021");
//        WebElement date_update_save = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_effectivedate));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", date_update_save);
//        Thread.sleep(1000);
//
//
//        WebElement click_contienus_efect_date = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_effectivedate_select_current));
//
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_contienus_efect_date);
//
//        Thread.sleep(1000);
//
//        WebElement reason_update_Assignment = dashBoardXpath.Assignment_Continue_after_reason_update;
//        reason_update_Assignment.clear();
//        reason_update_Assignment.sendKeys("Financial change");
//        WebElement reason_update_save = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_reason_update_save));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reason_update_save);
//
//        Thread.sleep(1000);
//
//        WebElement Assignment_save = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_save));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Assignment_save);
//
//
//
//    }
//
//
//    @Given("Log in as MSP User or Vendor")
//    public void log_msp_user_vendor() throws InterruptedException{
//        System.out.println("**********Login Msp User***************");
//        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
//
//
//        if (vendor_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if(LogOut.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**********LogOut Button Click:********** "+LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()){
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",2));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",2));
//        Thread.sleep(3000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",2));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",2));
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(3000);
//
//
//    }
//    @Then("Msp View General Expenses")
//    public void msp_view_general_expenses() throws InterruptedException {
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Time_Expense_msp);
//        System.out.println("Click into Navigation Pane");
//        Thread.sleep(2000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense_msp);
//        System.out.println("Click into View General Expense");
//        Thread.sleep(1000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense_msp_pending);
//        System.out.println("Click into View General Expense and pending");
//
//    }
//    @Then("Open an Expense that is pending for approval and Withdrawn")
//    public  void open_an_expense_is_pending_for_approval() throws InterruptedException {
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_click);
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_withdraw);
//
//
//    }
//
//    @Then("You can adjust the Expense entered then select the Reasons for Modification and click")
//    public void reasons_for_modification_and_click() throws InterruptedException {
//        Thread.sleep(2000);
//
//        WebElement withdraw_reason=dashBoardXpath.pending_approval_msp_user_withdraw_expense;
//
//        withdraw_reason.clear();
//        withdraw_reason.sendKeys("Other");
//        System.out.println("Other : ");
//
//        Thread.sleep(2000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_withdraw_Reason);
//        Thread.sleep(1000);
//
//        WebElement withdraw_reason_note=dashBoardXpath.pending_approval_msp_user_withdraw_Reason_note;
//        withdraw_reason_note.sendKeys("Not Expence");
//
//        Thread.sleep(3000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_withdraw_submit);
//
//    }
//
//    @Given("Log in as HM User")
//    public void log_in_hm_user() throws InterruptedException{
//
//        System.out.println("**********Login HM User***************");
//        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
//
//
//        if (vendor_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if(LogOut.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**********LogOut Button Click:********** "+LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()){
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",4));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",4));
//        Thread.sleep(3000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",4));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",4));
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(3000);
//
//
//
//    }
//    @Then("hm user time expense")
//    public void hm_user_time_expense() throws InterruptedException{
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.hm_user_time_expense);
//
//        Thread.sleep(1000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.hm_user_view_general_ecpenses);
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense_hm_pending);
//
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_hm_user_click);
//
//
//        Thread.sleep(2000);
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_hm_user_approve);
//    }
//
//    @Given("Login as the MSP user")
//    public void login_as_the_msp_user()throws Exception {
//        Thread.sleep(5000);
//        WebElement Action = dashBoardXpath.MSP_UserAccount;
//        if (Action.isDisplayed()) {
//            Thread.sleep(5000);
//            String action = Action.getText();
//            System.out.println("Action Tab Show:  " + action);
//            Action.click();
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        Thread.sleep(5000);
//        if (LogOut.isDisplayed()) {
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("***LogOut Button Click:*** " + LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()) {
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 2));
//        Thread.sleep(3000);
//        System.out.println("   Enter UserName is:  " + reader.getCellData("SimplifyVMS", "UserName", 2));
//        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
//        Thread.sleep(3000);
//        System.out.println(" Enter The Password is: " + reader.getCellData("SimplifyVMS", "Password", 2));
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        System.out.println("*****Click The Sing_In Button*****");
//        Thread.sleep(15000);
//        String title = driver.getTitle();
//        if (title.equals("Simplify VMS 2.0")) {
//            System.out.println("**** Login Successful******");
//        }
//
//
//    }
//    @Then("In Pending Actions click on Resumes to Review. Alternatively, navigate to the job from the left navigation pane and click on the job you are working on. You should be able to see a tab named Submitted Candidates")
//    public void in_pending_actions_click_on_resumes_to_review_alternatively_navigate_to_the_job_from_the_left_navigation_pane_and_click_on_the_job_you_are_working_on_you_should_be_able_to_see_a_tab_named_submitted_candidates() throws InterruptedException {
//        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Job);
//        Thread.sleep(10000);
//        System.out.println("*Job button click*");
//
//    }
//    @Then("This will bring up list of all submitted candidates. You can either review each one by clicking the Candidate's name")
//    public void this_will_bring_up_list_of_all_submitted_candidates_you_can_either_review_each_one_by_clicking_the_candidate_s_name() throws InterruptedException {
//        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Submission);
//        System.out.println("dashBoardXpath.Dashboard_Submission");
//        Thread.sleep(10000);
//        dashBoardXpath.enterValue(dashBoardXpath.job_search,reader.getCellData("SimplifyVMS","Project ID",2).trim());
//        dashBoardXpath.clickOn(dashBoardXpath.Dasboard_Search);
//        Thread.sleep(10000);
//    }
//    @Then("Review the candidate details. Click on {string} to review Rejection reasons in module; for this exercise, click {string}")
//    public void
//    review_the_candidate_details_click_on_to_review_rejection_reasons_in_module_for_this_exercise_click(String string, String string2) throws InterruptedException {
//        dashBoardXpath.clickOn(dashBoardXpath.Job_clk);
//        Thread.sleep(8000);
//        dashBoardXpath.clickOn(dashBoardXpath.Submitted_Candidate);
//        Thread.sleep(8000);
//        dashBoardXpath.clickOn(dashBoardXpath.Candidate_Click);
//        Thread.sleep(8000);
//        dashBoardXpath.clickOn(dashBoardXpath.Shortlist);
//        Thread.sleep(5000);
//        //------------------end--------------//
//
//    }
//    @Given("Login as the Vendor of the candidate Accept Interview")
//    public void Login_as_the_Vendor_of_the_candidate()throws Exception {
//        System.out.println("Logout MSP user------");
//        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
//
//
//        if (vendor_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: "+vendor_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if(LogOut.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**LogOut Button Click:** "+LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()){
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*Log_out_Pop_Up.isDisplayed:** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//        System.out.println("Login Vendor User");
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",3));
//        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",3));
//        Thread.sleep(4000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",3));
//        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",3));
//        Thread.sleep(4000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(4000);
//    }
//
//    @Then("click the pending action")
//    public void Login_as_the_Vendor_of_the_candidate_pending_action() throws InterruptedException
//    {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Pending_interview);
//        System.out.println("Pending Interview");
//        Thread.sleep(6000);
//
//    }
//    @Then("Select the candidate you were working on and click on the candidates name")
//    public  void Select_the_candidate_you_were_working_on_and_click_on_the_candidate_name() throws InterruptedException
//    {
//        JavascriptExecutor jse = (JavascriptExecutor) driver;
//        jse.executeScript("scroll(0, 500)");
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Click_name);
//        System.out.println("click name");
//        Thread.sleep(3000);
//
//    }
//    @Then("Accept_button")
//    public void Accept_button() throws InterruptedException {
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept);
//        System.out.println("click Accept");
//        Thread.sleep(3000);
//
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.check_interview_date);
//        System.out.println("check interview date");
//        Thread.sleep(3000);
//
//        WebElement phn_no =dashBoardXpath.phone_number;
//        System.out.println("Enter phone number");
//        phn_no.sendKeys(Keys.CONTROL + "a");
//        phn_no.sendKeys(reader.getCellData("SimplifyVMS","Phone Number",2));
//        System.out.println("phone number Accepted"+reader.getCellData("SimplifyVMS","Phone Number",2));
//    }
//    @Then("interview_and_select_Accept")
//    public void interview_and_select_Accept()throws InterruptedException {
//        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept_interview);
//        System.out.println("Accept Interview complete");
//    }
//
//
//    /*Name - Nirmalya Sarkar
//     * Date - 08.11.2021*/
//    @Given("Login as MSP,Vendor using the credentials for the MSP,Vendor")
//    public void login_as_msp_vendor_using_the_credentials_for_the_msp_vendor()throws Exception {
//        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
//        if (MSP_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if (LogOut.isDisplayed()) {
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()) {
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 3));
//        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 3));
//        Thread.sleep(4000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 3));
//        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 3));
//        Thread.sleep(4000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(4000);
//
//    }
//    @When("User Open menu on the left hand side of screen")
//    public void user_open_menu_on_the_left_hand_side_of_screen()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Switch_menu);
//        Thread.sleep(3000);
//    }
//    @When("User open Time and Expense")
//    public void user_open_time_and_expense()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Time_and_Expense);
//        Thread.sleep(3000);
//    }
//    @When("click View Timesheet")
//    public void click_view_timesheet()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.View_Timesheets);
//        Thread.sleep(3000);
//    }
//    @Then("User will landed on Timesheet List page")
//    public void user_will_landed_on_timesheet_list_page()throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("User Open a Timesheet that has been Pending for approval")
//    public void user_open_a_timesheet_that_has_been_pending_for_approval()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Pending_Approval);
//        Thread.sleep(3000);
//        WebElement pendingID=dashBoardXpath.PendingID;
//        String pendingid= pendingID.getText();
//        System.out.println("Successfully found the draft timesheet id"+pendingID.getText());
//        reader.setCellData("SimplifyVMS","PendingTimesheetID",2,pendingid);
//    }
//    @When("Can click one candidate")
//    public void can_click_one_candidate()throws Exception {
//        dashBoardXpath.enterValue(dashBoardXpath.job_search,reader.getCellData("SimplifyVMS","PendingTimesheetID",2));
//        System.out.println(reader.getCellData("SimplifyVMS","TimesheetID",2));
//        dashBoardXpath.clickOn(dashBoardXpath.search_button);
//        Thread.sleep(3000);
//    }
//    @Then("User will landed on Candidate profile page")
//    public void user_will_landed_on_candidate_profile_page()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.TimesheetList_WorkerName);
//        Thread.sleep(3000);
////        dashBoardXpath.clickOn(dashBoardXpath.ModifyTimesheet_pendingExpenses);
////        Thread.sleep(3000);
//    }
//    @When("User can withdraw Timesheet by clicking withdraw button")
//    public void user_can_withdraw_timesheet_by_clicking_withdraw_button()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.WithdrawTimesheet);
//        Thread.sleep(3000);
//    }
//    @Then("Modify withdrawn page will come")
//    public void modify_withdrawn_page_will_come()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Select_reason_for_withdraw);
//        Thread.sleep(3000);
//    }
//    @Then("user will choose data in withdraw reason field with notes")
//    public void user_will_choose_data_in_withdraw_reason_field_with_notes()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Reason_for_withdraw);
//        Thread.sleep(3000);
//    }
//    @Then("click withdraw")
//    public void click_withdraw()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Final_withdraw);
//        Thread.sleep(3000);
//    }
//    @Then("particular Timesheet will be withdrawn")
//    public void particular_timesheet_will_be_withdrawn()throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        throw new io.cucumber.java.PendingException();
//    }
//    @When("user click on Approved Timesheet")
//    public void user_click_on_approved_expenses()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Clickon_Approvetimesheet);
//        Thread.sleep(3000);
//        WebElement Time_Worker = dashBoardXpath.TimesheetList_WorkerName;
//        if(Time_Worker.isDisplayed()){
//            dashBoardXpath.clickOn(Time_Worker);
//            System.out.println(Time_Worker +"Successfully click on Worker Name");
//            Thread.sleep(3000);
//        }
//
//    }
//    @When("user click Modify Timesheet  at top right corner")
//    public void user_click_modify_timesheet_at_top_right_corner()throws Exception {
//
//        //driver.navigate().refresh();
//        WebElement checkMod = dashBoardXpath.Check_Timesheet_Modify;
//        if (checkMod.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.Timesheet_Modify);
//            Thread.sleep(3000);
//        }
//
//    }
//    @When("Modify Timesheet page will be open")
//    public void modify_timesheet_page_will_be_open()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.SelectAfterModify_Timesheet);
//        Thread.sleep(3000);
//    }
//    @Then("User can put data on Reason for modify fields with notes")
//    public void user_can_put_data_on_reason_for_modify_fields_with_notes()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Clickon_HoursUpdate);
//        Thread.sleep(3000);
//    }
//    @Then("Click Modify Button")
//    public void click_modify_button()throws Exception {
//        dashBoardXpath.clickOn(dashBoardXpath.Final_Modify);
//        Thread.sleep(3000);
//    }
//    @Then("Click Save button  for the modification Timesheet")
//    public void click_save_button_for_the_modification_timesheet()throws Exception {
//        WebElement draftID=dashBoardXpath.DraftTimesheetID;
//        String Draftid= draftID.getText();
//        System.out.println("Successfully found the draft timesheet id"+draftID.getText());
//        reader.setCellData("SimplifyVMS","DraftTimesheetID",2,Draftid);
//        System.out.println(reader.setCellData("SimplifyVMS","DraftTimesheetID",2,Draftid));
//        dashBoardXpath.clickOn(dashBoardXpath.Back_to_Timesheet);
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.TimesheetList_WorkerName);
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.Submit_timesheet);
//        Thread.sleep(3000);
//
//    }
//    @Then("Log in as Hiring Manager to approve Modification")
//    public void log_in_as_hiring_manager_to_approve_modification()throws Exception {
//        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
//        if (MSP_User.isDisplayed()) {
//            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
//            System.out.println(" MSP_UserAccount Account Click: " + MSP_User.isDisplayed());
//            Thread.sleep(3000);
//        }
//        WebElement LogOut = dashBoardXpath.LogOut;
//        if (LogOut.isDisplayed()) {
//            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
//            Thread.sleep(3000);
//            System.out.println("**********LogOut Button Click:********** " + LogOut.isDisplayed());
//            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
//            if (Log_out_Pop_Up.isDisplayed()) {
//                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
//                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
//                Thread.sleep(3000);
//            }
//            driver.navigate().refresh();
//            Thread.sleep(5000);
//        }
//
//        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 4));
//        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 4));
//        Thread.sleep(4000);
//        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 4));
//        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 4));
//        Thread.sleep(4000);
//        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
//        Thread.sleep(4000);
//        dashBoardXpath.enterValue(dashBoardXpath.job_search,reader.getCellData("SimplifyVMS","DraftTimesheetID",2));
//        dashBoardXpath.clickOn(dashBoardXpath.TimesheetList_WorkerName);
//        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.ApproveDraftID_FromHM);
//        Thread.sleep(3000);
//        WebElement PopUpApproveTimesheet = dashBoardXpath.WantToApproveTimesheet;
//        String TimesheetApprov = PopUpApproveTimesheet.getText();
//        if (PopUpApproveTimesheet.isDisplayed()){
//            dashBoardXpath.clickOn(dashBoardXpath.ApprovTimeYes);
//        }

//    }



    /*End of Scenario -Modify Timesheet */


}