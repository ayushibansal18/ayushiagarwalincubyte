package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPage {

        WebDriver driver;
        @FindBy(xpath = "//*[@class='panel header']/ul/li[3]")
        WebElement createaccountbutton;

        @FindBy(id = "firstname")
        WebElement firstName;
        @FindBy(id = "lastname")
        WebElement lastName;
        @FindBy(id = "email_address")
        WebElement email;
        @FindBy(id = "password")
        WebElement password;
        @FindBy(id = "password-confirmation")
        WebElement confirmPassword;
        @FindBy(css = "button.action.submit")
        WebElement signUpButton;

        public SignUpPage(WebDriver driver) {
            this.driver = driver;
            PageFactory.initElements(driver, this);
        }

        public void goToCreateAccountPage(){
            createaccountbutton.click();

        }

        public void enterDetails(String fname, String lname, String emailAddr, String pwd, String confirmPwd) {
            firstName.sendKeys(fname);
            lastName.sendKeys(lname);
            email.sendKeys(emailAddr);
            password.sendKeys(pwd);
            confirmPassword.sendKeys(confirmPwd);
        }

        public void clickSignUp() {
            signUpButton.click();
        }
        @FindBy(xpath="//div[contains(@class, 'message-success')]")
        WebElement successMessageXpath;

        public String successmessage(){
            String actualmessage=successMessageXpath.getText();
            return actualmessage;

        }
        public void returntoaccountdashboard(){
            driver.navigate().back();
            String currenturl= driver.getCurrentUrl();


        }
    }

