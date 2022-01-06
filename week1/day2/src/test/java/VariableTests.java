import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class VariableTests {
    @DisplayName("check the variable are equal")
    @Test
    void learnVariable() {
        int num=10;

        int expectedValue=10;

        Assertions.assertEquals(expectedValue,num);


    }
    @DisplayName("check the variables are not equal")
    @Test
    void learnVariableInvalid() {
        int n=23;

        int expectedValue=20;
        Assertions.assertNotEquals(expectedValue,n);
    }
}
