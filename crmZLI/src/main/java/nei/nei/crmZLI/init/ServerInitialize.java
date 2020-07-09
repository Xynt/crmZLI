package nei.nei.crmZLI.init;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import nei.nei.crmZLI.repository.CustomerRepo;


@Component
public class ServerInitialize implements ApplicationRunner{

	@Autowired
	CustomerRepo repo;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		repo.createCustomer("Max");
		repo.createCustomer("Fritz");
		repo.createCustomer("Lady");
	}
}
