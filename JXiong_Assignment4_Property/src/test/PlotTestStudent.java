/*
 * Class: CMSC203 21757
 * Instructor: Grigoriy Grinberg
 * Description: Plot Class JUnit Test
 * Due: 10/23/2023
 * Platform/compiler: IntellJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
import static org.junit.Assert.*;

import com.example.assignment4_property.Plot;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

public class PlotTestStudent {
    private Plot plot1, plot2, plot3, plot4, plot5;

    @Before
    public void setUp() throws Exception {
        // Create some Plot instances for testing
        plot1 = new Plot(2, 2, 6, 6);
        plot2 = new Plot(8, 8, 4, 4);
        plot3 = new Plot(1, 1, 1, 1);
        plot4 = new Plot(5, 5, 2, 2);
        plot5 = new Plot(3, 4, 4, 3);
    }

    @After
    public void tearDown() throws Exception {
        plot1 = plot2 = plot3 = plot4 = plot5 = null;
    }

    @Test
    public void testEncompasses() {
        assertTrue(plot1.encompasses(plot4)); // plot1 fully contains plot4
        assertFalse(plot1.encompasses(plot2)); // plot1 does not fully contain plot2
        assertFalse(plot2.encompasses(plot1)); // plot2 does not fully contain plot1
    }

    @Test
    public void testOverlaps() {
        assertTrue(plot1.overlaps(plot5)); // plot5 is entirely inside plot1
        assertFalse(plot2.overlaps(plot3)); // plot2 and plot3 do not overlap
    }


    @Test
    public void testToString() {
        assertEquals("2,2,6,6", plot1.toString());
        assertEquals("8,8,4,4", plot2.toString());
        assertEquals("1,1,1,1", plot3.toString());
    }
}