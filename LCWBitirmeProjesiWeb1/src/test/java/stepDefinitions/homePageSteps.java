package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.homePage;
import util.DriverFactory;

public class homePageSteps {
    homePage homePage = new homePage(DriverFactory.getDriver());

    @Given("user is on home page")
    public void userIsHomePage() {
        homePage.checkHomePage();
    }
    @When("mouse over {string} and click {string}")
    public void mouseOverAndClick(String textLogin, String textSignUp) {
        homePage.clickSignUpButton(textLogin, textSignUp);
    }
    @When("click login button {string}")
    public void clickLoginButton(String loginButton) {
        homePage.clickLoginButton(loginButton);
    }
    @Then("should see home page")
    public void shouldSeeHomePage() {
        homePage.checkHomePage();
    }
    @When("mouse over {string} Kadın,{string} Giyim and click Bluz {string}")
    public void mouseOverKadınGiyimAndClickBluz(String list, String menu, String item) {
        homePage.selectProductType(list, menu, item);
    }


}
