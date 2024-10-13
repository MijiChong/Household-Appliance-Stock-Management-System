package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class menuSceneController implements Initializable {
	Main m = new Main();

	@FXML
	private Label hello;

	@FXML
	private Button btBack;
	@FXML
	private Button btExit;
	@FXML
	private Button btAddProducts;
	@FXML
	private Button btViewProducts;
	@FXML
	private Button btAddStock;
	@FXML
	private Button btDeductStock;
	@FXML
	private Button btDiscont;

	public void initialize(URL url, ResourceBundle rb) {
		hello.setText(StockManagement.user.getName());
	}

	@FXML
	public void back(ActionEvent event) throws IOException {
		m.changeScene("loginScene.fxml");
	}

	@FXML
	public void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	@FXML
	void switchToAddProductScene(ActionEvent event) throws IOException {
		m.changeScene("addProduct.fxml");
	}

	@FXML
	void switchToAddStockScene(ActionEvent event) throws IOException {
		m.changeScene("addStock.fxml");
	}

	@FXML
	void switchToDeductStockScene(ActionEvent event) throws IOException {
		m.changeScene("deductStock.fxml");
	}

	@FXML
	void switchToDiscontinueProductScene(ActionEvent event) throws IOException {
		m.changeScene("DiscontinueProduct.fxml");
	}

	@FXML
	void switchToViewProductScene(ActionEvent event) throws IOException {
		m.changeScene("viewProduct.fxml");
	}
}
