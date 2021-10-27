package demo.stepdefs;

import demo.SimplifyVMSBase;
import demo.SimplifyVMSConstants;
import demo.pageObject.dashBoardXpath;
import demo.pageObject.xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.tools.ant.helper.ProjectHelper2;
import org.openqa.selenium.By;
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
    xls_Reader reader = new xls_Reader("D:\\Automation\\SimplifyVMS\\src\\test\\resources\\Data.xlsx");


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
                System.out.println("Column " + iLoop + " : '" + pending_action.get(iLoop).getText().toString() + "'");
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
            assertEquals(" Actions ",action);
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
            assertEquals(" Pending approval ",Pending.getText());

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
        Thread.sleep(3000);
        WebElement HM_Name = dashBoardXpath.HM_Name_Select;
        HM_Name.click();
        Thread.sleep(3000);

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
        Thread.sleep(5000);
    }

}
