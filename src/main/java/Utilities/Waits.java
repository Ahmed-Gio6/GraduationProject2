package Utilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

public class Waits {

    //present - visible - clickable
    //wait for element to be present

    public static WebElement waitForElementToBePresent(WebDriver driver, By locator) {

        return new WebDriverWait(driver , Duration.ofSeconds(1)).
                until(driver1 -> driver1.findElement(locator));

    }

    //Wait for element to be visible

    public static WebElement waitForElementToBeVisible(WebDriver driver, By locator) {
        return new WebDriverWait(driver , Duration.ofSeconds(1)).
                until(driver1->{
                    WebElement element = waitForElementToBePresent(driver1, locator);
                    return element.isDisplayed()? element : null;
                });
    }

    //Wait for element clicable

    public static WebElement waitForElementToBeClickable(WebDriver driver, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

}