/*
 * Independent exercise Chapter 8 - Frames
 *  Fields and Methods for switching between the left and bottom frames
 *  It also validates the text inside of the frames.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NestedFramesPage {
    private WebDriver driver;
    private By leftFrame = By.tagName("body");
    private By bottomFrame = By.tagName("body");

    public NestedFramesPage(WebDriver driver){        
        this.driver = driver;
    }


    public String getLeftFrameText(){
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String textOnFrame = driver.findElement(leftFrame).getText();
        driver.switchTo().parentFrame();
        return textOnFrame;
    }

    public String getBottomFrameText(){
        driver.switchTo().parentFrame();
        driver.switchTo().frame("frame-bottom");
        String text =  driver.findElement(bottomFrame).getText();
        driver.switchTo().parentFrame();
        return text;
    }
}
