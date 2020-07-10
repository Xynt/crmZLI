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

	@Override
	public void addMemo(MemoImp m) {
		memos.add(m);		
	}

	@Override
	public Memo getMemo(Long id) {
		for (Memo m : memos) {
			if (m.getId() == id) {
				return m;
			}
		}
		return null;
	}

	@Override
	public void deleteMemo(Memo m) {
		memos.remove(m);
		
	}
}
