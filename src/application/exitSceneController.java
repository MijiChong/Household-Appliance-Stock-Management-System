package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class exitSceneController implements Initializable {
	@FXML
	private Button btClose;
	@FXML
	private Label nameLabel;
	@FXML
	private Label idLabel;

	@FXML
	public void exit(ActionEvent event) {
		javafx.application.Platform.exit();
	}

	public void initialize(URL url, ResourceBundle rb) {
		if (StockManagement.user.getName() == null) {
			nameLabel.setText("Goodbye!");
			
		} else {
			nameLabel.setText("Goodbye, " + StockManagement.user.getName());
			idLabel.setText("ID: " + StockManagement.user.getUserID());
		}
	}
}
