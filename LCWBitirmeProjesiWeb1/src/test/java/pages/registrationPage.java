package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.ElementHelper;

public class registrationPage {
    By signUpTitle = By.cssSelector(".register .register__title");
    By mailInput = By.cssSelector("input[type=email]");
    By passwordInput = By.cssSelector("input[type=password]");
    By phoneInput = By.cssSelector("input[name=phone]");
    By approveCheckbox = By.cssSelector("input[name=memberPrivacyApprove]");
    By registerBtn = By.cssSelector(".register__button.register__button--blue");
    By timerLabel = By.id("base-timer-label");
    By reg_title = By.cssSelector(".register-successfully .register-successfully--p");
    By errorMessage = By.cssSelector(".input-container .error");
    By goUp = By.cssSelector(".fa.fa-angle-up.fa-2x.btn");
    WebDriver driver;
    WebDriverWait wait;
    ElementHelper elementHelper;

    //Constructor
    public registrationPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.elementHelper = new ElementHelper(driver);
    }
    //Registration page control
    public void checkRegistrationPage(){
        elementHelper.checkElementVisible(signUpTitle);
    }
    //Enter email, password and phone number
    public void enterInputs(String email, String password, String phone){
        elementHelper.sendKey(mailInput, email);
        elementHelper.sendKey(passwordInput, password);
        elementHelper.sendKey(phoneInput, phone);
    }
    //Click approve checkbox
    public void clickCheckbox(){
        elementHelper.click(approveCheckbox);
    }
    //Click register button
    public void clickButton(){
        elementHelper.click(registerBtn);
        elementHelper.click(goUp); //go to the top of the page
    }
    //Timer label control
    public void checkTimerLabel(){
        elementHelper.checkElementVisible(timerLabel);
    }
    //Success registration control
    public void checkRegTitle(String success){
        elementHelper.checkElementWithText(reg_title, success);
    }
    //Error message control
    public void errorMessage(String error){
        elementHelper.checkElementWithText(errorMessage, error);
    }
}
