package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

public class viewProductController implements Initializable {
	Main m = new Main();

	@FXML
	private ChoiceBox<String> cbType;
	@FXML
	private Button btBack;
	@FXML
	private Button btExit;
	@FXML
	private ListView<String> myListView;
	@FXML
	private Label l1;
	@FXML
	private Label l10;
	@FXML
	private Label l2;
	@FXML
	private Label l3;
	@FXML
	private Label l4;
	@FXML
	private Label l5;
	@FXML
	private Label l6;
	@FXML
	private Label l7;
	@FXML
	private Label l8;
	@FXML
	private Label l9;
	@FXML
	private Label label1;
	@FXML
	private Label label2;
	@FXML
	private Label label3;
	@FXML
	private Label label4;
	@FXML
	private Label label5;
	@FXML
	private Label label6;
	@FXML
	private Label label7;
	@FXML
	private Label label8;
	@FXML
	private Label label9;
	@FXML
	private Label label10;
	@FXML
	private Label label0;

	@FXML
	private Label selectPrompt;

	private String[] productType = { "All", "Refrigerator", "TV", "Microwave" };

	@FXML
	void mouseClicked(MouseEvent event) {
		selectPrompt.setText("");
	}

	@FXML
	public void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

	@FXML
	public void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	String myProduct;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		cbType.getItems().addAll(productType);
		cbType.setValue("");

		cbType.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {

			// if the item of the list is changed
			@Override
			public void changed(ObservableValue<? extends Number> observableValue, Number value, Number new_value) {
				selectPrompt.setText("");
				myListView.getItems().clear();

				if (productType[new_value.intValue()].equals("Microwave")) {
					for (int i = 0; i < StockManagement.list.size(); i++) {
						if (StockManagement.list.get(i) instanceof Microwave) {
							myListView.getItems().add(StockManagement.list.get(i).getName());
						}
					}
				} else if (productType[new_value.intValue()].equals("TV")) {
					for (int i = 0; i < StockManagement.list.size(); i++) {
						if (StockManagement.list.get(i) instanceof TV)
							myListView.getItems().add(StockManagement.list.get(i).getName());
					}
				} else if (productType[new_value.intValue()].equals("Refrigerator")) {
					for (int i = 0; i < StockManagement.list.size(); i++) {
						if (StockManagement.list.get(i) instanceof Refrigerator)
							myListView.getItems().add(StockManagement.list.get(i).getName());
					}
				} else {
					for (int i = 0; i < StockManagement.list.size(); i++)
						myListView.getItems().add(StockManagement.list.get(i).getName());
				}
			}
		});

		myListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> arg0, String arg1, String arg2) {

				myProduct = myListView.getSelectionModel().getSelectedItem();
				for (int i = 0; i < StockManagement.list.size(); i++) {
					if (myProduct.equals(StockManagement.list.get(i).getName())) {
						if (StockManagement.list.get(i) instanceof Refrigerator) {
							Refrigerator r = (Refrigerator) StockManagement.list.get(i);
							label0.setText("You are viewing a refrigerator!");
							l1.setText("Item number : ");
							label1.setText(Integer.toString(r.getItemNum()));
							l2.setText("Product name : ");
							label2.setText(r.getName());
							l3.setText("Door design : ");
							label3.setText(r.getDoorDesign());
							l4.setText("Color : ");
							label4.setText(r.getColor());
							l5.setText("Capacity : ");
							label5.setText(Double.toString(r.getCapacity()) + " Litres");
							l6.setText("Quantity available : ");
							label6.setText(r.getQty() + "");
							l7.setText("Price : ");
							label7.setText("RM " + String.format("%.2f", r.getPrice()));
							l8.setText("Inventory value : ");
							label8.setText("RM " + String.format("%.2f", r.calcStock()));
							l9.setText("Product status : ");
							if (r.getStatus())
								label9.setText("Available");
							else
								label9.setText("Discontinued");
							l10.setText("Warranty : ");
							label10.setText(r.getWarranty() + " year(s)");
							break;

						} else if (StockManagement.list.get(i) instanceof TV) {
							TV tv = (TV) StockManagement.list.get(i);
							label0.setText("You are viewing a TV!");
							l1.setText("Item number : ");
							label1.setText(Integer.toString(tv.getItemNum()));
							l2.setText("Product name : ");
							label2.setText(tv.getName());
							l3.setText("Screen Type : ");
							label3.setText(tv.getScreenType());
							l4.setText("Resolution : ");
							label4.setText(tv.getResolution());
							l5.setText("Display size : ");
							label5.setText(Integer.toString(tv.getDisplaySize()) + " Litres");
							l6.setText("Quantity available : ");
							label6.setText(tv.getQty() + "");
							l7.setText("Price : ");
							label7.setText("RM " + String.format("%.2f", tv.getPrice()));
							l8.setText("Inventory value : ");
							label8.setText("RM " + String.format("%.2f", tv.calcStock()));
							l9.setText("Product status : ");
							if (tv.getStatus())
								label9.setText("Available");
							else
								label9.setText("Discontinued");
							l10.setText("Warranty : ");
							label10.setText(tv.getWarranty() + " year(s)");
							break;
						}

						else {
							Microwave m = (Microwave) StockManagement.list.get(i);
							label0.setText("You are viewing a microwave!");
							l1.setText("Item number : ");
							label1.setText(Integer.toString(m.getItemNum()));
							l2.setText("Product name : ");
							label2.setText(m.getName());
							l3.setText("Width (cm) : ");
							label3.setText(m.getWidth() + "");
							l4.setText("Height (cm) : ");
							label4.setText(m.getHeight() + "");
							l5.setText("Length (cm) : ");
							label5.setText(m.getLength() + "");
							l6.setText("Quantity available : ");
							label6.setText(m.getQty() + "");
							l7.setText("Price : ");
							label7.setText("RM " + String.format("%.2f", m.getPrice()));
							l8.setText("Inventory value : ");
							label8.setText("RM " + String.format("%.2f", m.calcStock()));
							l9.setText("Product status : ");
							if (m.getStatus())
								label9.setText("Available");
							else
								label9.setText("Discontinued");
							l10.setText("Warranty : ");
							label10.setText(m.getWarranty() + " year(s)");
							break;
						}
					}
				}
			}
		});
	}
}
