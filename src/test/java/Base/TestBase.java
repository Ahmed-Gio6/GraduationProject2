package Base;


import Pages.HomePage;
import Pages.RegisterPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import Utilities.ScreenShot;

import java.time.Duration;

import org.testng.internal.TestResult;


public class TestBase {

    public WebDriver driver;

    @Parameters("browser")
    @BeforeClass

    public void precondition(@Optional("edge") String browser) {
        if (browser.equalsIgnoreCase("chrome"))
        {
            driver = new ChromeDriver();
        }
        else if (browser.equalsIgnoreCase("firefox"))
        {
            driver = new FirefoxDriver();
        }
        else if (browser.equalsIgnoreCase("edge"))
        {
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @BeforeMethod
    public void setUp() {
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    @AfterMethod
    public void takeScreenshot(ITestResult testResult) {

    }


    @AfterClass
    public void teardown() {
        driver.close();
    }
}
