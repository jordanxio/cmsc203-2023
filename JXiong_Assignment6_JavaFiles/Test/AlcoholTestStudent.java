import org.junit.Test;

import static org.junit.Assert.*;

public class AlcoholTestStudent {

    @Test
    public void testToString() {
        // Test toString method for an alcohol not offered on the weekend
        Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, false);
        assertEquals("Vodka, SMALL, $2.0", alcohol.toString());

        // Test toString method for an alcohol offered on the weekend
        Alcohol alcohol2 = new Alcohol("Whiskey", Size.MEDIUM, true);
        assertEquals("Whiskey, MEDIUM Weekend, $3.6", alcohol2.toString());
    }

    @Test
    public void testEquals() {
        // Test equals method for two identical alcohol objects
        Alcohol alcohol1 = new Alcohol("Vodka", Size.SMALL, false);
        Alcohol alcohol2 = new Alcohol("Vodka", Size.SMALL, false);
        assertTrue(alcohol1.equals(alcohol2));

        // Test equals method for two different alcohol objects
        Alcohol alcohol3 = new Alcohol("Whiskey", Size.MEDIUM, true);
        assertFalse(alcohol1.equals(alcohol3));
    }

    @Test
    public void testCalcPrice() {
        // Test for a small-size alcohol not offered on the weekend
        Alcohol alcohol1 = new Alcohol("Vodka", Size.SMALL, false);
        assertEquals(2.0, alcohol1.calcPrice(), 0.01);

        // Test for a medium-size alcohol offered on the weekend
        Alcohol alcohol2 = new Alcohol("Whiskey", Size.MEDIUM, true);
        assertEquals(3.6, alcohol2.calcPrice(), 0.01);

        // Test for a large-size alcohol offered on the weekend
        Alcohol alcohol3 = new Alcohol("Beer", Size.LARGE, true);
        assertEquals(4.6, alcohol3.calcPrice(), 0.01);
    }


    @Test
    public void getIsWeekend() {
        // Test for isWeekend value when it's set as true
        Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, true);
        assertTrue(alcohol.getIsWeekend());

        // Test for isWeekend value when it's set as false
        Alcohol alcohol2 = new Alcohol("Whiskey", Size.MEDIUM, false);
        assertFalse(alcohol2.getIsWeekend());
    }

    @Test
    public void getWeekendFee() {
        // Test for the value of WEEKEND_FEE constant
        Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, true);
        assertEquals(0.6, alcohol.getWeekendFee(), 0.01);
    }

    @Test
    public void setIsWeekend() {
        // Test setting isWeekend value to true
        Alcohol alcohol = new Alcohol("Vodka", Size.SMALL, false);
        alcohol.setIsWeekend(true);
        assertTrue(alcohol.getIsWeekend());

        // Test setting isWeekend value to false
        alcohol.setIsWeekend(false);
        assertFalse(alcohol.getIsWeekend());
    }
}