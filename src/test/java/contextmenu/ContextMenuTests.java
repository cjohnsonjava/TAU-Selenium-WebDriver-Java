package contextmenu;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {

    /*
     * Verify that this text "You selected a context menu" is correct and
     * click the "OK" button on the pop-up.
     */
    @Test
    public void testContextMenu(){
        var contextMenuPage = homePage.clickContextMenu();
        contextMenuPage.rightClickTriggerAlert();
        String message = contextMenuPage.alert_getText();
        System.out.println(message);
        contextMenuPage.alert_clickToAccept();
        assertEquals(message,"You selected a context menu", "The displayed text is incorrect");



    }

}
