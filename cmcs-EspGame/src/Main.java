/*
 * Class: CMSC203 CRN 21757
 * Instructor: Grigoriy Grinberg
 * Description: ESP Game where you would guess a color.
 * Due: 09/11/2023
 * Platform/compiler: IntelliJ
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or
 * any source. I have not given my code to any student.
 * Print your Name here: Jordan Xiong
 */
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_TRIES = 11;
        final String COLOR_RED = "Red";
        final String COLOR_GREEN = "Green";
        final String COLOR_BLUE = "Blue";
        final String COLOR_ORANGE = "Orange";
        final String COLOR_YELLOW = "Yellow";
        int correctGuesses = 0;

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        // Get the user's name
        System.out.print("Enter your name: ");
        String name = scan.nextLine();

        boolean isValid = true;

        // Check if the name contains only letters or spaces
        for (int i = 0; i < name.length(); i++) {
            char c = name.charAt(i);
            if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
                isValid = false;
                break;
            }
        }

        if (!isValid) {
            System.out.println("Invalid name. Please enter only letters.");
            return;
        }

        // Get the student ID number
        System.out.print("MC #M: ");
        String idNumber = scan.nextLine();

        boolean isValid2 = true;

        // Check if the ID number contains only digits
        for (int i = 0; i < idNumber.length(); i++) {
            char c = idNumber.charAt(i);
            if (c < '0' || c > '9') {
                isValid2 = false;
                break;
            }
        }

        if (!isValid2) {
            System.out.println("Invalid Student ID. Please enter only numbers.");
            return;
        }

        // Get user description
        System.out.print("Describe yourself: ");
        String aboutYou = scan.nextLine();

        // Get the due date
        System.out.print("Due Date: ");
        String due = scan.nextLine();

        System.out.println("CMSC203 Assignment1: Test your ESP skills!");
        int rounds = 0;

        //switch case translating random numbers to colors
        for (int i = 0; i < MAX_TRIES; i++) {
            int randomNumber = random.nextInt(5); // Generates a random number between 0 and 4
            String selectedColor = "";

            switch (randomNumber) {
                case 0:
                    selectedColor = COLOR_RED;
                    rounds++;
                    break;
                case 1:
                    selectedColor = COLOR_GREEN;
                    rounds++;
                    break;
                case 2:
                    selectedColor = COLOR_BLUE;
                    rounds++;
                    break;
                case 3:
                    selectedColor = COLOR_ORANGE;
                    rounds++;
                    break;
                case 4:
                    selectedColor = COLOR_YELLOW;
                    rounds++;
                    break;
            }

            System.out.print("\nRound " + rounds + "\n\nI am thinking of a color.\n" +
                    "Is it Red, Green, Blue, Orange, or Yellow?\nEnter your guess: ");

            String userGuess = scan.nextLine();

            //Input validity, test colors input while outputting correct color that was chosen.
            if (!userGuess.equalsIgnoreCase(COLOR_RED) && !userGuess.equalsIgnoreCase(COLOR_GREEN)
                    && !userGuess.equalsIgnoreCase(COLOR_BLUE) && !userGuess.equalsIgnoreCase(COLOR_ORANGE)
                    && !userGuess.equalsIgnoreCase(COLOR_YELLOW)) {
                System.out.print("You entered an incorrect color. Is it Red, Green, Blue, Orange, or Yellow?");
                rounds--;

            } else if (userGuess.equalsIgnoreCase(selectedColor)) {
                System.out.println("\nI was thinking of " + selectedColor + ".");
                correctGuesses++;
            } else {
                System.out.println("\nI was thinking of " + selectedColor + ".");
            }
        }

        scan.close();

        //Replay information that the user put in the beginning.
        System.out.println("Game Over");
        System.out.println("\nYou guessed " + correctGuesses + " out of "
                + MAX_TRIES + " colors correctly.");
        System.out.println("Username: " + name);
        System.out.println("MC #M" + idNumber);
        System.out.println("User Description: " + aboutYou);
        System.out.println("Due Date: " + due);
    }
}




