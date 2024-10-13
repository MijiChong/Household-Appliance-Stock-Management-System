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
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class DiscontinueProductController implements Initializable {
	Main m = new Main();

	@FXML
	private Label areYouSure;

	@FXML
	private Button btBack;

	@FXML
	private Button btDiscontinue;

	@FXML
	private Button btExit;

	@FXML
	private ChoiceBox<String> cbType;

	@FXML
	private Label l1;

	@FXML
	private Label l2;

	@FXML
	private Label label0;

	@FXML
	private Label labelItemNo;

	@FXML
	private Label labelName;

	@FXML
	private Label labelSuccess;

	@FXML
	private ListView<String> myListView;

	@FXML
	private Label selectPrompt;

	@FXML
	void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	@FXML
	void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

	private String[] productType = { "All", "Refrigerator", "TV", "Microwave" };
	String myProduct;

	@FXML
	void discontinueProduct(ActionEvent event) {
		if (myProduct == null) {
			labelSuccess.setTextFill(Color.RED);
			labelSuccess.setText("Please select a product!");
			return;

		}
		for (int i = 0; i < StockManagement.list.size(); i++) {
			if (myProduct.equals(StockManagement.list.get(i).getName())) {

				if (StockManagement.list.get(i).getStatus() == true) {
					StockManagement.list.get(i).setStatus(false);
					labelSuccess.setTextFill(Color.GREEN);
					labelSuccess.setText("Success! Product status is now unavailable.");
				} else {
					labelSuccess.setTextFill(Color.RED);
					labelSuccess.setText("*Caution: This product is already unavailable.");
				}
			}

		}
	}

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
				labelSuccess.setText("");

				myProduct = myListView.getSelectionModel().getSelectedItem();
				for (int i = 0; i < StockManagement.list.size(); i++) {
					if (myProduct.equals(StockManagement.list.get(i).getName())) {
						if (StockManagement.list.get(i) instanceof Refrigerator) {
							Refrigerator r = (Refrigerator) StockManagement.list.get(i);
							label0.setText("You are viewing a refrigerator!");
							l1.setText("Item number : ");
							labelName.setText(Integer.toString(r.getItemNum()));
							l2.setText("Product name : ");
							labelItemNo.setText(r.getName());

							break;

						} else if (StockManagement.list.get(i) instanceof TV) {
							TV tv = (TV) StockManagement.list.get(i);
							label0.setText("You are viewing a TV!");
							l1.setText("Item number : ");
							labelName.setText(Integer.toString(tv.getItemNum()));
							l2.setText("Product name : ");
							labelItemNo.setText(tv.getName());

							break;
						}

						else {
							Microwave m = (Microwave) StockManagement.list.get(i);
							label0.setText("You are viewing a microwave!");
							l1.setText("Item number : ");
							labelName.setText(Integer.toString(m.getItemNum()));
							l2.setText("Product name : ");
							labelItemNo.setText(m.getName());

							break;

						}

					}
				}

			}
		});
	}
}
