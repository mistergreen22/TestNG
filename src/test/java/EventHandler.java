import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class EventHandler implements WebDriverEventListener {

    @Override
    public void beforeAlertAccept(WebDriver webDriver) { }

    @Override
    public void afterAlertAccept(WebDriver webDriver) { }

    @Override
    public void afterAlertDismiss(WebDriver webDriver) { }

    @Override
    public void beforeAlertDismiss(WebDriver webDriver) { }

    @Override
    public void beforeNavigateTo(String s, WebDriver webDriver) {
        System.out.println("Before navigate to: '" + s + "'");
    }

    @Override
    public void afterNavigateTo(String s, WebDriver webDriver) {
        System.out.println("After navigate to: '" + s + "'");
    }

    @Override
    public void beforeNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating to the previous page");
    }

    @Override
    public void afterNavigateBack(WebDriver webDriver) {
        System.out.println("Navigating to the previous page");
    }

    @Override
    public void beforeNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating forward to the next page");
    }

    @Override
    public void afterNavigateForward(WebDriver webDriver) {
        System.out.println("Navigating forward to the next page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver webDriver) {
        System.out.print("Before refresh: '" + webDriver.getCurrentUrl() + "'");
    }

    @Override
    public void afterNavigateRefresh(WebDriver webDriver) {
        System.out.println("After refresh: '" + webDriver.getCurrentUrl() + "'");
    }

    @Override
    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to find element : " + by.toString());
    }

    @Override
    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
        if(webElement != null){
            System.out.println("Found element : " + by.toString());
        } else {
            System.out.println("Element is null");
        }
    }

    @Override
    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Trying to click on: " + webElement.toString());
    }

    @Override
    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        System.out.println("Clicked on: " + webElement.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Value of the: " + webElement.toString() + "before any changes made");
    }

    @Override
    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver, CharSequence[] charSequences) {
        System.out.println("Element value change to: " + webElement.toString());
    }

    @Override
    public void beforeScript(String s, WebDriver webDriver) { }

    @Override
    public void afterScript(String s, WebDriver webDriver) { }

    @Override
    public void beforeSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("Before switch window, window name is " + s);
    }

    @Override
    public void afterSwitchToWindow(String s, WebDriver webDriver) {
        System.out.println("After we switch window, window name is " +s);
    }

    @Override
    public void onException(Throwable throwable, WebDriver webDriver) {
        System.out.println("Exception occurred: " + throwable);
    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> outputType) {
        System.out.println("Return type before " + outputType.toString());
    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> outputType, X x) {
        System.out.println("Return type after " + outputType.toString());
    }

    @Override
    public void beforeGetText(WebElement webElement, WebDriver webDriver) {
        System.out.println("Getting text from element: " + webElement);
    }

    @Override
    public void afterGetText(WebElement webElement, WebDriver webDriver, String s) {
        System.out.println("Text from element: " + webElement + "is " + s);
    }
}
