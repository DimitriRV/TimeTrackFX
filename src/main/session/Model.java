package main.session;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	private IntegerProperty projectId;
	private IntegerProperty ticketId;
	private StringProperty bemerkung;
	private ObjectProperty<LocalDateTime> startDate;
	private ObjectProperty<LocalDateTime> endDate;
	
	/**
	 * @param projectId
	 * @param ticketId
	 * @param bemerkung
	 */
	public Model(int projectId, int ticketId, String bemerkung) {
		super();
		this.projectId = new SimpleIntegerProperty(projectId);
		this.ticketId = new SimpleIntegerProperty(ticketId);
		this.bemerkung = new SimpleStringProperty(bemerkung);
		this.startDate = new SimpleObjectProperty<LocalDateTime>();
		this.endDate = new SimpleObjectProperty<LocalDateTime>();
	}
	
	//Property getters
	public IntegerProperty projectIdProperty() {
		return projectId;
	}
	
	public IntegerProperty ticketIdProperty() {
		return ticketId;
	}
	
	public StringProperty bemerkungProperty() {
		return bemerkung;
	}
	
	public ObjectProperty<LocalDateTime> startDateProperty() {
		return startDate;
	}
	
	public ObjectProperty<LocalDateTime> endDateProperty() {
		return endDate;
	}
	
	//getters
	
	public int getProjectId() 
	{
		return projectId.get();
	}
	public int getTicketId() {
		return ticketId.get();
	}
	public String getBemerkung() {
		return bemerkung.get();
	}
	public LocalDateTime getStartDate() {
		return startDate.get();
	}
	public LocalDateTime getEndDate() {
		return endDate.get();
	}
	
	// setters
	public void setEndDate(LocalDateTime endDate) {
		this.endDate.set(endDate);
	}
	public void setProjectId(int projectId) {
		this.projectId.set(projectId);
	}
	public void setTicketId(int ticketId) {
		this.ticketId.set(ticketId);
	}
	public void setBemerkung(String bemerkung) {
		this.bemerkung.set(bemerkung);
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate.set(startDate);
	}
}
