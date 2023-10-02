import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GradeBookTest {
    private GradeBook gradeBook1;
    private GradeBook gradeBook2;

    @Before
    public void setUp() throws Exception {
        gradeBook1 = new GradeBook(5);
        gradeBook2 = new GradeBook(5);

        gradeBook1.addScore(90);
        gradeBook1.addScore(85);
        gradeBook1.addScore(78);

        gradeBook2.addScore(95);
        gradeBook2.addScore(88);
    }

    @After
    public void tearDown() throws Exception {
        gradeBook1 = null;
        gradeBook2 = null;
    }

    @Test
    public void getScoresSize() {
    }

    @Test
    public void addScore() {
        assertTrue(gradeBook1.toString().equals("90.0 85.0 78.0"));
        assertEquals(3, gradeBook1.getScoresSize());

        assertTrue(gradeBook2.toString().equals("95.0 88.0"));
        assertEquals(2, gradeBook2.getScoresSize());
    }

    @Test
    public void sum() {
        assertEquals(253.0, gradeBook1.sum(), 0.01);
        assertEquals(183.0, gradeBook2.sum(), 0.01);
    }

    @Test
    public void minimum() {
        assertEquals(78.0, gradeBook1.minimum(), 0.01);
        assertEquals(88.0, gradeBook2.minimum(), 0.01);
    }

    @Test
    public void finalScore() {
        assertEquals(175.0, gradeBook1.finalScore(), 0.01);
        assertEquals(95.0, gradeBook2.finalScore(), 0.01);
    }


    @Test
    public void testToString() {
    }
}