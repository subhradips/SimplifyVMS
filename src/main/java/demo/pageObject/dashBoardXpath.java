package demo.pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class dashBoardXpath extends userHomePage {
    public dashBoardXpath(WebDriver driver) {
        this.driver = driver;
        this.actions = new Actions(driver);
        PageFactory.initElements(driver, this);
    }

    public static final String invoicePattern = "[A-Z]{1}[0-9]{5,}";
    public static final String giPattern = "[GI]{2}[0-9]{5,}";

    private static WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    public static WebElement Username;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public static WebElement Password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public static WebElement Sing_In;

    @FindBy(how = How.XPATH,using = "//div[contains(text(),'> My Dashboard')]")
    public WebElement Display_My_DashBoard;

    @FindBy(how = How.XPATH,using = "//i[@class='material-icons cursor-pointer']")
    public WebElement Settings;

    @FindBy(how = How.XPATH,using = "//button[contains(text(), ' Add New Widget ')]")
    public WebElement Add_New_Widget;
    @FindBy(how = How.XPATH,using = "//div[.='Add Job']")
    public WebElement Add_Job;
    @FindBy(how = How.XPATH,using = "//input[@placeholder='Enter Label']")
    public WebElement WIDGET_LABEL;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Update Widget')]")
    public WebElement Update_Widget;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'cancel')]")
    public WebElement close_pop_up;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'more_horiz')]")
    public WebElement dots_Click;
    @FindBy(how = How.XPATH,using = "//button[@id='reset-dashboard']")
    public WebElement reset;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Yes')]")
    public WebElement Pop_Up_reset;
    @FindBy(how = How.XPATH,using = "//div[@class='user-settings']//span[@class='text-capitalize']")
    public static WebElement MSP_UserAccount;
    @FindBy(how = How.XPATH,using = "//a[@href='/auth/user-account/account-settings']")
    public WebElement AccountSettings;
    @FindBy(how = How.XPATH,using = "//a[.='create']")
    public WebElement Upload_pic;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Crop & Save')]")
    public WebElement Crop_and_Save_Value;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Edit Profile')]")
    public WebElement EditProfile;
    @FindBy(how = How.XPATH,using = "//button[@type='button']")
    public WebElement SubmitButton;
    @FindBy(how = How.XPATH,using = "//div[@class='job-view-content-header']//button[@class='btn btn-success small mr-8']")
    public WebElement ShortList;
    @FindBy(how = How.XPATH,using = "//gridster-item[.='.a{opacity:0.963;}.b{fill:none;}Add Jobbuild_circledelete']")
    public WebElement DashBoard_Add_Job_value;
    @FindBy(how = How.XPATH,using = "//h4[contains(text(),'Active Jobs')]")
    public WebElement Dashboard_Active_job;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-dashboard[1]/div[1]/div[1]/app-dashboard-grid[1]/gridster[1]/gridster-item[6]")
    public WebElement DashBoard_Head_Count;
    @FindBy(how = How.XPATH,using = "//gridster-item[.='.a{fill:none;}Contact Supportbuild_circledelete']")
    public WebElement DashBoard_Contact_Support;
    @FindBy(how = How.XPATH,using = "//h4[.='Contact Support']")
    public List<WebElement> pending_action;
    @FindBy(how = How.XPATH,using = "//button[contains(.,'Actions')]")
    public WebElement Action;
    @FindBy(how = How.XPATH,using ="//a[contains(.,'Approve')]")
    public WebElement Approve;
    @FindBy(how = How.XPATH,using ="//span[@class='ml-16 pending-approval status-ui']")
    public WebElement PendingApproval_massage;
    @FindBy(how = How.XPATH,using ="//li[.='work_outlineJobwork_outlineJob']")
    public WebElement Dashboard_Briefacse;
    @FindBy(how = How.XPATH,using ="//button[contains(.,'check_circle Distribute')]")
    public WebElement MSP_Distribute;
    @FindBy(how = How.XPATH,using ="//button[contains(.,'check_circle Distribute')]")
    public WebElement MSP_Distribute1;
    @FindBy(how = How.XPATH,using ="//a[contains(.,'chevron_left Back to Jobs')]")
    public WebElement Back_to_Jobs;
    @FindBy(how = How.XPATH,using ="//a[contains(.,'add Create Job')]")
    public WebElement Dashboard_Addjob;
    @FindBy(how = How.LINK_TEXT,using ="Software Engineer")
    public WebElement Software_Engineer;
    @FindBy(how = How.XPATH,using ="//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/ng-select[1]/div[1]/span[1]")
    public WebElement Job_Manager;
    @FindBy(how = How.XPATH,using ="//span[contains(.,'HM User')]")
    public WebElement HM_Name_Select;
    @FindBy(how = How.XPATH,using ="//p[contains(text(),'This is job description')]")
    public WebElement Job_Description;
    @FindBy(how = How.XPATH,using ="//span[@class='toggle-switch toggle-off']")
    public WebElement toggle_to_set;

    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-dashboard[1]/div[1]/div[1]/app-dashboard-grid[1]/gridster[1]/gridster-item[4]/app-parent-dynamic[1]/app-pending-actions-widget[1]/div[1]/div[1]/div[2]/div[3]/a[1]/p[1]")
    public static WebElement pending_offers;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-offers[1]/div[1]/div[1]/div[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/vms-row[2]/td[1]/span[1]")
    public static WebElement click_released;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-offers[1]/div[1]/div[1]/div[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/vms-row[1]/td[1]/p[1]/a[1]")
    public static WebElement offer_candidate_name;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'more_horiz')]")
    public static WebElement offer_candidate_status_check;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-offers[1]/nav[1]/ul[1]/li[1]/a[1]")
    public static WebElement offer_candidate_accept;
    @FindBy(how = How.XPATH,using = "//textarea[@placeholder='Enter Additional Notes']")
    public static WebElement offer_acceptance_reason;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary float-right']")
    public static WebElement Accept_offer;

    //Testcase 7
    @FindBy(how = How.XPATH, using = "//input[@id='start_date']")
    public WebElement Start_Date;
    @FindBy(how = How.XPATH, using = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/svms-datepicker[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[2]")
    public WebElement Select_Start_Date;
    @FindBy(how = How.XPATH, using = "//input[@id='end_date']")
    public WebElement End_Date;
    @FindBy (how = How.XPATH, using = "//div[.='29']")
    public WebElement Select_End_Date;
    @FindBy (how = How.XPATH, using = "//input[@placeholder='Number of positions']")
    public WebElement position;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/div[2]/input[1]")
    public WebElement Expense_Allowed;
    @FindBy(how =  How.XPATH, using = "//input[@placeholder='Enter Minimum bill rate']")
    public WebElement Min;
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Enter Maximum bill rate']")
    public  WebElement Max;
    @FindBy(how = How.XPATH, using = "//input[@value='true']")
    public WebElement overtime;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'View Detailed Estimate')]")
    public WebElement view_Estimate;
    @FindBy(how = How.XPATH, using = "//button[@class='btn btn-primary border-0']")
    public WebElement update;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[4]/button[2]")
    public WebElement Continue;

    @FindBy(how = How.XPATH,using ="//button[@class='btn btn-success small mr-12']")
    public WebElement approve_request;

    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-approval[1]/app-job-details[1]/div[1]/section[1]/div[1]/app-approval-notes-history[1]/svms-sidebar[1]/div[1]/div[2]/svms-sidebar-footer[1]/div[1]/div[1]/button[1]")
    public WebElement approve_request1;
    /*
     * Nirmalya Sarkar
     * Date - 27.10.2021
     * */
//    //click on dropdown button
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[1]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
//    public WebElement Select_GL_Location;
//    //select 1st value
//    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Contract Labor - 41345')]")
//    public WebElement First_Location;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
//    public WebElement select_Legal_Entity;
//    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Consulting Services - 62616')]")
//    public WebElement First_Legal_Entity;
    @FindBy(how = How.XPATH, using = "//app-foundational-fields[1]//div[2]//span[@class='ng-arrow-wrapper']")
    public WebElement Select_GL_Location;
    @FindBy(how = How.XPATH, using = "//span[2][contains(text(),'Contract Labor - 41345')]")
    public WebElement First_Location;
    @FindBy(how = How.XPATH, using = "//app-foundational-fields[1]//div[3]//span[@class='ng-arrow-wrapper']")
    public WebElement select_Legal_Entity;
    @FindBy(how = How.XPATH, using = "//div[3]//span[2][contains(text(),'Consulting Services - 62616')]")
    public WebElement First_Legal_Entity;
    @FindBy(how = How.XPATH,using = "//app-foundational-fields[1]//div[4]//span[@class='ng-arrow-wrapper']")
    public WebElement select_Service_Department;
    //@FindBy(how = How.XPATH, using = "//span[contains(text(),'1606 - 1606')]")
    @FindBy(how = How.XPATH, using = "//div[2]//span[contains(text(),'1603 - 1603')]")
    public WebElement First_Service_Department;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[4]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
//    public WebElement select_Dept_No;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[4]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
//    public WebElement First_Dept_No;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[5]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
//    public WebElement select_Intra;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[5]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
//    public WebElement First_Intra;
    @FindBy(how = How.XPATH, using = "//app-foundational-fields[1]//div[7]//span[@class='ng-arrow-wrapper']")
    public WebElement select_Cost;
    @FindBy(how = How.XPATH, using = "//div[2]//span[contains(text(),'Cub Foods - RESD Office Services - 59126')]")
    public WebElement First_Cost;
    @FindBy(how = How.XPATH, using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-create-job/form/div/div/div/div[2]/div/app-foundational-fields/div/div[8]/div/div/ng-select/div/span")
    public WebElement select_Business_Unit;
    @FindBy(how = How.XPATH, using = "//div[3]//span[contains(.,'Marble Brands - Marble Brands')]")
    public WebElement First_Business;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[8]/div[1]/div[1]/ng-select[1]/div[1]/span[2]")
    public WebElement select_GL_Account;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[8]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[3]/span[1]")
    public WebElement First_GL_Account;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
    public WebElement Create_Job;

    @FindBy(how = How.XPATH,using = "//div[contains(text(),' Aerotek Inc. ')]")
    public WebElement Vendor_name;

    @FindBy(how = How.XPATH,using = "//a[contains(.,'tVtest VendorVENDOR')]")
    public WebElement Vendor_sidepanel;
    @FindBy(how = How.XPATH,using = "//div[@class='qualification']/div[3]//button[@class='btn small btn-outine rounded-circle btn-add-item']")
    public WebElement Education_Button;
    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-main/div/div[1]/app-candidates/app-create-candidate/div[2]/app-add-education/svms-sidebar-ng/div[1]/div[2]/form/div/div[1]/ng-select/div/span")
    public WebElement Selectdrp_Education;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),\"Master's Degree\")]")
    public WebElement Subject_Name;
    @FindBy(how = How.XPATH,using = "//app-add-education[1]//button[@class='btn btn-primary float-right']")
    public WebElement Education_SubmitButton;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-candidates[1]/app-create-candidate[1]/div[1]/div[1]/div[1]/div[2]/div[1]/form[1]/section[1]/div[1]/div[1]/div[4]/div[1]/div[3]/div[1]/button[1]/icon[1]")
    public WebElement default_Close_educationTab;
    @FindBy(how = How.XPATH,using = "//app-add-education[1]//button[@class='btn btn-primary float-right']")
    public WebElement default_Close_educationTab_popup;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'keyboard_arrow_down')]")
    public WebElement Qualification_drpdwn;
    @FindBy(how = How.XPATH,using = "//label[.='Education']")
    public WebElement education_tab;
// 05/11/2021

// Anup Ghosh

// Testcase 21(Enter Expense by Worker )

    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[2]")
    public static WebElement Time_Expense;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[4]/div[2]/perfect-scrollbar[1]/div[1]/div[1]/ul[2]/li[2]/a[1]")
    public static WebElement View_general_expense;
    @FindBy(how = How.XPATH,using = "//i[contains(.,'add')]")
    public static WebElement click_add_general_expense;
    @FindBy(how = How.XPATH,using = "//*[@id='svmsSidebar']/svms-sidebar-body-ng/div/form/div[1]/div/ng-select/div/div/div[2]/input")
    public static WebElement select_worker;
    //@FindBy(how = How.XPATH,using = "//svms-sidebar-body-ng/div[1]/form[1]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
    @FindBy(how = How.XPATH,using = "//svms-sidebar-body-ng/div[1]/form[1]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
    public static WebElement select_name_of_worker;
    @FindBy(how = How.XPATH,using = "//button[contains(.,'Continue')]")
    public static WebElement continue_expense;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary small']")
    public static WebElement Add_general_expense;
    //@FindBy(how = How.XPATH,using = "//input[@formcontrolname='expense_type']")
    @FindBy(how = How.XPATH,using = "//*[@id='expense_type']")
    public static WebElement expense_category;
    @FindBy(how = How.XPATH,using = "//input[@class='datepicker-- form-control pl-32 text-truncate']")
    public static WebElement Date_Incurred;
    @FindBy(how = How.XPATH,using = "//*[@id='expense_date']/div[2]/div[1]/div[2]/div/div[1]/div/div/div/div[2]/div[26]")
    public static WebElement start_date_incurred;
    @FindBy(how = How.XPATH,using = "//*[@id='expense_date']/div[2]/div[1]/div[2]/div/div[2]/div/div/div/div[2]/div[13]")
    public static WebElement end_date_incurred;
    @FindBy(how = How.XPATH,using = "//button[@class='btn small btn-primary datepicker-apply-btn']")
    public static WebElement apply_date;
    @FindBy(how = How.XPATH,using = "//*[@id='expense_item_id']/div/div/div[2]/input")
    public static WebElement select_expense_type;
    @FindBy(how = How.XPATH,using = "//svms-sidebar-body-ng/div[1]/form[1]/div[2]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
    public static WebElement name_of_expense_type;
    @FindBy(how = How.XPATH,using = "//input[@name='totalamount']")
    public static WebElement toal_amount;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary ml-16']")
    public static WebElement submit_general_expense;
    @FindBy(how = How.XPATH,using ="//button[contains(.,'Submit Candidate')]")
    public WebElement Submit_and_Candidate;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary float-right']")
    public static WebElement final_submit_general_expense;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary float-right']")
    public WebElement confirm_general_expense;
    @FindBy(how = How.XPATH,using = "//h4[contains(.,'Are you sure you want to submit?')]")
    public static WebElement confirm_message;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary large']")
    public static WebElement submit_expense;





    // Debendra
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[1]/div[1]/ul[1]/li[4]/a[2]")
    public static WebElement Assignment_click;

    @FindBy(how = How.XPATH,using = "//a[@href='/assignment/all-list']")
    public static WebElement views_Assignment;

    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-assignment[1]/app-all-assignments[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/vms-row[1]/td[1]/p[1]/a[1]")
    public static WebElement views_Assignment_click_contact;

    @FindBy(how = How.XPATH,using = "//*[contains(text(), ' Actions ')]")
    public static WebElement views_Assignment_click_action;

    @FindBy(how = How.XPATH,using = "//*[contains(text(), ' Update Assignment ')]")
    public static WebElement Update_Assignment_click;

    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-assignment[1]/app-assignment-create[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[5]/app-foundational-fields[1]/div[1]/div[7]/div[1]/div[1]/ng-select[1]/div[1]/div[1]/div[3]/input[1]")
    public static WebElement Assignment_change_cost;

    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-main/div/div[1]/app-assignment/app-assignment-create/form/div/div/div/div/div/div[2]/div[5]/app-foundational-fields/div/div[7]/div/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")

    public static WebElement Assignment_change_cost_save;



    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary']")
    public static WebElement Assignment_Continue;

    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-assignment/app-assignment-create/form/div/div/div/div/div/div[3]/div[12]/div[1]/div/svms-datepicker/div[1]/input")
    public static WebElement Assignment_Continue_after_effectivedate;


    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-assignment/app-assignment-create/form/div/div/div/div/div/div[3]/div[12]/div[1]/div/svms-datepicker/div[2]/div/div/div/div/div/div/div/div[2]/div[11]")
    public static WebElement Assignment_Continue_after_effectivedate_select_current;


    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-assignment/app-assignment-create/form/div/div/div/div/div/div[3]/div[12]/div[2]/div/ng-select/div/div/div[2]/input")
    public static WebElement Assignment_Continue_after_reason_update;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Financial change')]")
    public static WebElement Assignment_Continue_after_reason_update_save;

    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Save Assignment')]")

    public static WebElement Assignment_Continue_after_save;

//Test Case 28

    @FindBy(how = How.XPATH,using = "//*[@id='sidebar']/div/ul/li[6]/a[2]")
    public static WebElement Time_Expense_msp;

    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/app-sidebar/div/div[4]/div[2]/perfect-scrollbar/div/div[1]/ul[2]/li[2]/a")
    public static WebElement View_general_expense_msp;

    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Pending Expenses')]")
    public static WebElement View_general_expense_msp_pending;


    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div[1]/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public static WebElement pending_approval_msp_user_click;

    @FindBy(how = How.XPATH,using = "//*[contains(text(),'Withdraw')]")
    public static WebElement pending_approval_msp_user_withdraw;

    @FindBy(how = How.XPATH,using = "//*[@id='svmsSidebar']/form/svms-sidebar-body-ng/div/div/div[1]/div/ng-select/div/div/div[2]/input")
    public static WebElement pending_approval_msp_user_withdraw_expense;

    @FindBy(how = How.XPATH,using = "/html/body/app-root/app-main/div/div[1]/app-expense/app-expense-detail/section/div/app-expense-header/app-withdraw-expense/svms-sidebar-ng/div[1]/form/svms-sidebar-body-ng/div/div/div[1]/div/ng-select/ng-dropdown-panel/div/div[2]/div[1]/span")
    public static WebElement pending_approval_msp_user_withdraw_Reason;

    @FindBy(how = How.XPATH,using = "//*[@placeholder='Enter Notes']")
    public static WebElement pending_approval_msp_user_withdraw_Reason_note;

    @FindBy(how = How.XPATH,using = "//button[@type='submit']")
    public static WebElement pending_approval_msp_user_withdraw_submit;


    //hm user

    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[1]/div[1]/ul[1]/li[6]/a[2]")
    public static WebElement hm_user_time_expense;

    @FindBy(how = How.XPATH,using = "//*[contains(text(),' View General Expenses ')]")
    public static WebElement hm_user_view_general_ecpenses;

    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Pending Expenses')]")
    public static WebElement View_general_expense_hm_pending;

    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div[1]/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public static WebElement pending_approval_hm_user_click;

    @FindBy(how = How.XPATH,using = "//*[contains(text(),' Approve ')]")
    public static WebElement pending_approval_hm_user_approve;



    /*
    * End of 27.10.2021
    * Name - Nirmalya Sarkar
    * */
    @FindBy(how = How.XPATH,using ="//a[contains(.,'login Logout')]")
    public static WebElement LogOut;
    @FindBy(how = How.XPATH,using ="//button[contains(text(),'Yes')]")
    public static WebElement LogOut_Pop_up;
    @FindBy(how = How.XPATH,using ="//p[.='Jobs Pending Approval']")
    public WebElement Pending;
    @FindBy(how = How.XPATH,using ="//li[@class='position-relative']//div[@class='position-relative search-head']//input[@type='text']")
    public static WebElement job_search;
    @FindBy(how = How.XPATH,using ="//*[@id='smarttable']/div/vms-header/div[1]/div/div[2]/ul/li[5]/div/input")
    public static WebElement search_button;
    @FindBy(how = How.LINK_TEXT,using ="Software Engineer")
    public WebElement Value_Click;
    @FindBy(how = How.XPATH,using ="//div[@class='mb-12']")
    public WebElement Approval_Details;
    @FindBy(how = How.XPATH,using ="//a[contains(.,'view_stream View All Jobs')]")
    public WebElement view_all_jobs;
    @FindBy(how = How.XPATH,using ="//a[contains(text(),'Distribute')]")
    public WebElement Distribute;
    @FindBy(how = How.XPATH,using ="//input[@placeholder='Search for Distribution Recipients']")
    public WebElement Search_vendors;

    /*Name - Nirmalya Sarkar
    * Date - 28.10.2021
    * Create and submit candidate as vendor
    * */
    @FindBy(how = How.XPATH,using ="//li[.='work_outlineJobwork_outlineJob']")
    public WebElement Dashboard_Briefacse1;
    @FindBy(how = How.XPATH, using = "//a[contains(.,'view_stream View All Jobs')]")
    public WebElement view_all_jobs1;
    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Active Jobs')]")
    public  WebElement Vendor_Active_Jobs;

    @FindBy(how = How.XPATH, using = "//b[contains(text(),'712450-SHOP RITE 130')]")
    public List<WebElement>  Customer_Dropdown_Value;

    @FindBy(how = How.XPATH,using = "//p[contains(text(),'Pending Interviews')]")
    public static WebElement Pending_interview;
    // @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-interviews[1]/div[1]/div[1]/div[2]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/vms-row[1]/td[1]/p[1]/a[1]")
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public static WebElement Click_name;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Accept')]")
    public static WebElement Accept;
    // @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/app-candidate-job-view-interview-details[1]/app-accept-interview-sidepanel[1]/svms-sidebar-ng[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/span[1]")
    @FindBy(how = How.XPATH,using = "//*[@id='svmsSidebar']/div[2]/div/div[1]/div/label/span")
    public static WebElement check_interview_date;
    @FindBy(how = How.XPATH,using = "//input[@placeholder='Enter Primary Phone Number']")
    public static WebElement phone_number;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-success float-right']")
    public static WebElement Accept_interview;
    @FindBy(how = How.XPATH,using ="//*[@id='smarttable']/div/vms-header/div[1]/div/div[2]/ul/li[5]/div/table-icon")
    public static WebElement Dasboard_Search;
    @FindBy(how = How.LINK_TEXT,using ="Software Engineer" )
    public static WebElement Job_clk;
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/vms-header/div[1]/div/div[2]/ul/li[4]/div/input")
    public WebElement Dashboard_SearchBy_Job_id;
    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Add & Submit Candidate')]")
    public  WebElement click_Add_And_Submit_Candidate;
    @FindBy(how = How.XPATH,using ="//div[@class='drop-zone']//icon[@type='material']")
    public  WebElement click_On_ResumeButton;
    @FindBy(how = How.XPATH,using ="//p[contains(.,'Resumes To Review')]")
    public  WebElement resume_to_review;

    @FindBy(how = How.XPATH, using = "//div[@class='confirmation-dialog position-fixed bg-light rounded-sm pt-32 overflow-hidden active']//h4[@class='mt-8 pl-16 pr-16']")
    public WebElement Check_AutoFill_Candidate;
    @FindBy(how = How.XPATH,using ="//div[@class='modal-footer text-center d-flex justify-content-center']//button[@class='btn btn-primary large']")
    public  WebElement click_On_ResumeYes;
    @FindBy(how = How.XPATH,using = "//*[@id='date1']/div[2]/div/div/div/div/div/div/div/div[2]/div[9]")
    public WebElement Select_AddCandidate_MM_DD;
    @FindBy(how = How.XPATH,using = "//input[@placeholder='MM/DD']")
    public WebElement Select_AddCandidate_MM_DD1;
    @FindBy(how = How.XPATH,using ="//*[@id='pagecontainer']/div[1]/app-candidates/app-create-candidate/div[1]/div/div/div[2]/div/form/section/div/div/div[2]/div/div[2]/div[2]/ng-select/div/span")
    public WebElement SelectCountry;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'India')]")
    public WebElement Click_on_ContryName;
    @FindBy(how = How.XPATH,using ="//input[@placeholder='Enter State ID']")
    public WebElement Select_stateID;
    @FindBy(how = How.XPATH,using ="//input[@placeholder='Enter Primary Email Address']")
    public WebElement Select_AddCandidate_email;
    @FindBy(how = How.XPATH,using ="//button[contains(text(),'Create Candidate')]")
    public WebElement Click_on_createCandidate;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-candidates/app-submit-candidate/div/div[1]/div/div[2]/form/div/div[1]/div[1]/svms-datepicker/div[1]/input")
    public WebElement Select_Candidate_Start_date;
    @FindBy(how = How.XPATH,using = "//div[.='2']")
    public WebElement Add_Startdate;
    @FindBy(how = How.XPATH,using = "//svms-datepicker[@class='ng-untouched ng-pristine ng-valid']//img[@id='datepicker']")
    public WebElement Select_Candidate_End_date;
    @FindBy(how =How.XPATH,using = "//div[.='29']")
    public WebElement Add_Enddate;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-candidates/app-submit-candidate/div/div[1]/div/div[2]/form/div/div[5]/div[2]/div/div[1]/div/div/input")
    public WebElement Select_candidatePayRate;
    @FindBy(how = How.XPATH,using = "//input[@name='uniqueid']")
    public WebElement Unique_ID;
//    @FindBy(how = How.XPATH,using = "[name='uniqueid']")
//    public WebElement Unique_ID;
//    @FindBy(how = How.XPATH,using = "//label[contains(.,'Unique ID ')]//input[@formcontrolname='unique_id']")
//    public WebElement unique_id;
    @FindBy(how = How.XPATH,using = "//vms-row[@class='not-scrollable has-border']/td[@class='position-relative if-submitted-candidate pl-24']")
    public WebElement Candidate_Name;

    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/job-details/app-job-details/div/section/div/nav/ul/li[2]/a")
    public WebElement Clickon_availableCandidate;
    /*
    * Start Scenario : Enter Time By Worker
    * Name - Nirmalya Sarkar*/

    @FindBy(how = How.XPATH,using = "//div[@id='sidebar']/a[@href='javascript:void(0)']")
    public static WebElement Switch_menu;
    @FindBy(how = How.XPATH,using ="//li[6]/a[2]/label[@class='m-0']")
    public static WebElement Time_and_Expense;
    @FindBy(how = How.XPATH,using ="//a[contains(.,'pending_actions View Timesheets')]")
    public static WebElement View_Timesheets;
    @FindBy(how = How.XPATH,using ="//i[contains(text(),'add')]")
    public WebElement Create_Timesheet;
    @FindBy(how = How.XPATH,using = "/html[1]/body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-timesheet-list[1]/app-enter-timesheet[1]/svms-sidebar[1]/div[1]/svms-sidebar-body[1]/div[1]/div[1]/div[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
    public WebElement Select_Worker_field;
    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Jake vic')]")
    public WebElement Select_Worker_Name;
    @FindBy(how = How.XPATH,using = "//button[.='Continue chevron_right']")
    public WebElement AfterWorkerName_ClickContinue;
    @FindBy(how = How.XPATH,using = "//div[@class='ng-input']/input[1]")
    public WebElement Select_project;
    @FindBy(how = How.XPATH,using ="//div[@class='ng-option ng-option-marked']/span[@class='ng-option-label']")
    public WebElement Select_project_value;
    @FindBy(how = How.XPATH,using ="//*[@id='pagecontainer']/div[1]/app-timesheet/app-hourly-timesheet-automatic-entry/div/div/section/div/div[2]/div[2]/div[3]/div[3]/input")
    public WebElement Select_Monday;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-timesheet/app-hourly-timesheet-automatic-entry/div/div/section/div/div[2]/div[2]/div[4]/div[3]/input")
    public WebElement Select_Tuesday;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-timesheet/app-hourly-timesheet-automatic-entry/div/div/section/div/div[2]/div[2]/div[5]/div[3]/input")
    public WebElement Select_Wednesday;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-timesheet/app-hourly-timesheet-automatic-entry/div/div/section/div/div[2]/div[2]/div[6]/div[3]/input")
    public WebElement Select_Thursday;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-timesheet/app-hourly-timesheet-automatic-entry/div/div/section/div/div[2]/div[2]/div[7]/div[3]/input")
    public WebElement Select_Friday;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-timesheet/app-hourly-timesheet-automatic-entry/div/div/section/div/div[2]/div[2]/div[8]/div[3]")
    public WebElement Clickon_Saturday;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Submit Timesheet')]")
    public static WebElement Submit_timesheet;
    @FindBy(how = How.XPATH,using = "//div[@class='success-modal-body text-center pb-32']/h4[contains(text(),' Are you sure you want to submit the timesheet? ')]")
    public WebElement Are_you_sure_submit_timesheet;
    @FindBy(how = How.XPATH,using ="//div//button[@class='btn btn-primary large']")
    public WebElement clickon_yes_submit_timesheet;
    /*End Scenario : Enter Time By Worker*/

    /*Scenario - Scenario: Approve Timesheet
    Name - Anup Ghosh*/

    @FindBy(how = How.XPATH,using = "//p[contains(.,'Timesheet(s) Pending Approval')]")
    public WebElement Timesheets_pending_approval;
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div[1]/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/td/div/label/div")
    public WebElement checkmark_timesheet;
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div[1]/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public WebElement Worker_name;
    @FindBy(how = How.XPATH,using = "//button[@class='float-right btn btn-primary green mr-8']")
    public WebElement Approve_Timesheet;
    @FindBy(how = How.XPATH,using = "//h4[contains(.,'Are you sure you want to approve the timesheet?')]")
    public WebElement confirmation_message_for_approve_timesheet;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary large']")
    public WebElement click_ok;
    /*Scenario : Approve Timesheet End*/

    /*Name - Arijit Chowdhury
    * Scenario - Shortlist candidate/s as Program MSP user*/

    @FindBy(how = How.PARTIAL_LINK_TEXT,using = "Submitted Candidat")
    public static WebElement Submitted_Candidate;
    @FindBy(how = How.PARTIAL_LINK_TEXT,using ="CHRISTOPHER MORG")
    public static WebElement Candidate_Click;
    @FindBy(how = How.XPATH,using =" //button[contains(text(),'Schedule Interview')]")
    public  WebElement Schedule_interview;
    @FindBy(how = How.XPATH,using ="//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/candidate-job-view-interview-create[1]/form[1]/div[1]/div[1]/div[2]/div[1]/ng-select[1]/div[1]/span[1]")
    public WebElement Interviewer;
    @FindBy(how = How.XPATH,using ="//span[contains(.,'Ramesh Khanna')]")
    public WebElement Select_Interview;
    @FindBy(how = How.XPATH,using ="//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/candidate-job-view-interview-create[1]/form[1]/div[1]/div[1]/div[3]/div[1]/ng-select[1]/div[1]/span[1]")
    public WebElement Interview_Type;
    @FindBy(how = How.XPATH,using ="//span[contains(.,'In Person')]")
    public WebElement Select_int_Type;
    @FindBy(how = How.XPATH,using = "//input[@id='addressField']")
    public WebElement Interview_Location;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/candidate-job-view-interview-create[1]/form[1]/div[1]/div[1]/div[4]/div[1]/ng-select[1]/div[1]/span[1]")
    public WebElement Timezone;
    //    @FindBy(how = How.XPATH,using = "//div[@id='ab2cda6e55f5-0']")
    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Hawaii-Aleutian Standard Time (HAST) (UTC-10)')]")
    public WebElement Select_Timezon;
    @FindBy(how = How.XPATH,using = "//div//span[2][contains(.,'Eastern Standard Time (North America) (EST) (UTC-05)')]")
    public WebElement Duration;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-candidate-job-view/div/section/div/div[1]/app-candidate-job-view-content/div/div/app-candidate-job-view-interviews/candidate-job-view-interview-create/form/div[1]/div/div[4]/div[2]/ng-select/div/span")
    public WebElement Interview_Duration;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'60 Minutes')]")
    public WebElement Select_Duration;
    @FindBy(how = How.XPATH,using = "//input[@id='']")
    public WebElement Choose_Date;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'24')]")
    public WebElement Select_Date;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/candidate-job-view-interview-create[1]/form[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[2]/ng-select[1]/div[1]/span[1]")
    public WebElement Time_Slot;
    @FindBy(how = How.XPATH,using = "//div[2]//div[contains(*,'10:00 AM-11:00 AM')]")
    public WebElement Select_Time_Slot;
    @FindBy (how = How.XPATH,using = "//button[contains(text(),'Schedule')]")
    public WebElement schedule;

    @FindBy(how =How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[2]")
    public static WebElement click_job;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[4]/div[2]/perfect-scrollbar[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")
    public static WebElement click_submission;
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public static WebElement submitted_candidate_Name;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'more_horiz')]")
    public static WebElement offer_button;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Create Offer')]")
    public static WebElement create_offer;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-offers[1]/div[1]/div[1]/div[1]/app-no-data[1]/div[1]/div[1]/button[1]")
    public static WebElement final_Create_offer;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-candidate-job-view/div/section/div/div[1]/app-candidate-job-view-content/div/div/app-candidate-job-view-offers/app-create-offers/form/div[1]/div[5]/div/ng-select")
    public static WebElement Timesheet;
    //@FindBy(how = How.XPATH,using = "//span[contains(.,'Hours')]")
    @FindBy(how = How.XPATH,using = "//div[@class='ng-dropdown-panel-items scroll-host']//span[contains(text(),'Hours')]")
    public static WebElement choose_timesheet;
    //@FindBy(how = How.XPATH,using = "//div[contains(text(),'Select Assignment')]")
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-candidate-job-view/div/section/div/div[1]/app-candidate-job-view-content/div/div/app-candidate-job-view-offers/app-create-offers/form/div[1]/div[8]/div/ng-select")
    public static WebElement Assignment_active_upon;
//    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Offer Acceptance')]")
//    public WebElement Choose_assignment;

    @FindBy(how = How.XPATH,using = "//span[@class='ng-option-label']")
    public static WebElement Choose_assignment;

    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='candidatePayRate']")
    public static WebElement candidate_pay_rate;
    @FindBy(how = How.XPATH,using = "//button[contains(.,'Release Offer')]")
    public static WebElement Release_offer;

    @FindBy(how = How.XPATH,using ="//li[.='work_outlineJobwork_outlineJob']")
    public static WebElement Dashboard_Job;

    @FindBy(how = How.XPATH,using ="//ul[@class='submenu mt-0 mr-24 mb-0 ml-24 p-0']//li//a[contains(.,'View All Jobs')]")
    public static WebElement Dashboard_Submission;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Shortlist')]")
    public static WebElement Shortlist;

    @FindBy(how = How.XPATH,using ="//span[.='Pending Approval']")
    public static WebElement Pending_Approval;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-timesheet-list[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/vms-row[3]/td[1]/span[1]/span[1]")
    public static WebElement PendingID;

    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div[1]/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr/vms-row[1]/td/p/a")
    public static WebElement TimesheetList_WorkerName;

    @FindBy(how = How.XPATH,using = "//div[@class='float-right breadcrumb-right mt-8']//button[.='Withdraw Timesheet']")
    public static WebElement WithdrawTimesheet;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-hourly-timesheet-automatic-entry[1]/div[1]/app-timesheet-action-flyout[1]/svms-sidebar[1]/div[1]/svms-sidebar-body[1]/div[1]/div[1]/div[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
    public static WebElement Select_reason_for_withdraw;

    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Submitted for wrong work duration')]")
    public static WebElement Reason_for_withdraw;

    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-hourly-timesheet-automatic-entry[1]/div[1]/app-timesheet-action-flyout[1]/svms-sidebar[1]/div[1]/svms-sidebar-footer[1]/div[1]/button[2]")
    public static WebElement Final_withdraw;

    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Approved')]")
    public static WebElement Clickon_Approvetimesheet;
    @FindBy(how = How.XPATH,using = "//div[@class='p-24']")
    public static WebElement Check_Timesheet_Modify;

    @FindBy(how = How.XPATH,using = "//div[@class='p-24']/div[@class='float-right breadcrumb-right mt-8']")
    public static WebElement Timesheet_Modify;

    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-hourly-timesheet-automatic-entry[1]/div[1]/app-timesheet-action-flyout[1]/svms-sidebar[1]/div[1]/svms-sidebar-body[1]/div[1]/div[1]/div[1]/ng-select[1]/div[1]/div[1]/div[2]/input[1]")
    public static WebElement SelectAfterModify_Timesheet;

    @FindBy(how = How.XPATH,using = "//div[@class='ng-dropdown-panel-items scroll-host']//div[@class='ng-option']/span[contains(.,'Hours Update')]")
    public static WebElement Clickon_HoursUpdate;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-hourly-timesheet-automatic-entry[1]/div[1]/app-timesheet-action-flyout[1]/svms-sidebar[1]/div[1]/svms-sidebar-footer[1]/div[1]/button[2]")
    public static WebElement Final_Modify;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-timesheet-list[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/vms-row[3]/td[1]/span[1]/span[1]")
    public static WebElement DraftTimesheetID;

    @FindBy(how = How.PARTIAL_LINK_TEXT,using = "Back to Timeshee")
    public static WebElement Back_to_Timesheet;

    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-timesheet[1]/app-hourly-timesheet-automatic-entry[1]/div[1]/div[1]/section[1]/div[1]/div[1]/app-timesheet-breadcrumb[1]/div[1]/div[2]/button[1]")
    public static WebElement ApproveDraftID_FromHM;
    @FindBy(how = How.XPATH,using ="//h4[text()=' Are you sure you want to approve the timesheet? ']")
    public static WebElement WantToApproveTimesheet;
    @FindBy(how = How.XPATH,using ="//button[contains(text(),'Yes')]")
    public static WebElement ApprovTimeYes;

    public static void enterValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public static void clickOn(WebElement submitButton) throws InterruptedException {
        submitButton.click();
        Thread.sleep(2000);
    }

    public void checkElementVisibility(WebElement element, long timeinMillisecond) {
        driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS) ;
    }

    public void iterateWebElementListAndSelectValue(List<WebElement> webElementList, String elementValue) {
        for (int i = 0; i <= webElementList.size() - 1; i++) {
            if (webElementList.get(i).getText().contains(elementValue)) {
                webElementList.get(i).click();
                break;
            }
        }
    }

    public static void clickOnAfterElementIsVisible(WebElement element) {
        driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS) ;
        element.click();
    }

    public void moveToElementAndCLikOn(WebElement paymentMode) {
        actions.moveToElement(paymentMode).click().perform();
    }

    public static BigDecimal getExpectedItemGrossAmount(String unitCount, String quantity) {
        BigDecimal uc = new BigDecimal(unitCount);
        BigDecimal quant = new BigDecimal(quantity);
        return uc.multiply(quant);
    }

    public static String findStringUsingRegex(String input, String regex) {
        final Pattern pattern = Pattern.compile(regex, Pattern.MULTILINE);
        final Matcher matcher = pattern.matcher(input);
        String output = new String();
        while (matcher.find()) {
            output = output.concat(matcher.group(0));
        }
        return output;
    }
    public static String getStatusText(WebElement element) {
        System.out.println("element: " + element);
        String  statusText=element.getText();
        return statusText;
    }



}
