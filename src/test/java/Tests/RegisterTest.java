package Tests;
import Pages.LoginPage;
import Utilities.ScreenShot;
import Base.TestBase;
import Pages.HomePage;
import Pages.RegisterPage;
import Utilities.ScreenShot;
import Utilities.TestDataReader;
import jdk.jfr.Description;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.util.Map;
import java.util.Objects;

public class RegisterTest extends TestBase {

    HomePage homePage;
    RegisterPage registerPage;
    LoginPage loginPage;
    Map<String, String> data = TestDataReader.getTestData("src/main/resources/RegisterData.json");

    @AfterMethod
    void GoToReg(ITestResult testResult){
        if (ITestResult.FAILURE == testResult.getStatus()) {
            ScreenShot.ScreenShoots(driver,testResult.getName() );
        }
        if(Objects.equals(driver.getCurrentUrl(), "https://awesomeqa.com/ui/index.php?route=account/success")) {
            homePage.ContinueToRegister();
        }
    }

    @Description("Validate that user can register with valid data")
    @Test
    public void validateRegisterNewUser(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmValid"));
        registerPage.assertSuccessfullRegister();

    }

    @Description("Validate that user can register with invalid firstName")
    @Test
    public void validateRegisterwithInvalidFirstname(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameInValid"),data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmValid"));
        registerPage.assertRegisterInvalidName();
    }

    @Description("Validate that user can register with invalid LastName")
    @Test
    public void validateRegisterwithInvalidLastname(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameValid"),data.get("lastNameInValid"),
                data.get("emailValid"),data.get("telephoneValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmValid"));
        registerPage.assertRegisterInvalidName();

    }


    @Description("Validate that user can register with Repeated Email")
    @Test
    public void validateRegisterwithRepeatedEmail(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameValid"),data.get("lastNameInValid"),
                data.get("emailRepeated"),data.get("telephoneValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmValid"));
        registerPage.assertRegisterRepeatedEmail();
    }

    @Description("Validate that user can register with Invalid Email")
    @Test
    public void validateRegisterwithInvalidEmail(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameValid"),data.get("lastNameInValid"),
                data.get("emailInValid"),data.get("telephoneValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmValid"));
        registerPage.assertRegisterInvalidEmail();
    }

    @Description("Validate that user can register with invalid TelephoneNumber")
    @Test
    public void validateRegisterwithInvalidTelephoneNumber(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneInValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmValid"));

        registerPage.assertRegisterInvalidTelephoneNum();
    }


    @Description("Validate that user can register with invalid ConfirmPass")
    @Test
    public void validateRegisterwithInvalidConfirmPass(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUser(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneInValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmInValid"));

        registerPage.assertRegisterInvalidConfirmPassword();
    }

    @Description("Validate that user can register Without PrivacyCheck")
    @Test
    public void validateRegisterwithoutPrivacyCheck(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneInValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmInValid"));

        registerPage.assertRegisterWithoutPrivacyCheck();
    }

    @Description("Validate that user register With FirstName EmptyField")
    @Test
    public void validateRegisterwithFirstNameEmptyField(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck("",data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneInValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmInValid"));
        registerPage.assertRegisterWithFirstNameEmptyField();
    }

    @Description("Validate that user register With LastName EmptyField")
    @Test
    public void validateRegisterwithLastNameEmptyField(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck(data.get("firstNameValid"),"",
                data.get("emailValid"),data.get("telephoneInValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmInValid"));
        registerPage.assertRegisterWithLastNameEmptyField();
    }

    @Description("Validate that user register With Email EmptyField")
    @Test
    public void validateRegisterwithEmailEmptyField(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck(data.get("firstNameValid"),data.get("lastNameValid"),
                "",data.get("telephoneInValid"),data.get("PasswordValid"),
                data.get("PasswordConfirmInValid"));
        registerPage.assertRegisterWithEmailEmptyField();
    }

    @Description("Validate that user register With Telephone EmptyField")
    @Test
    public void validateRegisterwithTelephoneEmptyField(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),"",data.get("PasswordValid"),
                data.get("PasswordConfirmInValid"));
        registerPage.assertRegisterWithTelephoneEmptyField();
    }

    @Description("Validate that user register With Password EmptyField")
    @Test
    public void validateRegisterwithPasswordEmptyField(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),"","",
                data.get("PasswordConfirmInValid"));
        registerPage.assertRegisterWithPasswordEmptyField();
    }

    @Description("Validate that user register With Confirm EmptyField")
    @Test
    public void validateRegisterwithConfirmEmptyField(){
        homePage = new HomePage(driver);
        registerPage = new RegisterPage(driver);
        homePage.goToRegisterPage();
        registerPage.RegisterNewUserWithoutPrivacyCheck(data.get("firstNameValid"),data.get("lastNameValid"),
                data.get("emailValid"),data.get("telephoneInValid"),data.get("PasswordValid"),
                "");
        registerPage.assertRegisterWithPasswordconfirmationField();
    }


}
