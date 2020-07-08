package nei.nei.crmZLI.model;

import java.util.ArrayList;
import java.util.List;

public class CustomerDto implements Customer {
	
	public Long id;
	public String name;
	public ArrayList<Memo> memos;

	CustomerDto() {
		memos = new ArrayList<Memo>();
	}
	
	public CustomerDto(Customer c) {
		id = c.getId();
		name = c.getName();
		memos = new ArrayList<Memo>(c.getMemos());
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
	public List<Memo> getMemos() {
		return memos;
	}

}
