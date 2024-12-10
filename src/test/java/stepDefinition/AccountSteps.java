package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.SignInPage;
import pages.SignUpPage;
import testcomponents.Basetest;

import java.io.IOException;

public class AccountSteps {
    WebDriver driver = new ChromeDriver();
    SignUpPage signUpPage;
    SignInPage signInPage;


    @Given("I navigate to the \"Create Account\" page")
    public void navigateToCreateAccount() {
        driver.get("https://magento.softwaretestingboard.com/");
        signUpPage = new SignUpPage(driver);
        signUpPage.goToCreateAccountPage();
    }

    @When("^I enter valid account details$")
    public void enterAccountDetails() {
        signUpPage.enterDetails("Ayushi", "Agarwal", "ayushiagarwal.182@gmai.com", "Ayushi@182", "Ayushi@182");
    }

    @And("^I click the \"Create an Account\" button$")
    public void clickSignUpButton() {
        signUpPage.clickSignUp();
    }

    @Then("I should see a success message  as {string}")
    public void iShouldSeeASuccessMessageAs(String expectedMessage) {
        String actualmessage = signUpPage.successmessage();
        Assert.assertEquals(actualmessage, expectedMessage);
    }


    @Given("^I navigate to the \"Sign In\" page$")
    public void navigateToSignInPage() {
        driver.get("https://magento.softwaretestingboard.com/");
        signInPage = new SignInPage(driver);
        signInPage.landingonsignInPage();
    }

    @When("I enter username {string} and password {string}")
    public void iEnterUsernameAndPassword(String username, String password) {
        signInPage.enterEmail(username);
        signInPage.enterPassword(password);
    }

    @When("^I enter invalid credentials$")
    public void enterInvalidCredentials() {
        signInPage.enterEmail("invalid@example.com");
        signInPage.enterPassword("InvalidPassword");
    }

    @And("^I click the \"Sign In\" button$")
    public void clickSignInButton() {
        signInPage.clickSignIn();
    }

    @Then("^I should be redirected to the account dashboard$")
    public void verifyDashboardRedirection() {
        String expectedUrl = "https://magento.softwaretestingboard.com/customer/account/";
        driver.navigate().back();
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(expectedUrl.equalsIgnoreCase(actualUrl));
        //Assert.assertEquals(expectedUrl,actualUrl,  "User is redirected to the dashboard");

    }

    @Then("^I should see an error message$")
    public void verifyErrorMessage() {
        String expectedErrorMessage = "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later.";
        String actualErrorMessage = signInPage.getErrorMessage();
        Assert.assertEquals(expectedErrorMessage, actualErrorMessage);
    }


}

