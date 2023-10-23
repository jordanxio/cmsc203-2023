/*
 * Class: CMSC203 21757
 * Instructor: Grigoriy Grinberg
 * Description: Plot Class that determines the properties plot grid
 * Due: 10/23/2023
 * Platform/compiler: IntellJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/

package com.example.assignment4_property;

public class Plot {
    // Instance variables to represent the x and y coordinates of the upper left corner of the location,
    // and depth and width to represent the vertical and horizontal extents of the plot.
    private int x;
    private int y;
    private int width;
    private int depth;

    // Constructors
    public Plot() {
        // Creates a default Plot with width and depth of 1.
        this(0, 0, 1, 1);
    }

    public Plot(int x, int y, int width, int depth) {
        // Creates a Plot using the given values.
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public Plot(Plot otherPlot) {
        // Creates a new plot given another plot.
        this(otherPlot.x, otherPlot.y, otherPlot.width, otherPlot.depth);
    }

    // Getter and Setter methods
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    // Method to check if the current plot overlaps with another plot
    public boolean overlaps(Plot plot) {
        // Calculate the boundaries of the current plot
        int thisX1 = this.x;
        int thisX2 = this.x + this.width;
        int thisY1 = this.y;
        int thisY2 = this.y + this.depth;

        // Calculate the boundaries of the other plot
        int otherX1 = plot.x;
        int otherX2 = plot.x + plot.width;
        int otherY1 = plot.y;
        int otherY2 = plot.y + plot.depth;

        // Check for overlap
        return thisX1 < otherX2 && thisX2 > otherX1 && thisY1 < otherY2 && thisY2 > otherY1;
    }

    // Method to check if the current plot encompasses another plot
    public boolean encompasses(Plot plot) {
        // Calculate the boundaries of the current plot
        int thisX1 = this.x;
        int thisX2 = this.x + this.width;
        int thisY1 = this.y;
        int thisY2 = this.y + this.depth;

        // Calculate the boundaries of the other plot
        int otherX1 = plot.x;
        int otherX2 = plot.x + plot.width;
        int otherY1 = plot.y;
        int otherY2 = plot.y + plot.depth;

        // Check if the other plot is fully contained within the current plot
        return thisX1 <= otherX1 && thisX2 >= otherX2 && thisY1 <= otherY1 && thisY2 >= otherY2;
    }

    // Method to represent a Plot instance as a String
    @Override
    public String toString() {
        return   x + "," + y + "," + width + "," + depth ;
    }
}

