package base.enumeration;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Projects extends AEnumeration{
	
	private static Projects instance;
	public class Model extends IntegerStringModel{
		public Model(Integer id, String displayValue) {
			super(id, displayValue);
		}
	}
		
	private ObservableList<Model> data = FXCollections.observableArrayList();
	
	protected Projects() {
		data.add(new Model(1, "Project1"));
		data.add(new Model(2, "Project2"));
		data.add(new Model(3, "Project3"));
		data.add(new Model(4, "Project4"));
		data.add(new Model(5, "Project5"));
	}
	
	public ObservableList<Model> getData()
	{
		return data;
	}
	
	/**
	 * @return {@link Projects}
	 */
	public static Projects getInstance()
	{
		if(instance == null)
		{
			instance = new Projects();
		}
		
		return instance;
	}	
}