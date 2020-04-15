package base;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class BaseTest {

    private static WebDriver driver;

    @BeforeTest
    public void driverSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }


    public static WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void afterTest() {
        getDriver().close();
    }

    private static ThreadLocal<ExtentTest> test = new ThreadLocal();

    public static ThreadLocal<ExtentTest> getTest() {
        return test;
    }
}