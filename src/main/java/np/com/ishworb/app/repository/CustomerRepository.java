package np.com.ishworb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import np.com.ishworb.app.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
	// @Query("select c,sum(cd.totalAmount) FROM Customer c JOIN c.customerDetails
	// cd WHERE c.id=:id")
//	@Query("select c.id,c.name,SUM(cd.totalAmount)as totalAmount from Customer c JOIN c.customerDetails cd ON c.id=:id")
	@Query("select c from Customer c WHERE c.id=:id")
	Customer findById(@Param("id") Long id);
	@Query("SELECT c from Customer c")
	List<Customer> findAllCustomer();
}
