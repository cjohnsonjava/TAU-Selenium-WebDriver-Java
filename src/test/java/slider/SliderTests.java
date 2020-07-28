package slider;

import base.BaseTests;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import pages.HorizontalSliderPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SliderTests extends BaseTests {

    /*
     * It will sendKeys to the slider until it gets to the number 4. The test verifies that this text actually equals 4.
     */
    @Test
    public void testSlider(){
        var sliderPage = homePage.clickHorizontalSlider();
        String i = "4";
        sliderPage.moveSlider(i);
        var sliderResultsText = sliderPage.sliderResults();
        assertEquals(sliderResultsText,i,"The range is incorrect");
    }
}
