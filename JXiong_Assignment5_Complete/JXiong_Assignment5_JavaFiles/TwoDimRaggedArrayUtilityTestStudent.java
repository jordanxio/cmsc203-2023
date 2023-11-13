/*
 * Class: CMSC203 CRN 21575
 * Instructor:Grigoriy Grinberg
 * Description: TwoDimRaggedArrayUtility JUnit Test - District4 exampling
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.Assert.*;

public class TwoDimRaggedArrayUtilityTestStudent {
    private double[][] dataSet1 = { {1253.65 , 4.50 , 2154.36 , 7532.45 , 3388.44 },
            { 2876.22 , -3.24 , 1954.66 },
            { 4896.23 , 2.29 , 5499.29 },
            { 2256.76 ,  3.76, 4286.29 , 5438.48 , 3794.43},
            {3184.38 , 3654.65 , 3455.76 , 6387.23 ,4265.77 , 4592.45},
            {2657.46 , 3265.34 , 2256.38 , 8935.26 , 5287.34 , 6598.23}
    };

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void readFile() { File file = new File("district4.txt");
        try {
            TwoDimRaggedArrayUtility.writeToFile(dataSet1, file);
            double[][] readData = TwoDimRaggedArrayUtility.readFile(file);
            assertArrayEquals(dataSet1, readData);
        } catch (FileNotFoundException e) {
            fail("Exception thrown: " + e.getMessage());
        }

    }


    @Test
    public void writeToFile() {
        File tempFile = new File("tempFile.txt");

        // Call the writeToFile method
        try {
            TwoDimRaggedArrayUtility.writeToFile(dataSet1, tempFile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        // Read the content of the file and compare with the expected content
        try (Scanner scanner = new Scanner(tempFile)) {
            StringBuilder fileContent = new StringBuilder();
            while (scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine()).append("\n");
            }

            String expectedContent = "1253.65 4.5 2154.36 7532.45 3388.44\n" +
                    "2876.22 (-3.24) 1954.66\n" +
                    "4896.23 2.29 5499.29\n" +
                    "2256.76 3.76 4286.29 5438.48 3794.43\n" +
                    "3184.38 3654.65 3455.76 6387.23 4265.77 4592.45\n" +
                    "2657.46 3265.34 2256.38 8935.26 5287.34 6598.23\n";

            assertEquals(expectedContent, fileContent.toString());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            // Delete the temporary file
            tempFile.delete();
        }
    }


    @Test
    public void getTotal() {
        double average = TwoDimRaggedArrayUtility.getTotal(dataSet1);
        assertEquals(99878.82, average, 0.0001);

    }



    @Test
    public void getAverage() { double average = TwoDimRaggedArrayUtility.getAverage(dataSet1);
        assertEquals(3567.100714285714, average, 0.01);
    }

    @Test
    public void getRowTotal() {
        double[] result = new double[dataSet1.length];
        for (int i = 0; i < dataSet1.length; i++) {
            result[i] = TwoDimRaggedArrayUtility.getRowTotal(dataSet1, i);
        }

        assertEquals(14333.40, result[0], 0.001);
        assertEquals(4827.64, result[1], 0.001);
        assertEquals(10397.81, result[2], 0.001);
        assertEquals(15779.72, result[3], 0.001);
        assertEquals(25540.24, result[4], 0.001);
        assertEquals(29000.01, result[5], 0.001);
    }

    @Test
    public void getColumnTotal() {
        double[] result = new double[dataSet1.length];
        for (int i = 0; i < dataSet1.length; i++) {
            result[i] = TwoDimRaggedArrayUtility.getColumnTotal(dataSet1, i);
        }

        assertEquals(17124.70, result[0], 0.001);
        assertEquals(6927.30, result[1], 0.001);
        assertEquals(19606.74, result[2], 0.001);
        assertEquals(28293.42, result[3], 0.001);
        assertEquals(16735.98, result[4], 0.001);
        assertEquals(11190.68, result[5], 0.001);
    }

    @Test
    public void getHighestInRow() {
        double highest = TwoDimRaggedArrayUtility.getHighestInRow(dataSet1, 0);
        assertEquals(7532.45, highest, 0.001);

    }

    @Test
    public void getLowestInRow() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInRow(dataSet1, 0);
        assertEquals(4.50, lowest, 0.001);
    }

    @Test
    public void getHighestInColumn() {
        double highest = TwoDimRaggedArrayUtility.getHighestInColumn(dataSet1, 0);
        assertEquals(4896.23, highest, 0.001);
    }

    @Test
    public void getLowestInColumn() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(dataSet1, 0);
        assertEquals(1253.65, lowest, 0.001);

    }

    @Test
    public void getHighestInArray() {
        double highest = TwoDimRaggedArrayUtility.getHighestInArray(dataSet1);
        assertEquals(8935.26, highest, 0.001);
    }

    @Test
    public void getLowestInArray() {
        double lowest = TwoDimRaggedArrayUtility.getLowestInArray(dataSet1);
        assertEquals(-3.24, lowest, 0.001);
    }

    @Test
    public void getLowestInRowIndex() {
        int rowIndex = TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet1, 3);
        assertEquals(1, rowIndex);

    }

    @Test
    public void getLowestInColumnIndex() {
        int rowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet1,0);
        assertEquals(0, rowIndex);
    }

    @Test
    public void getHighestInRowIndex() {
        int rowIndex = TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet1, 2);
        assertEquals(2, rowIndex);
    }

    @Test
    public void getHighestInColumnIndex() {
        int rowIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet1, 4);
        assertEquals(5, rowIndex);

    }
}