package main.session;

import java.time.LocalDate;
import java.time.LocalDateTime;

import base.enumeration.Projects;
import base.enumeration.Tickets;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

public class Controller {
	
	
	private ToggleGroup startStopGroup;
	private Model session;
	
	
	@FXML
	private ComboBox<base.enumeration.Projects.Model> projectCombo;
	
	@FXML
	private ComboBox<base.enumeration.Tickets.Model> ticketCombo;
	
	
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
		
		startStopGroup = new ToggleGroup();
		startStopGroup.selectedToggleProperty().addListener((observable,oldToggle,newToggle) -> handleStartStop(newToggle));
		
	}
	
	
	public void handleStartStop(Toggle newToggle)
	{
		createNewSession();
	}
	
	private void createNewSession()
	{
		session = new Model(projectCombo.getSelectionModel().getSelectedItem().getId(), ticketCombo.getSelectionModel().getSelectedItem().getId(), "");
		session.setStartDate(LocalDateTime.now());
	}
	
	private void saveSession()
	{
//		session.setBemerkung(bemerkung);
		session.setEndDate(LocalDateTime.now());
	}
	
	
	public void handleProjectSelection(base.enumeration.Projects.Model newV)
	{
//		ticketCombo.getItems().remove(0, ticketCombo.getItems().size());
		
		if(newV != null)
		{
			ticketCombo.getItems().setAll(Tickets.getInstance().getData(newV.getId()));
		}
	}
}