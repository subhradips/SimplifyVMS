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
    @FindBy(how = How.XPATH,using = "//gridster-item[.='72Active Jobsbuild_circledelete']")
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
