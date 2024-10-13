package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class addRefrigeratorController {
	Main m = new Main();

	@FXML
	private Label labelWarranty;

	@FXML
	private TextField tfWarranty;

	@FXML
	private Label labelName;

	@FXML
	private Label labelDoorDesign;

	@FXML
	private Button backToMenu;

	@FXML
	private Button btAddRefrigerator;

	@FXML
	private Button btBack;

	@FXML
	private Button btExit;

	@FXML
	private ChoiceBox<String> cbDoorDesign;

	@FXML
	private Label labelCapacity;

	@FXML
	private Label labelColor;

	@FXML
	private Label labelItemNo;

	@FXML
	private Label labelPrice;

	@FXML
	private Label labelQuantity;

	@FXML
	private TextField tfCapacity;

	@FXML
	private TextField tfColor;

	@FXML
	private TextField tfItemNo;

	@FXML
	private TextField tfName;

	@FXML
	private TextField tfPrice;

	@FXML
	private TextField tfQty;

	@FXML
	private Label tfSuccess;

	private String[] doorDesign = { "Side-by-side", "French Door", "Bottom Freezer", "Top Freezer", "InstaView Door" };

	// initialize the choice box of door design
	public void initialize() {
		cbDoorDesign.getItems().addAll(doorDesign);
	}

	@FXML
	void addRefrigerator(ActionEvent event) {
		// reset all error messages to empty string
		tfSuccess.setText("");
		labelName.setText(null);
		labelDoorDesign.setText(null);
		labelColor.setText(null);
		labelCapacity.setText(null);
		labelQuantity.setText(null);
		labelPrice.setText(null);
		labelItemNo.setText(null);
		labelWarranty.setText(null);

		boolean cont = true;

		String tempName = tfName.getText();
		String tempDoorDesign = cbDoorDesign.getValue();
		String tempColor = tfColor.getText();
		String tempCapacity = tfCapacity.getText();
		String tempQty = tfQty.getText();
		String tempPrice = tfPrice.getText();
		String tempItemNo = tfItemNo.getText();
		String tempWarranty = tfWarranty.getText();

		// user input error handling
		try {
			int temp = Integer.parseInt(tempItemNo);
		} catch (NumberFormatException e) {
			labelItemNo.setText("Item number must not contain alphabets!");
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
		if (tempDoorDesign == null) {
			labelDoorDesign.setText("Please choose a door design!");
			cont = false;
		}

		if (tempColor.isBlank()) {
			labelColor.setText("Please enter a color!");
			cont = false;
		}
		for (char c : tempColor.toCharArray()) {
			if (Character.isDigit(c)) {
				labelColor.setText("Please enter valid color without digits!");
				cont = false;
			}
		}
		try {
			if (tempCapacity.isBlank()) {
				labelCapacity.setText("Please enter capacity!");
				cont = false;
			} else if (Double.parseDouble(tempCapacity) < 0) {
				labelCapacity.setText("capacity cannot be negative!");
			}
		} catch (NumberFormatException e) {
			labelCapacity.setText("Capacity must not contain alphabets!");
			cont = false;
		} catch (Exception e) {
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

		} catch (Exception e) {
			labelItemNo.setText("Item number must not contain alphabets!");
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

		// create a new refrigerator instance to add to the list
		Refrigerator r = new Refrigerator(Integer.parseInt(tempItemNo), tempName, tempDoorDesign, tempColor,
				Double.parseDouble(tempCapacity), Integer.parseInt(tempQty), Double.parseDouble(tempPrice), true,
				Integer.parseInt(tempWarranty));
		
		// add refrigerator to the product list
		StockManagement.addRefrigerator(r);
		tfSuccess.setText(r.getName() + " successfully added!");
		
		// reset all text fields when user click add
		tfName.setText("");
		cbDoorDesign.setValue(null);
		tfColor.setText("");
		tfCapacity.setText("");
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
	
	// switching scenes when user press "back to menu" button
	@FXML
	void switchToMenuScene(ActionEvent event) throws IOException {
		m.changeScene("menuScene.fxml");

	}

}
