package nei.nei.crmZLI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nei.nei.crmZLI.model.Customer;
import nei.nei.crmZLI.repository.CustomerRepo;
import nei.nei.crmZLI.service.exceptions.CustomerAlreadyExistsException;
import nei.nei.crmZLI.service.exceptions.InvalidParamException;

@Service
public class CustomerServiceImp implements CustomerService {
	
	@Autowired
	CustomerRepo customerRepo;

	@Override
	public List<Customer> getAllCustomers() {
		return customerRepo.findAllCustomers();
	}

	@Override
	public Customer createCustomer(String name) {
		if (name != null) {
			Customer existingCust = customerRepo.findCustomerByName(name);
			if (existingCust == null) {
				return customerRepo.createCustomer(name);
			}
			throw new CustomerAlreadyExistsException(String.format("Name: %s", name));
		}
		throw new InvalidParamException(String.format("Invalid Name: %s", name));
	}

	@Override
	public Customer getCustomerById(Long id) {
		if (id != null) {
			return customerRepo.findById(id).orElseThrow(RuntimeException::new);
		} 
		throw new InvalidParamException(String.format("Invalid ID: %s", id));
	}

	@Override
	public void deleteCustomer(Long id) {
		getCustomerById(id);
		customerRepo.deleteCustomer(id);
	}
}