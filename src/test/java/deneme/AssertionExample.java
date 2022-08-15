package deneme;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class AssertionExample {

    WebDriver driver;
    @BeforeClass
    void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://amazon.com");
    }

    @Test(priority = 1)
    void titleTest(){
        Assert.assertTrue(driver.getTitle().contains("Amzon"), "title does not contain amazon");
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
