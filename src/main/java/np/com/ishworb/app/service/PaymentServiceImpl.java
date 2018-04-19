package np.com.ishworb.app.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import np.com.ishworb.app.entity.Payment;
import np.com.ishworb.app.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;

	@Override
	public void add(Payment entity) {
		paymentRepository.save(entity);
	}

	@Override
	public List<Payment> getAll() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment getById(Serializable id) {
		return paymentRepository.findOne((Long) id);
	}

	@Override
	public void delete(Serializable id) {
		paymentRepository.delete((Long) id);
	}

	@Override
	public List<Payment> findPaymentByCustomerId(@Param("id")Long id) {
		return paymentRepository.findPaymentByCustomerId(id);
	}

}
