package demo.stepdefs;

import demo.SimplifyVMSBase;
import demo.pageObject.dashBoardXpath;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static demo.stepdefs.loginStepdefination.reader;

public class CreateOfferForCandidate extends SimplifyVMSBase {
    loginStepdefination login = new loginStepdefination();

    @Given("Navigate to the job from the left navigation pane and click on the job you are working on")
    public void Navigate_to_the_job_from_the_left_navigation_pane_and_click_on_the_job_you_are_working_on() throws InterruptedException {
        WebElement My_DashBoard = dashBoardXpath.MSP_UserAccount;
        Thread.sleep(2000);
        if (My_DashBoard.isDisplayed()) {
            dashBoardXpath.clickOn(My_DashBoard);
            System.out.println(My_DashBoard.getText());
            Thread.sleep(2000);
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
        System.out.println("Login MSP Credentials");

        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 2));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 2));
        Thread.sleep(2000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 2));
        Thread.sleep(2000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_job);
        System.out.println("Click on job");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_submission);
        System.out.println("click into subsmission");
        Thread.sleep(3000);

    }

    @Then("This will bring up list of all submitted candidatesYou can either review each one by clicking the Candidate's name")
    public void submitted_Candidate_name() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submitted_candidate_Name);
        System.out.println("dashBoardXpath.submitted_candidate_Name");
        Thread.sleep(2000);

    }

    @Then("Click on the candidate you wish to create offer for and head to offers tab in the candidates detail page")
    public void Click_on_the_candidate_you_wish_to_create_offer() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_button);
        System.out.println("click into offer button");
        Thread.sleep((2000));
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.create_offer);
        System.out.println("click into Create offer");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.final_Create_offer);
        System.out.println("Click into Final Create offer");
        Thread.sleep(2000);


    }

    @Then("Fill in all the relevant details")
    public void Fill_in_all_the_relevant_details() throws InterruptedException {


        //Thread.sleep(5000);
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Timesheet);
        System.out.println("After Click into Timesheet");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.choose_timesheet);
        System.out.println("after choose Time sheet");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Assignment_active_upon);
        System.out.println("Click into Assignment Active button");
        Thread.sleep(3000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Choose_assignment);
        System.out.println("candidate pay rate");

        Thread.sleep(3000);
        WebElement pay_rate = dashBoardXpath.candidate_pay_rate;
        pay_rate.sendKeys(Keys.CONTROL + "a");
        pay_rate.sendKeys("100");
        Thread.sleep(5000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Release_offer);
        System.out.println("dashBoardXpath.Release_offer");
        Thread.sleep(2000);
    }

    @Given("Log in as Supplier you are using")
    public void Log_in_as_Supplier_you_are_using() throws InterruptedException {
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;
        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
            Thread.sleep(3000);
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("***LogOut Button Click:*** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
                Thread.sleep(3000);
            }
            driver.navigate().refresh();
            Thread.sleep(5000);
        }

        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 3));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 3));
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 3));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 3));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(3000);
    }

    @Then("Click on Pending Offers under Pending Actions")
    public void Click_on_Pending_Offers_under_Pending_Actions() throws InterruptedException {

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_offers);
        Thread.sleep(3000);
        System.out.println("pending offer");
    }

    @Then("Click on Candidate name for whom the offer was created in step 15")
    public void Click_on_Candidate_name_for_whom_the_offer_was_created_in_step_15() {
        String status = dashBoardXpath.getStatusText(dashBoardXpath.click_released);
        System.out.println("Enter next Step:" + status);

        if (status.contains("Released")) {
            System.out.println("Enter next Step:");
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_name);


        } else {
            System.out.println("Status not matched");
        }
    }

    @Then("Click on Reject Offer or click Accept Offer")
    public void click_accept_offer() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_status_check);
        System.out.println("dashBoardXpath.offer_candidate_status_check");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.offer_candidate_accept);
        System.out.println("dashBoardXpath.offer_candidate_accept");
        Thread.sleep(2000);
        WebElement note = dashBoardXpath.offer_acceptance_reason;
        note.sendKeys(Keys.CONTROL + "a");
        note.sendKeys("Good Knowledge");
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept_offer);
        System.out.println("dashBoardXpath.Accept_offer");

    }

// 05/11/2021
// Anup Ghosh
    // Testcase -21 (Enter Expense by Worker )

    @Given("Log in as Worker Vendor")
    public void Login_worker_vendor() throws InterruptedException {
        System.out.println("*********** Logout *********");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;

        if (vendor_User.isDisplayed()) {
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
            dashBoardXpath.clickOnAfterElementIsVisible(vendor_User);
            Thread.sleep(3000);
        }
        System.out.println("******** Logout Hiring Manager **********");
        WebElement LogOut = dashBoardXpath.LogOut;
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("***LogOut Button Click:*** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
                Thread.sleep(3000);
            }
            System.out.println("******** Hiring Manager Logout Successfully ********");
            driver.navigate().refresh();
            Thread.sleep(3000);
        }

        System.out.println("************* Login Vendor User **************");
        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 3));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 3));
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 3));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 3));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(3000);

    }

    @Then("Click on the second icon clock icon on the eft navigation pane and click on View General Expenses")
    public void click_on_second_icon() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Time_Expense);
        System.out.println("Click into Navigation Pane");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense);
        System.out.println("Click into View General Expense");
    }

    @Then("Click on the blue + icon near the Expense list")
    public void click_blue_icon() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.click_add_general_expense);
        System.out.println("Click into General Expense");
        Thread.sleep(3000);
    }

    @Then("Select the assignment you wish to add the expense for and click Continue")
    public void select_assignment() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.select_worker);
        Thread.sleep(3000);
        WebElement worker = dashBoardXpath.select_worker;
        //worker.sendKeys(Keys.CONTROL+ "a");
        //Select workr = new Select(worker);
        //workr.selectByVisibleText("Jake vic");
        worker.sendKeys("Jake vic");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.select_name_of_worker);
        System.out.println("Select Worker Name");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.continue_expense);
        System.out.println("Click Into Continue Expense");
    }

    @Then("Click on Add expense")
    public void click_on_Add_Expense() throws InterruptedException {

        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Add_general_expense);
        //dashBoardXpath.clickOn(dashBoardXpath.Add_general_expense);
        System.out.println("Click Add General Expense");
        // Thread.sleep(6000);
        System.out.println("Expense category--------" + dashBoardXpath.expense_category.getText());

    }

    @Then("Select the Day for the Expense, Expense Type, Amount, and Receipt attachment - click Add Expense")
    public void select_date() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Date_Incurred);
        System.out.println("Select Date");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.start_date_incurred);
        System.out.println("click into start date incurred");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.end_date_incurred);
        System.out.println("click into end date incurred");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.apply_date);
        System.out.println("click into apply date approve");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.select_expense_type);
        System.out.println("Select Expense Type");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.name_of_expense_type);
        System.out.println("Select Expense Type");
        Thread.sleep(3000);
        WebElement amount = dashBoardXpath.toal_amount;
        amount.sendKeys("100");
        System.out.println("Total Amount");
        Thread.sleep(2000);
    }

    @Then("You can add more expenses for the Expense Sheet by clicking Add Expense. Once you are finished, click Submit for Approval")
    public void click_submit_approval() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submit_general_expense);
        System.out.println("Submit General Expense");
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.final_submit_general_expense);
        System.out.println("Final Submit General Expense");
        Thread.sleep(3000);
        WebElement message = dashBoardXpath.confirm_message;
        if (message.isDisplayed()) {
            System.out.println("Verified----------------------");
            Thread.sleep(3000);
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.submit_expense);
            Thread.sleep(3000);

        }
    }

// Debendra -------- 08-11-2021


    @Given("Log in as MSP User Update Assignment")

    public void log_msp_user_update_asssigment() throws InterruptedException {
        System.out.println("**********Login Msp User***************");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;


        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
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
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 2));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(3000);

    }

    @Then("Open menu on the left hand side of screen open Assignments and click View Assignments")
    public void click_view_Assignemnt() throws InterruptedException {
        Thread.sleep(3000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Assignment_click);
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.views_Assignment);
    }

    @Then("Select one of the Contracts you created")
    public void Select_one_the_contract_created() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.views_Assignment_click_contact);
        Thread.sleep(2000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.views_Assignment_click_action);

    }

    @Then("Select Update Assignment")
    public void select_update_assigment() throws InterruptedException {
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Update_Assignment_click);
        Thread.sleep(2000);

        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");

        Thread.sleep(2000);

        WebElement gCost = dashBoardXpath.Assignment_change_cost;
        gCost.clear();
        gCost.sendKeys("71183 - 71183");
        System.out.println("Expense Allowed");
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_change_cost_save));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);

        WebElement click_contienus = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_contienus);

        Thread.sleep(1000);


//        effectiveDate.sendKeys("11/10/2021");
        WebElement date_update_save = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_effectivedate));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", date_update_save);
        Thread.sleep(1000);


        WebElement click_contienus_efect_date = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_effectivedate_select_current));

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", click_contienus_efect_date);

        Thread.sleep(1000);

        WebElement reason_update_Assignment = dashBoardXpath.Assignment_Continue_after_reason_update;
        reason_update_Assignment.clear();
        reason_update_Assignment.sendKeys("Financial change");
        WebElement reason_update_save = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_reason_update_save));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", reason_update_save);

        Thread.sleep(1000);

        WebElement Assignment_save = wait.until(ExpectedConditions.elementToBeClickable(dashBoardXpath.Assignment_Continue_after_save));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", Assignment_save);


    }


    @Given("Log in as MSP User or Vendor")
    public void log_msp_user_vendor() throws InterruptedException {
        System.out.println("**********Login Msp User***************");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;


        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
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
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 2));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 2));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(3000);


    }

    @Then("Msp View General Expenses")
    public void msp_view_general_expenses() throws InterruptedException {
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Time_Expense_msp);
        System.out.println("Click into Navigation Pane");
        Thread.sleep(2000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense_msp);
        System.out.println("Click into View General Expense");
        Thread.sleep(1000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense_msp_pending);
        System.out.println("Click into View General Expense and pending");

    }

    @Then("Open an Expense that is pending for approval and Withdrawn")
    public void open_an_expense_is_pending_for_approval() throws InterruptedException {
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_click);
        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_withdraw);


    }

    @Then("You can adjust the Expense entered then select the Reasons for Modification and click")
    public void reasons_for_modification_and_click() throws InterruptedException {
        Thread.sleep(2000);

        WebElement withdraw_reason = dashBoardXpath.pending_approval_msp_user_withdraw_expense;

        withdraw_reason.clear();
        withdraw_reason.sendKeys("Other");
        System.out.println("Other : ");

        Thread.sleep(2000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_withdraw_Reason);
        Thread.sleep(1000);

        WebElement withdraw_reason_note = dashBoardXpath.pending_approval_msp_user_withdraw_Reason_note;
        withdraw_reason_note.sendKeys("Not Expence");

        Thread.sleep(3000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_msp_user_withdraw_submit);

    }

    @Given("Log in as HM User")
    public void log_in_hm_user() throws InterruptedException {

        System.out.println("**********Login HM User***************");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;


        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
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
        Thread.sleep(3000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 4));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 4));
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(3000);


    }

    @Then("hm user time expense")
    public void hm_user_time_expense() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.hm_user_time_expense);

        Thread.sleep(1000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.hm_user_view_general_ecpenses);
        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.View_general_expense_hm_pending);

        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_hm_user_click);


        Thread.sleep(2000);
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.pending_approval_hm_user_approve);
    }

    @Given("Login as the MSP user")
    public void login_as_the_msp_user() throws Exception {
        Thread.sleep(5000);
        WebElement Action = dashBoardXpath.MSP_UserAccount;
        if (Action.isDisplayed()) {
            Thread.sleep(5000);
            String action = Action.getText();
            System.out.println("Action Tab Show:  " + action);
            Action.click();
        }
        WebElement LogOut = dashBoardXpath.LogOut;
        Thread.sleep(5000);
        if (LogOut.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.LogOut);
            Thread.sleep(3000);
            System.out.println("***LogOut Button Click:*** " + LogOut.isDisplayed());
            WebElement Log_out_Pop_Up = dashBoardXpath.LogOut_Pop_up;
            if (Log_out_Pop_Up.isDisplayed()) {
                dashBoardXpath.clickOn(dashBoardXpath.LogOut_Pop_up);
                System.out.println("****Log_out_Pop_Up.isDisplayed:*** ");
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
        System.out.println("*****Click The Sing_In Button*****");
        Thread.sleep(15000);
        String title = driver.getTitle();
        if (title.equals("Simplify VMS 2.0")) {
            System.out.println("**** Login Successful******");
        }


    }

    @Then("In Pending Actions click on Resumes to Review. Alternatively, navigate to the job from the left navigation pane and click on the job you are working on. You should be able to see a tab named Submitted Candidates")
    public void in_pending_actions_click_on_resumes_to_review_alternatively_navigate_to_the_job_from_the_left_navigation_pane_and_click_on_the_job_you_are_working_on_you_should_be_able_to_see_a_tab_named_submitted_candidates() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Job);
        Thread.sleep(10000);
        System.out.println("*Job button click*");

    }

    @Then("This will bring up list of all submitted candidates. You can either review each one by clicking the Candidate's name")
    public void this_will_bring_up_list_of_all_submitted_candidates_you_can_either_review_each_one_by_clicking_the_candidate_s_name() throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Dashboard_Submission);
        System.out.println("dashBoardXpath.Dashboard_Submission");
        Thread.sleep(10000);
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "Project ID", 2).trim());
        dashBoardXpath.clickOn(dashBoardXpath.Dasboard_Search);
        Thread.sleep(10000);
    }

    @Then("Review the candidate details. Click on {string} to review Rejection reasons in module; for this exercise, click {string}")
    public void
    review_the_candidate_details_click_on_to_review_rejection_reasons_in_module_for_this_exercise_click(String string, String string2) throws InterruptedException {
        dashBoardXpath.clickOn(dashBoardXpath.Job_clk);
        Thread.sleep(8000);
        dashBoardXpath.clickOn(dashBoardXpath.Submitted_Candidate);
        Thread.sleep(8000);
        dashBoardXpath.clickOn(dashBoardXpath.Candidate_Click);
        Thread.sleep(8000);
        dashBoardXpath.clickOn(dashBoardXpath.Shortlist);
        Thread.sleep(5000);
        //------------------end--------------//

    }

    @Given("Login as the Vendor of the candidate Accept Interview")
    public void Login_as_the_Vendor_of_the_candidate() throws Exception {
        System.out.println("Logout MSP user------");
        WebElement vendor_User = dashBoardXpath.MSP_UserAccount;


        if (vendor_User.isDisplayed()) {
            dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.MSP_UserAccount);
            System.out.println(" MSP_UserAccount Account Click: " + vendor_User.isDisplayed());
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
            driver.navigate().refresh();
            Thread.sleep(5000);
        }
        System.out.println("Login Vendor User");

        dashBoardXpath.enterValue(dashBoardXpath.Username, reader.getCellData("SimplifyVMS", "UserName", 3));
        System.out.println("Enter HM User name: " + reader.getCellData("SimplifyVMS", "UserName", 3));
        Thread.sleep(4000);
        dashBoardXpath.enterValue(dashBoardXpath.Password, reader.getCellData("SimplifyVMS", "Password", 3));
        System.out.println("Enter Password: " + reader.getCellData("SimplifyVMS", "Password", 3));
        Thread.sleep(4000);
        dashBoardXpath.clickOn(dashBoardXpath.Sing_In);
        Thread.sleep(4000);
    }

    @Then("click the pending action")
    public void Login_as_the_Vendor_of_the_candidate_pending_action() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Pending_interview);
        System.out.println("Pending Interview");
        Thread.sleep(6000);

    }

    @Then("Select the candidate you were working on and click on the candidates name")
    public void Select_the_candidate_you_were_working_on_and_click_on_the_candidate_name() throws InterruptedException {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("scroll(0, 500)");
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Click_name);
        System.out.println("click name");
        Thread.sleep(3000);

    }

    @Then("Accept_button")
    public void Accept_button() throws InterruptedException {

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept);
        System.out.println("click Accept");
        Thread.sleep(3000);

        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.check_interview_date);
        System.out.println("check interview date");
        Thread.sleep(3000);

        WebElement phn_no = dashBoardXpath.phone_number;
        System.out.println("Enter phone number");
        phn_no.sendKeys(Keys.CONTROL + "a");
        phn_no.sendKeys(reader.getCellData("SimplifyVMS", "Phone Number", 2));
        System.out.println("phone number Accepted" + reader.getCellData("SimplifyVMS", "Phone Number", 2));
    }

    @Then("interview_and_select_Accept")
    public void interview_and_select_Accept() throws InterruptedException {
        dashBoardXpath.clickOnAfterElementIsVisible(dashBoardXpath.Accept_interview);
        System.out.println("Accept Interview complete");
    }


    /*Name - Nirmalya Sarkar
     * Date - 08.11.2021*/
    @Given("Login as MSP,Vendor using the credentials for the MSP,Vendor")
    public void login_as_msp_vendor_using_the_credentials_for_the_msp_vendor() throws Exception {
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

    @When("User Open menu on the left hand side of screen")
    public void user_open_menu_on_the_left_hand_side_of_screen() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Switch_menu);
        Thread.sleep(3000);
    }

    @When("User open Time and Expense")
    public void user_open_time_and_expense() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Time_and_Expense);
        Thread.sleep(3000);
    }

    @When("click View Timesheet")
    public void click_view_timesheet() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.View_Timesheets);
        Thread.sleep(3000);
    }

    @Then("User will landed on Timesheet List page")
    public void user_will_landed_on_timesheet_list_page() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("User Open a Timesheet that has been Pending for approval")
    public void user_open_a_timesheet_that_has_been_pending_for_approval() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Pending_Approval);
        Thread.sleep(3000);
        WebElement pendingID = dashBoardXpath.PendingID;
        String pendingid = pendingID.getText();
        System.out.println("Successfully found the draft timesheet id" + pendingID.getText());
        reader.setCellData("SimplifyVMS", "PendingTimesheetID", 2, pendingid);
    }

    @When("Can click one candidate")
    public void can_click_one_candidate() throws Exception {
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "PendingTimesheetID", 2));
        System.out.println(reader.getCellData("SimplifyVMS", "TimesheetID", 2));
        dashBoardXpath.clickOn(dashBoardXpath.search_button);
        Thread.sleep(3000);
    }

    @Then("User will landed on Candidate profile page")
    public void user_will_landed_on_candidate_profile_page() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.TimesheetList_WorkerName);
        Thread.sleep(3000);
//        dashBoardXpath.clickOn(dashBoardXpath.ModifyTimesheet_pendingExpenses);
//        Thread.sleep(3000);
    }

    @When("User can withdraw Timesheet by clicking withdraw button")
    public void user_can_withdraw_timesheet_by_clicking_withdraw_button() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.WithdrawTimesheet);
        Thread.sleep(3000);
    }

    @Then("Modify withdrawn page will come")
    public void modify_withdrawn_page_will_come() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Select_reason_for_withdraw);
        Thread.sleep(3000);
    }

    @Then("user will choose data in withdraw reason field with notes")
    public void user_will_choose_data_in_withdraw_reason_field_with_notes() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Reason_for_withdraw);
        Thread.sleep(3000);
    }

    @Then("click withdraw")
    public void click_withdraw() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Final_withdraw);
        Thread.sleep(3000);
    }

    @Then("particular Timesheet will be withdrawn")
    public void particular_timesheet_will_be_withdrawn() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    @When("user click on Approved Timesheet")
    public void user_click_on_approved_expenses() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Clickon_Approvetimesheet);
        Thread.sleep(3000);
        WebElement Time_Worker = dashBoardXpath.TimesheetList_WorkerName;
        if (Time_Worker.isDisplayed()) {
            dashBoardXpath.clickOn(Time_Worker);
            System.out.println(Time_Worker + "Successfully click on Worker Name");
            Thread.sleep(3000);
        }

    }

    @When("user click Modify Timesheet  at top right corner")
    public void user_click_modify_timesheet_at_top_right_corner() throws Exception {

        //driver.navigate().refresh();
        WebElement checkMod = dashBoardXpath.Check_Timesheet_Modify;
        if (checkMod.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.Timesheet_Modify);
            Thread.sleep(3000);
        }

    }

    @When("Modify Timesheet page will be open")
    public void modify_timesheet_page_will_be_open() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.SelectAfterModify_Timesheet);
        Thread.sleep(3000);
    }

    @Then("User can put data on Reason for modify fields with notes")
    public void user_can_put_data_on_reason_for_modify_fields_with_notes() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Clickon_HoursUpdate);
        Thread.sleep(3000);
    }

    @Then("Click Modify Button")
    public void click_modify_button() throws Exception {
        dashBoardXpath.clickOn(dashBoardXpath.Final_Modify);
        Thread.sleep(3000);
    }

    @Then("Click Save button  for the modification Timesheet")
    public void click_save_button_for_the_modification_timesheet() throws Exception {
        WebElement draftID = dashBoardXpath.DraftTimesheetID;
        String Draftid = draftID.getText();
        System.out.println("Successfully found the draft timesheet id" + draftID.getText());
        reader.setCellData("SimplifyVMS", "DraftTimesheetID", 2, Draftid);
        System.out.println(reader.setCellData("SimplifyVMS", "DraftTimesheetID", 2, Draftid));
        dashBoardXpath.clickOn(dashBoardXpath.Back_to_Timesheet);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.TimesheetList_WorkerName);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.Submit_timesheet);
        Thread.sleep(3000);

    }

    @Then("Log in as Hiring Manager to approve Modification")
    public void log_in_as_hiring_manager_to_approve_modification() throws Exception {
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
        dashBoardXpath.enterValue(dashBoardXpath.job_search, reader.getCellData("SimplifyVMS", "DraftTimesheetID", 2));
        dashBoardXpath.clickOn(dashBoardXpath.TimesheetList_WorkerName);
        Thread.sleep(3000);
        dashBoardXpath.clickOn(dashBoardXpath.ApproveDraftID_FromHM);
        Thread.sleep(3000);
        WebElement PopUpApproveTimesheet = dashBoardXpath.WantToApproveTimesheet;
        String TimesheetApprov = PopUpApproveTimesheet.getText();
        if (PopUpApproveTimesheet.isDisplayed()) {
            dashBoardXpath.clickOn(dashBoardXpath.ApprovTimeYes);
        }

    }
}
