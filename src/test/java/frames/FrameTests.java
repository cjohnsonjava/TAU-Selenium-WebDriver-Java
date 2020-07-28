/*
 * Chapter 8 - Frames
 */
package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {

    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();

        String text1 = "hello" ;
        String text2 = "world";

        editorPage.setTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.setTextArea(text2);

        assertEquals(editorPage.getTextFromEditor(),text1+text2,"Text from editor is incorrect");

    }

    /**verify that the text inside of this particular
     * frame says "Left" and that the text inside of this particular frame says "Bottom".
     **/
    @Test
    public void testNestedFrames(){
        var nestedFramePage = homePage.clickNestedFrames();
        assertEquals(nestedFramePage.getLeftFrameText(),"LEFT", "Text in the left frame is incorrect");
        assertEquals(nestedFramePage.getBottomFrameText(),"BOTTOM", "Text in the bottom frame is incorrect");
    }
}
