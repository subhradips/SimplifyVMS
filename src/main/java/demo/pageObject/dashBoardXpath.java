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

    @FindBy(how = How.XPATH,using ="//a[contains(.,'add Create Job')]")
    public WebElement Dashboard_Addjob;
    @FindBy(how = How.LINK_TEXT,using ="Software Engineer")
    public WebElement Software_Engineer;
    @FindBy(how = How.XPATH,using ="//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[2]/ng-select[1]/div[1]/span[1]")
    public WebElement Job_Manager;
    @FindBy(how = How.XPATH,using ="//div[@class='ng-dropdown-panel-items scroll-host']//div[3]//span[@class='text-capitalize']")
    public WebElement HM_Name_Select;
    @FindBy(how = How.XPATH,using ="//p[contains(text(),'This is job description')]")
    public WebElement Job_Description;

    //Testcase 7
    @FindBy(how = How.XPATH, using = "//input[@id='start_date']")
    public WebElement Start_Date;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/svms-datepicker[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[13]")
    public WebElement Select_Start_Date;
    @FindBy(how = How.XPATH, using = "//input[@id='end_date']")
    public WebElement End_Date;
    @FindBy (how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/svms-datepicker[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[36]/span[1]")
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
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[1]/div[1]/div[1]/ng-select[1]/div[1]/span[2]")
    public WebElement Select_GL_Location;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Contract Labor - 41345')]")
    public WebElement First_Location;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[2]/div[1]/div[1]/ng-select[1]/div[1]/span[2]")
    public WebElement select_Legal_Entity;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Consulting Services - 62616')]")
    public WebElement First_Legal_Entity;
    @FindBy(how = How.XPATH,using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[3]/div[1]/div[1]/ng-select[1]/div[1]/span[2]")
    public WebElement select_Service_Department;
    //@FindBy(how = How.XPATH, using = "//span[contains(text(),'1606 - 1606')]")
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[3]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[4]/span[1]")
    public WebElement First_Service_Department;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[4]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
//    public WebElement select_Dept_No;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[4]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
//    public WebElement First_Dept_No;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[5]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
//    public WebElement select_Intra;
//    @FindBy(how = How.XPATH, using = "//body[1]/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[5]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[1]/span[1]")
//    public WebElement First_Intra;
    @FindBy(how = How.XPATH, using = "//*[@id='pagecontainer']/div[1]/app-jobs/app-create-job/form/div/div/div/div[2]/div/app-foundational-fields/div/div[6]/div/div/ng-select")
    public WebElement select_Cost;
    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Cub Foods - RESD Office Services - 59126')]")
    public WebElement First_Cost;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[7]/div[1]/div[1]/ng-select[1]/div[1]/span[1]")
    public WebElement select_Business_Unit;
    @FindBy(how = How.XPATH, using = "//span[contains(.,'Marble Brands - Marble Brands')]")
    public WebElement First_Business;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[8]/div[1]/div[1]/ng-select[1]/div[1]/span[2]")
    public WebElement select_GL_Account;
    @FindBy(how = How.XPATH, using = "//body/app-root[1]/app-main[1]/div[1]/div[1]/app-jobs[1]/app-create-job[1]/form[1]/div[1]/div[1]/div[1]/div[2]/div[1]/app-foundational-fields[1]/div[1]/div[8]/div[1]/div[1]/ng-select[1]/ng-dropdown-panel[1]/div[1]/div[2]/div[3]/span[1]")
    public WebElement First_GL_Account;
    @FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
    public WebElement Create_Job;

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

    /*Name - Nirmalya Sarkar
    * Date - 28.10.2021
    * Create and submit candidate as vendor
    * */
    @FindBy(how = How.XPATH,using ="//li[.='work_outlineJobwork_outlineJob']")
    public WebElement Dashboard_Briefacse1;
    @FindBy(how = How.XPATH, using = "//a[contains(.,'view_stream View All Jobs')]")
    public WebElement view_all_jobs1;





    @FindBy(how = How.XPATH, using = "//b[contains(text(),'712450-SHOP RITE 130')]")
    public List<WebElement>  Customer_Dropdown_Value;



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



}
