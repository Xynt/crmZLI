package nei.nei.crmZLI.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity(name = "Customer")
public class CustomerImp implements Customer {

	@Id
	@GeneratedValue
	Long id;
	String name;
	
	@OneToMany(
	        mappedBy = "customer",
	        targetEntity = MemoImp.class,
	        cascade = CascadeType.ALL,
	        orphanRemoval = true
	    )
	List<MemoImp> memos;
	
	protected CustomerImp() {
		memos = new ArrayList<>();
	}
	
	public CustomerImp(String name) {
		this.name = name;
		memos = new ArrayList<>();
	}
	
	public CustomerImp(Customer customer) {
		name = customer.getName();
		id = customer.getId();
		memos = new ArrayList<>();
		for (Memo m : customer.getMemos()) {
			memos.add(new MemoImp(m));
		}
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
		return new ArrayList<>(memos);
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
	
	/*
	@Override
	public void deleteMemo(Memo m) {
		memos.remove(m);
	}
	*/
}
