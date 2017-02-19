package base.control;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TableCellDateTime<S> extends javafx.scene.control.TableCell<S,LocalDateTime>
{
	private final DateTimeFormatter dateColumnFormatter;
	
	public TableCellDateTime() {
		this("d.MM.Y H:m:s");
	}
	
	public TableCellDateTime(String format) {
		super();
		dateColumnFormatter= DateTimeFormatter.ofPattern(format);
	}

	@Override
	protected void updateItem(LocalDateTime item, boolean empty) 
	{
		super.updateItem(item, empty);
		if (empty || item == null)
		{
			setText(null);
		}
		else
		{
			setText(String.format(item.format(dateColumnFormatter)));
		}
	}
}
