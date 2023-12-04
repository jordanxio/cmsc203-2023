import org.junit.Test;
import static org.junit.Assert.*;

public class SizeTestStudent {

    @Test
    public void valueOfIgnoreCase() {
        assertEquals(Size.SMALL, Size.valueOfIgnoreCase("small"));
        assertEquals(Size.MEDIUM, Size.valueOfIgnoreCase("medium"));
        assertEquals(Size.LARGE, Size.valueOfIgnoreCase("large"));
    }

    @Test
    public void values() {
        Size[] expectedSizes = { Size.SMALL, Size.MEDIUM, Size.LARGE };
        assertArrayEquals(expectedSizes, Size.values());
    }

    @Test
    public void valueOf() {
        assertEquals(Size.SMALL, Size.valueOf("SMALL"));
        assertEquals(Size.MEDIUM, Size.valueOf("MEDIUM"));
        assertEquals(Size.LARGE, Size.valueOf("LARGE"));
    }
}
