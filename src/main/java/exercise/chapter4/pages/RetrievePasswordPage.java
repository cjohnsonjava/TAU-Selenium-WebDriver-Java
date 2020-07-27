package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RetrievePasswordPage {

    private WebDriver driver;
    private By messageAlert = By.id("content");

    RetrievePasswordPage(WebDriver driver){
        this.driver = driver;
    }

    public String getMessageText(){
        return driver.findElement(messageAlert).getText();//returns the text of the element
    }


}



