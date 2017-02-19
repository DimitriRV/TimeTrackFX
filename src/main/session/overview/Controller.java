package main.session.overview;

import java.time.LocalDateTime;

import base.control.TableCellDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import main.session.Model;

public class Controller {

	private ObservableList<Model> sessions = FXCollections.observableArrayList();

	@FXML
	private TableView<Model> sessionsTable;

	@FXML
	private TableColumn<Model, String> projectColumn;

	@FXML
	private TableColumn<Model, String> ticketColumn;

	@FXML
	private TableColumn<Model, LocalDateTime> startColumn;

	@FXML
	private TableColumn<Model, LocalDateTime> endColumn;
	

	public Controller() {
		// TODO Auto-generated constructor stub
	}

	@FXML
	private void initialize() {

		projectColumn.setCellValueFactory(cellData -> cellData.getValue().projectProperty().get().displayValueProperty());
		ticketColumn.setCellValueFactory(cellData -> cellData.getValue().ticketProperty().get().displayValueProperty());
		startColumn.setCellValueFactory(cellData -> cellData.getValue().startDateProperty());
		startColumn.setCellFactory(tableColumn -> new TableCellDateTime<Model>());
		endColumn.setCellValueFactory(cellData -> cellData.getValue().endDateProperty());
		endColumn.setCellFactory(tableColumn -> new TableCellDateTime<Model>("d-MM-Y H+m+s"));
		
		sessionsTable.setItems(sessions);
	}

	public void addNewSession(Model session) {
		sessions.add(session);

	}

}
