package nei.nei.crmZLI.service;

import java.util.List;

import nei.nei.crmZLI.model.Memo;

public interface MemoService {
	List<Memo> getAllMemos(Long customerId);
	Memo createMemo(Long customerId, String value);
	Memo getMemoById(Long customerId, Long id);
	void deleteMemo(Long customerId, Long id);
}
