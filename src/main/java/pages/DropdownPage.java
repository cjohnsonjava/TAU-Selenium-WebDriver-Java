package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.stream.Collectors;

public class DropdownPage {

    private WebDriver driver;
    private By dropdown = By.id("dropdown");

    public DropdownPage(WebDriver driver){
        this.driver = driver;
    }

    /**
     * Chapter 4.3 Interacting with Dropdown Elements
     * Select one option
     */
    public void selectFromDropDown(String option){

        findDropDownElement().selectByVisibleText(option);
    }

    /**
     * Get all of the selected options and return the text
     * @return
     */
    public List<String> getSelectedOptions(){
        List<WebElement> selectedElements =
                findDropDownElement().getAllSelectedOptions();
        return selectedElements.stream().map(e->e.getText()).collect(Collectors.toList());
    }

    private Select findDropDownElement(){
         return new Select(driver.findElement(dropdown));
    }

    /**
     * Chapter 10 - Using JavaScript Independent Exercise
    Add JavaScript to change to multiple dropdown options
     */
    public void multipleDropDownElements(){
        WebElement dropDownElements = driver.findElement(dropdown);//Create web element to find the dropdown
        String script = "arguments[0].setAttribute('multiple', '');";
        ((JavascriptExecutor)driver).executeScript(script,dropDownElements);
    }


    /* Chapter 10 - Using JavaScript Independent Exercise
     * select both Option 1 and Option 2
     */
    public void selectmultipleDropdownOptions(String option1, String option2){
        Select multipleDropDownElements = new Select(driver.findElement(dropdown));
        multipleDropDownElements.selectByVisibleText(option1);
        multipleDropDownElements.selectByVisibleText(option2);
          }
}
