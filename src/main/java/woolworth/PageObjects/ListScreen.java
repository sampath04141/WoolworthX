package woolworth.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ListScreen extends BasePage {

    public ListScreen(AppiumDriver driver) {
        super(driver);
    }

    @FindBy(id = "tv_header")
    private MobileElement listTitle;

    @FindBy(id = "nz.co.countdown.android.pickup:id/fab_add")
    private MobileElement addListItemToYourList;

    @FindBy(id = "et_itemList")
    private MobileElement typeListItem;

    @FindBy(id = "btn_submit")
    private MobileElement addButton;

    @FindBy(id = "nz.co.countdown.android.pickup:id/fab_add")
    private MobileElement closeButton;

    private String itemSelectBox = "//android.widget.CheckedTextView[@text='%s']";

    @FindBy(xpath = "//android.widget.TextView[@resource-id='nz.co.countdown.android.pickup:id/checkbox']")
    private List<MobileElement> items;


    public void isListTitleDisplayed(String expectedResults) {
        waitForElementVisibility(listTitle);
        Assert.assertTrue("ListTitle is not display", listTitle.getText().equals(expectedResults));
    }

    public void tapAddItemToYOurList() {
        waitAndClick(addListItemToYourList);
    }

    public void addItemToYOurList(String item) {
        type(typeListItem, item);
        waitAndClick(addButton);
        // String eleText=String.format(itemSelectBox,item);
        // MobileElement  ele = (MobileElement) driver.findElements(By.xpath(eleText));
        // waitAndClick((MobileElement) driver.findElements(By.xpath(eleText)));
    }

    public void closeItemAddButton() {
        waitAndClick(closeButton);
    }

    public void validateListItems(String isItemExist) {
        Assert.assertTrue(isItemExist(isItemExist));
    }

    public boolean isItemExist(String expectedResults) {
        boolean itemExist = false;
        for (MobileElement item : items) {
            waitForElementVisibility(item);
            if (item.getText().contains(expectedResults)) {
                itemExist = true;
            }
        }
        return itemExist;
    }

    public void addItemToYOurList(String item1, String item2) {
        addItemToYOurList(item1);
        addItemToYOurList(item2);
        closeItemAddButton();
    }

    public void validateListItems(String ex1, String ex2) {
        validateListItems(ex1);
        validateListItems(ex2);
    }
}
