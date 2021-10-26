package demo.stepdefs;

import demo.SimplifyVMSBase;
import demo.SimplifyVMSConstants;
import demo.pageObject.dashBoardXpath;
import demo.pageObject.xls_Reader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    public void check_the_default_screen_after_log_in() {
        WebElement My_DashBoard = dashBoardXpath.Display_My_DashBoard;
        if (My_DashBoard.isDisplayed())
        {
            String title = My_DashBoard.getText();
            assertEquals("> My Dashboard", title);
            System.out.println("********DashBoard showing*************"+title);
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
        }




    }


}
