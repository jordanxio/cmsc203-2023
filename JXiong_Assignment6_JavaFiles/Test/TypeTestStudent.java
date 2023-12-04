import org.junit.Test;
import static org.junit.Assert.*;

public class TypeTestStudent {

    @Test
    public void valueOfIgnoreCase() {
        assertEquals(Type.COFFEE, Type.valueOfIgnoreCase("coffee"));
        assertEquals(Type.SMOOTHIE, Type.valueOfIgnoreCase("smoothie"));
        assertEquals(Type.ALCOHOL, Type.valueOfIgnoreCase("alcohol"));
    }

    @Test
    public void values() {
        Type[] expectedTypes = { Type.COFFEE, Type.SMOOTHIE, Type.ALCOHOL };
        assertArrayEquals(expectedTypes, Type.values());
    }

    @Test
    public void valueOf() {
        assertEquals(Type.COFFEE, Type.valueOf("COFFEE"));
        assertEquals(Type.SMOOTHIE, Type.valueOf("SMOOTHIE"));
        assertEquals(Type.ALCOHOL, Type.valueOf("ALCOHOL"));
    }
}
