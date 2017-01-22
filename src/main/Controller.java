package main;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Controller extends Application {

	private Stage primaryStage;
	private BorderPane myPane;
	private Scene scene;
	
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
		render();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	private void render()
	{
		FXMLLoader loader = new FXMLLoader(Controller.class.getResource("View.fxml"));
		try {
			myPane = (BorderPane) loader.load();
			scene = new Scene(myPane);
			primaryStage.setScene(scene);
			primaryStage.show();
			renderChilds();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void renderChilds()
	{
		TabPane tabPane = new TabPane();
		FXMLLoader sessionLoader = new FXMLLoader(main.session.Controller.class.getResource("View.fxml"));
		try {
			BorderPane sessionPane = (BorderPane) sessionLoader.load();
			Tab tabSession = createTab("Aktuell");
			tabSession.setContent(sessionPane);
			tabPane.getTabs().add(tabSession);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		FXMLLoader overviewLoader = new FXMLLoader(main.session.overview.Controller.class.getResource("View.fxml"));
		try {
			BorderPane overviewPane = (BorderPane) overviewLoader.load();
			Tab tabOverview = createTab("Übersicht");
			tabOverview.setContent(overviewPane);
			tabPane.getTabs().add(tabOverview);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		main.session.Controller sessionC =  sessionLoader.getController();
		main.session.overview.Controller overviewC = overviewLoader.getController();
		sessionC.setOverviewController(overviewC);
		
		myPane.setCenter(tabPane);
	}
	
	private Tab createTab(String title)
	{
		Tab tab = new Tab();
		tab.setClosable(false);
		tab.setText(title);
		return tab;
	}
	
}