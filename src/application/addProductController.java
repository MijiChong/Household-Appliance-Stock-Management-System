package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class addProductController {
	Main m = new Main();

	@FXML
	private Button btExit;

	@FXML
	private Button btMicrowave;

	@FXML
	private Button btRefrigerator;

	@FXML
	private Button btTV;

	@FXML
	private Button btnBack;

	@FXML
	void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
		

	}

	@FXML
	void switchToAddMicrowaveScene(ActionEvent event) throws IOException {
		m.changeScene("addMicrowave.fxml");
	}

	@FXML
	void switchToAddRefrigeratorScene(ActionEvent event) throws IOException {
		m.changeScene("addRefrigerator.fxml");
		
	}

	@FXML
	void switchToAddTVScene(ActionEvent event) throws IOException {
		m.changeScene("addTV.fxml");
	}

	@FXML
	void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

}
