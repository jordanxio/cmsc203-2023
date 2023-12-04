/*
 * Class: CMSC203 21575
 * Instructor: Grigoriy Grinberg
 * Description: BevShopDriverApp Class- Scanner/String
 * Due: 12/04/2023
 * Platform/compiler: IntellJ
 * I pledge that I have completed the programming
 * assignment independently. I have not copied the code
 * from a student or any source. I have not given my code
 * to any student.
   Print your Name here: Jordan Xiong
*/
import java.util.Scanner;

public class BevShopDriverApp {

    public static void main(String[] args) {
        BevShop bevShop = new BevShop();
        Scanner scanner = new Scanner(System.in);

        System.out.println("The current order in process can have at most 3 alcoholic beverages.");
        System.out.println("The minimum age to order alcohol drink is 21");

        // Start a new order
        bevShop.startNewOrder(12, Day.MONDAY, "John", 23);
        Order currentOrder = bevShop.getCurrentOrder();

        System.out.println("Your Total Order for now is " + currentOrder.calcOrderTotal());

        System.out.print("Would you please enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Would you please enter your age: ");
        int age = scanner.nextInt();

        if (bevShop.isValidAge(age)) {
            System.out.println("Your age is above 20 and you are eligible to order alcohol");
            // Add alcohol drinks
            for (int i = 0; i < 3; i++) {
                System.out.println("Would you please add an alcohol drink");
                bevShop.processAlcoholOrder("Whiskey", Size.MEDIUM);
                System.out.println("The current order of drinks is " + currentOrder.getTotalItems());
                System.out.println("The Total price on the Order is: " + currentOrder.calcOrderTotal());
            }

            System.out.println("You have a maximum alcohol drinks for this order");
        } else {
            System.out.println("Your Age is not appropriate for alcohol drink!!");
        }

        // Add more beverages
        System.out.println("#------------------------------------#");
        System.out.println("Would you please start a new order");
        scanner.nextLine(); // Clear the newline from previous input

        System.out.print("Would you please enter your name: ");
        name = scanner.nextLine();

        System.out.print("Would you please enter your age: ");
        age = scanner.nextInt();

        bevShop.startNewOrder(14, Day.TUESDAY, name, age);
        currentOrder = bevShop.getCurrentOrder();

        System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());

        bevShop.processSmoothieOrder("Berry Blast Smoothie", Size.LARGE, 3, true);
        System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());

        bevShop.processSmoothieOrder("Fruity Bunch Smoothie", Size.SMALL, 5, false);
        System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());

        bevShop.processCoffeeOrder("Espresso", Size.SMALL, true, false);
        System.out.println("The Total Price on the Order: " + currentOrder.calcOrderTotal());

        if (currentOrder.getTotalItems() < 5) {
            System.out.println("Would you please add a drink");
        } else {
            System.out.println("The current order of drinks is " + currentOrder.getTotalItems());
            System.out.println("The Total price on the Order: " + currentOrder.calcOrderTotal());
        }

        System.out.println(" The total number of fruits is " + bevShop.getMaxNumOfFruits());
        System.out.println("You reached a Maximum number of fruits");

        System.out.println("Total price on the second Order: " + bevShop.totalOrderPrice(2));
        System.out.println("Total amount for all Orders: " + bevShop.totalMonthlySale());
    }
}
