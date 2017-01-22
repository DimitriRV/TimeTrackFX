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
	private main.session.overview.Controller overview;
	
	
	@FXML
	private ComboBox<base.enumeration.Projects.Model> projectCombo;
	
	@FXML
	private ComboBox<base.enumeration.Tickets.Model> ticketCombo;
	
	@FXML
	private ToggleButton startButton;
	
	@FXML
	private ToggleButton stopButton;
	
	static public String startButtonValue = "start";
	static public String stopButtonValue = "stop";
	
	
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
		
		stopButton.setToggleGroup(startStopGroup);
		startButton.setToggleGroup(startStopGroup);
		
		stopButton.setSelected(true);
		startButton.setUserData(Controller.startButtonValue);
		stopButton.setUserData(Controller.stopButtonValue);
		
	}
	
	/**
	 * 
	 * @param newToggle
	 */
	public void handleStartStop(Toggle newToggle)
	{
		if(newToggle != null && newToggle.getUserData() == Controller.startButtonValue)
		{
			createNewSession();
			return;
		}
		
		saveSession();
	}
	
	/**
	 * Creates some Session
	 */
	private void createNewSession()
	{
		session = new Model(projectCombo.getSelectionModel().getSelectedItem(), ticketCombo.getSelectionModel().getSelectedItem(), "");
		session.setStartDate(LocalDateTime.now());
	}
	
	/**
	 * save some Session Data
	 */
	private void saveSession()
	{
		if(session == null)
		{
			return;
		}
//		session.setBemerkung(bemerkung);
		session.setEndDate(LocalDateTime.now());
		overview.addNewSession(session);
	}
	
	
	public void handleProjectSelection(base.enumeration.Projects.Model newV)
	{
//		ticketCombo.getItems().remove(0, ticketCombo.getItems().size());
		
		if(newV != null)
		{
			ticketCombo.getItems().setAll(Tickets.getInstance().getData(newV.getId()));
		}
	}
	
	public void setOverviewController(main.session.overview.Controller overview)
	{
		this.overview = overview;
	}
}