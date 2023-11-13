/*
 * Class: CMSC203 CRN 21575
 * Instructor:Grigoriy Grinberg
 * Description: TwoDimRaggedArrayUtility Class - Handles general 2D arrays elements
 * Due: 11/13/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jordan Xiong
 */

package com.example.demo1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class TwoDimRaggedArrayUtility {
    /**
     * construct
     */
    public TwoDimRaggedArrayUtility() {
    }
    /**
     * readFile method -
     * @param file the file to read from
     * @return array - a two-dimensional ragged array of doubles
     */
    public static double[][] readFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int maxRows = 10;
        int maxColumns = 10;
        double[][] array = new double[maxRows][];
        int rowCount = 0;

        while (scanner.hasNextLine() && rowCount < maxRows) {
            String[] values = scanner.nextLine().trim().split("\\s+");
            array[rowCount] = new double[values.length];

            for (int i = 0; i < values.length; i++) {
                array[rowCount][i] = parseValue(values[i]);
            }

            rowCount++;
        }

        scanner.close();

        if (rowCount == 0) {
            return null; // File is empty
        }

        // Resize the array to the actual number of rows
        double[][] result = new double[rowCount][];
        System.arraycopy(array, 0, result, 0, rowCount);

        return result;
    }
    /**
     * parseValue method
     * @param str the string returning back within readFile
     * @return total - the sum of all the elements in the two-dimensional array
     */
    private static double parseValue(String str) {
        // Handle values enclosed in parentheses
        if (str.startsWith("(") && str.endsWith(")")) {
            return Double.parseDouble(str.substring(1, str.length() - 1));
        }

        return Double.parseDouble(str);
    }

    /**
     * writeToFile method
     * @param data the two-dimensional array getting total of
     * @param outputFile outFile of the two-dimensional array
     * @return total - the sum of all the elements in the two-dimensional array
     */
    public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            for (double[] row : data) {
                for (int i = 0; i < row.length; i++) {
                    writer.print(row[i] < 0 ? "(" + row[i] + ")" : row[i]);
                    if (i < row.length - 1) {
                        writer.print(" ");
                    }
                }
                writer.println();
            }
        }
    }

    /**
     * getTotal method
     * @param data the two-dimensional array getting total of
     *
     * @return total - the sum of all the elements in the two-dimensional array
     */
    public static double getTotal(double[][] data) {
        double total = 0;

        for (double[] row : data) {
            for (double value : row) {
                total += value;
            }
        }

        return total;
    }

    /**
     * getAverage method calculate average
     * @param data the two-dimensional array getting the average of
     * @return average - the average of the elements in the two-dimensional array
     */
    public static double getAverage(double[][] data)

    {

        double total = 0;

        int numOfElements = 0;

        // find the sum of the values of the 2D array

        for (int i = 0; i < data.length; i++)

        {

            for (int j = 0; j < data[i].length; j++)

            {

                total += data[i][j];

                numOfElements += 1;

            }

        }

        // find and return the average

        return (total / numOfElements);

    }

    /**
     * getRowTotal method
     * @param data the two-dimensional array
     * @param row the row index to take the total of
     * @return total - the total of the row
     */
    public static double getRowTotal(double[][] data, int row) {
        if (row < 0 || row >= data.length) {
            return 0; // Invalid row index
        }

        double total = 0;
        for (double value : data[row]) {
            total += value;
        }

        return total;
    }

    /**
     * getColumnTotal method
     * @param data the two-dimensional array
     * @param col the column index to take the total of
     * @return total - the total of the column
     */

    public static double getColumnTotal(double[][] data, int col) {
        double total = 0;

        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                total += row[col];
            }
        }

        return total;
    }

    /**
     * getHighestInRow method
     * @param data the two-dimensional array
     * @param row the row index to find the largest element of
     * @return highElementInRow - the largest element of the row
     */
    public static double getHighestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0; // Invalid row index or empty row
        }

        double max = data[row][0];

        for (double value : data[row]) {
            if (value > max) {
                max = value;
            }
        }

        return max;
    }
    /**
     * getLowestInRow method
     * @param data the two-dimensional array
     * @param row the row index to find the smallest element of
     * @return lowElementInRow - the smallest element of the row
     */
    public static double getLowestInRow(double[][] data, int row) {
        if (row < 0 || row >= data.length || data[row].length == 0) {
            return 0; // Invalid row index or empty row
        }

        double min = data[row][0];

        for (double value : data[row]) {
            if (value < min) {
                min = value;
            }
        }

        return min;
    }

    /**
     * gethighestInColumn method
     * @param data the two-dimensional array
     * @param col the column index to find the largest element of
     * @return highElementInColumn - the largest element of the column
     */

    public static double getHighestInColumn(double[][] data, int col) {
        double max = Double.MIN_VALUE;

        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                max = Math.max(max, row[col]);
            }
        }

        return max;
    }

    /**
     * getLowestInColumn method
     * @param data the two-dimensional array
     * @param col the column index to find the smallest element of
     * @return lowElementInColumn - the smallest element of the column
     */
    public static double getLowestInColumn(double[][] data, int col) {
        double min = Double.MAX_VALUE;

        for (double[] row : data) {
            if (col >= 0 && col < row.length) {
                min = Math.min(min, row[col]);
            }
        }

        return min;
    }

    /**
     * getHighestInArray method
     * @param data the two-dimensional array
     * @return highElementInArray - the largest element in the two dimensional
    array
     */
    public static double getHighestInArray(double[][] data) {
        double max = Double.MIN_VALUE;

        for (double[] row : data) {
            for (double value : row) {
                max = Math.max(max, value);
            }
        }

        return max;
    }


    /**
     * getLowestInArray method
     * @param data the two-dimensional array
     * @return lowElementInArray - the smallest element in the two-dimensional
    array
     */
    public static double getLowestInArray(double[][] data) {
        double min = Double.MAX_VALUE;

        for (double[] row : data) {
            for (double value : row) {
                min = Math.min(min, value);
            }
        }

        return min;
    }

    /**
     * getLowestInRowIndex method
     * @param data the two-dimensional array
     * @param row row of said arrays
     * @return the lowest row index
     */
    public static int getLowestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length) {
            return -1; // Invalid row index
        }

        double min = data[row][0];
        int minIndex = 0;

        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] < min) {
                min = data[row][i];
                minIndex = i;
            }
        }

        return minIndex;
    }

    /**
     * getLowestInColumnIndex method
     * @param data the two-dimensional array
     * @param col column of said arrays
     * @return the lowest column index
     */

    public static int getLowestInColumnIndex(double[][] data, int col) {
        if (col < 0) {
            return -1; // Invalid column index
        }

        double min = Double.MAX_VALUE;
        int minIndex = -1;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] < min) {
                min = data[i][col];
                minIndex = i;
            }
        }

        return minIndex;
    }



    /**
     * getHighestInRowIndex method
     * @param data the two-dimensional array
     * @param row row of said arrays
     * @return the highest row index
     */


    public static int getHighestInRowIndex(double[][] data, int row) {
        if (row < 0 || row >= data.length) {
            return -1; // Invalid row index
        }

        double max = data[row][0];
        int maxIndex = 0;

        for (int i = 1; i < data[row].length; i++) {
            if (data[row][i] > max) {
                max = data[row][i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    /**
 * getHighestColumnIndex method
 * @param data the two-dimensional array
 *  @param col column of said arrays
 *  @return the highest column index
 */
    public static int getHighestInColumnIndex(double[][] data, int col) {
        if (col < 0) {
            return -1; // Invalid column index
        }

        double max = Double.MIN_VALUE;
        int maxIndex = -1;

        for (int i = 0; i < data.length; i++) {
            if (col < data[i].length && data[i][col] > max) {
                max = data[i][col];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
