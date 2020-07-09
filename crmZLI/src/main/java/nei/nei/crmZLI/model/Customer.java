package nei.nei.crmZLI.model;

import java.util.List;

public interface Customer {
	Long getId();
	String getName();
	List<Memo> getMemos();
	void addMemo(MemoImp m);
	Memo getMemo(Long id);
	//void deleteMemo(Memo m);
}
