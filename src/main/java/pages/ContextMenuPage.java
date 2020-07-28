/*
 * Chapter 7 - Independent Exercise
 * This program goes to the Context Menu link
 * Click on it, and then on the box, does a context click, meaning a right click.
 * An Actions class is utilized to achieve this.
 * Once you do the right click, you see a pop-up here.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ContextMenuPage {
    private WebDriver driver;
    private By contextBox = By.id("hot-spot");

    public ContextMenuPage(WebDriver driver){
        this.driver = driver;
    }

    public void rightClickTriggerAlert(){
        WebElement contextPicBox = driver.findElement(contextBox);
        Actions action = new Actions(driver);
        action.contextClick(contextPicBox).perform();
    }

    public String alert_getText(){
        return driver.switchTo().alert().getText();
    }

    public void alert_clickToAccept()
    {
        driver.switchTo().alert().accept();
    }
}
