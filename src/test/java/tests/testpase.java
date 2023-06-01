package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Helper;

import java.util.concurrent.TimeUnit;

public class testpase {
    public static WebDriver driver;
    @BeforeSuite
    @Parameters({"browser"})
    public void  startDriver( @Optional ("firefox")  String browserName){
        if (browserName.equalsIgnoreCase("firefox")){
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();}
        else if ((browserName.equalsIgnoreCase("chrome"))) {
            WebDriverManager.chromedriver().setup();
            driver=new ChromeDriver();
            }
        else if ((browserName.equalsIgnoreCase("ie"))) {
            WebDriverManager.iedriver().setup();
            driver=new InternetExplorerDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
        driver.get("https://demo.nopcommerce.com/");
    }


    @AfterSuite
    public void closeDriver(){
driver.quit();
    }
    @AfterMethod
    public void screenshotOnFailure(ITestResult result){

if(result.getStatus()==ITestResult.FAILURE){
    System.out.println("Faild");
    System.out.println("taking screenshot");
    Helper.captureScreenShoot(driver, result.getName());
}
    }

}
