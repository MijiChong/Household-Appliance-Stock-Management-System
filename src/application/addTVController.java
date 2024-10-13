package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addTVController {
	Main m = new Main();

	@FXML
	private Button backToMenu;

	@FXML
	private Button btAddTV;

	@FXML
	private Button btExit;

	@FXML
	private ChoiceBox<String> cbScreenType;

	@FXML
	private Label labelDisplaySize;

	@FXML
	private Label labelItemNo;

	@FXML
	private Label labelName;

	@FXML
	private Label labelPrice;

	@FXML
	private Label labelQuantity;

	@FXML
	private Label labelResolution;

	@FXML
	private Label labelScreenType;

	@FXML
	private TextField tfDisplaySize;

	@FXML
	private TextField tfItemNo;

	@FXML
	private TextField tfName;

	@FXML
	private TextField tfPrice;

	@FXML
	private TextField tfQty;

	@FXML
	private TextField tfResolution;

	@FXML
	private Label tfSuccess;

	@FXML
	private Label labelWarranty;

	@FXML
	private TextField tfWarranty;
	
	private String[] screenType = { "LCD", "LED", "OLED", "QLED" };

	// initialize the choice box of screen type
	@FXML
	public void initialize() {
		cbScreenType.getItems().addAll(screenType);
	}

	@FXML
	void addTV(ActionEvent event) {
		
		// reset all error messages to empty string
		tfSuccess.setText("");
		labelName.setText(null);
		labelScreenType.setText(null);
		labelResolution.setText(null);
		labelDisplaySize.setText(null);
		labelQuantity.setText(null);
		labelPrice.setText(null);
		labelItemNo.setText(null);
		labelWarranty.setText(null);

		boolean cont = true;

		String tempName = tfName.getText();
		String tempScreenType = cbScreenType.getValue();
		String tempResolution = tfResolution.getText();
		String tempDisplaySize = tfDisplaySize.getText();
		String tempQty = tfQty.getText();
		String tempPrice = tfPrice.getText();
		String tempItemNo = tfItemNo.getText();
		String tempWarranty = tfWarranty.getText();

		// user input error handling
		try {
			int temp = Integer.parseInt(tempDisplaySize);
		} catch (NumberFormatException e) {
			labelDisplaySize.setText("Display size must not contain alphabets!");
			cont = false;
		}

		try {
			int temp = Integer.parseInt(tempQty);
		} catch (NumberFormatException e) {
			labelQuantity.setText("Quantity must not contain alphabets!");
			cont = false;
		}

		try {
			double temp = Double.parseDouble(tempPrice);
		} catch (NumberFormatException e) {
			labelPrice.setText("Price must not contain alphabets!");
			cont = false;
		}

		try {
			double temp = Double.parseDouble(tempWarranty);
		} catch (NumberFormatException e) {
			labelWarranty.setText("warranty must not contain alphabets!");
			cont = false;
		}

		if (tempName.isBlank()) {
			labelName.setText("Please enter product name!");
			cont = false;
		}
		if (tempScreenType == null) {
			labelScreenType.setText("Please choose a screen type!");
			cont = false;
		}

		if (tempResolution.isBlank()) {
			labelResolution.setText("Please enter a resolution!");
			cont = false;
		}
		if (tempDisplaySize.isBlank()) {
			labelDisplaySize.setText("Please enter display size!");
			cont = false;
		}
		try {
			if (tempQty.isBlank()) {
				labelQuantity.setText("Please enter quantity!");
				cont = false;
			} else if (Double.parseDouble(tempQty) % 1 != 0) {
				labelQuantity.setText("Quantity should be integer!");
				cont = false;
			} else if (Double.parseDouble(tempQty) < 0) {
				labelQuantity.setText("Quantity cannot be negative!");
				cont = false;
			}

		} catch (Exception e) {
			labelQuantity.setText("Quantity must not contain alphabets!");
		}

		try {
			if (tempPrice.isBlank()) {
				labelPrice.setText("Please enter price!");
				cont = false;
			} else if (Double.parseDouble(tempPrice) < 0) {
				labelPrice.setText("Price cannot be negative!");
			}
		} catch (Exception e) {
			cont = false;
		}
		try {
			if (tempItemNo.isBlank()) {
				labelItemNo.setText("Please enter item number!");
				cont = false;
			} else if (Double.parseDouble(tempItemNo) % 1 != 0) {
				labelItemNo.setText("Item number should be integer!");
				cont = false;
			} else if (Double.parseDouble(tempItemNo) < 0) {
				labelItemNo.setText("Item number cannot be negative!");
				cont = false;
			}

		} catch (NumberFormatException e) {
			labelItemNo.setText("Item number must not contain alphabets!");
			cont = false;
		}
		try {
			if (tempWarranty.isBlank()) {
				labelWarranty.setText("Please enter warranty!");
				cont = false;
			} else if (Double.parseDouble(tempWarranty) % 1 != 0) {
				labelWarranty.setText("Warranty should be integer!");
				cont = false;
			} else if (Double.parseDouble(tempWarranty) < 0) {
				labelWarranty.setText("Warranty cannot be negative!");
				cont = false;
			}
		} catch (Exception e) {
			cont = false;
		}

		// if user input is incorrect, don't proceed
		if (!cont)
			return;

		// create a new TV instance to add to the list
		TV tv = new TV(Integer.parseInt(tempItemNo), tempName, tempScreenType, tempResolution,
				Integer.parseInt(tempDisplaySize), Integer.parseInt(tempQty), Double.parseDouble(tempPrice), true,
				Integer.parseInt(tempWarranty));

		// reset all text fields when user click add
		StockManagement.addTV(tv);
		tfSuccess.setText(tv.getName() + " successfully added!");

		// reset all text fields when user click add
		tfName.setText("");
		cbScreenType.setValue(null);
		tfResolution.setText("");
		tfDisplaySize.setText("");
		tfQty.setText("");
		tfPrice.setText("");
		tfItemNo.setText("");
		tfWarranty.setText("");
	}

	// switching scenes when user press "exit" button
	@FXML
	void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	// switching scenes when user press "add another product" button
	@FXML
	void switchToAddProductScene(ActionEvent event) throws IOException {
		m.changeScene("addProduct.fxml");
	}

	// switching scenes when user "back to menu" button
	@FXML
	void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

}
