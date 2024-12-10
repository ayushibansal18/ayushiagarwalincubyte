package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Standalonetest {
    @Test
    public void signup (){
        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@class='panel header']/ul/li[3]")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(3000));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstname")));
        driver.findElement(By.id("firstname")).sendKeys("Ayushi");
        driver.findElement(By.id("lastname")).sendKeys("Agarwal");
        driver.findElement(By.id("email_address")).sendKeys("ayushiagarwal.18@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Ayushi@18");
        String passwordtext=driver.findElement(By.id("password-strength-meter")).getText();
        //Assert.assertEquals(passwordtext,"Password Strength: Strong");
        driver.findElement(By.id("password-confirmation")).sendKeys("Ayushi@18888");
        driver.findElement(By.xpath("//*[contains(@class,'submit')]")).click();
        String successMessageXpath = "//div[contains(@class, 'message-success')]";
        String expectedMessage = "Thank you for registering with Main Website Store.";

        // Find the success message element
        String actualMessage = driver.findElement(By.xpath(successMessageXpath)).getText();
        System.out.printf(actualMessage);

        // Assert the success message
        Assert.assertEquals(actualMessage,expectedMessage);
        //Assert.assertEquals("Success message does not match!", expectedMessage, actualMessage);
    }

    @Test
    public void signin(){
        WebDriver driver= new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@class='panel header']/ul/li[2]")).click();
        driver.findElement(By.id("email")).sendKeys("ayushiagarwal.1804@gmail.com");
        driver.findElement(By.id("pass")).sendKeys("Ayushi@18");
        driver.findElement(By.id("send2")).click();


    }




}
