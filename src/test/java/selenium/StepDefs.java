package selenium;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static selenium.SeleniumHelper.*;

public class StepDefs {
    @Given("user opens {string}")
    public void userOpens(String url) {
        navigateHelper(url);
    }

    @When("user enters {string} to {string} area")
    public void userEntersToArea(String input, String area) {
        enterToAreaHelper(input, area);
    }

    @Then("user views {string}")
    public void userViews(String arg0) {
        userViewsHelper(arg0);
    }

    @And("user clicks {string}")
    public void userClicks(String element) {
        userClicks(element);
    }

    @Then("user should see {string} page")
    public void userShouldSeePage(String element) {
        userShouldSeePage(element);
    }
}
