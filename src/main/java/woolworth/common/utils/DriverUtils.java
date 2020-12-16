package woolworth.common.utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverUtils {

    public static AppiumDriver<AndroidElement> driver;

    public static void Capabilities() throws MalformedURLException {

        File classpathRoot = new File(System.getProperty("user.dir"));
        File appDir = new File(classpathRoot, "App//");

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Android");

        caps.setCapability(MobileCapabilityType.APP,(new File(appDir, "/"+ProjectProperties.app).getAbsolutePath()));
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ProjectProperties.appActivity);
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, ProjectProperties.appPackageName);
        //caps.setCapability("noReset", true);
        driver = new AndroidDriver<AndroidElement>(new URL("http://"+ProjectProperties.hubUrl+":"+ProjectProperties.hubPort+"/wd/hub"), caps);

    }

    public static AppiumDriver<AndroidElement> getDriver(){
        return driver;
    }


    public static void closeDriver(){
        driver.closeApp();
        driver.quit();
    }
}