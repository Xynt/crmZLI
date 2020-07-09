package nei.nei.crmZLI.model;

import java.util.Calendar;
import java.util.Date;

public class MemoDto implements Memo {

	public Long id;
	public String value;
	public Date date;
	
	MemoDto() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		date = today.getTime();
	}
	
	public MemoDto(Memo m) {
		id = m.getId();
		value = m.getValue();
		date = m.getDate();
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public Date getDate() {
		return date;
	}

	@Override
	public String getValue() {
		return value;
	}
}
