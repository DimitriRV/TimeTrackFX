package main.session;

import enumeration.Projects;
import enumeration.Tickets;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;

public class Controller {
	
	@FXML
	private ComboBox<enumeration.Projects.Model> projectCombo;
	
	@FXML
	private ComboBox<enumeration.Tickets.Model> ticketCombo;
	
//	@FXML
//	private TextArea commitMessage; 
	
	
	public Controller() {
		// TODO Auto-generated constructor stub
	}
	
	@FXML
	private void initialize() 
	{
		projectCombo.getItems().setAll(Projects.getInstance().getData());
		ticketCombo.getItems().setAll(Tickets.getInstance().getData(null));
		projectCombo.valueProperty().addListener((observable, oldV, newV) -> handleProjectSelection(newV));
		
	}
	
	public void handleProjectSelection(enumeration.Projects.Model newV)
	{
		ticketCombo.getItems().remove(0, ticketCombo.getItems().size());
		
		if(newV != null)
		{
			ticketCombo.getItems().setAll(Tickets.getInstance().getData(newV.getId()));
		}
	}
}