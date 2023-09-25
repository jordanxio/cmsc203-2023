import java.util.Scanner;

public class MovieDriver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean continueInput = true;

        while (continueInput) {
            Movie movie = new Movie();

            System.out.println("Enter the title of the movie");
            String title = input.nextLine();
            movie.setTitle(title);

            System.out.println("Enter the rating of the movie");
            String rating = input.nextLine();
            movie.setRating(rating);

            System.out.println("Enter the number of tickets sold for this movie");
            int ticketsSold = Integer.parseInt(input.nextLine());
            movie.setSoldTickets(ticketsSold);

            System.out.println(movie.toString());

            System.out.println("Do you want to enter another? (y or n)");
            String response = input.nextLine().toLowerCase();

            if (!response.equals("y")) {
                continueInput = false;
            }
        }

        System.out.println("Goodbye");
        input.close();
    }
}
