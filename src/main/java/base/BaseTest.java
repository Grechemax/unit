package base;

import com.aventstack.extentreports.ExtentTest;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimeZone;



@org.testng.annotations.Listeners({base.Listeners.class})

public class BaseTest {

    private static WebDriver driver;
    private static final ThreadLocal<WebDriver> DRIVER = new ThreadLocal();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal();
    private static String suiteName;
    private static ThreadLocal<ExtentTest> parentTest = new ThreadLocal();
    protected static String ENVIRONMENT;
    protected static String BROWSER;

    @Parameters({"environment","browser"})
    @BeforeMethod
    public synchronized void beforeClass(ITestContext ctx, Method method, @Optional("chrome") String browser, @Optional("TEST") String environment
    ) {

        suiteName = ctx.getCurrentXmlTest().getSuite().getName();
        ExtentTest parent = ExtentManager.getInstance(suiteName).createTest(method.getName());
        parentTest.set(parent);
        setEnvironmentForTests(environment);
        setBrowser(browser);


        if ("chrome".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
            driver = new ChromeDriver();
            driver.manage().window().setPosition(new Point(0, 0));
            driver.manage().window().setSize(new Dimension(1924, 838));
        }

        else if ("chromeHeadless".equalsIgnoreCase(browser)) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless");
            chromeOptions.addArguments("--disable-infobars");
            chromeOptions.addArguments("--disable-dev-shm-usage");
            chromeOptions.addArguments("--no-sandbox");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1924,938");
            chromeOptions.addArguments("--no-first-run");
            chromeOptions.addArguments("--no-default-browser-check");
            chromeOptions.addArguments("--ignore-certificate-errors");


            driver = new ChromeDriver(chromeOptions);
        } else if ("firefox".equalsIgnoreCase(browser)) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        }
        DRIVER.set(driver);
    }

    @BeforeMethod
    public void setup(Method method) {
        ExtentTest child = parentTest.get().createNode(method.getName());
        test.set(child);

        base.Reporter.log("--__---------------------__--");
        base.Reporter.log("Method -" + method.getName() + " - is started.");

    }

    public static WebDriver getDriver() {
        return DRIVER.get();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.manage().deleteAllCookies();
            driver.quit();
            DRIVER.remove();
        }
        ExtentManager.getInstance(suiteName).flush();
        Reporter.log("Tests PERFORMED");
    }

    public static ThreadLocal<ExtentTest> getTest() {
        return test;
    }

    @AfterMethod(alwaysRun = true)

    public void closeWindow(ITestResult result){
        if (result.getStatus() == ITestResult.FAILURE) {
            test.get().fail(result.getThrowable());
            Reporter.logFail("Test "+result.getMethod().getMethodName()+ " FAILED");
            try {
                DateFormat dateFormat = new SimpleDateFormat("yyyy MM d");
                Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Europe/Kiev"));
                test.get().addScreenCaptureFromPath("screenshotsOnFailure"+ File.separator
                        + result.getMethod().getXmlTest().getName() + File.separator + dateFormat.format(calendar.getTime())
                        + File.separator + result.getMethod().getMethodName()+ ".png");
            } catch (IOException e) { }

            ExtentManager.getInstance(suiteName).flush();
        } else if (result.getStatus() == ITestResult.SKIP)
            test.get().skip(result.getThrowable());
        else
            test.get().pass("Test passed");
        ExtentManager.getInstance(suiteName).flush();
        Reporter.log("Stopping test");

    }

    private static void setEnvironmentForTests(String environmentForTests) {
        ENVIRONMENT = environmentForTests;
    }
    private static void setBrowser(String browser) {
        BROWSER = browser;
    }

}