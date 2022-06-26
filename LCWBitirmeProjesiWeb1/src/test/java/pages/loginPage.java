package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class loginPage {
    By loginTitle = By.cssSelector(".login-form .login-form__title");
    By mailText = By.cssSelector("[name=email]");
    By passwordText = By.cssSelector("[name=password]");
    By loginButton = By.cssSelector("button[type=submit]");
    By checkLogin = By.cssSelector(".header-dropdown-toggle.striped-button .dropdown-label");
    By errorMessage = By.cssSelector(".login-form__header-errors .login-form__header-errors--p");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Constructor
    public loginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }
    //Login page control
    public void checkLoginPage(){
        elementHelper.checkElementPresence(loginTitle);
    }
    //Enter email and password
    public void inputSend(String email, String pass){
        elementHelper.sendKey(mailText,email);
        elementHelper.sendKey(passwordText,pass);
    }
    //Click login button
    public void clickButton(){
        elementHelper.click(loginButton);
    }
    //Correct page control
    public void checkSuccessLoginPage(String text){
        elementHelper.checkElementWithText(checkLogin, text);
    }
    //Error message control
    public void invalidLogin(String error){
        elementHelper.clickElementWithText(errorMessage,error);
    }
}
