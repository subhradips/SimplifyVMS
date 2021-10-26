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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
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
}
