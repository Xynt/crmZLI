package nei.nei.crmZLI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

public class CustomerImp implements Customer {

	@Id
	@GeneratedValue
	Long id;
	String name;
	ArrayList<Memo> memos;
	
	protected CustomerImp() {
		memos = new ArrayList<Memo>();
	}
	
	public CustomerImp(String name) {
		this.name = name;
	}
	
	@Override
	public Long getId() {
		return id;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public ArrayList<Memo> getMemos() {
		return memos;
	}

}
