/*
 * Independent exercise Chapter 6 - Additional Keys
 * which also covers Advanced Interactions learned in Chapter 5
 * It will sendKeys to the horizontal slider to move it.
 * I added a method to check the maximum value which can be used to test an out of bounds condition
 * but it wasn't part of the requirement for this exercise.
 */
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class HorizontalSliderPage {
    private WebDriver driver;
    private By sliderRangeMovedTo = By.cssSelector("input[type ='range']");
    private By sliderRangeResult = By.cssSelector("div.sliderContainer #range");
    private By maxSliderValue = By.cssSelector("input[max=\"5.0\"]");

    public HorizontalSliderPage(WebDriver driver) {
        this.driver = driver;
    }

    public void moveSlider(String i) {
        Actions move = new Actions(driver);
        WebElement sliderMover = driver.findElement(sliderRangeMovedTo);
        move.click(sliderMover).perform();

        while(!i.equals(sliderResults())) {
            move.sendKeys(Keys.ARROW_RIGHT).perform();
        }
    }

    public String sliderResults(){

        return driver.findElement(sliderRangeResult).getText();
    }

    public String maxValue(){
        return driver.findElement(maxSliderValue).getAttribute("max");//gets the actual max value
    }

}