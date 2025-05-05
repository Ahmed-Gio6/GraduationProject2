package Pages;

import Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;



public class HomePage {
    WebDriver driver;


    public HomePage(WebDriver driver){
        this.driver = driver;
    }

    //Locators
    private final By myAccount_Dropdown = By.xpath("//a[@class='dropdown-toggle' and @title='My Account']");
    private final By RegisterOption = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=account/register']");
    private final By LoginOption = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=account/login']");
    private final By Logout = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=account/logout']");
    private final By Continue_btn = By.xpath("//a[@href='https://awesomeqa.com/ui/index.php?route=common/home']");
    private final By Continue_btn1 = By.xpath("//a[@href=https://awesomeqa.com/ui/index.php?route=account/login']");
    private final By ReturnBtn = By.className("img-responsive");

    public void navigate(){
        driver.get("https://awesomeqa.com/ui/index.php?route=common/home");
    }

    public void clickOnMyAccount(){
        driver.findElement(myAccount_Dropdown).click();
    }

    public void clickOnRegister(){
        driver.findElement(RegisterOption).click();
    }

    public void clickOnLogout(){
        driver.findElement(Logout).click();
    }
    public void clickOnContinue(){
        WebElement Continue_btnL = Waits.waitForElementToBeClickable(driver, Continue_btn);
        Continue_btnL.click();
    }

    public void clickOnContinue1(){
        WebElement Continue_btnL1 = Waits.waitForElementToBeClickable(driver, Continue_btn1);
        Continue_btnL1.click();
    }
    public void clickOnReturn(){
        WebElement ReturnBtnC = Waits.waitForElementToBeClickable(driver, ReturnBtn);
        ReturnBtnC.click();
    }

    public void goToRegisterPage(){
        navigate();
        clickOnMyAccount();
        clickOnRegister();
    }

    public void ContinueToRegister()
    {

        clickOnReturn();
        try {
            clickOnMyAccount();
            clickOnLogout();
            clickOnContinue();
        }catch (Exception e){
            System.out.println("Error");
        }

    }


    //Login

    public void clickOnLogin(){
        driver.findElement(LoginOption).click();
    }

    public void goToLogin(){
        navigate();
        clickOnMyAccount();
        clickOnLogin();
    }


}
