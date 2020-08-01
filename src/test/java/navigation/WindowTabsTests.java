/**
 * Chapter 11 - Independent Exercise: Application Navigation
 * Click on the Dynamic Loading link and you have two links here
 * Take either one, maybe let's go with the Example 2, and simulate a right click.
 * After opening this link in a new tab, switch over to it and verify that the “Start” button is there.
 */
package navigation;
import base.BaseTests;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class WindowTabsTests extends BaseTests {

    @Test
    public void testMultipleWindows(){
      homePage.clickDynamicLoading().rightclickExample2();

        getWindowManager().switchToWindow();
        var buttonText  = getWindowManager().ButtonTextExample2();
        assertTrue(buttonText.equals("Start"),"The Start button is not displayed");
    }
}