package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
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
	
	@FXML
	private ImageView loadingGif;
	
	Converter converter = new Converter();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		
		loadingGif.setVisible(false);
		currencyInitComboBox.getItems().addAll(converter.getMonedas());		
		currencyFinComboBox.getItems().addAll(converter.getMonedas());

		
	}//End initialize
	
	public void convert() throws Exception {
		
		resultLabel.setText("Loading...");
		loadingGif.setVisible(true);
		
//		PauseTransition delay = new PauseTransition(Duration.seconds(2));// Este se puede desactivar si queres.		
		Timeline timeline = new Timeline();
		timeline.getKeyFrames().addAll(
		    new KeyFrame(Duration.ZERO, e -> resultLabel.setVisible(true)),
		    new KeyFrame(Duration.seconds(2), e -> resultLabel.setVisible(false))
		);

		timeline.setOnFinished(e -> {
			resultLabel.setVisible(true);
			Double num = Double.parseDouble(amountTextField.getText());
			int index = currencyInitComboBox.getValue().getIndex();
			int indexF = currencyFinComboBox.getValue().getIndex();
			String FinSymbol = currencyFinComboBox.getValue().getSymbol();
			String FinRate = Double.toString(currencyFinComboBox.getValue().getValuePerDollar());
			String CName = currencyFinComboBox.getValue().getName();
			String result;
			loadingGif.setVisible(false);
			
			result = converter.convertAndPrint(index, num, indexF);
			
			usdConverterRateLabel.setText("1 USD = "+ FinRate+" "+CName);
			resultLabel.setText(result);
			resultSymbolLabel.setText(FinSymbol);
		});
		timeline.play();

		
		

	}//End convert
	
	public void handleEnterKeyPress(KeyEvent event) throws Exception {
		if(event.getCode() == KeyCode.ENTER) {
			convert();
		}
	}


	
}//End class controller

