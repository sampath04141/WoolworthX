package woolworth.StepDefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import woolworth.PageObjects.HomeScreen;
import woolworth.common.utils.DriverUtils;

public class HomeSteps {
    private HomeScreen homescreen = null;

    @Given("^that the application has loaded$")
    public void thatTheApplicationHasLoaded() throws InterruptedException{
        if(homescreen == null){
            homescreen = new HomeScreen(DriverUtils.getDriver());
        }
        homescreen.isHomeTitleDisplayed();

    }
    @When("^I tap \"([^\"]*)\"$")
    public void i_tap(String icon) throws Throwable {
        homescreen.tapHomeIcon(icon);
    }

    @Then("^I can see \"([^\"]*)\" text$")
    public void i_can_see_text(String expected) throws Throwable {
        homescreen.validateShopOnlineText(expected);
    }


}
