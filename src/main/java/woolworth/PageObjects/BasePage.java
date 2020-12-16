package woolworth.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import woolworth.common.utils.Helper;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashMap;

public class BasePage extends Helper {

    protected final AppiumDriver driver;
    public static WebDriverWait driverWait;

    public BasePage(AppiumDriver driver) {
        this.driver = driver;

        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
        int timeoutInSeconds = 60;
        driverWait = new WebDriverWait(driver, timeoutInSeconds);
    }

    public static void waitAndClick(MobileElement element) {
        driverWait.until(ExpectedConditions.elementToBeClickable(element)).click();

    }

    public static void type(MobileElement element, String text) {
        driverWait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element.clear();
        element.sendKeys(text);
    }

    public static void waitForElementVisibility(MobileElement element) {
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static MobileElement waitForVisibility(MobileElement element) {
        driverWait.until(ExpectedConditions.visibilityOf(element));
        return (MobileElement) element;
    }

    public static void waitForElementVisibility(MobileElement element, int sec) {
        driverWait.until(ExpectedConditions.visibilityOf(element));
    }

    public static Boolean waitUntilNotDisplayed(By element) {
        return driverWait.until(ExpectedConditions.invisibilityOfElementLocated(element));

    }

    public void swipeTopToBottomElement(MobileElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        scrollObject.put("element", ((AndroidElement) element).getId());
        js.executeScript("mobile: scroll", scrollObject);
    }


    public static void scrollToAnElement(AndroidDriver driver, String locator) {
        boolean isPresent = false;
        int pressX = driver.manage().window().getSize().width / 2;
        int bottomY = driver.manage().window().getSize().height * 4 / 5;
        int topY = driver.manage().window().getSize().height / 8;
        int i = 0;
        do {
            isPresent = driver.findElements(By.xpath(locator)).size() > 0;
            if (!isPresent) {
                TouchAction touchAction = new TouchAction(driver);
                touchAction.press(PointOption.point(pressX, bottomY)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(2000))).moveTo(PointOption.point(pressX, topY)).release().perform();
            }
            i++;
        } while (i <= 4);
        if (!isPresent) {
            Assert.fail("Unable to scroll to the locator " + locator);
        }
    }

}
