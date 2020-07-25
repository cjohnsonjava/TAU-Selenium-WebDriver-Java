package exercise.chapter3;

/*
Chapter 3 Exercise
1. Click on the “Shifting Content” link
2. Then click on the first example Menu Element
3. Then print how many of these menu elements appear.
 */
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ShiftingContent {

    private WebDriver driver;//WebDriver object

    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/");


        WebElement shiftingContentLink = driver.findElement(By.linkText("Shifting Content"));
        shiftingContentLink.click();

        WebElement firstExampleMenuElement = driver.findElement(By.linkText("Example 1: Menu Element"));
        firstExampleMenuElement.click();

        List<WebElement> links = driver.findElements(By.cssSelector("ul a"));
        System.out.println(links.size());

        driver.quit();
    }

    public static void main(String args[]){
        ShiftingContent test = new ShiftingContent();
        test.setUp();
    }
}
