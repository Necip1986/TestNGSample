import org.testng.Assert;
import org.testng.annotations.Test;

public class SecondTestClass {


    @Test(priority = 4)
    public void set_up(){
        System.out.println("opening browser");
    }

    @Test(priority = 5)
    public void test2(){
        System.out.println("test2 executed");
        Assert.assertEquals(1,1);
    }

    @Test(priority = 6)
    public void tearDown(){
        System.out.println("closing browser");
    }


}
