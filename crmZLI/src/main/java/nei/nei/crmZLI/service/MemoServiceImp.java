package nei.nei.crmZLI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nei.nei.crmZLI.model.CustomerImp;
import nei.nei.crmZLI.model.Memo;
import nei.nei.crmZLI.model.MemoImp;
import nei.nei.crmZLI.repository.CustomerRepo;
import nei.nei.crmZLI.repository.MemoRepo;
import nei.nei.crmZLI.service.exceptions.InvalidParamException;

@Service
public class MemoServiceImp implements MemoService {

	@Autowired
	CustomerRepo customerRepo;
	
	@Autowired
	MemoRepo memoRepo;
	
	private CustomerImp getCustomer(Long customerId) {
		if (customerId != null) {
			return customerRepo.findById(customerId).orElseThrow(RuntimeException::new);
		}
		throw new InvalidParamException(String.format("Invalid ID: %s", customerId)); 
	}
	
	@Override
	public List<Memo> getAllMemos(Long customerId) {
		return getCustomer(customerId).getMemos();
	}

	@Override
	public Memo createMemo(Long customerId, String value) {
		if (value != null) {
			MemoImp m = new MemoImp(value, getCustomer(customerId));
			getCustomer(customerId).addMemo(m);
			memoRepo.createMemo(m);
			return m;
		}
		throw new InvalidParamException(String.format("Invalid Value: %s", value)); 
	}

	@Override
	public Memo getMemoById(Long customerId, Long id) {
		if (id != null) {
			Memo m = getCustomer(customerId).getMemo(id);
			if (m != null) {
				return m;
			}
		}
		throw new InvalidParamException(String.format("Invalid ID: %s", id));
	}

	/*
	@Override
	public void deleteMemo(Long customerId, Long id) {
		if (id != null) {
			Memo m = getCustomer(customerId).getMemo(id);
			if (m != null) {
				getCustomer(customerId).deleteMemo(m);
			}
		}
		throw new InvalidParamException(String.format("Invalid ID: %s", id));
	}
	*/
}
