package nei.nei.crmZLI.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import nei.nei.crmZLI.model.Customer;
import nei.nei.crmZLI.model.Memo;
import nei.nei.crmZLI.model.MemoImp;

public interface MemoRepo extends JpaRepository<MemoImp, Long>{

	public default List<Memo> findAllMemos() {
		return new ArrayList<Memo>(findAll());
	}
	
	public Memo findMemoByValue(String value);
	
	public default Memo createMemo(MemoImp m) {
		return save(m);
	}
	
	public default void deleteMemo(Long id) {
		deleteById(id);
	}
}
