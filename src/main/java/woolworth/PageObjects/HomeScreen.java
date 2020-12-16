package woolworth.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;


public class HomeScreen extends BasePage {

    @FindBy(id = "skipView")
    private MobileElement skip;

    @FindBy(id = "iv_header")
    private MobileElement title;

    @FindBy(id = "largeLabel")
    private MobileElement homeIcon;

    @FindBy(id = "webShopTitle")
    private MobileElement onlineShopTitle1;

    @FindBy(id = "webShopDescription")
    private MobileElement webShopDescription;

    @FindBy(id = "textViewDeliveryLabel")
    private MobileElement webShopDelivery;

    @FindBy(id = "textViewPickUpLabel")
    private MobileElement webShopPickup;

    @FindBy(xpath = "//android.widget.TextView[@text='Specials']")
    private MobileElement specialIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='List']")
    private MobileElement listIcon;

    @FindBy(xpath = "//android.widget.TextView[@text='Account']")
    private MobileElement accountIcon;

    public HomeScreen(AppiumDriver driver) {
        super(driver);
    }

    public void isHomeTitleDisplayed() {
        waitAndClick(skip);
        waitForElementVisibility(title);
        Assert.assertTrue("Cannot display title", title.isDisplayed() == true);

    }

    public void tapHomeIcon(String icon) {
        switch (icon) {
            case "Home":
                waitAndClick(homeIcon);
                break;
            case "List":
                waitAndClick(listIcon);
                break;
            case "Special":
                waitAndClick(specialIcon);
                break;
            default:
                waitAndClick(accountIcon);
                break;
        }
    }

    public void validateShopOnlineText(String expected) {
        if (expected.equalsIgnoreCase("Shop Online"))
            Assert.assertTrue(expected + "- Text cannot visible", onlineShopTitle1.getText().equals(expected));
        else if (expected.contains("your way"))
            Assert.assertTrue(expected + "- Text cannot visible", webShopDescription.getText().equals(expected));
        else if (expected.equalsIgnoreCase("Delivery"))
            Assert.assertTrue(expected + "- Text cannot visible", webShopDelivery.getText().equals(expected));
        else
            Assert.assertTrue(expected + "- Text cannot visible", webShopPickup.getText().equals(expected));
    }
}
