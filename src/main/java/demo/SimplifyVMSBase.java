package demo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class SimplifyVMSBase {

    public  static WebDriver driver;
    public  static SimplifyVMSGetPropertyValues prop = new SimplifyVMSGetPropertyValues();

    static {
        //System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/driver/geckodriver.exe");
//        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/driver/chromedriver.exe");
//      System.setProperty("webdriver.chrome.driver","driver/chromedriver2.exe");
//        driver = new ChromeDriver();

//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setBinary("C:/Program Files (x86)/Google/Chrome/Application/chrome.exe");
//
//        driver = new ChromeDriver(chromeOptions);
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
}
