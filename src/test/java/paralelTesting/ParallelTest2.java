package paralelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ParallelTest2 {


    public static WebDriver browserAl(String browserName) {
            WebDriver driver = null;

        if (browserName.equals("Firefox")) {
            //System.setProperty("webdriver.gecko.driver", "./drivers/geckodriver.exe");
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        } else if (browserName.equals("Edge")) {
            //System.setProperty("webdriver.edge.driver", "./drivers/MicrosoftWebDriver.exe");
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
        } else if (browserName.equals("Chrome")) {
            //System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
            //driver = new ChromeDriver();
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        return driver;
    }

    public static void closeDriver(WebDriver driver) {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    void loginTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("admin123");
        driver.findElement(By.id("btnLogin")).click();
        Thread.sleep(2000);
        WebElement loginVerified = driver.findElement(By.cssSelector("fieldset#panel_resizable_0_0 legend"));
        Assert.assertTrue(loginVerified.isDisplayed());
    }


}
