package woolworth.StepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import woolworth.PageObjects.AccountScreen;
import woolworth.common.utils.DriverUtils;

public class AccountSteps {

    private AccountScreen accountScreen = null;

    @When("^I scroll down to see the \"([^\"]*)\"$")
    public void i_scroll_down_to_see_the(String contactUs) throws Throwable {
        if (accountScreen == null) {
            accountScreen = new AccountScreen(DriverUtils.getDriver());
        }
        accountScreen.isHomeAccountDisplayed("Account");
        accountScreen.tapBottomElement();
    }

    @Then("^I can see \"([^\"]*)\" email address$")
    public void i_can_see_email_address(String expectedResults) throws Throwable {
        accountScreen.validateContactEmail(expectedResults);
    }
}
