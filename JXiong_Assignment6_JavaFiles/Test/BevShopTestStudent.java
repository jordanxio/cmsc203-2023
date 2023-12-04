import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class BevShopTestStudent {
    private BevShop bevShop;
    @Before
    public void setUp() {
        bevShop = new BevShop();
    }

    @Test
    public void testToString() {
        String expected = "Monthly Orders\nTotal Sale: 0.0";
        assertEquals(expected, bevShop.toString());
    }

    @Test
    public void isValidTime() {
        assertTrue(bevShop.isValidTime(8));
        assertFalse(bevShop.isValidTime(7));
        assertTrue(bevShop.isValidTime(23));
        assertFalse(bevShop.isValidTime(24));
    }

    @Test
    public void getMaxNumOfFruits() {
        assertEquals(5, bevShop.getMaxNumOfFruits());
    }

    @Test
    public void isValidAge() {
        assertTrue(bevShop.isValidAge(21));
        assertFalse(bevShop.isValidAge(20));
    }

    @Test
    public void isEligibleForMore() {
        bevShop.startNewOrder(12, Day.FRIDAY, "Bob", 25);
        assertTrue(bevShop.isEligibleForMore()); // Initial order is eligible

        bevShop.processAlcoholOrder("Vodka", Size.MEDIUM);
        assertTrue(bevShop.isEligibleForMore()); // One alcohol drink added, still eligible

        bevShop.processAlcoholOrder("Gin", Size.LARGE);
        assertTrue(bevShop.isEligibleForMore()); // Two alcohol drinks added, still eligible

        bevShop.processAlcoholOrder("Tequila", Size.SMALL);
        assertFalse(bevShop.isEligibleForMore()); // Three alcohol drinks added, not eligible anymore
    }


    @Test
    public void isMaxFruit() {
        assertTrue(bevShop.isMaxFruit(6));
        assertFalse(bevShop.isMaxFruit(4));
    }

    @Test
    public void startNewOrder() {
        bevShop.startNewOrder(12, Day.MONDAY, "John", 25);
        assertEquals(0, bevShop.getNumOfAlcoholDrink());
        assertEquals(1, bevShop.totalNumOfMonthlyOrders());
    }

    @Test
    public void processCoffeeOrder() {
        bevShop.startNewOrder(10, Day.MONDAY, "Alice", 30);
        bevShop.processCoffeeOrder("Latte", Size.SMALL, true, false);
        assertEquals(1, bevShop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void processSmoothieOrder() {
        bevShop.startNewOrder(12, Day.WEDNESDAY, "Charlie", 28);
        bevShop.processSmoothieOrder("BerryBlast", Size.LARGE, 3, true);
        assertEquals(1, bevShop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void processAlcoholOrder() {
        bevShop.startNewOrder(15, Day.FRIDAY, "Eve", 22);
        bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
        assertEquals(1, bevShop.getCurrentOrder().getBeverages().size());
    }

    @Test
    public void findOrder() {
        bevShop.startNewOrder(14, Day.THURSDAY, "Grace", 25);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        bevShop.startNewOrder(18, Day.SATURDAY, "Harry", 26);
        bevShop.processSmoothieOrder("Tropical", Size.MEDIUM, 2, true);
        assertEquals(-1, bevShop.findOrder(2)); // Finding order number 2
    }

    @Test
    public void totalOrderPrice() {
        bevShop.startNewOrder(12, Day.SUNDAY, "John", 30);
        bevShop.processAlcoholOrder("Beer", Size.SMALL);
        bevShop.processCoffeeOrder("Mocha", Size.LARGE, true, false);
        assertEquals(0.0, bevShop.totalOrderPrice(1), 0.01); // Calculating the total order price for order number 1
    }

    @Test
    public void totalMonthlySale() {
        bevShop.startNewOrder(13, Day.MONDAY, "Lisa", 29);
        bevShop.processAlcoholOrder("Wine", Size.LARGE);
        bevShop.processSmoothieOrder("Citrus", Size.MEDIUM, 1, true);
        bevShop.startNewOrder(20, Day.SATURDAY, "Mike", 23);
        bevShop.processCoffeeOrder("Cappuccino", Size.SMALL, false, true);
        assertEquals(11.5, bevShop.totalMonthlySale(), 0.01); // Calculating the total monthly sale
    }

    @Test
    public void totalNumOfMonthlyOrders() {
        bevShop.startNewOrder(14, Day.TUESDAY, "Nancy", 27);
        bevShop.processAlcoholOrder("Vodka", Size.SMALL);
        bevShop.startNewOrder(18, Day.SUNDAY, "Oliver", 24);
        assertEquals(2, bevShop.totalNumOfMonthlyOrders()); // Counting the total number of monthly orders
    }

    @Test
    public void sortOrders() {

    }

    @Test
    public void getOrderAtIndex() {
        bevShop.startNewOrder(11, Day.TUESDAY, "Rachel", 31);
        bevShop.processSmoothieOrder("Blueberry", Size.MEDIUM, 2, false);
        assertEquals("Rachel", bevShop.getOrderAtIndex(0).getCustomer().getName()); // Getting order at index 0
    }

    @Test
    public void getCurrentOrder() {
        bevShop.startNewOrder(12, Day.WEDNESDAY, "Steve", 29);
        bevShop.processCoffeeOrder("Espresso", Size.SMALL, false, false);
        assertEquals("Steve", bevShop.getCurrentOrder().getCustomer().getName()); // Getting the current order
    }
    @Test
    public void getNumOfAlcoholDrink() {
        bevShop.startNewOrder(13, Day.THURSDAY, "Tina", 27);
        bevShop.processAlcoholOrder("Gin", Size.LARGE);
        bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
        bevShop.processAlcoholOrder("Vodka", Size.SMALL);
        assertEquals(3, bevShop.getNumOfAlcoholDrink()); // Checking the number of alcohol drinks in the current order
    }

    @Test
    public void getMaxOrderForAlcohol() {
        assertEquals(3, bevShop.getMaxOrderForAlcohol()); // Getting the maximum number of alcohol drinks allowed per order
    }

    @Test
    public void getMinAgeForAlcohol() {
        assertEquals(21, bevShop.getMinAgeForAlcohol()); // Getting the minimum age for alcohol drinks
    }
}