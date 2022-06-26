package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class productPage {
    By checkPageText = By.cssSelector(".dropdown-button.desktop-list-options-bar__sort-select-button .dropdown-button__button");
    By sizeSearchBox = By.cssSelector("input[placeholder=\"Beden Ara\"]");
    By sizeButton = By.cssSelector(".collapsible-filter-container__content-area.collapsible-filter-container__content-area--size-filter div:nth-child(2) .lcw-checkbox");
    By colorSearchBox = By.cssSelector("input[placeholder=\"Renk Ara\"]");
    By colorButton = By.cssSelector("[src=\"http://akstatic.lcwaikiki.com/Resource/Images/icon/siyah.png\"]");
    By pageControl = By.cssSelector(".applied-filters__applied-filter .applied-filters__value");
    By productList = By.cssSelector(".product-list__content-area .product-grid");
    By size = By.cssSelector("#option-size [size=\"M\"]");
    By btnAddToCart = By.cssSelector("#pd_add_to_cart.add-to-cart.button-link.add-to-cart-button");
    By btnMyCart = By.id("shopping-cart");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Constructor
    public productPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }
    //Product page control
    public void checkProductPage(){
        elementHelper.checkElementVisible(checkPageText);
    }
    //Select size on filter
    public void clickSizeFilter(String size){
        elementHelper.sendKey(sizeSearchBox, size);
        elementHelper.click(sizeButton);
    }
    //Select color on filter
    public void clickColorFilter(String color){
        elementHelper.sendKey(colorSearchBox, color);
        elementHelper.click(colorButton);
    }
    public void pageControl(){
        elementHelper.checkElementVisible(pageControl);
    }
    //select product
    public void clickProduct(){
        elementHelper.clickElementFromList(productList);
    }
    //Select product's size
    public void selectSize(String sizeText){
        elementHelper.clickElementWithText(size, sizeText);
    }
    //Add selected product to cart
    public void clickAddCartButton(String button){
        elementHelper.clickElementWithText(btnAddToCart, button);
    }
    //Go to myCart
    public void clickCart(){
        elementHelper.click(btnMyCart);
    }

}
