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
// This class represents a medical procedure with various attributes and methods
class Procedure {
    // Private attributes to store procedure information
    private String procedureName;
    private String procedureDate;
    private String practitionerName;
    private double procedureCharges;

    // No-arg constructor
    public Procedure() {
    }

    // Parametrized constructor for name and date
    public Procedure(String procedureName, String procedureDate) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
    }

    // Parametrized constructor for all attributes
    public Procedure(String procedureName, String procedureDate, String practitionerName, double procedureCharges) {
        this.procedureName = procedureName;
        this.procedureDate = procedureDate;
        this.practitionerName = practitionerName;
        this.procedureCharges = procedureCharges;
    }

    // Get the procedure name
    public String getProcedureName() {
        return procedureName;
    }

    // Set the procedure name
    public void setProcedureName(String procedureName) {
        this.procedureName = procedureName;
    }

    // Get the procedure date
    public String getProcedureDate() {
        return procedureDate;
    }

    // Set the procedure date
    public void setProcedureDate(String procedureDate) {
        this.procedureDate = procedureDate;
    }

    // Get the practitioner's name
    public String getPractitionerName() {
        return practitionerName;
    }

    // Set the practitioner's name
    public void setPractitionerName(String practitionerName) {
        this.practitionerName = practitionerName;
    }

    // Get the procedure charges
    public double getProcedureCharges() {
        return procedureCharges;
    }

    // Set the procedure charges
    public void setProcedureCharges(double procedureCharges) {
        this.procedureCharges = procedureCharges;
    }

    // toString method to display procedure information
    @Override
    public String toString() {
        // Generate a string representation of the procedure's information
        return "\tProcedure: " + procedureName + "\n" +
                "\tProcedure Date=" + procedureDate + "\n" +
                "\tPractitioner=" + practitionerName + "\n" +
                "\tCharges=" + String.format("%.2f", procedureCharges);
    }
}
