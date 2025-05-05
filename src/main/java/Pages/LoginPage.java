package Pages;

import Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private final By LoginEmail     = By.id("input-email");
    private final By LoginPassword  = By.id("input-password");
    private final By LoginButton    = By.cssSelector("input[value*='Login']");
    private final By successMessage = By.xpath("//div[@id='content']//h2[1]");
    private final By ErrorMessage   = By.cssSelector("div[class='alert alert-danger alert-dismissible']");

    //Action
    public void EnterEmail(String password) {
        driver.findElement(LoginEmail).sendKeys(password);
    }

    public void EnterPassword(String password) {
        driver.findElement(LoginPassword).sendKeys(password);
    }

    public void ClickLoginButton(){
        driver.findElement(LoginButton).click();
    }

    public void Login(String Email , String Password){
        EnterEmail(Email);
        EnterPassword(Password);
        ClickLoginButton();
    }

    //Assert
    public void assertSuccessfullLogin(){
        WebElement SuccessMessage = Waits.waitForElementToBeVisible(driver, successMessage);

        Assert.assertEquals(SuccessMessage.getText(), "My Account", "Header text doesn't match!");
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/account");
    }

    public void assertLoginErrorMessage(){
        WebElement errorMessageElement = Waits.waitForElementToBeVisible(driver, ErrorMessage);
        String actualMessage = errorMessageElement.getText();

        boolean isInvalidCredentials = actualMessage.contains("No match for E-Mail Address and/or Password.");
        boolean isAccountLocked = actualMessage.contains("Your account has exceeded allowed number of login attempts");

        Assert.assertTrue(isInvalidCredentials || isAccountLocked,
                "Unexpected login error message: " + actualMessage);

        Assert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/account");
    }
}
