package nei.nei.crmZLI.service;

import java.util.List;

import nei.nei.crmZLI.model.Customer;

public interface CustomerService {
	List<Customer> getAllCustomers();
	Customer createCustomer(String name);
	Customer getCustomerById(Long id);
}
