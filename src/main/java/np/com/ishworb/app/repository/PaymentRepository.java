package np.com.ishworb.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import np.com.ishworb.app.entity.Payment;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long>{
	@Query("select p from Payment p join fetch p.customer ps where ps.id=:id")
	List<Payment> findPaymentByCustomerId(@Param("id")Long id);
}
