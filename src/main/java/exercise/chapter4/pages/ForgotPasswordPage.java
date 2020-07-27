package exercise.chapter4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.RetrievePasswordPage;

public class ForgotPasswordPage {
    private WebDriver driver;
    private By emailField = By.id("email");
    private By retrievePasswordButton = By.id("form_submit");

    public ForgotPasswordPage(WebDriver driver) {
        this.driver = driver;
    }

    public void setEmailField(String email){
        driver.findElement(emailField).sendKeys(email);
    }

    public RetrievePasswordPage clickRetrievePasswordButton(){
        driver.findElement(retrievePasswordButton).click();
        return new RetrievePasswordPage(driver);
    }
}
