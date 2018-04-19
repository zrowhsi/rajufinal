package np.com.ishworb.app.service;

import java.util.List;

import np.com.ishworb.app.entity.Customer;

public interface CustomerService extends CrudService<Customer>{

	Customer findById(Long id);
	List<Customer> listCustomer();

}
