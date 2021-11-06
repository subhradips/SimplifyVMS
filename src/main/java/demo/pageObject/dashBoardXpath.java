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

    private WebDriver driver;

    @FindBy(how = How.XPATH, using = "//input[@name='email']")
    public WebElement Username;

    @FindBy(how = How.XPATH, using = "//input[@name='password']")
    public WebElement Password;

    @FindBy(how = How.XPATH, using = "//button[@type='submit']")
    public WebElement Sing_In;

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
    @FindBy(how = How.XPATH,using = "//span[@class='text-capitalize']")
    public WebElement MSP_UserAccount;
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
    @FindBy(how = How.XPATH,using = "//header/div[2]/div[1]/button[1]")
    public WebElement Action;
    @FindBy(how = How.XPATH,using ="//a[contains(text(),'Approve')]")
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
    public  WebElement pending_offers;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-offers[1]/div[1]/div[1]/div[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[2]/tbody[1]/tr[1]/vms-row[2]/td[1]/span[1]")
    public WebElement click_released;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-offers[1]/div[1]/div[1]/div[1]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/vms-row[1]/td[1]/p[1]/a[1]")
    public WebElement offer_candidate_name;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'more_horiz')]")
    public WebElement offer_candidate_status_check;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-offers[1]/nav[1]/ul[1]/li[1]/a[1]")
    public WebElement offer_candidate_accept;
    @FindBy(how = How.XPATH,using = "//textarea[@placeholder='Enter Additional Notes']")
    public WebElement offer_acceptance_reason;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary float-right']")
    public WebElement Accept_offer;

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
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Contract Labor - 41345')]")
    public WebElement First_Location;
    @FindBy(how = How.XPATH, using = "//app-foundational-fields[1]//div[3]//span[@class='ng-arrow-wrapper']")
    public WebElement select_Legal_Entity;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Consulting Services - 62616')]")
    public WebElement First_Legal_Entity;
    @FindBy(how = How.XPATH,using = "//app-foundational-fields[1]//div[4]//span[@class='ng-arrow-wrapper']")
    public WebElement select_Service_Department;
    //@FindBy(how = How.XPATH, using = "//span[contains(text(),'1606 - 1606')]")
    @FindBy(how = How.XPATH, using = "//div[@class='ng-option ng-option-selected ng-option-marked']/span[@class='ng-option-label']")
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
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Cub Foods - RESD Office Services - 59126')]")
    public WebElement First_Cost;
    @FindBy(how = How.XPATH, using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-create-job/form/div/div/div/div[2]/div/app-foundational-fields/div/div[8]/div/div/ng-select/div/span")
    public WebElement select_Business_Unit;
    @FindBy(how = How.XPATH, using = "//span[contains(.,'Marble Brands - Marble Brands')]")
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
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Bachelor Degree of Computer Science')]")
    public WebElement Subject_Name;
    @FindBy(how = How.XPATH,using = "//app-add-education[1]//button[@class='btn btn-primary float-right']")
    public WebElement Education_SubmitButton;


    /*
    * End of 27.10.2021
    * Name - Nirmalya Sarkar
    * */
    @FindBy(how = How.XPATH,using ="//a[contains(.,'login Logout')]")
    public WebElement LogOut;
    @FindBy(how = How.XPATH,using ="//button[contains(text(),'Yes')]")
    public WebElement LogOut_Pop_up;
    @FindBy(how = How.XPATH,using ="//p[.='Jobs Pending Approval']")
    public WebElement Pending;
    @FindBy(how = How.XPATH,using ="//*[@id='smarttable']/div/vms-header/div[1]/div/div[2]/ul/li[4]/div/input")
    public WebElement job_search;
    @FindBy(how = How.XPATH,using ="//table-icon[@name='search']/i[@class='d-flex material-icons']")
    public WebElement search_button;
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
    public WebElement Pending_interview;
    // @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-interviews[1]/div[1]/div[1]/div[2]/vms-table[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/perfect-scrollbar[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]/vms-row[1]/td[1]/p[1]/a[1]")
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public WebElement Click_name;
    @FindBy(how = How.XPATH,using = "//button[contains(text(),'Accept')]")
    public WebElement Accept;
    // @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/app-candidate-job-view-interview-details[1]/app-accept-interview-sidepanel[1]/svms-sidebar-ng[1]/div[1]/div[2]/div[1]/div[1]/div[1]/label[1]/span[1]")
    @FindBy(how = How.XPATH,using = "//*[@id='svmsSidebar']/div[2]/div/div[1]/div/label/span")
    public WebElement check_interview_date;
    @FindBy(how = How.XPATH,using = "//input[@placeholder='Enter Primary Phone Number']")
    public WebElement phone_number;
    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-success float-right']")
    public WebElement Accept_interview;

    @FindBy(how = How.XPATH,using ="//li[.='work_outlineJobwork_outlineJob']")
    public WebElement Dashboard_Job;

    @FindBy(how = How.XPATH,using ="//a[contains(.,'View All Jobs')]")
    public WebElement Dashboard_Submission;
    @FindBy(how = How.XPATH,using ="//vms-header/div[1]/div[1]/div[2]/ul[1]/li[4]/div[1]/table-icon[1]/i[1]")
    public WebElement Dasboard_Search;
    @FindBy(how = How.LINK_TEXT,using ="Software Engineer" )
    public WebElement Job_clk;
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/vms-header/div[1]/div/div[2]/ul/li[4]/div/input")
    public WebElement Dashboard_SearchBy_Job_id;
    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Add & Submit Candidate')]")
    public  WebElement click_Add_And_Submit_Candidate;
    @FindBy(how = How.XPATH,using ="//div[@class='drop-zone']//icon[@type='material']")
    public  WebElement click_On_ResumeButton;
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

    @FindBy(how = How.XPATH,using ="//button[contains(.,'Submit Candidate')]")
    public WebElement Submit_and_Candidate;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/job-details/app-job-details/div/section/div/nav/ul/li[2]/a")
    public WebElement Clickon_availableCandidate;
    /*
    * Start Scenario : Enter Time By Worker
    * Name - Nirmalya Sarkar*/

    @FindBy(how = How.XPATH,using = "//div[@id='sidebar']/a[@href='javascript:void(0)']")
    public WebElement Switch_menu;
    @FindBy(how = How.XPATH,using ="//li[6]/a[2]/label[@class='m-0']")
    public WebElement Time_and_Expense;
    @FindBy(how = How.XPATH,using ="//a[contains(.,'pending_actions View Timesheets')]")
    public WebElement View_Timesheets;
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
    public WebElement Submit_timesheet;
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
    public WebElement Submitted_Candidate;
    @FindBy(how = How.PARTIAL_LINK_TEXT,using ="CHRISTOPHER MORG")
    public WebElement Candidate_Click;
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
    @FindBy(how = How.XPATH,using ="//span[contains(text(),'Baker Island Time (BIT) (UTC-12)')]")
    public WebElement Select_Timezon;
    @FindBy(how = How.XPATH,using = "//div//span[2][contains(.,'Eastern Standard Time (North America) (EST) (UTC-05)')]")
    public WebElement Duration;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'45 Minutes')]")
    public WebElement Select_Duration;
    @FindBy(how = How.XPATH,using = "//input[@id='']")
    public WebElement Choose_Date;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'24')]")
    public WebElement Select_Date;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-interviews[1]/candidate-job-view-interview-create[1]/form[1]/div[1]/div[1]/div[7]/div[1]/div[1]/div[2]/ng-select[1]/div[1]/span[1]")
    public WebElement Time_Slot;
    @FindBy(how = How.XPATH,using = "//div[contains(text(),'09:00 AM-09:45 AM')]")
    public WebElement Select_Time_Slot;
    @FindBy (how = How.XPATH,using = "//button[contains(text(),'Schedule')]")
    public WebElement schedule;

    @FindBy(how =How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[1]/div[1]/ul[1]/li[3]/a[2]")
    public WebElement click_job;
    @FindBy(how = How.XPATH,using = "//body[1]/app-root[1]/app-main[1]/div[1]/app-sidebar[1]/div[1]/div[4]/div[2]/perfect-scrollbar[1]/div[1]/div[1]/ul[1]/li[5]/a[1]")
    public WebElement click_submission;
    @FindBy(how = How.XPATH,using = "//*[@id='smarttable']/div/div[1]/div/div/div/div/perfect-scrollbar/div/div[1]/table[1]/tbody/tr[1]/vms-row[1]/td/p/a")
    public WebElement submitted_candidate_Name;
    @FindBy(how = How.XPATH,using = "//i[contains(text(),'more_horiz')]")
    public WebElement offer_button;
    @FindBy(how = How.XPATH,using = "//a[contains(text(),'Create Offer')]")
    public WebElement create_offer;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-candidate-job-view[1]/div[1]/section[1]/div[1]/div[1]/app-candidate-job-view-content[1]/div[1]/div[1]/app-candidate-job-view-offers[1]/div[1]/div[1]/div[1]/app-no-data[1]/div[1]/div[1]/button[1]")
    public WebElement final_Create_offer;
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-candidate-job-view/div/section/div/div[1]/app-candidate-job-view-content/div/div/app-candidate-job-view-offers/app-create-offers/form/div[1]/div[5]/div/ng-select")
    public WebElement Timesheet;
    //@FindBy(how = How.XPATH,using = "//span[contains(.,'Hours')]")
    @FindBy(how = How.XPATH,using = "//div[@class='ng-dropdown-panel-items scroll-host']//span[contains(text(),'Hours')]")
    public WebElement choose_timesheet;
    //@FindBy(how = How.XPATH,using = "//div[contains(text(),'Select Assignment')]")
    @FindBy(how = How.XPATH,using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-candidate-job-view/div/section/div/div[1]/app-candidate-job-view-content/div/div/app-candidate-job-view-offers/app-create-offers/form/div[1]/div[8]/div/ng-select")
    public WebElement Assignment_active_upon;
    @FindBy(how = How.XPATH,using = "//span[contains(text(),'Offer Acceptance')]")
    public WebElement Choose_assignment;
    @FindBy(how = How.XPATH,using = "//input[@formcontrolname='candidatePayRate']")
    public WebElement candidate_pay_rate;
    @FindBy(how = How.XPATH,using = "//button[contains(.,'Release Offer')]")
    public WebElement Release_offer;




    public void enterValue(WebElement element, String value) {
        element.sendKeys(value);
    }

    public void clickOn(WebElement submitButton) throws InterruptedException {
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

    public void clickOnAfterElementIsVisible(WebElement element) {
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
