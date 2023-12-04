import org.junit.Test;

import static org.junit.Assert.*;

public class CustomerTestStudent {

    @Test
    public void testToString() {
        Customer customer = new Customer("John Doe", 30);
        String expected = "John Doe, 30y/o";
        assertEquals(expected, customer.toString());
    }

    @Test
    public void getName() {
        Customer customer = new Customer("Alice", 25);
        assertEquals("Alice", customer.getName());
    }


    @Test
    public void getAge() {
        Customer customer = new Customer("Bob", 35);
        assertEquals(35, customer.getAge());
    }

    @Test
    public void setName() {
        Customer customer = new Customer("Alice", 25);
        customer.setName("Alex");
        assertEquals("Alex", customer.getName());
    }

    @Test
    public void setAge() {
        Customer customer = new Customer("Bob", 35);
        customer.setAge(40);
        assertEquals(40, customer.getAge());
    }
}