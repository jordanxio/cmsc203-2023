import org.junit.Test;
import static org.junit.Assert.*;

public class SmoothieTestStudent {

    @Test
    public void testToString() {
        Smoothie smoothie = new Smoothie("Berry Blast", Size.MEDIUM, 3, true);
        String expected = "Berry Blast, MEDIUM 3 Fruits Protein powder, $6.0";
        assertEquals(expected, smoothie.toString());
    }

    @Test
    public void testEquals() {
        Smoothie smoothie1 = new Smoothie("Strawberry Shake", Size.LARGE, 2, false);
        Smoothie smoothie2 = new Smoothie("Strawberry Shake", Size.LARGE, 2, false);
        assertTrue(smoothie1.equals(smoothie2));
    }

    @Test
    public void calcPrice() {
        Smoothie smoothie = new Smoothie("Mango Magic", Size.SMALL, 4, true);
        double expectedPrice = 5.5; // Small base price + 4 fruits cost + protein cost
        assertEquals(expectedPrice, smoothie.calcPrice(), 0.001);
    }

    @Test
    public void getNumOfFruits() {
        Smoothie smoothie = new Smoothie("Tropical Delight", Size.LARGE, 5, true);
        assertEquals(5, smoothie.getNumOfFruits());
    }

    @Test
    public void getAddProtien() {
        Smoothie smoothie = new Smoothie("Blueberry Boost", Size.MEDIUM, 2, true);
        assertTrue(smoothie.getAddProtien());
    }

    @Test
    public void getFruitCost() {
        Smoothie smoothie = new Smoothie("Pineapple Pleasure", Size.SMALL, 3, false);
        assertEquals(0.5, smoothie.getFruitCost(), 0.001);
    }

    @Test
    public void getProteinCost() {
        Smoothie smoothie = new Smoothie("Green Machine", Size.LARGE, 4, true);
        assertEquals(1.5, smoothie.getProteinCost(), 0.001);
    }

    @Test
    public void setNumOfFruits() {
        Smoothie smoothie = new Smoothie("Peach Paradise", Size.MEDIUM, 2, false);
        smoothie.setNumOfFruits(3);
        assertEquals(3, smoothie.getNumOfFruits());
    }

    @Test
    public void setProteinPowder() {
        Smoothie smoothie = new Smoothie("Orange Oasis", Size.SMALL, 1, false);
        smoothie.setProteinPowder(true);
        assertTrue(smoothie.getAddProtien());
    }
}
