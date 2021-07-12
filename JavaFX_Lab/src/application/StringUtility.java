package application;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class StringUtility extends Application {

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("String Utility");

			FlowPane flowpaneVl = new FlowPane(Orientation.VERTICAL, 20, 20);

			flowpaneVl.setAlignment(Pos.CENTER);
			flowpaneVl.setColumnHalignment(HPos.CENTER);
			flowpaneVl.setRowValignment(VPos.CENTER);

			// Count Letters button
			Button btnCountLetters = new Button("Count Letters");
			btnCountLetters.setMinWidth(170);
			btnCountLetters.setPadding(new Insets(10, 20, 10, 20));
			btnCountLetters.setAlignment(Pos.CENTER_LEFT);
			btnCountLetters.setTextAlignment(TextAlignment.LEFT);

			// Reverse Letters Button
			Button btnReverse = new Button("Reverse Letters");
			btnReverse.setMinWidth(170);
			btnReverse.setPadding(new Insets(10, 20, 10, 20));
			btnReverse.setAlignment(Pos.CENTER_LEFT);
			btnReverse.setTextAlignment(TextAlignment.LEFT);

			// Remove Duplicates Button
			Button btnRemoveDups = new Button("Remove Duplicates");
			btnRemoveDups.setMinWidth(170);
			btnRemoveDups.setPadding(new Insets(10, 20, 10, 20));
			btnRemoveDups.setAlignment(Pos.CENTER_LEFT);
			btnRemoveDups.setTextAlignment(TextAlignment.LEFT);

			// Input text field
			VBox vboxInput = new VBox();
			Label lblInput = new Label("Input");
			TextField txtInput = new TextField();
			vboxInput.getChildren().addAll(lblInput, txtInput);

			// Output text field
			VBox vboxOutput = new VBox();
			Label lblOutput = new Label("Output");
			TextField txtOutput = new TextField();
			vboxOutput.getChildren().addAll(lblOutput, txtOutput);

			// add all components to the root container (flowpane)
			flowpaneVl.getChildren().addAll(btnCountLetters, btnReverse, btnRemoveDups, vboxInput, vboxOutput);

			// Event Handlers
			EventHandler<ActionEvent> btnCountLetterClick = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String input = txtInput.getText();
					txtOutput.setText(String.valueOf(input.length()));
				}
			};
			btnCountLetters.setOnAction(btnCountLetterClick);

			// reverse
			EventHandler<ActionEvent> btnReverseLettersClick = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String input = txtInput.getText();
					StringBuilder sb = new StringBuilder(input);
					String reversed = sb.reverse().toString();
					txtOutput.setText(reversed);
				}
			};
			btnReverse.setOnAction(btnReverseLettersClick);

			// remove duplicates
			EventHandler<ActionEvent> btnRemoveDupsClick = new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					String input = txtInput.getText();
					StringBuilder sbOutput = new StringBuilder();
					Map<Character, Character> hmap = new HashMap<Character, Character>();
					/*
					 * input.chars().forEach(c->hmap.put(Character.valueOf((char) c),
					 * Character.valueOf((char) c)));
					 * 
					 * for (Map.Entry<Character, Character> entry : hmap.entrySet()) { uniqueChars =
					 * uniqueChars.concat(entry.toString()); }
					 */

					input.chars().forEach(c -> {
						if (sbOutput.toString().indexOf(c) == -1) {
							sbOutput.append(Character.valueOf((char)c));
						}
					});
					txtOutput.setText(sbOutput.toString());
				}
			};
			btnRemoveDups.setOnAction(btnRemoveDupsClick);

			Scene scene = new Scene(flowpaneVl, 700, 200);

			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
