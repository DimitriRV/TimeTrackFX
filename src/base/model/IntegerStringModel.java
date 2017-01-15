package base.model;

public class IntegerStringModel {
	private Integer id;
	private String displayValue;
	
	public IntegerStringModel(Integer id, String displayValue) 
	{
		this.id = id;
		this.displayValue = displayValue;
	}
	
	@Override
	public String toString() {
		return displayValue;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		
		if(obj == null || getClass() != obj.getClass()) return false;
		
		IntegerStringModel model = (IntegerStringModel) obj; 
		
		return displayValue != null && displayValue.equals(model.displayValue) || id != null && id.equals(model.id);
	}
	
	
	@Override
	public int hashCode() {
		int result = id != null ? id.hashCode() : 0;
		result = 31 * result + (displayValue != null ? displayValue.hashCode() : 0);
		return result;
	}

	public Integer getId() {
		return id;
	}

	public String getDisplayValue() {
		return displayValue;
	}
}
