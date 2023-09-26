/*
 * Class: CMSC203 CRN 21575
 * Instructor:Grigoriy Grinberg
 * Description: Patient and Procedure Combined Object Class
 * Due: 09/25/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/

// This class represents a Patient with various attributes and methods
class Patient {
    // Private attributes to store patient information
    private String firstName;
    private String middleName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zipCode;
    private String phoneNumber;
    private String emergencyContactName;
    private String emergencyContactPhone;

    // No-arg constructor
    public Patient() {
    }

    // Parametrized constructor for name
    public Patient(String firstName, String middleName, String lastName) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }

    // Parametrized constructor for all attributes
    public Patient(String firstName, String middleName, String lastName, String streetAddress,
                   String city, String state, String zipCode, String phoneNumber,
                   String emergencyContactName, String emergencyContactPhone) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Get the first name
    public String getFirstName() {
        return firstName;
    }

    // Set the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Get the middle name
    public String getMiddleName() {
        return middleName;
    }

    // Set the middle name
    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    // Get the last name
    public String getLastName() {
        return lastName;
    }

    // Set the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Get the street address
    public String getStreetAddress() {
        return streetAddress;
    }

    // Set the street address
    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    // Get the city
    public String getCity() {
        return city;
    }

    // Set the city
    public void setCity(String city) {
        this.city = city;
    }

    // Get the state
    public String getState() {
        return state;
    }

    // Set the state
    public void setState(String state) {
        this.state = state;
    }

    // Get the zip code
    public String getZipCode() {
        return zipCode;
    }

    // Set the zip code
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    // Get the phone number
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Set the phone number
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Get the emergency contact name
    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    // Set the emergency contact name
    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    // Get the emergency contact phone number
    public String getEmergencyContactPhone() {
        return emergencyContactPhone;
    }

    // Set the emergency contact phone number
    public void setEmergencyContactPhone(String emergencyContactPhone) {
        this.emergencyContactPhone = emergencyContactPhone;
    }

    // Method to build full name
    public String buildFullName() {
        // Concatenate the first name, middle name, and last name to form the full name
        return firstName + " " + middleName + " " + lastName;
    }

    // Method to build address
    public String buildAddress() {
        // Concatenate the street address, city, state, and zip code to form the full address
        return streetAddress + " " + city + " " + state + " " + zipCode;
    }

    // Method to build emergency contact
    public String buildEmergencyContact() {
        // Concatenate the emergency contact name and phone number
        return emergencyContactName + " " + emergencyContactPhone;
    }

    // toString method to display patient information
    @Override
    public String toString() {
        // Generate a string representation of the patient's information
        return "Patient Info:\n" +
                " Name: " + buildFullName() + "\n" +
                " Address: " + buildAddress() + "\n" +
                " Phone: " + phoneNumber + "\n" +
                " Emergency Contact: " + buildEmergencyContact() + "\n";
    }
}
