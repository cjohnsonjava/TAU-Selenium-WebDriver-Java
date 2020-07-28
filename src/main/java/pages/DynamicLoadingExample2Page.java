/**
 Independent Exercise 9
 Use the waiting strategy to verify the Hello World! text displays
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DynamicLoadingExample2Page {

    private WebDriver driver;
    private By startButton = By.cssSelector("#start button");
    private By loadingIndicator = By.id("loading");
    private By loadedText = By.id("finish");

    public DynamicLoadingExample2Page(WebDriver driver){
        this.driver = driver;
    }

    public void clickStartButton(){
        driver.findElement(startButton).click();
     }

    public void VerifyTextLoadedExample2(){
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loadedText));
            }

    public String getLoadedTextExample2(){
               return driver.findElement(loadedText).getText();
    }


}
