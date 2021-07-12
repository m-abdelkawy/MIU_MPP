package application;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

public class AddressForm extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage.setTitle("Address Form");

			FlowPane flowpaneHz = new FlowPane(Orientation.HORIZONTAL, 20, 20);

			flowpaneHz.setAlignment(Pos.CENTER);
			flowpaneHz.setColumnHalignment(HPos.CENTER);
			flowpaneHz.setRowValignment(VPos.CENTER);

			/*
			 * VBox vboxTxtFields = new VBox(); HBox hboxRow1 = new HBox(); HBox hboxRow2 =
			 * new HBox(); HBox hboxRow3 = new HBox();
			 * 
			 * vboxTxtFields.getChildren().addAll(hboxRow1, hboxRow2, hboxRow3);
			 */

			// name
			Label lblName = new Label("Name");
			TextField txtName = new TextField();
			VBox vboxName = new VBox();
			// vboxName.fillWidthProperty().set(false);
			vboxName.getChildren().add(lblName);
			vboxName.getChildren().add(txtName);

			flowpaneHz.getChildren().add(vboxName);

			// street
			Label lblStreet = new Label("Street");
			TextField txtStreet = new TextField();
			VBox vboxStreet = new VBox();
			vboxStreet.getChildren().add(lblStreet);
			vboxStreet.getChildren().add(txtStreet);

			flowpaneHz.getChildren().add(vboxStreet);

			// city
			Label lblCity = new Label("City");
			TextField txtCity = new TextField();
			VBox vboxCity = new VBox();
			vboxCity.getChildren().add(lblCity);
			vboxCity.getChildren().add(txtCity);

			flowpaneHz.getChildren().add(vboxCity);

			// state
			Label lblState = new Label("State");
			TextField txtState = new TextField();
			VBox vboxState = new VBox();
			vboxState.getChildren().add(lblState);
			vboxState.getChildren().add(txtState);

			flowpaneHz.getChildren().add(vboxState);

			// zip
			Label lblZip = new Label("Zip");
			TextField txtZip = new TextField();
			VBox vboxZip = new VBox();
			vboxZip.getChildren().add(lblZip);
			vboxZip.getChildren().add(txtZip);

			flowpaneHz.getChildren().add(vboxZip);

			// Submit Button
			Region region = new Region();
			region.setPrefSize(Double.MAX_VALUE, 0.0);
			Button btnSubmit = new Button("Submit");
			flowpaneHz.getChildren().add(region);
			flowpaneHz.getChildren().add(btnSubmit);

			btnSubmit.setOnAction(event -> {
				String output = String.format("%s%n%s%n%s, %s %s",
						txtName.getText().isEmpty() ? "-Empty Value-" : txtName.getText(),
						txtStreet.getText().isEmpty() ? "-Empty Value-" : txtStreet.getText(),
						txtCity.getText().isEmpty() ? "-Empty Value-" : txtCity.getText(),
						txtState.getText().isEmpty() ? "-Empty Value-" : txtState.getText(),
						txtZip.getText().isEmpty() ? "-Empty Value-" : txtZip.getText());
				System.out.println(output);
			});

			Scene scene = new Scene(flowpaneHz, 700, 250);

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
