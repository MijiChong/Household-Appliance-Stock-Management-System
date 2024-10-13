package application;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class mainSceneController implements Initializable {
	Main m = new Main();
	
	// get the current date, time, and day of week
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MMM-yyyy  HH:mm:ss");
	DayOfWeek dayOfWeek = DayOfWeek.from(LocalDate.now());
	LocalDateTime now = LocalDateTime.now();

	@FXML
	private Label name;
	@FXML
	private Label name3;
	@FXML
	private Label name4;
	@FXML
	private Label name2;
	@FXML
	private Label name1;
	@FXML
	private Button continueBtn;
	@FXML
	private Label welcome;
	@FXML
	private Button exit;
	@FXML
	private Label date;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		date.setText(dayOfWeek + "  " + dtf.format(now));
	}

	public void switchToLoginScene(ActionEvent event) throws IOException {
		m.changeScene("loginScene.fxml");
	}

	public void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
		
	}
}