package deneme;

import org.testng.annotations.Test;

public class GroupingExample {

    @Test (groups = {"sanity"})
    void test1(){
        System.out.println("this is test1");
    }

    @Test (groups = {"sanity"})
    void test2(){
        System.out.println("this is test2");
    }

    @Test (groups = {"regression"})
    void test3(){
        System.out.println("this is test3");
    }

    @Test (groups = {"regression"})
    void test4(){
        System.out.println("this is test4");
    }

    @Test (groups ={"regression", "sanity"} )
    void test5(){
        System.out.println("this is test5");
    }
}
