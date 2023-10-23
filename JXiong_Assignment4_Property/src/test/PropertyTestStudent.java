/*
 * Class: CMSC203 21757
 * Instructor: Grigoriy Grinberg
 * Description: Property Class JUnit Test
 * Due: 10/23/2023
 * Platform/compiler: IntellJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
import static org.junit.jupiter.api.Assertions.*;

import com.example.assignment4_property.Property;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {
    Property property;

    @BeforeEach
    void setUp() throws Exception {
        property = new Property("Lakeview Villa", "Los Angeles", 3000.50, "Alice Johnson");
    }

    @AfterEach
    void tearDown() throws Exception {
        property = null;
    }

    @Test
    void testGetPropertyName() {
        assertEquals("Lakeview Villa", property.getPropertyName());
    }

    @Test
    void testGetCity() {
        assertEquals("Los Angeles", property.getCity());
    }

    @Test
    void testGetRentAmount() {
        assertEquals(3000.50, property.getRentAmount());
    }

    @Test
    void testGetOwner() {
        assertEquals("Alice Johnson", property.getOwner());
    }

    @Test
    void testGetPlot() {
        assertEquals(0, property.getPlot().getX());
        assertEquals(0, property.getPlot().getY());
        assertEquals(1, property.getPlot().getWidth());
        assertEquals(1, property.getPlot().getDepth());
    }

    @Test
    void testToString() {
        assertEquals("Lakeview Villa,Los Angeles,Alice Johnson,3000.5", property.toString());
    }

    @Test
    void testPropertyWithCustomPlot() {
        Property customProperty = new Property("Custom Property", "Citytown", 2200.0, "Bob Smith", 2, 3, 5, 5);
        assertEquals(2, customProperty.getPlot().getX());
        assertEquals(3, customProperty.getPlot().getY());
        assertEquals(5, customProperty.getPlot().getWidth());
        assertEquals(5, customProperty.getPlot().getDepth());
    }
}