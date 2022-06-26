package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.loginPage;
import util.DriverFactory;

public class loginPageSteps {

    loginPage loginPage = new loginPage(DriverFactory.getDriver());

    @Then("should see login page")
    public void shouldSeeLoginPage() {
        loginPage.checkLoginPage();
    }
    @When("type Email {string}, Password {string}")
    public void typeEmailPassword(String email, String pass) {loginPage.inputSend(email,pass);}
    @And("click button")
    public void clickButton() {loginPage.clickButton();}
    @Then("should see {string}")
    public void shouldSee(String text) {
        loginPage.checkSuccessLoginPage(text);
    }
    @Then("user should see error message {string}")
    public void userShouldSeeErrorMessage(String error) {
        loginPage.invalidLogin(error);
    }
}
