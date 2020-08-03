package base;

import com.google.common.io.Files;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.EventReporter;
import utils.WindowManager;
import utils.WindowsTabManager;

import java.io.File;
import java.io.IOException;

public class BaseTests {

    private EventFiringWebDriver driver;//A specific instance of a WebDriver called the EventFiringWebDriver
    protected HomePage homePage;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new EventFiringWebDriver(new ChromeDriver());//an instance of the EventFiringWebDriver listens out for events
//        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.register(new EventReporter());//listens out for events
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
     * This will run if a test fails.
     * The method will take a screenshot, give it the name of the test
     * and put it in our project
     * in the screenshots directory folder
     */
    @AfterMethod
    public void recordFailure(ITestResult result){
        if(ITestResult.FAILURE == result.getStatus())
        {
            var camera = (TakesScreenshot)driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);
            try {
                Files.move(screenshot, new File("resources/screenshots/"+ result.getName() + ".png"));
            }catch(IOException e){
                e.printStackTrace();
            }
        }
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
