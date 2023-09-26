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
//This class shows the actual output of the patients and procedure combined with the total cost
public class PatientDriverApp {
    public static void main(String[] args) {
        // Create a Patient object
        Patient patient = new Patient("John", "Doe", "Smith", "123 Main St", "Cityville", "CA", "90210",
                "555-123-4567", "Jane Smith", "555-987-6543");

        // Create three Procedure objects using different constructors
        Procedure procedure1 = new Procedure("X-Ray", "06/12/2023", "Dr. Lowis", 0);
        Procedure procedure2 = new Procedure("MRI", "07/15/2023", "Dr. Johnson", 1500);
        Procedure procedure3 = new Procedure();
        procedure3.setProcedureName("Blood Test");
        procedure3.setProcedureDate("08/20/2023");
        procedure3.setPractitionerName("Dr. Anderson");
        procedure3.setProcedureCharges(250);

        // Display patient information
        displayPatient(patient);

        // Display procedure information for each procedure
        displayProcedure(procedure1);
        displayProcedure(procedure2);
        displayProcedure(procedure3);

        // Calculate and display total charges for all procedures
        double totalCharges = calculateTotalCharges(procedure1, procedure2, procedure3);
        System.out.println("Total Charges for All Procedures: $" + String.format("%.2f", totalCharges));

        // Display student information
        System.out.println("\nStudent Name: Jordan Xiong");
        System.out.println("MC#: M21166680");
        System.out.println("Due Date: 09/25/2023");
    }

    // Method to display patient information
    public static void displayPatient(Patient patient) {
        System.out.println(patient.toString());
    }

    // Method to display procedure information
    public static void displayProcedure(Procedure procedure) {
        System.out.println(procedure.toString() + "\n");
    }

    // Method to calculate total charges for procedures
    public static double calculateTotalCharges(Procedure... procedures) {
        double totalCharges = 0.0;
        for (Procedure procedure : procedures) {
            totalCharges += procedure.getProcedureCharges();
        }
        return totalCharges;
    }
}
