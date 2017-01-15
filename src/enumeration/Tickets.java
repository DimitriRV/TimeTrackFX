package enumeration;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Tickets extends AEnumeration{
	
	private static Tickets instance;
	public class Model extends IntegerStringModel
	{
		public Model(Integer id, String displayValue) {
			super(id, displayValue);
			// TODO Auto-generated constructor stub
		}
	}
	
	private Integer curProjectId = null;
	private ObservableList<Model> data = FXCollections.observableArrayList();
		
	protected Tickets(){}
	
	/**
	 * @return {@link Tickets}
	 */
	public static Tickets getInstance()
	{
		if(instance == null)
		{
			instance = new Tickets();
		}
		return instance;
	}
	
	public ObservableList<Model> getData(Integer projectId)
	{
		if(curProjectId != projectId)
		{
			if(data.size() > 0)
			{
				data.remove(0, data.size());
			}
			
			switch (projectId) {
			case 1:
				data.add(new Model(1, "Ticket 11"));
				data.add(new Model(2, "Ticket 12"));
				break;
			case 2:
				data.add(new Model(1, "Ticket 23"));
				data.add(new Model(2, "Ticket 24"));
				data.add(new Model(3, "Ticket 28"));
				break;
			case 3:
				data.add(new Model(1, "Ticket 33"));
				data.add(new Model(2, "Ticket 34"));
				data.add(new Model(3, "Ticket 38"));
				break;
			case 4:
				data.add(new Model(1, "Ticket 43"));
				data.add(new Model(2, "Ticket 44"));
				data.add(new Model(3, "Ticket 48"));
				break;
			case 5:
				data.add(new Model(1, "Ticket 53"));
				data.add(new Model(2, "Ticket 54"));
				data.add(new Model(3, "Ticket 58"));
				break;
			default:
				break;
			}
			
			curProjectId = projectId;
		}
		
		return data;
	}
}
