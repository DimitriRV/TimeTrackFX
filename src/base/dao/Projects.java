package base.dao;

import base.model.IntegerStringModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Projects {

	public Projects() {
		// TODO Auto-generated constructor stub
	}
	
	public ObservableList<IntegerStringModel> getEnumData()
	{
		ObservableList<IntegerStringModel> values = FXCollections.observableArrayList();
		
		values.add(new IntegerStringModel(1, "Project1"));
		values.add(new IntegerStringModel(2, "Project2"));
		values.add(new IntegerStringModel(3, "Project3"));
		values.add(new IntegerStringModel(4, "Project4"));
		values.add(new IntegerStringModel(5, "Project5"));
		return values;
	}
}
