package np.com.ishworb.app.service;

import java.util.List;

import np.com.ishworb.app.entity.Payment;

public interface PaymentService extends CrudService<Payment>{

	List<Payment> findPaymentByCustomerId(Long id);

}
