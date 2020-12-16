package woolworth.common.utils;

import org.junit.Assert;
import org.openqa.selenium.By;

public class Helper {
    /**
     * Just packaged implicit wait option
     * @param mills
     * @throws InterruptedException
     */
    public static void sleep(long mills){
        try {
            Thread.sleep(mills);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    /**
     * waits for the xpath element to be present (as clickable and presence sometimes fail)
     * to click.
     * @param xpath
     * @param sleepTime
     * @throws InterruptedException
     */
    public static void waitForElementCountByXPath(String xpath, long sleepTime){
        int i=1;
        while(DriverUtils.getDriver().findElements(By.xpath(xpath)).size() == 0){
            sleep(sleepTime);
            i++;
            if(i>20){
                Assert.fail("Unable to find the element by the xpath "+xpath);
            }
        }
        sleep(1000);
    }


    public static void hideAndroidKeyBoard(){
        DriverUtils.getDriver().hideKeyboard();
    }

}
