package woolworth.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

public class AccountScreen extends BasePage {
    public AccountScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "nz.co.countdown.android.pickup:id/tv_header")
    private MobileElement AccountTitle;

    @FindBy(xpath = "//android.widget.TextView[@text='Contact us']")
    private MobileElement contactUs;

    @FindBy(xpath = "//android.view.View[@content-desc='onlineshop@countdown.co.nz']/android.widget.TextView")
    private MobileElement emailaddress;

    public void isHomeAccountDisplayed(String expectedResults) {
        waitForElementVisibility(AccountTitle);
        Assert.assertTrue("ListTitle is not display", AccountTitle.getText().equals(expectedResults));
    }

    public void tapBottomElement() {
        scrollToAnElement((AndroidDriver) driver, "//android.widget.TextView[@text='Contact us']");
        waitAndClick(contactUs);
    }

    public void validateContactEmail(String expectedResults) {
        waitForElementVisibility(emailaddress);
        Assert.assertTrue(emailaddress.getText().contains("onlineshop@countdown.co.nz"));
    }
}
