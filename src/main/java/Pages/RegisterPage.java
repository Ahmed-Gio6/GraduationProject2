package Pages;

import Utilities.TestDataReader;
import Utilities.Waits;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;


import java.util.Map;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }
    SoftAssert softAssert = new SoftAssert();


    Map<String, String> data = TestDataReader.getTestData("src/main/resources/RegisterData.json");

    //Locators
    private final By FirstNameField = By.id("input-firstname");
    private final By LastNameField = By.id("input-lastname");
    private final By EmailTextField = By.id("input-email");
    private final By TelephoneTextField = By.id("input-telephone");
    private final By PasswordField = By.id("input-password");
    private final By ConfirmPasswordField = By.id("input-confirm");
    private final By YesOption = By.cssSelector("input[name*='newsletter'][value='1']");
    private final By newsletter_Yes_RadioButton = By.cssSelector("input[name='newsletter'][value='1']");
    private final By newsletter_No_RadioButton = By.cssSelector("input[name='newsletter'][value='0']");
    private final By PrivacyCheck = By.cssSelector("input[name*='agree'][value='1']");
    private final By ContinueButton = By.cssSelector("input[value*='Continue']");
    private final By successMessage = By.xpath("//h1[contains(text(), 'Your Account Has Been Created!')]");
    private final By EmailRegisteredError = By.cssSelector("div.alert.alert-danger.alert-dismissible");
    private final By ErrorMessage = By.className("text-danger");
    private final By firstNameEmptyError = By.cssSelector("#input-firstname + div.text-danger");
    private final By LastNameEmptyError = By.cssSelector("#input-lastname+ div.text-danger");
    private final By EmailEmptyError = By.cssSelector("#input-email + div.text-danger");
    private final By TelephoneEmptyError = By.cssSelector("#input-telephone + div.text-danger");
    private final By ConfirmEmptyError = By.cssSelector("#input-confirm + div.text-danger");
    private final By PasswordEmptyError = By.cssSelector("#input-password + div.text-danger");


    public static String generateRandomEmail() {
        long timestamp = System.currentTimeMillis();
        return "user" + timestamp + "@test.com";
    }
    public void EnterFirstName(String firstName){
        driver.findElement(FirstNameField).sendKeys(firstName);
    }
    public void EnterLastName(String lastName){
        driver.findElement(LastNameField).sendKeys(lastName);
    }
    public void EnterEmail(String email){
        if (email.equalsIgnoreCase("random")) {
            email = generateRandomEmail();
        }
        driver.findElement(EmailTextField).sendKeys(email);
    }
    public void EnterTelephone(String telephone){
        driver.findElement(TelephoneTextField).sendKeys(telephone);
    }
    public void EnterPassword(String password) {
        driver.findElement(PasswordField).sendKeys(password);
    }
    public void EnterConfirmPassword(String confirmPassword){
        driver.findElement(ConfirmPasswordField).sendKeys(confirmPassword);
    }
    public void ClickYesOption(){
        driver.findElement(YesOption).click();
    }
    public void ClickNewsletterYesRadioButton(){
        driver.findElement(newsletter_Yes_RadioButton).click();
    }
    public void ClickNewsletterNoRadioButton(){
        driver.findElement(newsletter_No_RadioButton).click();
    }
    public void ClickPrivacyCheck(){
        driver.findElement(PrivacyCheck).click();
    }
    public void ClickContinueButton(){
        driver.findElement(ContinueButton).click();
    }

    public void RegisterNewUser(String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
        EnterFirstName(firstName);
        EnterLastName(lastName);
        EnterEmail(email);
        EnterTelephone(telephone);
        EnterPassword(password);
        EnterConfirmPassword(confirmPassword);
        ClickNewsletterYesRadioButton();
        ClickPrivacyCheck();
        ClickContinueButton();
    }

    public void RegisterNewUserWithoutPrivacyCheck(String firstName, String lastName, String email, String telephone, String password, String confirmPassword){
        EnterFirstName(firstName);
        EnterLastName(lastName);
        EnterEmail(email);
        EnterTelephone(telephone);
        EnterPassword(password);
        EnterConfirmPassword(confirmPassword);
        ClickNewsletterYesRadioButton();
        /*ClickPrivacyCheck();*/
        ClickContinueButton();
    }


    public void assertSuccessfullRegister(){
        WebElement SuccessMessage = Waits.waitForElementToBeVisible(driver, successMessage);

        Assert.assertTrue(SuccessMessage.isDisplayed(), "Welcome message is not displayed.");
        Assert.assertEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
    }
/*
    public void assertRegisterInvalidName(){
        WebElement SuccessMessage = Waits.waitForElementToBeVisible(driver, successMessage);

        Assert.assertFalse(SuccessMessage.isDisplayed(), "Welcome message is not displayed.");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
    }/*
softAssert.assertEquals(BrowserAction.getAlertText(driver), "Sign up successful.");
        BrowserAction.acceptAlert(driver);
        softAssert.assertAll();*//*
    public void assertRegisterRepeatedEmail(){
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver,EmailRegisteredError);

        Assert.assertTrue(emailRegisteredError.isDisplayed(), "Warning: E-Mail Address is already registered!");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
    }

    public void assertRegisterInvalidEmail(){
        WebElement emailField = driver.findElement(By.name("email"));
        String validationMessage = emailField.getAttribute("validationMessage");
        Assert.assertEquals(validationMessage, "Please include an '@' in the email address. '"+ data.get("emailInValid") +"' is missing an '@'.");
        Assert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
    }*/

    public void assertRegisterInvalidName() {
        WebElement SuccessMessage = Waits.waitForElementToBeVisible(driver, successMessage);
        softAssert.assertFalse(SuccessMessage.isDisplayed(), "Welcome message is not displayed.");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();
    }

    public void assertRegisterInvalidTelephoneNum() {
        WebElement SuccessMessage = Waits.waitForElementToBeVisible(driver, successMessage);
        softAssert.assertFalse(SuccessMessage.isDisplayed(), "Welcome message is not displayed.");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();
    }

    public void assertRegisterRepeatedEmail() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, EmailRegisteredError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "Warning: E-Mail Address is already registered!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();

    }

    public void assertRegisterInvalidEmail() {
        WebElement emailField = driver.findElement(By.name("email"));
        String validationMessage = emailField.getAttribute("validationMessage");

        softAssert.assertEquals(validationMessage, "Please include an '@' in the email address. '" + data.get("emailInValid") + "' is missing an '@'.");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();

    }

    public void assertRegisterInvalidConfirmPassword() {
        WebElement errorMessage = driver.findElement(ErrorMessage);
        softAssert.assertTrue(errorMessage.isDisplayed(), "Password confirmation does not match password!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();

    }

    public void assertRegisterWithoutPrivacyCheck() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, EmailRegisteredError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "Warning: You must agree to the Privacy Policy!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();

    }

    public void assertRegisterWithFirstNameEmptyField() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, firstNameEmptyError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "First Name must be between 1 and 32 characters!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();

    }

    public void assertRegisterWithLastNameEmptyField() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, LastNameEmptyError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "First Name must be between 1 and 32 characters!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();

    }

    public void assertRegisterWithEmailEmptyField() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, EmailEmptyError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "E-Mail Address does not appear to be valid!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();
    }

    public void assertRegisterWithTelephoneEmptyField() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, TelephoneEmptyError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "Telephone must be between 3 and 32 characters!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();
    }

    public void assertRegisterWithPasswordEmptyField() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, PasswordEmptyError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "Password must be between 4 and 20 characters!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();
    }

    public void assertRegisterWithPasswordconfirmationField() {
        WebElement emailRegisteredError = Waits.waitForElementToBeVisible(driver, ConfirmEmptyError);
        softAssert.assertTrue(emailRegisteredError.isDisplayed(), "Password confirmation does not match password!");
        softAssert.assertNotEquals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success");
        softAssert.assertAll();
    }

}
