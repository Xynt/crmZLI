package nei.nei.crmZLI.model;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "Memo")
public class MemoImp implements Memo {

	@Id
	@GeneratedValue
	Long id;
	String value;
	Date date;
	
	@ManyToOne(fetch = FetchType.EAGER)
	CustomerImp customer;
	
	protected MemoImp() {
		initDate();
	}
	
	public MemoImp(String val, Customer customer) {
		value = val;
		this.customer = new CustomerImp(customer);
		initDate();
	}
	
	public MemoImp(Memo memo) {
		value = memo.getValue();
		date = memo.getDate();
		id = memo.getId();
	}

	private void initDate() {
		Calendar today = Calendar.getInstance();
		today.set(Calendar.HOUR_OF_DAY, 0);
		date = today.getTime();
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
