/*
 * Class: CMSC203 21757
 * Instructor: Grigoriy Grinberg
 * Description: Management Company Class -- focuses on the GUI's information to be displayed for properties
 * Due: 10/23/2023
 * Platform/compiler: IntellJ IDEA
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
package com.example.assignment4_property;

public class ManagementCompany {
    // Instance variables for ManagementCompany name, Tax ID, management fee percentage
    private String name;
    private String taxID;
    private double mgmFeePer;


    // Constant class variables
    public static final int MAX_PROPERTY = 5;
    public static final int MGMT_WIDTH = 10;
    public static final int MGMT_DEPTH = 10;

    // Instance array variable to store properties
    private Property[] properties;

    // Instance variable to define the plot of the management company
    private Plot plot;

    // Instance variable to store the current number of properties
    private int numberOfProperties;

    // Constructors
    public ManagementCompany() {
        // Creates a ManagementCompany object with empty strings, a default Plot, and initializes the properties array.
        this("", "", 0.0, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee) {
        // Creates a ManagementCompany object with the given values, a default Plot, and initializes the properties array.
        this(name, taxID, mgmFee, 0, 0, MGMT_WIDTH, MGMT_DEPTH);
    }

    public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth) {
        // Creates a ManagementCompany object with the given values, a Plot using the given values, and initializes the properties array.
        this.name = name;
        this.taxID = taxID;
        this.mgmFeePer = mgmFee;
        this.plot = new Plot(x, y, width, depth);
        this.properties = new Property[MAX_PROPERTY];
        this.numberOfProperties = 0;
    }

    public ManagementCompany(ManagementCompany otherCompany) {
        // Creates a new ManagementCompany copy of the given ManagementCompany.
        this(otherCompany.name, otherCompany.taxID, otherCompany.mgmFeePer, otherCompany.plot.getX(), otherCompany.plot.getY(), otherCompany.plot.getWidth(), otherCompany.plot.getDepth());
    }

    // Getter and Setter methods
    public String getName() {
        return name;
    }

    public String getTaxID() {
        return taxID;
    }

    public double getMgmFeePer() {
        return mgmFeePer;
    }

    public Plot getPlot() {
        return plot;
    }

    public Property[] getProperties() {
        return properties;
    }

    public int getPropertiesCount() {
        return numberOfProperties;
    }

    // Method to add a property to the properties array
    public int addProperty(Property property) {
        // Check if the array is full
        if (numberOfProperties >= MAX_PROPERTY) {
            return -1;
        }

        // Check if the Property object is null
        if (property == null) {
            return -2;
        }

        // Check if the property plot is encompassed by the management company plot
        if (!plot.encompasses(property.getPlot())) {
            return -3;
        }

        // Check if the property plot overlaps with any other property's plot
        for (int i = 0; i < numberOfProperties; i++) {
            if (properties[i].getPlot().overlaps(property.getPlot())) {
                return -4;
            }
        }

        // Add the property to the array
        properties[numberOfProperties] = new Property(property);
        numberOfProperties++;
        return numberOfProperties - 1;
    }

    // Method to add a property using individual parameters
    public int addProperty(String name, String city, double rent, String owner) {
        return addProperty(new Property(name, city, rent, owner));
    }

    // Method to add a property using individual parameters, including plot details
    public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
        return addProperty(new Property(name, city, rent, owner, x, y, width, depth));
    }

    // Method to calculate the total rent of all properties
    public double getTotalRent() {
        double totalRent = 0.0;
        for (int i = 0; i < numberOfProperties; i++) {
            totalRent += properties[i].getRentAmount();
        }
        return totalRent;
    }

    // Private method to find the index of the property with the highest rent
    private int maxRentPropertyIndex() {
        if (numberOfProperties == 0) {
            return -1;
        }

        int maxIndex = 0;
        double maxRent = properties[0].getRentAmount();

        for (int i = 1; i < numberOfProperties; i++) {
            double rent = properties[i].getRentAmount();
            if (rent > maxRent) {
                maxRent = rent;
                maxIndex = i;
            }
        }

        return maxIndex;
    }

    // Method to get the property with the highest rent
    public Property getHighestRentPropperty() {
        int maxIndex = maxRentPropertyIndex();
        if (maxIndex == -1) {
            return null;
        }
        return properties[maxIndex];
    }

    // Method to remove the last property
    public void removeLastProperty() {
        if (numberOfProperties > 0) {
            properties[numberOfProperties - 1] = null;
            numberOfProperties--;
        }
    }

    // Method to check if the properties array is full
    public boolean isPropertiesFull() {
        return numberOfProperties >= MAX_PROPERTY;
    }

    // Method to check if the management fee is valid
    public boolean isMangementFeeValid() {
        return mgmFeePer >= 0 && mgmFeePer <= 100;
    }

    // Method to represent information of all properties
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("List of the properties for ").append(name).append(", taxID: ").append(taxID).append("\n");

        for (int i = 0; i < numberOfProperties; i++) {
            Property property = properties[i];
            builder.append("______________________________________________________\n");
            builder.append(property.getPropertyName()).append(",");
            builder.append(property.getCity()).append(",");
            builder.append(property.getOwner()).append(",");
            builder.append(property.getRentAmount()).append("\n");
        }

        builder.append("______________________________________________________\n\n");
        builder.append(" total management Fee: ").append(mgmFeePer * getTotalRent() / 100.0);

        return builder.toString();
    }
}
