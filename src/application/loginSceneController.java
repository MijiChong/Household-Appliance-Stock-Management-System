package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class loginSceneController {
	Main m = new Main();

	@FXML
	private Label errorLabel;

	@FXML
	private AnchorPane anchorPane;

	@FXML
	private Button btnBack;

	@FXML
	private Button btnExit;

	@FXML
	private Label hello;

	@FXML
	private Label name;

	@FXML
	private TextField nametf;

	@FXML
	private Label welcome;
	@FXML
	private Button btNext;

	@FXML
	void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	@FXML
	void next(ActionEvent event) throws IOException {
		String userName = nametf.getText();
		if (nametf.getText().isEmpty() || nametf.getText().isBlank()) {
			errorLabel.setText("Please enter your name!");
			return;
		}
		for (char c : userName.toCharArray()) {
			if (Character.isDigit(c)) {
				errorLabel.setText("Please enter a valid name without digits!");
				return;
			}
		}
		StockManagement.user.setNameAndID(userName);
		m.changeScene("menuScene.fxml");
	}

	@FXML
	void switchToMainScene(ActionEvent event) throws IOException {
		m.changeScene("mainScene.fxml");
	}

}
