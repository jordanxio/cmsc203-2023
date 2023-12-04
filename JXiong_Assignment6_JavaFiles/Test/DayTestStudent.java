import org.junit.Test;
import static org.junit.Assert.*;

public class DayTestStudent {

    @Test
    public void valueOfIgnoreCase() {
        assertEquals(Day.MONDAY, Day.valueOfIgnoreCase("Monday"));
        assertEquals(Day.TUESDAY, Day.valueOfIgnoreCase("Tuesday"));
        assertEquals(Day.WEDNESDAY, Day.valueOfIgnoreCase("Wednesday"));
        assertEquals(Day.THURSDAY, Day.valueOfIgnoreCase("Thursday"));
        assertEquals(Day.FRIDAY, Day.valueOfIgnoreCase("Friday"));
        assertEquals(Day.SATURDAY, Day.valueOfIgnoreCase("Saturday"));
        assertEquals(Day.SUNDAY, Day.valueOfIgnoreCase("Sunday"));
    }

    @Test
    public void values() {
        Day[] expectedDays = { Day.MONDAY, Day.TUESDAY, Day.WEDNESDAY, Day.THURSDAY, Day.FRIDAY, Day.SATURDAY, Day.SUNDAY };
        assertArrayEquals(expectedDays, Day.values());
    }

    @Test
    public void valueOf() {
        assertEquals(Day.MONDAY, Day.valueOf("MONDAY"));
        assertEquals(Day.TUESDAY, Day.valueOf("TUESDAY"));
        assertEquals(Day.WEDNESDAY, Day.valueOf("WEDNESDAY"));
        assertEquals(Day.THURSDAY, Day.valueOf("THURSDAY"));
        assertEquals(Day.FRIDAY, Day.valueOf("FRIDAY"));
        assertEquals(Day.SATURDAY, Day.valueOf("SATURDAY"));
        assertEquals(Day.SUNDAY, Day.valueOf("SUNDAY"));
    }
}
