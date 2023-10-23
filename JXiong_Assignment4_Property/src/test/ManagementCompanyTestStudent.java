/*
 * Class: CMSC203 21757
 * Instructor: Grigoriy Grinberg
 * Description: Management Company Class JUnit Test
 * Due: 10/23/2023
 * Platform/compiler: IntellJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
import static org.junit.Assert.*;

import com.example.assignment4_property.ManagementCompany;
import com.example.assignment4_property.Property;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class ManagementCompanyTestStudent {
    ManagementCompany managementCompany;
    Property property1, property2, property3;

    @Before
    public void setUp() throws Exception {
        managementCompany = new ManagementCompany("TestCo", "123456789", 6);

        property1 = new Property("Property A", "City A", 2000.0, "Owner A", 1, 1, 3, 3);
        property2 = new Property("Property B", "City B", 2500.0, "Owner B", 5, 5, 2, 2);
        property3 = new Property("Property C", "City C", 3000.0, "Owner C", 8, 8, 4, 4);
    }

    @After
    public void tearDown() throws Exception {
        managementCompany = null;
    }

    @Test
    public void testAddProperty() {
        assertEquals(0, managementCompany.addProperty(property1)); // Property 1 has been successfully added to index 0
        assertEquals(1, managementCompany.addProperty(property2)); // Property 2 has been successfully added to index 1
    }

    @Test
    public void testGetPropertiesCount() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        assertEquals(2, managementCompany.getPropertiesCount());
    }

    @Test
    public void testToString() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);

        String expectedString = "List of the properties for TestCo, taxID: 123456789\n" +
                "______________________________________________________\n" +
                "Property A,City A,Owner A,2000.0\n" +
                "______________________________________________________\n" +
                "Property B,City B,Owner B,2500.0\n" +
                "______________________________________________________\n\n" +
                " total management Fee: 270.0";

        assertEquals(expectedString, managementCompany.toString());
    }

    @Test
    public void testGetHighestRentProperty() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);
        managementCompany.addProperty(property3);

        Property highestRentProperty = managementCompany.getHighestRentPropperty();

        assertEquals("Property B", highestRentProperty.getPropertyName());
        assertEquals("City B", highestRentProperty.getCity());
        assertEquals("Owner B", highestRentProperty.getOwner());
        assertEquals(2500.0, highestRentProperty.getRentAmount(), 0.01);
    }

    @Test
    public void testRemoveLastProperty() {
        managementCompany.addProperty(property1);
        managementCompany.addProperty(property2);

        assertEquals(2, managementCompany.getPropertiesCount());
        managementCompany.removeLastProperty();
        assertEquals(1, managementCompany.getPropertiesCount());
    }
}