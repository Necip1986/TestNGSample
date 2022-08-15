package deneme;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyExample {

    @Test
    void startCar(){
        System.out.println("car started");
        Assert.fail();
    }
    @Test (dependsOnMethods = "startCar")
    void driveCar(){
        System.out.println("car driving");
    }
    @Test (dependsOnMethods = "driveCar")
    void stopCar(){
        System.out.println("car stopped");
    }
    @Test (dependsOnMethods = "stopCar", alwaysRun = true)
    void parkedCar(){
        System.out.println("parked car");
    }
}
