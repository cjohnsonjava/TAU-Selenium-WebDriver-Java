package wait;

import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class WaitTests extends BaseTests {

    @Test
    public void testWaitUntilHidden(){
        var loadingPage = homePage.clickDynamicLoading().clickExample1();
        loadingPage.clickStart();
        assertEquals(loadingPage.getLoadedText(),"Hello World!","Loaded text incorrect");
    }

    /**
    Independent Exercise 9
    Use the waiting strategy to verify the Hello World! text displays
     */
    @Test
    public void testWaitUntilTextDisplays(){
        var loadingPage = homePage.clickDynamicLoading().clickExample2();
        loadingPage.clickStartButton();
        loadingPage.VerifyTextLoadedExample2();

        assertEquals(loadingPage.getLoadedTextExample2(),"Hello World!","Loaded text incorrect");

    }
}
