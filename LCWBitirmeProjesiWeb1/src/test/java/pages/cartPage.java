package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class cartPage {

    By selectedProductName = By.cssSelector(".rd-cart-item-title");
    By checkText = By.cssSelector(".keep-shopping-label");
    By selectedSize = By.cssSelector(".rd-cart-item-size");
    By cartCounter = By.cssSelector(".col-md-12.cart-header.mb-20 span:nth-child(1)");
    By paymentButton = By.cssSelector("#ShoppingCartContent > div:nth-child(4) > div.col-md-4.desktop-price-info > div.col-md-12.pl-20.pr-20 > a");
    By textCheckoutPage = By.cssSelector(".text-left.sectionTitleBottomMargin .sectionTitle");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Constructor
    public cartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }

    //Cart page control
    public void checkCartPage(){
        elementHelper.checkElementVisible(checkText);
    }
    //Product size control
    public void checkProductSize(String size){
        elementHelper.checkElementWithText(selectedSize, size);
    }
    //Product code control
    public void checkProductName(String name){
        elementHelper.checkElementWithText(selectedProductName,name);
    }
    //Product counter control
    public void checkProductCounter(String counter){
        elementHelper.checkElementWithText(cartCounter,counter);
    }
    //Click payment button
    public void clickPaymentButton(String button){
        elementHelper.clickElementWithText(paymentButton, button);
    }
    //Checkout page control
    public void checkPage(String text){
        elementHelper.checkElementText(textCheckoutPage, text);
    }

}
