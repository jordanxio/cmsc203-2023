import org.junit.Test;
import static org.junit.Assert.*;

public class OrderTestStudent {

    @Test
    public void genOrderNum() {
        Order order = new Order(12, Day.FRIDAY, new Customer("John", 25));
        int orderNo = order.genOrderNum();
        assertTrue(orderNo >= 10_000 && orderNo < 90_000);
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("Alice", 30);
        Order order = new Order(10, Day.MONDAY, customer);
        order.addNewBeverage("Latte", Size.SMALL, false, true);
    }

    @Test
    public void isWeekend() {
        Order order1 = new Order(10, Day.SATURDAY, new Customer("Bob", 28));
        assertTrue(order1.isWeekend());

        Order order2 = new Order(12, Day.TUESDAY, new Customer("Emily", 22));
        assertFalse(order2.isWeekend());
    }

    @Test
    public void getBeverage() {
        Order order = new Order(14, Day.WEDNESDAY, new Customer("David", 35));
        order.addNewBeverage("Smoothie", Size.LARGE, 4, true);
        Beverage beverage = order.getBeverage(0);
        assertNotNull(beverage);
    }

    // Add tests for other methods as required
}
