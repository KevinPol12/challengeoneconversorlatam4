package application;

import java.math.BigDecimal;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import logic.Converter;
import logic.Moneda;

public class MonedaMainController implements Initializable {
	
	@FXML
	private TextField amountTextField;
	
	@FXML
	private ComboBox<Moneda> currencyInitComboBox;
	
	@FXML
	private ComboBox<Moneda>currencyFinComboBox;
	
	@FXML
	private Label usdConverterRateLabel;
	
	@FXML
	private Label resultLabel;
	
	@FXML
	private Label resultSymbolLabel;
	
	@FXML
	private Label resultCoinNameLabel;
	
	@FXML
	private Button btnConverterButton;	
	
	Converter converter = new Converter();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		
		currencyInitComboBox.getItems().addAll(converter.getMonedas());		
		currencyFinComboBox.getItems().addAll(converter.getMonedas());

		
	}//End initialize
	
	public void convert() {
		usdConverterRateLabel.setText("");
		resultSymbolLabel.setText("");
		resultLabel.setText("Loading...");
		try {
		Thread.sleep(2000);
		}catch(InterruptedException e) {e.printStackTrace();}
		resultLabel.setText("");
		
		Double num = Double.parseDouble(amountTextField.getText());
		int index = currencyInitComboBox.getValue().getIndex();
		int indexF = currencyFinComboBox.getValue().getIndex();
		String FinSymbol = currencyFinComboBox.getValue().getSymbol();
		String FinRate = Double.toString(currencyFinComboBox.getValue().getValuePerDollar());
		String CName = currencyFinComboBox.getValue().getName();
		String result;
		
		result = converter.convertAndPrint(index, num, indexF);
		
		usdConverterRateLabel.setText("1 USD = "+ FinRate+" "+CName);
		resultLabel.setText(result);
		resultSymbolLabel.setText(FinSymbol);

	}


	
}//End class

