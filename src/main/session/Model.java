package main.session;

import java.time.LocalDateTime;

import base.enumeration.Projects;
import base.enumeration.Tickets;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model {
	private ObjectProperty<Projects.Model> project;
	private ObjectProperty<Tickets.Model> ticket;
	private StringProperty bemerkung;
	private ObjectProperty<LocalDateTime> startDate;
	private ObjectProperty<LocalDateTime> endDate;
	
	/**
	 * @param project
	 * @param ticket
	 * @param bemerkung
	 */
	public Model(Projects.Model project, Tickets.Model ticket, String bemerkung) {
		super();
		this.project = new SimpleObjectProperty<Projects.Model>(project);
		this.ticket = new SimpleObjectProperty<Tickets.Model>(ticket);
		this.bemerkung = new SimpleStringProperty(bemerkung);
		this.startDate = new SimpleObjectProperty<LocalDateTime>();
		this.endDate = new SimpleObjectProperty<LocalDateTime>();
	}
	
	//Property getters
	public ObjectProperty<Projects.Model> projectProperty() {
		return project;
	}
	
//	public 
	
	public ObjectProperty<Tickets.Model> ticketProperty() {
		return ticket;
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
		return project.get().getId();
	}
	
	public String getProjectDisplayValue() 
	{
		return project.get().getDisplayValue();
	}
	
	public int getTicketId() {
		return ticket.get().getId();
	}
	
	public String getTicketDisplayValue()
	{
		return ticket.get().getDisplayValue();
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
	public void setProject(Projects.Model project) {
		this.project.set(project);
	}
	public void setTicket(Tickets.Model ticket) {
		this.ticket.set(ticket);
	}
	public void setBemerkung(String bemerkung) {
		this.bemerkung.set(bemerkung);
	}
	
	public void setStartDate(LocalDateTime startDate) {
		this.startDate.set(startDate);
	}
}
