package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.registrationPage;
import util.DriverFactory;

public class registrationPageSteps {
    registrationPage registrationPage = new registrationPage(DriverFactory.getDriver());
    @Then("should see registration page")
    public void shouldSeeRegistrationPage() {
        registrationPage.checkRegistrationPage();
    }

    @When("type Email {string}, Password {string}, phone number {string}")
    public void typeEmailPasswordPhoneNumber(String email, String password, String phoneNumber) {
        registrationPage.enterInputs(email,password,phoneNumber);
    }
    @And("click approve checkbox")
    public void clickCheckboxOfAgreementAndClickSignUpButton() {
        registrationPage.clickCheckbox();
    }
    @And("click sign up button")
    public void clickRegistrationButton() {
        registrationPage.clickButton();
    }
    @Then("should see phone code box")
    public void shouldSeePhoneCodeBox() {
        registrationPage.checkTimerLabel();
    }
    @Then("should see {string} success registration title")
    public void shouldSeeSuccessRegistrationTitle(String success) {
        registrationPage.checkRegTitle(success);
    }
    @Then("should see {string} error message")
    public void shouldSeeErrorMessage(String error) {
        registrationPage.errorMessage(error);
    }
}
