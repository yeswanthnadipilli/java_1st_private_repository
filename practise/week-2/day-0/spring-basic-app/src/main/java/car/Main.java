package car;

public class Main {

    public static void main(String[] args) {
        Car car = new Car();


        // if we want to create a driver object,we need a car object
        // that means driver object is depented on car object.

        // dependencyes can be satisfied in two ways
        //1. constructorInjection
        //2. Setter Injection.

       // Driver driver = new Driver(car); ConstructorInjection

        Driver driver = new Driver();  // SetterInjection
        driver.setCar(car);
    }
}
