package deneme;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReportsSearchTest {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    WebDriver driver;

    @BeforeTest
    public void setup(){
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle("MyReport");
        extent.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
    }

    @AfterTest
    public void teardown(){
        extent.flush();
        driver.quit();
    }

    @Test
    public void test1(){

        ExtentTest test=extent.createTest("verify the title").assignAuthor("Yunus").
                assignCategory("smoke").assignDevice("window");
        test.info("I am capturing the title");
        String title= driver.getTitle();
        test.info("page title is "+title);
        if(title.equalsIgnoreCase("google")){
            test.pass("page title is verified");
        }else{
            test.fail("page title is not matched with expected title");
        }
    }



}
