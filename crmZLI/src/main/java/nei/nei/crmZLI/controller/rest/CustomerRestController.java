package nei.nei.crmZLI.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import nei.nei.crmZLI.model.Customer;
import nei.nei.crmZLI.model.CustomerDto;
import nei.nei.crmZLI.service.CustomerService;


@RestController
public class CustomerRestController {
	
	@Autowired
	CustomerService customerService;
	
	/** 
	 * @return list of all customers
	 */
	@GetMapping("/rest/customers")
	public List<CustomerDto> getCustomerList() {
		List<Customer> customers = customerService.getAllCustomers();
		List<CustomerDto> res = new ArrayList<>();
		for (Customer c : customers) {
			res.add(new CustomerDto(c));
		}
		return res;
	}
	
	@GetMapping("/rest/customers/{id}")
	public CustomerDto getCustomer(@PathVariable("id") Long id) {
		return new CustomerDto(customerService.getCustomerById(id));
	}
	
	@PostMapping("/rest/customers")
	public CustomerDto newCustomer(@RequestBody() CustomerDto customerDto) {
		
		return new CustomerDto(customerService.createCustomer(customerDto.name));
	}

}
