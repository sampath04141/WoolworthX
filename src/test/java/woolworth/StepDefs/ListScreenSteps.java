package woolworth.StepDefs;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import woolworth.PageObjects.ListScreen;
import woolworth.common.utils.DriverUtils;

public class ListScreenSteps {

    private ListScreen listScreen = null;

    @When("^I tap add item button$")
    public void i_tap_add_item_button() throws Throwable {
        if(listScreen == null){
            listScreen = new ListScreen(DriverUtils.getDriver());
        }
        listScreen.isListTitleDisplayed("Shopping list");
        listScreen.tapAddItemToYOurList();
    }

    @When("^I add \"([^\"]*)\" to the list$")
    public void i_add_to_the_list(String item) throws Throwable {
        listScreen.addItemToYOurList(item);
        listScreen.closeItemAddButton();
    }

    @Then("^I can see \"([^\"]*)\" in the list$")
    public void i_can_see_in_the_list(String expectedResults) throws Throwable {
        listScreen.validateListItems(expectedResults);
    }

    @When("^I add \"([^\"]*)\",\"([^\"]*)\" to the list$")
    public void i_add_two_item_to_the_list(String item1,String item2) throws Throwable {
        listScreen.addItemToYOurList(item1,item2);
    }

    @Then("^I can see \"([^\"]*)\",\"([^\"]*)\" in the list$")
    public void i_can_see_two_Item_in_the_list(String ex1,String ex2) throws Throwable {
        listScreen.validateListItems(ex1,ex2);
    }

}
