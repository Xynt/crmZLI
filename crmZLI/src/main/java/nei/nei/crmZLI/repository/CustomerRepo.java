package nei.nei.crmZLI.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;

import nei.nei.crmZLI.model.Customer;
import nei.nei.crmZLI.model.CustomerImp;

public interface CustomerRepo extends JpaRepository<CustomerImp, Long>{
	
	public default List<Customer> findAllCustomers() {
		return new ArrayList<Customer>(findAll());
	}
	
	public Customer findCustomerByName(String name);
	
	public default Customer createCustomer(String name) {
		
		return save(new CustomerImp(name));
	}
	
	public default void deleteCustomer(Long id) {
		deleteById(id);
	}
}
