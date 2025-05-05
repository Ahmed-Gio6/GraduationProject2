package StepDefs;

import Pages.HomePage;
import Pages.LoginPage;
import Utilities.TestDataReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Map;

public class Login_StepDef {

    LoginPage loginPage = new LoginPage(Hooks.driver);
    HomePage homePage   = new HomePage(Hooks.driver);
    Map<String, String> data = TestDataReader.getTestData("src/main/resources/LoginData.json");


    @Given("User navigate to login page")
    public void userNavigateToLoginPage(){
        homePage.navigate();
    }

    @When("User go to login page")
    public void userGoToLoginPage() {
        homePage.goToLogin();
    }


    @And("User click button")
    public void userClickButton() {
        loginPage.ClickLoginButton();
    }

    @Then("User should login successfully")
    public void userShouldLoginSuccessfully() {
        loginPage.assertSuccessfullLogin();
    }


    @Then("Error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        loginPage.assertLoginErrorMessage();
    }

    @And("User enter valid email {string}")
    public void userEnterValidEmail(String email) {
        loginPage.EnterEmail(email);
    }

    @And("User enter valid password {string}")
    public void userEnterValidPassword(String password) {
        loginPage.EnterPassword(password);
    }
}
