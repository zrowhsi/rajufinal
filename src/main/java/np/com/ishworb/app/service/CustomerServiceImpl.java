package np.com.ishworb.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import np.com.ishworb.app.entity.Customer;
import np.com.ishworb.app.repository.CustomerRepository;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	CustomerRepository customerRepository;
	

	@Override
	public void add(Customer customer) {
		customerRepository.save(customer);		
	}

	@Override
	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer getById(Serializable id) {
		return customerRepository.findOne((Long) id);
	}

	@Override
	public void delete(Serializable id) {
		customerRepository.delete((Long) id);		
	}

	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id);
	}

	@Override
	public List<Customer> listCustomer() {
		return customerRepository.findAllCustomer();
	}
	

}
