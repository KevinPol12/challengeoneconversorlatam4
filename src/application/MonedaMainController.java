package application;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;

public class MonedaMainController implements Initializable {
	
	@FXML
	private ComboBox<String> comboboxField;
	private ChoiceBox<String> choiceboxField;
	
	private String[] box ={"Wassa","Guero"};
	
	
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		comboboxField.getItems().addAll(box);
		choiceboxField.getItems().addAll(box);
		
	}


	
}//End class

