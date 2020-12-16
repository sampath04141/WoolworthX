package woolworth.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProperties {

    public static String deviceName;
    public static String hubUrl;
    public static String hubPort;
    public static String appPackageName;
    public static String appActivity;
    public static String app;

    static {
        readProperties();
    }

    public static void readProperties() {
        Properties prop = readPropertyFile("test.properties");
        deviceName = prop.getProperty("deviceName");
        hubUrl = prop.getProperty("hubUrl");
        hubPort = prop.getProperty("hubPort", "4723");
        appPackageName = prop.getProperty("appPackageName", "nz.govt.nzta.milford");
        appActivity = prop.getProperty("appActivity", "MainActivity");
        app=prop.getProperty("app","myCountdown.apk");

    }


    public static Properties readPropertyFile(String propertyPath) {
        Properties prop = new Properties();
        InputStream input = null;
        try {
            input = new FileInputStream(propertyPath);
            prop.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return prop;
    }
}
