package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class homePage {
    By popup = By.cssSelector("#cookieseal-banner button:nth-child(3)");
    By header = By.cssSelector(".header.header--high .header__top ");
    By loginLabel = By.cssSelector("a[href=\"https://www.lcwaikiki.com/tr-TR/TR/giris\"].header-dropdown-toggle .dropdown-label");
    By signUpButton = By.cssSelector("div.cart-action .cart-action__btn.cart-action__btn--bg-white");
    By loginButton = By.cssSelector(".user-wrapper .cart-dropdown  .dropdown-label");
    By menu = By.cssSelector("a[href=\"https://www.lcwaikiki.com/tr-TR/TR/lp/32-33-kadin\"]");
    By list = By.cssSelector(".zone-header a[href=\"/tr-TR/TR/kadin/giyim\"]");
    By item = By.cssSelector("a.zone-item__anchor[href=\"/tr-TR/TR/kategori/kadin/bluz\"]");

    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Constructor
    public homePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }
    // Home page control and close popup
    public void checkHomePage() {
        elementHelper.checkElementPresence(header);
        elementHelper.clickPopup(popup);
        //for scroll up
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0, -1500);");
    }
    //Click on the sub-element signup
    public void clickSignUpButton(String element, String subElement) {
        elementHelper.clickUnderElement(loginLabel, signUpButton, element, subElement);
    }
    //Click login button
    public void clickLoginButton(String logButton) {
        elementHelper.clickElementWithText(loginButton, logButton);
    }

    //Find and click sub-element
    public void selectProductType(String menuText, String listText, String itemText) {
        elementHelper.clickSecondSubElement(menu, list, item, menuText, listText, itemText);
    }
}











