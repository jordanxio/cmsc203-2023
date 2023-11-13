/*
 * Class: CMSC203 CRN 21575
 * Instructor:Grigoriy Grinberg
 * Description: Holiday Bonus JUnit Test - from dataset2
 * Due: 11/13/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jordan Xiong
 */
package com.example.demo1;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HolidayBonusTestStudent {
    private double[][] dataSet1 = { { 7, 2, 9, 4 }, { 5 }, { 8, 1, 3 }, { 11, 6, 7, 2 }};

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void calculateHolidayBonus() {
        try {
        double[] result = HolidayBonus.calculateHolidayBonus(dataSet1);
        assertEquals(14000.0, result[0], .001);
        assertEquals(1000.0, result[1], .001);
        assertEquals(4000.0, result[2], .001);
        assertEquals(13000.0, result[3], .001);
    } catch (Exception e) {
        fail("This should not have caused an Exception");
    }
    }

    @Test
    public void calculateTotalHolidayBonus() {
        assertEquals(32000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet1), .001);
    }
}