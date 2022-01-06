import opp.Car;
import opp.Bmw;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BmwTests {
    @Test
    void testValidObject() {
        Bmw bmw = new Bmw();
        Assertions.assertNotNull(bmw);
    }

    @Test
    void testInValidObject() {
        Bmw bmw = null;
        Assertions.assertNull(null);
    }

}
