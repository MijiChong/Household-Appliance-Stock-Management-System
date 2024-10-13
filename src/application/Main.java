package application;

import java.io.IOException;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static Stage stg;

	@Override
	public void start(Stage primaryStage) {
		try {
			stg = primaryStage;
			Parent root = FXMLLoader.load(getClass().getResource("mainScene.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setTitle("SMS - Stock Management System");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		
		// add instances to the product list
		StockManagement.list.add(new TV(1, "Samsung QLED 4K TV", "QLED", "4K Ultra HD", 55, 4, 9000.00, true, 5));
		StockManagement.list
				.add(new TV(2, "Vizio Quantum X Ultra HD TV", "QLED", " 4K Ultra HD", 60, 6, 8500.00, true, 3));
		StockManagement.list.add(new Microwave("LG NeoChef Countertop Microwave", 55.80, 40.10, 60.70, 3, 8, 500.00,
				"SmoothTouch glass controls, hexagonal stable turntable", 2));
		StockManagement.list.add(new Refrigerator(4, "GE Bottom Freezer Refrigerator",
				"Bottom freezer drawer with French doors", "Slate Gray", 730, 2, 2500.00, true, 2));
		StockManagement.list.add(new TV(5, "ONY Bravia 8K HDR TV", "LED", " 8K Ultra HD", 70, 2, 8800.0, false, 2));
		StockManagement.list.add(new Refrigerator(6, "Frigidaire Top Mount Freezer Refrigerator",
				"Top freezer with single door refrigerator", "Black", 488, 3, 1800.00, false, 6));
		StockManagement.list.add(new Microwave("Panasonic Genius Sensor Microwave", 76.50, 53.70, 45.65, 7, 1, 450.00,
				"Inverter Turbo Defrost, Genius Sensor cooking", 10));

		launch(args);
	}

	// function to change scenes
	public void changeScene(String fxml) throws IOException {
		Parent pane = FXMLLoader.load(getClass().getResource(fxml));
		stg.getScene().setRoot(pane);
	}
}
