package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartPage;
import util.DriverFactory;

public class cartPageSteps {
    cartPage cartPage = new cartPage(DriverFactory.getDriver());

    @Then("should see cart page")
    public void shouldSeeCartPage() {
        cartPage.checkCartPage();
    }
    @When("check product size {string}")
    public void checkProductSize(String size) {
        cartPage.checkProductSize(size);
    }
    @And("check product name {string}")
    public void checkProductName(String name) {
        cartPage.checkProductName(name);
    }
    @And("check product counter {string}")
    public void checkProductCounter(String counter) {
        cartPage.checkProductCounter(counter);
    }
    @And("click payment button {string}")
    public void clickPaymentButton(String btn) {
        cartPage.clickPaymentButton(btn);
    }
    @Then("should see text {string}")
    public void shouldSeeText(String text) {
        cartPage.checkPage(text);
    }



}
