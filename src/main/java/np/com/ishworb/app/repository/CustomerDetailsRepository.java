package np.com.ishworb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import np.com.ishworb.app.entity.CustomerDetails;
import np.com.ishworb.app.entity.CustomerDform;

@Repository
public interface CustomerDetailsRepository extends JpaRepository<CustomerDetails, Long> {

	// @Transactional
	@Query("select c from CustomerDetails c join fetch c.customer cs where cs.id=:id")
	List<CustomerDetails> findCustomerDetailsByCustomerId(@Param("id") Long id);
//	@Query("select c.name,c.address,c.phone,cd.totalAmount from CustomerDetails cd JOIN cd.customer c WHERE c.id=:cd.id")
//	List<CustomerDetails> findDetails();

}
