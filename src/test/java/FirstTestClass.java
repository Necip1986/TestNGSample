import org.testng.annotations.Test;

public class FirstTestClass {


    @Test(priority = 1)
    public void set_up(){
        System.out.println("set up executed");
    }

    @Test(priority = 2)
    public void loginTest1(){
        System.out.println("test1 executed");
    }

    @Test(priority = 3)
    public void tearDown(){
        System.out.println("closing activity executed");
    }


}
