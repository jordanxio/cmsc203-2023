/*
 * Class: CMSC203 CRN 21575
 * Instructor:Grigoriy Grinberg
 * Description: HolidayBonus Class - handles bonuses from sections
 * Due: 11/13/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming assignment independently.
 *  I have not copied the code from a student or any source.
 *  I have not given my code to any student.
 *  Print your Name here: Jordan Xiong
 */
package com.example.demo1;
public class HolidayBonus {
    //Final Constants of bonuses
    private static final double HIGHEST_BONUS = 5000.0;
    private static final double LOWEST_BONUS = 1000.0;
    private static final double OTHER_BONUS = 2000.0;
    /**
     * Calculates the holiday bonus for each store.
     * @param data the two-dimensional array of store sales
     * @return an array of the bonus for each store
     */

    public static double[] calculateHolidayBonus(double[][] data) {
        double[] bonuses = new double[data.length];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] > 0) {
                    if (data[i][j] == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
                        bonuses[i] += HIGHEST_BONUS;
                    } else if (data[i][j] == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
                        bonuses[i] += LOWEST_BONUS;
                    } else {
                        bonuses[i] += OTHER_BONUS;
                    }
                }
            }
        }
        return bonuses;
    }

    /**
     * Calculates the total holiday bonuses
     * @param data the two-dimensional array of store sales
     * @return the total of all holiday bonuses
     */
    public static double calculateTotalHolidayBonus(double[][] data) {
        double totalBonus = 0;
        double[] bonuses = calculateHolidayBonus(data);
        for (double bonus : bonuses) {
            totalBonus += bonus;
        }
        return totalBonus;
    }}

//
