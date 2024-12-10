package testcomponents;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.SignUpPage;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;


public class Basetest {
    public WebDriver driver;

    public WebDriver initilizedriver() throws IOException {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/GlobalData.properties");
        prop.load(fis);
        String browsername= prop.getProperty("browser");
        if(browsername.equalsIgnoreCase("Chrome")){
            driver = new ChromeDriver();
        } else if (browsername.equalsIgnoreCase("firefox")) {
             driver = new FirefoxDriver();
        } else if (browsername.equalsIgnoreCase("edge")) {
             driver= new EdgeDriver();

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        return driver;

    }

    @BeforeMethod(alwaysRun = true)
    public SignUpPage launchApplication() throws IOException {
        driver= initilizedriver();
        driver.get("https://magento.softwaretestingboard.com/");
        SignUpPage signuppage = new SignUpPage(driver);
        return signuppage;


    }
    @AfterMethod(alwaysRun = true)
    public void closeapplication() throws IOException {
        driver=initilizedriver();
        driver.close();
    }



}
