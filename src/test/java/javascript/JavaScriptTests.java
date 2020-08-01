package javascript;

import base.BaseTests;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class JavaScriptTests extends BaseTests {

    @Test
    public void testScrollToTable() {
        homePage.clickLargeAndDeepDom().scrollToTable();
    }

    @Test
    public void testScrollToFifthParagraph() {

        homePage.clickInfiniteScroll().scrollToParagraph(5);
    }


    /**
     * Chapter 10 - Using JavaScript Independent Exercise
     * Verify that you have selected both options, and that they're “Option 1” and “Option 2”
     */
    @Test
    public void testSelectedMultipleDropdownOptions() {
        var multipleOptions = homePage.clickDropdown();
        multipleOptions.multipleDropDownElements();
        String valueOption1 = "Option 1";
        String valueOption2 = "Option 2";
        multipleOptions.selectmultipleDropdownOptions(valueOption1, valueOption2);
        var selectedMultiOptions = multipleOptions.getSelectedOptions();
        Assert.assertEquals(selectedMultiOptions.size(), 2,"Incorrect number of selections");
        assertTrue(selectedMultiOptions.contains(valueOption1) && selectedMultiOptions.contains(valueOption2),"Multiple options not selected");
    }


}

