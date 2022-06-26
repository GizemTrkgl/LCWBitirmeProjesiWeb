package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.productPage;
import util.DriverFactory;

public class productPageSteps {
    productPage productPage = new productPage(DriverFactory.getDriver());

    @Then("should see product page")
    public void shouldSeeProductPage() {
        productPage.checkProductPage();
    }
    @When("enter size {string} to search box and click size")
    public void enterSizeToSearchBox(String size) {
        productPage.clickSizeFilter(size);
    }
    @And("enter color {string} to search box and click color text")
    public void enterColorToSearchBox(String color) {
        productPage.clickColorFilter(color);
    }
    @Then("should see filter text")
    public void shouldSeeFilterText() {
        productPage.pageControl();
    }
    @When("select product")
    public void selectProduct() {
        productPage.clickProduct();
    }
    @And("select size {string}")
    public void selectSize(String size) {
        productPage.selectSize(size);
    }
    @And("click add to cart button {string}")
    public void clickAddToCartButton(String button) {
        productPage.clickAddCartButton(button);
    }
    @And("click my cart button")
    public void clickCart() {
        productPage.clickCart();
    }




}
