package nei.nei.crmZLI.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nei.nei.crmZLI.model.Memo;
import nei.nei.crmZLI.model.MemoDto;
import nei.nei.crmZLI.service.MemoService;

@RestController
public class MemoRestController {

	@Autowired
	MemoService memoService;
	
	@GetMapping("/rest/customers/{customerId}/memos")
	public List<Memo> getMemos(@PathVariable("customerId") Long customerId) {
		return memoService.getAllMemos(customerId);
	}
	
	@GetMapping("/rest/customers/{customerId}/memos/{id}")
	public Memo getMemo(@PathVariable("customerId") Long customerId, @PathVariable("id") Long id) {
		return memoService.getMemoById(customerId, id);
	}
	
	@PostMapping("/rest/customers/{customerId}/memos")
	public MemoDto newMemo(@PathVariable("customerId") Long customerId, @RequestBody() MemoDto memoDto) {
		return new MemoDto(memoService.createMemo(customerId, memoDto.getValue()));
	}
	
	
	@DeleteMapping("/rest/customers/{customerId}/memos/{id}")
	public void deleteMemo(@PathVariable("customerId") Long customerId, @PathVariable("id") Long id) {
		memoService.deleteMemo(customerId, id);
	}
}
