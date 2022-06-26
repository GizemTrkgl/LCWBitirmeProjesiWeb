package util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;

public class ElementHelper {
    WebDriver driver;
    WebDriverWait wait;
    Actions action;

    public ElementHelper(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        this.action = new Actions(driver);
    }

    /**
     * @param key
     * @return
     */
    public WebElement findElement(By key) {
        WebElement element = presenceElement(key);
        scrollToElement(element);
        return element;
    }

    /**
     * @param key
     * @return
     */
    public List<WebElement> findElements(By key) {
        List<WebElement> elements = presenceElements(key);
        scrollToElement(elements.get(0));
        return elements;
    }
    /**
     * @param key
     */
    public void click(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        findElement(key).click();
    }
    /**
     * @param key
     */
    public void clickPopup(By key) {
        boolean check=false;
        if(driver.findElement(key).isDisplayed()){
            findElement(key).click();
            check=true;
        }
        if  (check == false) {
            Assert.fail();
        }
    }
    /**
     * @param key
     * @return
     */
    public List<WebElement> clickElementFromList(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        List<WebElement> resultsList = driver.findElements(key);
        resultsList.get(0).click();
        return resultsList;
    }

    /**
     * @param key
     * @param text
     */
    public void sendKey(By key, String text) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        findElement(key).sendKeys(text);
    }

    /**
     * @param key
     * @param text
     * @return
     */
    public boolean checkElementText(By key, String text) {
        return wait.until(ExpectedConditions.textToBe(key, text));
    }

    /**
     * @param key
     */
    public void checkElementVisible(By key) {
        wait.until(ExpectedConditions.visibilityOf(findElement(key)));
    }

    /**
     *
     * @param key
     */
    public void checkElementPresence(By key) {
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }

    /**
     * @param key
     * @param text
     */
    public void clickElementWithText(By key, String text) {
        boolean find = false;
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                element.click();
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }

    /**
     * @param key
     * @param text
     */
    public void checkElementWithText(By key, String text) {
        boolean find = false;
        wait.until(ExpectedConditions.presenceOfElementLocated(key));
        List<WebElement> elements = findElements(key);
        for (WebElement element : elements) {
            if (element.getText().contains(text)) {
                find = true;
                break;
            }
        }
        Assert.assertEquals(true, find);
    }
    /**
     * @param key
     * @return
     */
    public WebElement presenceElement(By key) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(key));
    }
    /**
     * @param key
     * @return
     */
    public List<WebElement> presenceElements(By key) {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(key));
    }

    /**
     * @param element
     */
    public void scrollToElement(WebElement element) {
        String scrollElementIntoMiddle = "var viewPortHeight = Math.max(document.documentElement.clientHeight, window.innerHeight || 0);"
                + "var elementTop = arguments[0].getBoundingClientRect().top;"
                + "window.scrollBy(0, elementTop-(viewPortHeight/2));";
        ((JavascriptExecutor) driver).executeScript(scrollElementIntoMiddle, element);

    }
    /**
     *
     * @param element
     * @param under
     * @param text
     */
    public void clickUnderElement(By element, By under, String text, String text1) {
        boolean find = false;
        wait.until(ExpectedConditions.presenceOfElementLocated(element));
        List<WebElement> elements = findElements(element);
        for (WebElement elem : elements) {
            if (elem.getText().contains(text)) {
                Actions action = new Actions(driver);
                WebElement mainmenu = driver.findElement(element);
                wait.until(ExpectedConditions.presenceOfElementLocated(element));
                action.moveToElement(mainmenu).build().perform();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                List<WebElement> elements2 = driver.findElements(under);
                for (WebElement elem2 : elements2) {
                    if (elem2.getText().contains(text1)) {
                        WebElement secSub = driver.findElement(under);
                        wait.until(ExpectedConditions.presenceOfElementLocated(under));
                        action.moveToElement(secSub).click().perform();
                        find = true;
                        break;
                    }
                }
            }
        }
        Assert.assertEquals(true, find);
    }
    /**
     *
     * @param element
     * @param firstUnderElement
     * @param secUnderElement
     * @param textElm
     * @param textFirstSub
     * @param textSecSub
     *
     */
    public void clickSecondSubElement(By element, By firstUnderElement, By secUnderElement, String textElm, String textFirstSub, String textSecSub) {
        boolean find = false;
        List<WebElement> elements = driver.findElements(element);
        for (WebElement elem : elements) {
            if (elem.getText().contains(textElm)) {
                Actions action = new Actions(driver);
                WebElement mainmenu = driver.findElement(element);
                wait.until(ExpectedConditions.presenceOfElementLocated(element));
                action.moveToElement(mainmenu).build().perform();
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                List<WebElement> elements1 = driver.findElements(firstUnderElement);
                for (WebElement elem1 : elements1) {
                    if (elem1.getText().contains(textFirstSub)) {
                        WebElement firstSub = driver.findElement(firstUnderElement);
                        wait.until(ExpectedConditions.presenceOfElementLocated(firstUnderElement));
                        action.moveToElement(firstSub).build().perform();
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        List<WebElement> elements2 = driver.findElements(secUnderElement);
                        for (WebElement elem2 : elements2) {
                            if (elem2.getText().contains(textSecSub)) {
                                WebElement secSub = driver.findElement(secUnderElement);
                                wait.until(ExpectedConditions.presenceOfElementLocated(secUnderElement));
                                action.moveToElement(secSub).click().perform();
                                find = true;
                                break;
                            }
                        }
                        Assert.assertEquals(true, find);
                    }
                }
            }
        }
    }
}
