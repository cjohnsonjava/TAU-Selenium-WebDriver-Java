/**
 * Chapter 11 - Application Navigation
 * utility methods to go Back, forward, refresh and navigate to a url
 * Added methods to click on a link and open it in a new tab
 * switch to a window tab
 */
package utils;
import org.openqa.selenium.WebDriver;
import pages.DynamicLoadingExample2Page;

public class WindowManager {

    private WebDriver driver;
    private WebDriver.Navigation navigate;

    public WindowManager(WebDriver driver) {
        this.driver = driver;
        navigate = driver.navigate();
    }

    public void goBack() {
        navigate.back();
    }

    public void goForward() {
        navigate.forward();
    }

    public void refreshPage() {
        navigate.refresh();
    }

    public void goTo(String url) {
        navigate.to(url);
    }

    /*
     * Pass the tab to switch to
     * returns a handles to all of the open tabs or windows
     */
    public void switchToTab(String tabTitle) {
        var windows = driver.getWindowHandles();

        System.out.println("Number of tabs: " + windows.size());
        System.out.print("Window handles:");
        windows.forEach(System.out::println);

        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);

            System.out.println("Current window title: " + driver.getTitle());

            if (tabTitle.equals(driver.getTitle())) {
                break;
            }
        }

    }

    /*
     * Loops through all of the windows and
     * Switches to a new tab
     */
    public void switchToWindow() {
        var windows = driver.getWindowHandles();

        for (String window : windows) {
            System.out.println("Switching to window: " + window);
            driver.switchTo().window(window);
        }
    }

        /*
         * Gets the text of the start button
         * by calling getButtonTextExample2()
         */
        public String ButtonTextExample2 () {
            DynamicLoadingExample2Page text = new DynamicLoadingExample2Page(driver);
            var buttonText = text.getButtonTextExample2();
            return buttonText;
        }
    }


