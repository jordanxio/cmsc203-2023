/*
 * Class: CMSC203 21757
 * Instructor: Grigoriy Grinberg
 * Description: Property Class - assembles plot information into returning information for a property
 * Due: 10/23/2023
 * Platform/compiler: IntellJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
package com.example.assignment4_property;

public class Property {
    // Instance variables for property name, city, rental amount, owner, and plot
    private String propertyName;
    private String city;
    private double rentAmount;
    private String owner;
    private Plot plot;

    // Constructors
    public Property() {
        // Creates a new Property using empty strings and a default Plot.
        this("", "", 0.0, "");
    }

    public Property(String propertyName, String city, double rentAmount, String owner) {
        // Creates a new Property object using the given values and a default Plot.
        this(propertyName, city, rentAmount, owner, 0, 0, 1, 1);
    }

    public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth) {
        // Creates a new Property object using the given values and a Plot.
        this.propertyName = propertyName;
        this.city = city;
        this.rentAmount = rentAmount;
        this.owner = owner;
        this.plot = new Plot(x, y, width, depth);
    }

    public Property(Property otherProperty) {
        // Creates a new copy of the given property object.
        this.propertyName = otherProperty.propertyName;
        this.city = otherProperty.city;
        this.rentAmount = otherProperty.rentAmount;
        this.owner = otherProperty.owner;
        this.plot = new Plot(otherProperty.plot);
    }

    // Getter and Setter methods
    public String getPropertyName() {
        return propertyName;
    }

    public String getCity() {
        return city;
    }

    public double getRentAmount() {
        return rentAmount;
    }

    public String getOwner() {
        return owner;
    }

    public Plot getPlot() {
        return plot;
    }

    // Method to represent a Property instance as a String
    @Override
    public String toString() {
        return propertyName + "," + city + "," + owner + "," + rentAmount;
    }
}
