import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class Main {
    @Test
    public void test() {
        int a = 5;
        int b = 10;
        Assertions.assertEquals(14, a + b);
    }
}
