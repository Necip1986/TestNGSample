package paralelTesting;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ParalelTest1 {

    //WebDriver driver;
    @BeforeMethod
    public void setup(){

    }

    @AfterMethod
    void teardown(){
        //driver.close();
    }

    @Test
    public void logoTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        WebElement logo=driver.findElement(By.cssSelector("div[id='divLogo'] img"));
        Assert.assertTrue(logo.isDisplayed());
        Thread.sleep(5000);

    }

    @Test
    public void titleTest() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        String title=driver.getTitle();
        Assert.assertEquals("OrangeHRM",title);
        Thread.sleep(5000);


    }
}
