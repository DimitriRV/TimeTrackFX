package main.session;

import base.dao.Projects;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import base.model.IntegerStringModel;

public class Controller {
	
	private Model session;
	
	@FXML
	private ComboBox<IntegerStringModel> projectsCombo;
	
	@FXML
	private ComboBox<IntegerStringModel> tasksCombo;
	
	@FXML
	private TextArea bemerkungField;
	
	@FXML
	private TextField pauseField;
	
	@FXML
	private TextField beginnField;
	
	@FXML
	private TextField endeField;
	
	private Projects projectsDao; 
	
	
	@FXML
	private void initialize() {
		
		projectsDao = new Projects();
		projectsCombo.setItems(projectsDao.getEnumData());
		
	}
}
