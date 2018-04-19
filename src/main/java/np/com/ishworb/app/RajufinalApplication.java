package np.com.ishworb.app;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import np.com.ishworb.app.entity.Customer;
import np.com.ishworb.app.entity.CustomerDetails;
import np.com.ishworb.app.entity.Payment;
import np.com.ishworb.app.entity.PaymentMode;
import np.com.ishworb.app.repository.CustomerDetailsRepository;
import np.com.ishworb.app.repository.CustomerRepository;
import np.com.ishworb.app.repository.PaymentRepository;

@SpringBootApplication
@EnableJpaAuditing
public class RajufinalApplication implements CommandLineRunner {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CustomerRepository customerRepository;
	@Autowired
	private CustomerDetailsRepository customerDeatilsRepository;
	@Autowired
	private PaymentRepository paymentRepository;
	
	
	private static final Logger logger = LoggerFactory.getLogger(RajufinalApplication.class);

	public static void main(String[] args) {
		logger.debug("======inside main method");
		SpringApplication.run(RajufinalApplication.class, args);

	}

	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}

//	@Override
//	@Transactional
//	public void run(String... args) throws Exception {
//		logger.debug("======inside overridden method");
//		// Cleanup Database tables
//		customerDeatilsRepository.deleteAllInBatch();
//		paymentRepository.deleteAllInBatch();
//		customerRepository.deleteAllInBatch();
//		
//
//		// ======================================
//		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		// Date date = df.parse("2018-04-02");
////		Customer customer1 = new Customer("seller", "OD company", "damak", "9806049839",df.parse("2018-04-02 9:53:00"),df.parse("2018-04-02 9:53:00"));
//		Customer customer1 = new Customer("seller", "company", "damak", "9806049839");
//		
//
//		Set custDetails = new HashSet<CustomerDetails>() {
//			
//
//			{
//				add(new CustomerDetails(df.parse("2018-04-02"), "OD half", 6, (float) 1200 * 6, customer1));
//				add(new CustomerDetails(df.parse("2018-04-01"), "OD full", 5, (float) (2400 * 5), customer1));
//			}
//		};
//		customer1.setCustomerDetails( custDetails);
//		Set payment=new HashSet<Payment>() {
//			{
//				add(new Payment(df.parse("2018-04-04"),PaymentMode.CHEQUE,(float)2000,customer1));
//				add(new Payment(df.parse("2018-04-04"),PaymentMode.CASH,(float)3000,customer1));
//			}
//		};
//		customer1.setPayment(payment);
//
////		Customer customer2 = new Customer("buyer", "thapa dai", "damak", "9806049888",df.parse("2018-04-02 9:53:00"),df.parse("2018-04-02 9:53:00"));
//		Customer customer2 = new Customer("buyer", " thapa dai", "damak", "9806049839");
//		Set<CustomerDetails> custDetails2 = new HashSet<CustomerDetails>() {
//			
//
//			{
//				add(new CustomerDetails(df.parse("2018-04-02"), "OD half", 2, (float) 1200*2, customer2));
//				add(new CustomerDetails(df.parse("2018-04-01"), "OD full", 3, (float) 2400*3, customer2));
//			}
//		};
//		customer2.setCustomerDetails( custDetails2);
////		Set payment2=new HashSet<Payment>() {
////			{
////				add(new Payment(df.parse("2018-04-05"),PaymentMode.CHEQUE,(float)2500,customer2));
////				add(new Payment(df.parse("2018-04-05"),PaymentMode.CASH,(float)1500,customer2));
////			}
////		};
////		customer2.setPayment(payment2);
//
//		customerRepository.save(new HashSet<Customer>() {
//			
//
//			{
//				add(customer1);
//				add(customer2);
//			}
//		});
//		
//
//		for (Customer customer : customerRepository.findAll()) {
//			logger.info(customer.toString());
//		}
//
//	}
}
