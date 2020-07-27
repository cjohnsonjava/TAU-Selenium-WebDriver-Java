package forgotpassword;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.ForgotPasswordPage;
import pages.RetrievePasswordPage;
import static org.testng.Assert.assertTrue;

public class ForgotPasswordTests extends BaseTests {

    @Test
    public void testRetrievePassword(){
        ForgotPasswordPage ForgotPassword = homePage.clickForgotPassword();
        ForgotPassword.setEmailField("test@gmail.com");
        RetrievePasswordPage RetrievePassword = ForgotPassword.clickRetrievePasswordButton();
        assertTrue(RetrievePassword.getMessageText().
                contains("Your e-mail's been sent!"),"Message is incorrect");

        System.out.println(RetrievePassword.getMessageText());

    }
}
