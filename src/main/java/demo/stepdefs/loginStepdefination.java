package demo.stepdefs;

import demo.SimplifyVMSBase;
import demo.SimplifyVMSConstants;
import demo.pageObject.dashBoardXpath;
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
    xls_Reader reader = new xls_Reader("./src/test/resources/Data.xlsx");


    @Given("Enter application URL in address bar")
    public void enter_application_url_in_address_bar()throws Exception {
        driver.get(prop.getPropValues(SimplifyVMSConstants.URL));
        Thread.sleep(3000);
    }
    @When("Enter Username")
    public void enter_username()throws Exception {
        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",2));
        Thread.sleep(3000);
        System.out.println("   Enter UserName is:  " +reader.getCellData("SimplifyVMS","UserName",2));
    }
    @Then("Enter Password")
    public void enter_password() throws Exception{
        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",2));
        Thread.sleep(3000);
        System.out.println(" Enter The Password is: " + reader.getCellData("SimplifyVMS","Password",2));
    }
    @Then("Click Sing_In")
    public void click_sing_in()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        System.out.println("************Click The Sing_In Button************");
        Thread.sleep(15000);
        String title = driver.getTitle();
        if (title.equals("Simplify VMS 2.0")){
            System.out.println("************ Login Successful**************");
        }

    }
    @Given("Check the default screen after log in")
    public void check_the_default_screen_after_log_in()throws Exception {
        WebElement My_DashBoard = dashBoardXpath.Display_My_DashBoard;
        if (My_DashBoard.isDisplayed())
        {
            String title = My_DashBoard.getText();
            assertEquals("> My Dashboard", title);
            System.out.println("********DashBoard showing*************"+title);
            Thread.sleep(3000);
        }
        WebElement DashBoard_Add_Job = dashBoardXpath.DashBoard_Add_Job_value;
            assertEquals("Add Job",DashBoard_Add_Job.getText());
            System.out.println("DashBoard_Add_Job Tab Click: "+DashBoard_Add_Job.getText());
            dashBoardXpath.clickOn(dashBoardXpath.DashBoard_Add_Job_value);
            Thread.sleep(15000);
            driver.navigate().back();
            Thread.sleep(15000);
            driver.navigate().refresh();
            Thread.sleep(5000);


            WebElement Active_Job = dashBoardXpath.Dashboard_Active_job;
            System.out.println("Dashboard_Active_job Tab click: "+Active_Job.getText());
            Active_Job.click();
            Thread.sleep(15000);
            driver.navigate().back();
            Thread.sleep(15000);
            driver.navigate().refresh();
            Thread.sleep(5000);

            WebElement Head_Count = dashBoardXpath.DashBoard_Head_Count;
            System.out.println("DashBoard_Head_Count Tab Click:  "+Head_Count.getText());
            Head_Count.click();
            Thread.sleep(15000);
            driver.navigate().back();
            Thread.sleep(5000);

            WebElement Contact_Support = dashBoardXpath.DashBoard_Contact_Support;
            System.out.println("Contact_Support Tab Click: "+Contact_Support.getText());
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
    public void in_dashboard_click_the_setting_icon_in_the_top_right_hand_corner()throws Exception {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Settings);
        Thread.sleep(3000);
        System.out.println("Settings button click");
    }
    @Then("User can move dashboard items around, and expand\\/contract them")
    public void user_can_move_dashboard_items_around_and_expand_contract_them() {

    }
    @Then("User can Add New Widget, Save dashboard configuration, empty dashboard and close editing")
    public void user_can_add_new_widget_save_dashboard_configuration_empty_dashboard_and_close_editing()throws Exception {
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
        if(value.isDisplayed())
        {
            value.sendKeys(reader.getCellData("SimplifyVMS","WIDGET LABEL",2));
            System.out.println(reader.getCellData("SimplifyVMS","WIDGET LABEL",2));
            Thread.sleep(3000);
        }

        WebElement Update_Widget = dashBoardXpath.Update_Widget;
        if (Update_Widget.isDisplayed())
        {
            dashBoardXpath.Update_Widget.click();
            Thread.sleep(3000);
        }
        WebElement pop_Up_close = dashBoardXpath.close_pop_up;
        if (pop_Up_close.isDisplayed())
        {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.close_pop_up);
            Thread.sleep(3000);
        }
        WebElement dots = dashBoardXpath.dots_Click;
        if (dots.isDisplayed())
        {
            dashBoardXpath.clickOn(dashBoardXpath.dots_Click);
            Thread.sleep(3000);
            System.out.println("************* 3dots Tab click***********");
            WebElement reset = dashBoardXpath.reset;
            if (reset.isDisplayed()){
                dashBoardXpath.clickOn(dashBoardXpath.reset);
                System.out.println("************* Reset Tab Click**********");
                Thread.sleep(3000);
            }
            WebElement Pop_Up = dashBoardXpath.Pop_Up_reset;
            if (Pop_Up.isDisplayed()){
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
       if (MSP_User.isDisplayed()){
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
           System.out.println("MSP_UserAccount Account Click");
       Thread.sleep(3000);

       WebElement Account = dashBoardXpath.AccountSettings;
       if (Account.isDisplayed())
       {
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
       Runtime.getRuntime().exec("./autoIt/FileUploadScript.exe");
       Thread.sleep(5000);
        System.out.println("************* Photo Upload************");
        driver.navigate().refresh();
        Thread.sleep(5000);
    }
    @Then("If changes made, click \"\"Save\"\"\"")
    public void if_changes_made_click_save()throws Exception{
        WebElement EditProfile = dashBoardXpath.EditProfile;
        if (EditProfile.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.EditProfile);
            System.out.println("*********Edit profile Display **********"+EditProfile.getText());
            Thread.sleep(5000);
            dashBoardXpath.clickOn(dashBoardXpath.SubmitButton);
            System.out.println("*********Edit Submit button click*******");
            Thread.sleep(15000);
            driver.navigate().refresh();
            Thread.sleep(15000);
        }
    }
    @Given("Once submitted, the user will be shown the details of the job created")
    public void once_submitted_the_user_will_be_shown_the_details_of_the_job_created()throws Exception {
        WebElement Action = dashBoardXpath.Action;
        if(Action.isDisplayed()){
            Thread.sleep(3000);
            String action = Action.getText();
//            assertEquals(" Actions" +
//                    " keyboard_arrow_down ",action);
            System.out.println("Action Tab Show:  "+ action);
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
        if (Pending.isDisplayed()){
            System.out.println(Pending.getText());
            assertEquals(" Pending Approval ",Pending.getText());

        }
    }

    @Given("Click the second icon on the left navigation panel")
    public void click_the_second_icon_on_the_left_navigation_panel()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Briefacse);
        Thread.sleep(10000);
        System.out.println("****Briefcase button click**");

    }
    @Then("A flyout window will appear. Click on \"\"Create Job\"\"")
    public void a_flyout_window_will_appear_click_on_create_job()throws Exception {

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
    public void select_the_job_manager_work_location_will_be_auto_populated_continue_to_select_program_industry() throws InterruptedException {
        WebElement Job_Manager = dashBoardXpath.Job_Manager;
        Job_Manager.click();
        System.out.println("Job_Manager successful run");
        Thread.sleep(3000);
        WebElement HM_Name = dashBoardXpath.HM_Name_Select;
        HM_Name.click();
        Thread.sleep(3000);
        System.out.println("HM_Name Successful run");

    }
    @Then("Add a job description")
    public void add_a_job_description()throws Exception {
        WebElement jb = dashBoardXpath.Job_Description;
        Thread.sleep(2000);
        jb.sendKeys(Keys.CONTROL+"a");
        Thread.sleep(2000);
        jb.sendKeys(prop.getPropValues(SimplifyVMSConstants.Message));
        Thread.sleep(5000);

    }
    @Then("Click on {string} button\"")
    public void click_on_button(String string)throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(10000);
    }
    /*
    * Name - Nirmalya Sarkar
    * Date - 27.10.2021*/

    @Given("The foundational data will be defaulted based on the selection made . Click each field to make changes if necessary")
    public void the_foundational_data_will_be_defaulted_based_on_the_selection_made_click_each_field_to_make_changes_if_necessary() throws InterruptedException {
//        Select select = new Select(dashBoardXpath.Select_GL_Location);
//        Thread.sleep(3000);
//        select.selectByIndex(2);
//        select.selectByValue("Contract Labor - 41345");
//        Thread.sleep(3000);
//
//        Select select1 = new Select(dashBoardXpath.select_Legal_Entity);
//        Thread.sleep(3000);
//        select1.selectByIndex(2);
//        Thread.sleep(3000);
//        select1.selectByValue("Consulting Services - 62616 ");
//        Thread.sleep(5000);

         //Select on GL Location and Click on 2nd Element
        dashBoardXpath.Select_GL_Location.click();
        System.out.println("Gl_location");
        Thread.sleep(3000);
        dashBoardXpath.First_Location.click();
        Thread.sleep(3000);
        System.out.println("Select_GL_Location Select value");
        // Select on Legal Entity and click on 2nd element
        System.out.println("Gl ligal Entity");
        dashBoardXpath.select_Legal_Entity.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Legal_Entity.click();
        Thread.sleep(3000);
        // select on GL Service Department and click on 2nd element
        System.out.println("Gl service department");
        dashBoardXpath.select_Service_Department.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Service_Department.click();
        Thread.sleep(3000);
//        // select on Dept no and click on 1st element
//        dashBoardXpath.select_Dept_No.click();
//        Thread.sleep(3000);
//        dashBoardXpath.First_Dept_No.click();
//        Thread.sleep(3000);
//        // select on Intra Company and click on 1st element
//        dashBoardXpath.select_Intra.click();
//        Thread.sleep(3000);
//        dashBoardXpath.First_Intra.click();
//        Thread.sleep(3000);
        // select on Cost Center and click on 2nd element
        System.out.println("cost center");
        Thread.sleep(3000);
        dashBoardXpath.select_Cost.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Cost.click();
        Thread.sleep(3000);
        // select on Business unit and click on 2nd element
        System.out.println("Business unit");
        dashBoardXpath.select_Business_Unit.click();
        Thread.sleep(3000);
        dashBoardXpath.First_Business.click();
        Thread.sleep(3000);
        // select on GL Account and click on the element
        System.out.println("Gl Account");
        dashBoardXpath.select_GL_Account.click();
        Thread.sleep(3000);
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
        WebElement min =dashBoardXpath.Min;
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
    public void login_as_hiring_manager_using_the_credentials_for_the_hiring_manager()throws Exception {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: "+MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if(LogOut.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** "+LogOut.isDisplayed());
            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()){
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",4));
        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",4));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",4));
        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",4));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }
    @Then("From the dashboard under pending actions widget, click on jobs pending approval")
    public void from_the_dashboard_under_pending_actions_widget_click_on_jobs_pending_approval()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Pending);
        Thread.sleep(5000);
    }
    @Then("Select the job created and either click on the approval tab or on the Pending approval button on the top right corner of the screen.")
    public void select_the_job_created_and_either_click_on_the_approval_tab_or_on_the_pending_approval_button_on_the_top_right_corner_of_the_screen()throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.job_search);
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.job_search,reader.getCellData("SimplifyVMS","Job Profile",2));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        System.out.println("***********dashBoardXpath.search_button click************");
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Value_Click);
        System.out.println("***********dashBoardXpath.Value_Click successfully*********");
        Thread.sleep(3000);
    }
    @Then("Click on approve")
    public void click_on_approve()throws Exception {
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
        if (Approval_Details.isDisplayed()){
            Approval_Details.getText();
            System.out.println("************Approval_Details showing:***********"+Approval_Details.getText());
        }

    }

    @Given("Login as Hiring manager+{int} using the credentials for the Hiring Manager+{int}")
    public void login_as_hiring_manager_using_the_credentials_for_the_hiring_manager(Integer int1, Integer int2)throws Exception {
        WebElement MSP_User = dashBoardXpath.MSP_UserAccount;
        if (MSP_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: "+MSP_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if(LogOut.isDisplayed()){
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("**********LogOut Button Click:********** "+LogOut.isDisplayed());
            WebElement Log_out_Pop_Up=dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()){
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("*********Log_out_Pop_Up.isDisplayed:********** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        dashBoardXpath.enterValue(dashBoardXpath.Username,reader.getCellData("SimplifyVMS","UserName",5));
        System.out.println("Enter HM User name: "+reader.getCellData("SimplifyVMS","UserName",5));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password,reader.getCellData("SimplifyVMS","Password",5));
        System.out.println("Enter Password: "+reader.getCellData("SimplifyVMS","Password",5));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }
}


