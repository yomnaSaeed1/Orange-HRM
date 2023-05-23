package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import java.time.Duration;


public class PageBase {

    public WebDriver driver;
    JavascriptExecutor js;

    //Super constructor
    protected PageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void clickButton(By button) {
        waitUntilElementIsClickable(button);
        driver.findElement(button).click();
    }

    public void typeTextInField(By txtField, String txtValue) {
        elementVisible(txtField);
        driver.findElement(txtField).clear();
        driver.findElement(txtField).sendKeys(txtValue);
        System.out.println("Inserted [ " + txtValue + " ] successfully");
    }

    public boolean waitUntilElementIsClickable(By element) {
        return waitFor(ExpectedConditions.elementToBeClickable(element), Duration.ofSeconds(15));
    }

    public boolean elementVisible(By locator) {
        return waitFor(ExpectedConditions.visibilityOfElementLocated(locator), Duration.ofSeconds(15));
    }

    public String getElementText(By locator) {
        elementVisible(locator);
        return driver.findElement(locator).getText();
    }


    public boolean waitFor(ExpectedCondition<?> expectedCondition, Duration duration) {
        try {
            FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
                    .withTimeout(duration)
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class);
            fluentWait.until(expectedCondition);
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    public void waitForPageLoad(WebDriver driver, int timeout) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeout));
    }

    public void scrollToButtom(){
        js = (JavascriptExecutor) driver;
        js.executeScript("scrollBy(0,2000)");


    }

}
