import org.junit.Test;

import static org.junit.Assert.*;

public class CoffeeTestStudent {

    @Test
    public void testToString() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, true, false);
        String expected = "Latte, SMALL Extra shot, $2.5";
        assertEquals(expected, coffee.toString());
    }

    @Test
    public void calcPrice() {
        Coffee coffee = new Coffee("Mocha", Size.MEDIUM, true, true);
        double expectedPrice = 4.0; // Base price + Medium size price + Extra shot + Extra syrup
        assertEquals(expectedPrice, coffee.calcPrice(), 0.001); // Delta for double comparison
    }

    @Test
    public void testEquals() {
        Coffee coffee1 = new Coffee("Cappuccino", Size.LARGE, true, true);
        Coffee coffee2 = new Coffee("Cappuccino", Size.LARGE, true, true);
        assertTrue(coffee1.equals(coffee2));
    }

    @Test
    public void getExtraShot() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertTrue(coffee.getExtraShot());
    }

    @Test
    public void getExtraSyrup() {
        Coffee coffee = new Coffee("Americano", Size.LARGE, false, true);
        assertTrue(coffee.getExtraSyrup());
    }

    @Test
    public void getShotCost() {
        Coffee coffee = new Coffee("Espresso", Size.SMALL, true, false);
        assertEquals(0.5, coffee.getShotCost(), 0.001);
    }

    @Test
    public void getSyrupCost() {
        Coffee coffee = new Coffee("Americano", Size.LARGE, false, true);
        assertEquals(0.5, coffee.getSyrupCost(), 0.001);
    }

    @Test
    public void setExtraShot() {
        Coffee coffee = new Coffee("Latte", Size.SMALL, false, false);
        coffee.setExtraShot(true);
        assertTrue(coffee.getExtraShot());
    }

    @Test
    public void setExtraSyrup() {
        Coffee coffee = new Coffee("Mocha", Size.MEDIUM, true, true);
        coffee.setExtraSyrup(false);
        assertFalse(coffee.getExtraSyrup());
    }
}