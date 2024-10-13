package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class addStockController implements Initializable {
	Main m = new Main();

	@FXML
	private ListView<String> mylist;
	@FXML
	private TextField tfNumber;
	@FXML
	private Button btBack;
	@FXML
	private Button btExit;
	@FXML
	private Button btConfirm;
	@FXML
	private Label L5;
	@FXML
	private Label L6;
	@FXML
	private Label L7;
	@FXML
	private Label L8;
	@FXML
	private TextField tfNumber1;
	@FXML
	private Label lblText;
	@FXML
	private Label lblText2;

	// Event Listener on Button[#btBack].onAction
	@FXML
	public void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

	// Event Listener on Button[#btExit].onAction
	@FXML
	public void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	String Product;

	public void initialize(URL arg0, ResourceBundle arg1) {
		for (Product product : StockManagement.list) {
			if (product.getStatus()) { // Check if product status is true
				mylist.getItems().add(product.getName()); // Add the product name directly
			}
		}

		mylist.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				Product = mylist.getSelectionModel().getSelectedItem();
				for (int i = 0; i < StockManagement.list.size(); i++) {
					if (Product.equals(StockManagement.list.get(i).getName())) {
						if (StockManagement.list.get(i) instanceof Refrigerator) {
							Refrigerator r = (Refrigerator) StockManagement.list.get(i);
							L5.setText(Integer.toString(r.getItemNum()));
							L6.setText(r.getName());
							L7.setText("RM " + String.format("%.2f", r.getPrice()));
							L8.setText(r.getQty() + "");
							break;
						} else if (StockManagement.list.get(i) instanceof TV) {
							TV tv = (TV) StockManagement.list.get(i);
							L5.setText(Integer.toString(tv.getItemNum()));
							L6.setText(tv.getName());
							L7.setText("RM " + String.format("%.2f", tv.getPrice()));
							L8.setText(tv.getQty() + "");
							break;
						}

						else {
							Microwave m = (Microwave) StockManagement.list.get(i);
							L5.setText(Integer.toString(m.getItemNum()));
							L6.setText(m.getName());
							L7.setText("RM " + String.format("%.2f", m.getPrice()));
							L8.setText(m.getQty() + "");
							break;
						}

					}
				}
			}
		});
	}

	public void addQty(ActionEvent event) {
		lblText.setText(null);
		lblText2.setText(null);
		String temQty = tfNumber1.getText();
		lblText.setAlignment(Pos.CENTER);
		lblText2.setAlignment(Pos.CENTER);
		boolean cont = true;
		String selectedProduct = L6.getText();

		try {
			int temp = Integer.parseInt(temQty);
			if (temp < 0) {
				lblText2.setText("Please enter a positive integer!");
				cont = false;
			}
			if (selectedProduct.isEmpty()) {
				lblText2.setText("Please select a product!");
			}

		} catch (NumberFormatException e) {
			if (selectedProduct.isEmpty()) {
				lblText2.setText("Please select a product!");
			} else if (temQty.isEmpty()) {
				lblText2.setText("Please enter a value!");
				return;
			}

			else {
				lblText2.setText("Quantity must not contain alphabets!");
			}
			cont = false;
		}

		if (!cont) {
			return;
		}

		if (!selectedProduct.isEmpty()) {
			for (int i = 0; i < StockManagement.list.size(); i++) {
				if (StockManagement.list.get(i).getName().equals(selectedProduct)) {
					if (StockManagement.list.get(i) instanceof TV) {
						TV tv = (TV) StockManagement.list.get(i);
						int newQty = tv.getQty() + Integer.parseInt(temQty); // Add the entered quantity
						tv.setQty(newQty); // Update the TV's quantity
						L8.setText(Integer.toString(newQty)); // Update the displayed quantity in the UI
						lblText.setText(tv.getName() + " successfully added!");
						break;
					} else if (StockManagement.list.get(i) instanceof Refrigerator) {
						Refrigerator rf = (Refrigerator) StockManagement.list.get(i);
						int newQty = rf.getQty() + Integer.parseInt(temQty); // Add the entered quantity
						rf.setQty(newQty); // Update the TV's quantity
						L8.setText(Integer.toString(newQty)); // Update the displayed quantity in the UI
						lblText.setText(rf.getName() + " successfully added stock!");
						break;
					} else {
						Microwave m = (Microwave) StockManagement.list.get(i);
						int newQty = m.getQty() + Integer.parseInt(temQty); // Add the entered quantity
						m.setQty(newQty); // Update the TV's quantity
						L8.setText(Integer.toString(newQty)); // Update the displayed quantity in the UI
						lblText.setText(m.getName() + " successfully added stock!");
						tfNumber1.setText(null);
						break;
					}
				}

			}
		} else {
			lblText2.setText("Please select a product!");
		}
	}
}
