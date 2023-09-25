


import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class FXDriver extends Application {
	   

	public static void main(String[] args) {
		launch(args);   
	}
		   
	@Override
	public void start(Stage stage) throws IOException {
		// Task #1: Instantiate the FXMainPane and name it 'root'
		FXMainPane root = new FXMainPane();

		// Task #2: Set the scene to hold 'root' with specified width and height
		int width = 800; // Replace with your desired width in pixels
		int height = 600; // Replace with your desired height in pixels
		Scene scene = new Scene(root, width, height);

		// Set the scene for the stage
		stage.setScene(scene);

		// Set stage title
		stage.setTitle("Hello World GUI");

		// Display the stage
		stage.show();

	}
}
