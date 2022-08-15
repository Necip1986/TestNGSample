package deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersExample {

    WebDriver driver;
    @BeforeClass
    @Parameters({"browser","url"})
    void setUp(String browser,String app){

        switch (browser){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver=new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver=new FirefoxDriver();
                break;
        }

        driver.manage().window().maximize();
        driver.get(app);



    }

    @Test(priority = 1)
    void titleTest(){
        Assert.assertTrue(driver.getTitle().contains("Amazon"), "title does not contain amazon");
    }

    @Test(priority = 2)
    void logoTest(){
        WebElement logo= driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed(),"logo is not displayed on the page");
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}
