import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MainTest {

    @Test
    public void addTest(){
        Assertions.assertEquals(2+2, 4);
    }

    @Test
    public void minusTest(){
        Assertions.assertEquals(3-2, 1);
    }

    @Test
    public void mulTest(){
        Assertions.assertEquals(4*5, 20);
    }

    @Test
    public void divTest(){
        Assertions.assertEquals(6/3, 2);
    }
}

