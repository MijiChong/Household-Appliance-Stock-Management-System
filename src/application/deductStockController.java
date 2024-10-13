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

public class deductStockController implements Initializable {

	Main m = new Main();

	@FXML
	private Button btBack;

	@FXML
	private Button btExit;

	@FXML
	private Button btConfirm;

	@FXML
	private ListView<String> myListView;

	@FXML
	private Label L1;

	@FXML
	private Label L2;

	@FXML
	private Label L3;

	@FXML
	private Label L4;

	@FXML
	private Label labelText1;

	@FXML
	private Label labelText2;

	@FXML
	private TextField tf;

	@FXML
	public void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

	@FXML
	public void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	String product;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for (Product product : StockManagement.list) {
			if (product.getStatus()) {
				myListView.getItems().add(product.getName());
			}
		}

		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {
				product = myListView.getSelectionModel().getSelectedItem();
				for (int i = 0; i < StockManagement.list.size(); i++) {
					if (product.equals(StockManagement.list.get(i).getName())) {
						if (StockManagement.list.get(i) instanceof Refrigerator) {
							Refrigerator r = (Refrigerator) StockManagement.list.get(i);
							L1.setText(Integer.toString(r.getItemNum()));
							L2.setText(r.getName());
							L3.setText("RM " + String.format("%.2f", r.getPrice()));
							L4.setText(r.getQty() + "");
							break;
						} else if (StockManagement.list.get(i) instanceof TV) {
							TV tv = (TV) StockManagement.list.get(i);
							L1.setText(Integer.toString(tv.getItemNum()));
							L2.setText(tv.getName());
							L3.setText("RM " + String.format("%.2f", tv.getPrice()));
							L4.setText(tv.getQty() + "");
							break;
						}

						else {
							Microwave m = (Microwave) StockManagement.list.get(i);
							L1.setText(Integer.toString(m.getItemNum()));
							L2.setText(m.getName());
							L3.setText("RM " + String.format("%.2f", m.getPrice()));
							L4.setText(m.getQty() + "");
							break;
						}

					}
				}
			}
		});
	}

	public void deductQty(ActionEvent event) {
		labelText1.setText(null);
		labelText2.setText(null);
		String inputQty = tf.getText();
		labelText1.setAlignment(Pos.CENTER);
		labelText2.setAlignment(Pos.CENTER);
		boolean cont = true;
		String selectedProduct = L2.getText();

		try {
			int temp = Integer.parseInt(inputQty);
			if (temp < 0) {
				labelText2.setText("Please enter a positive integer!");
				cont = false;
			}
			if (selectedProduct.isEmpty()) {
				labelText2.setText("Please select a product!");
			}

		} catch (NumberFormatException e) {
			if (selectedProduct.isEmpty()) {
				labelText2.setText("Please select a product!");
			} else if (inputQty.isEmpty()) {
				labelText2.setText("Please enter a value!");
				return;
			}

			else {
				labelText2.setText("Quantity must not contain alphabets!");
			}
			cont = false;
		}

		if (!cont) {
			return;
		}

		if (!selectedProduct.isEmpty()) {
			for (int i = 0; i < StockManagement.list.size(); i++) {
				if (StockManagement.list.get(i).getName().equals(selectedProduct)) {
					if (Integer.parseInt(inputQty) > StockManagement.list.get(i).getQty()) {
						labelText2.setText("Insufficient stock");
						return;
					}
					if (StockManagement.list.get(i) instanceof TV) {
						TV tv = (TV) StockManagement.list.get(i);
						int newQty = tv.getQty() - Integer.parseInt(inputQty); // Deduct the entered quantity
						tv.setQty(newQty); // Update the TV's quantity
						L4.setText(Integer.toString(newQty)); // Update the displayed quantity in the UI
						labelText1.setText(tv.getName() + " successfully deduct stock!");
						break;
					} else if (StockManagement.list.get(i) instanceof Refrigerator) {
						Refrigerator rf = (Refrigerator) StockManagement.list.get(i);
						int newQty = rf.getQty() - Integer.parseInt(inputQty); // Deduct the entered quantity
						rf.setQty(newQty); // Update the TV's quantity
						L4.setText(Integer.toString(newQty)); // Update the displayed quantity in the UI
						labelText1.setText(rf.getName() + " successfully deduct stock!");
						break;
					} else {
						Microwave m = (Microwave) StockManagement.list.get(i);
						int newQty = m.getQty() - Integer.parseInt(inputQty); // Deduct the entered quantity
						m.setQty(newQty); // Update the TV's quantity
						L4.setText(Integer.toString(newQty)); // Update the displayed quantity in the UI
						labelText1.setText(m.getName() + " successfully deduct stock!");
						tf.setText(null);
						break;
					}
				}

			}
		} else {
			labelText2.setText("Please select a product!");
		}
	}
}
