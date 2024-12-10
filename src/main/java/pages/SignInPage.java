package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignInPage {
    WebDriver driver;

    @FindBy(id = "email")
    WebElement emailField;
    @FindBy(id = "pass")
    WebElement passwordField;
    @FindBy(css = "button.action.login")
    WebElement signInButton;
    @FindBy(css = "div.message-error")
    WebElement errorMessage;
    @FindBy(xpath = "//*[@class='panel header']/ul/li[2]")
    WebElement siginbutton;

    public SignInPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void landingonsignInPage() {
        siginbutton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickSignIn() {
        signInButton.click();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

}
