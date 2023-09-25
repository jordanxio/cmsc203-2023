


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.
 * Before beginning to implement, design the structure of your GUI in order to
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.
 * @author ralexander
 *
 */

public class FXMainPane extends VBox {
	private Button helloButton;
	private Button howdyButton;
	private Button chineseButton;
	private Button clearButton;
	private Button exitButton;
	private Label feedbackLabel;
	private TextField feedbackTextField;

	private HBox buttonBox;
	private HBox feedbackBox;

	FXMainPane() {
		// Instantiate the buttons with the specified labels
		helloButton = new Button("Hello");
		howdyButton = new Button("Howdy");
		chineseButton = new Button("Chinese");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");

		// Instantiate the label with the argument "Feedback:"
		feedbackLabel = new Label("Feedback:");

		// Instantiate the textfield
		feedbackTextField = new TextField();

		// Instantiate the HBoxes
		buttonBox = new HBox(10, helloButton, howdyButton, chineseButton, clearButton, exitButton);
		feedbackBox = new HBox(10, feedbackLabel, feedbackTextField);

		// Set alignment for the HBoxes
		buttonBox.setAlignment(Pos.CENTER);
		feedbackBox.setAlignment(Pos.CENTER);

		// Add the HBoxes to the VBox
		getChildren().addAll(buttonBox, feedbackBox);

		// Set alignment for the VBox to center vertically
		setAlignment(Pos.CENTER);

		Insets inset = new Insets(10);
		HBox.setMargin(helloButton, inset);
		HBox.setMargin(howdyButton, inset);
		HBox.setMargin(chineseButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);

		DataManager dataManager = new DataManager();

		helloButton.setOnAction(new ButtonHandler(dataManager, "Hello"));
		howdyButton.setOnAction(new ButtonHandler(dataManager, "Howdy"));
		chineseButton.setOnAction(new ButtonHandler(dataManager, "Chinese"));
		clearButton.setOnAction(new ButtonHandler(dataManager, "Clear"));
		exitButton.setOnAction(new ButtonHandler(dataManager, "Exit"));
	}
	private class ButtonHandler implements EventHandler<ActionEvent> {
		private DataManager dataManager;
		private String buttonLabel;

		public ButtonHandler(DataManager dataManager, String buttonLabel) {
			this.dataManager = dataManager;
			this.buttonLabel = buttonLabel;
		}

		@Override
		public void handle(ActionEvent event) {
			if ("Hello".equals(buttonLabel)) {
				// Call DataManager's getHello method and set the text field
				feedbackTextField.setText(dataManager.getHello());
			} else if ("Howdy".equals(buttonLabel)) {
				// Call DataManager's getHowdy method and set the text field
				feedbackTextField.setText(dataManager.getHowdy());
			} else if ("Chinese".equals(buttonLabel)) {
				// Call DataManager's getChinese method and set the text field
				feedbackTextField.setText(dataManager.getChinese());
			} else if ("Clear".equals(buttonLabel)) {
				// Clear the text field
				feedbackTextField.setText("");
			} else if ("Exit".equals(buttonLabel)) {
				// Exit the application
				Platform.exit();
				System.exit(0);
			}
		}
	}}



