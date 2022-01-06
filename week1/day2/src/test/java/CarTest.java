import opp.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class CarTest {
    @DisplayName("Car valid object")
    @Test
    void carTestValidObject() {

        Car car=new Car();
        Assertions.assertNotNull(car);
    }
    @DisplayName("Car Invalid Object")
    @Test
    void carTestInvalidObject() {
        Car car= null;
        Assertions.assertNull(null);
    }
    @DisplayName("Car speed by default constructor")
    @Test
    void testCarDefaultCons()
    {
        Car car=new Car();
        int expectedValue = 10;
        int actualValue = car.speed;
        Assertions.assertEquals(expectedValue,actualValue);
    }
    @DisplayName("car speed by parametrized constructor")
    @Test
    void testCarParametrized() {
        Car car = new Car(10);
        int expectedValue=10;
        int actualSpeed = car.speed;
        Assertions.assertEquals(expectedValue,actualSpeed);
    }





}
