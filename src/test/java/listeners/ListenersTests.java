package listeners;

import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(listeners.CustomListeners.class)
public class ListenersTests {

    @Test
    void test1(){
        System.out.println("this is test 1");
        Assert.assertTrue(true);
    }

    @Test
    void test2(){
        System.out.println("this is test 2");
        Assert.assertTrue(false);
    }

    @Test
    void test3(){
        System.out.println("this is test 3");
        throw new SkipException("this is skip exception...");
    }
}
