package base;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.WindowManager;
import utils.WindowsTabManager;

import java.io.File;

public class BaseTests {

    private WebDriver driver;//WebDriver object
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        goHome();

//        driver.manage().window().setSize(new Dimension(375,812));


    }

    @BeforeMethod
    public void goHome(){
        driver.get("https://the-internet.herokuapp.com/");
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void tearDown(){
        driver.quit();
    }

    /*
     * This will run after each test runs.
     * The method will take a screenshot
     * and save it as a file
     */

    @AfterMethod
    public void takeScreenshot(){
        var camera = (TakesScreenshot)driver;
        File screenshot = camera.getScreenshotAs(OutputType.FILE);
        System.out.println("Screenshot taken: " + screenshot.getAbsolutePath());
    }

    /*
     * Gives us a handle to the WindowManager
     */
    public WindowManager getWindowManager(){
        return new WindowManager(driver);
    }

    public WindowsTabManager getTabWindowManager(){
        return new WindowsTabManager(driver);
    }
}
