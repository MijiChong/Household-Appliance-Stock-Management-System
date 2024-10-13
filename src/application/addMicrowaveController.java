package application;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

import javafx.scene.control.TextField;

import java.io.IOException;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class addMicrowaveController {
	Main m = new Main();

	@FXML
	private Label labelWarranty;

	@FXML
	private Label labelFeature;
	@FXML
	private TextField tfName;
	@FXML
	private TextField tfWidth;
	@FXML
	private TextField tfHeight;
	@FXML
	private TextField tfLength;
	@FXML
	private TextField tfQty;
	@FXML
	private TextField tfPrice;
	@FXML
	private TextField tfItemNo;
	@FXML
	private Button btExit;
	@FXML
	private Button btAddMicrowave;
	@FXML
	private Button backToMenu;
	@FXML
	private Label labelName;
	@FXML
	private Label labelWidth;
	@FXML
	private Label labelHeight;
	@FXML
	private Label labelLength;
	@FXML
	private Label labelItemNo;
	@FXML
	private Label labelQty;
	@FXML
	private Label labelPrice;
	@FXML
	private TextField tfFeature;
	@FXML
	private TextField tfWarranty;
	@FXML
	private Label tfSuccess;

	@FXML
	public void exit(ActionEvent event) throws IOException {
		m.changeScene("exitScene.fxml");
	}

	@FXML
	public void addMicrowave(ActionEvent event) {
		// reset all error messages to empty string
		tfSuccess.setText("");
		labelName.setText(null);
		labelWidth.setText(null);
		labelHeight.setText(null);
		labelLength.setText(null);
		labelQty.setText(null);
		labelPrice.setText(null);
		labelFeature.setText(null);
		labelWarranty.setText(null);
		labelItemNo.setText(null);

		boolean cont = true;

		String tempName = tfName.getText();
		String tempWidth = tfWidth.getText();
		String tempHeight = tfHeight.getText();
		String tempLength = tfLength.getText();
		String tempQty = tfQty.getText();
		String tempPrice = tfPrice.getText();
		String tempFeature = tfFeature.getText();
		String tempWarranty = tfWarranty.getText();
		String tempItemNo = tfItemNo.getText();

		// user input error handling
		try {
			double temp = Double.parseDouble(tempWidth);
			if (temp < 0) {
				labelWidth.setText("Width cannot be negative!");
			}
		} catch (NumberFormatException e) {
			labelWidth.setText("Width must not contain alphabets!");
			cont = false;
		}

		try {
			double temp = Double.parseDouble(tempHeight);
			if (temp < 0) {
				labelHeight.setText("Height cannot be negative!");
			}
		} catch (NumberFormatException e) {
			labelHeight.setText("Height must not contain alphabets!");
			cont = false;
		}

		try {
			double temp = Double.parseDouble(tempLength);
			if (temp < 0) {
				labelLength.setText("Length cannot be negative!");
			}
		} catch (NumberFormatException e) {
			labelLength.setText("Length must not contain alphabets!");
			cont = false;
		}
		try {
			double temp = Double.parseDouble(tempWarranty);
		} catch (NumberFormatException e) {
			labelWarranty.setText("warranty must not contain alphabets!");
			cont = false;
		}
		try {
			int temp = Integer.parseInt(tempItemNo);
		} catch (NumberFormatException e) {
			labelItemNo.setText("Item number must not contain alphabets!");
			cont = false;
		}

		try {
			int temp = Integer.parseInt(tempQty);
		} catch (NumberFormatException e) {
			labelQty.setText("Quantity must not contain alphabets!");
			cont = false;
		}

		try {
			double temp = Double.parseDouble(tempPrice);
		} catch (NumberFormatException e) {
			labelPrice.setText("Price must not contain alphabets!");
			cont = false;
		}

		if (tempName.isBlank()) {
			labelName.setText("Please enter product name!");
			cont = false;
		}

		if (tempWidth.isBlank()) {
			labelWidth.setText("Please enter width!");
			cont = false;
		}

		if (tempHeight.isBlank()) {
			labelHeight.setText("Please enter height!");
			cont = false;
		}
		if (tempLength.isBlank()) {
			labelLength.setText("Please enter length!");
			cont = false;
		}

		try {
			if (tempQty.isBlank()) {
				labelQty.setText("Please enter quantity!");
				cont = false;
			} else if (Double.parseDouble(tempQty) % 1 != 0) {
				labelQty.setText("Quantity should be integer!");
				cont = false;
			} else if (Double.parseDouble(tempQty) < 0) {
				labelQty.setText("Quantity cannot be negative!");
				cont = false;
			}

		} catch (Exception e) {
			labelQty.setText("Quantity must not contain alphabets!");
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

		if (tempFeature.isBlank()) {
			labelFeature.setText("Please enter feature!");
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

		} catch (Exception e) {
			labelItemNo.setText("Item number cannot be negative!");
		}
		
		// if user input is incorrect, don't proceed
		if (!cont)
			return;
		
		// create a new microwave instance to add to the list
		Microwave mw = new Microwave(tempName, Double.parseDouble(tempWidth), Double.parseDouble(tempHeight),
				Double.parseDouble(tempLength), Integer.parseInt(tempItemNo), Integer.parseInt(tempQty),
				Double.parseDouble(tempPrice), tempFeature, Integer.parseInt(tempWarranty));
	
		// add refrigerator to the product list
		StockManagement.addMicrowave(mw);
		tfSuccess.setText(mw.getName() + " successfully added!");
		
		// reset all text fields when user click add
		tfName.setText("");
		tfWidth.setText("");
		tfHeight.setText("");
		tfLength.setText("");
		tfQty.setText("");
		tfPrice.setText("");
		tfFeature.setText("");
		tfWarranty.setText("");
		tfItemNo.setText("");
	}

	// switching scenes when user press "back to menu" button
	@FXML
	public void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");
	}

	// switching scenes when user press "add another product" button
	@FXML
	public void switchToAddProductScene(ActionEvent event) throws IOException {
		m.changeScene("addProduct.fxml");
	}
}
