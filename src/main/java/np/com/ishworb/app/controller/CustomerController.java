package np.com.ishworb.app.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import np.com.ishworb.app.entity.Customer;
import np.com.ishworb.app.entity.CustomerDetails;
import np.com.ishworb.app.entity.Payment;
import np.com.ishworb.app.repository.CustomerDetailsRepository;
import np.com.ishworb.app.service.CustomerService;
import np.com.ishworb.app.service.PaymentService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	@Autowired
	PaymentService paymentService;

	// ======================INDEX PAGE=======================================
//	@GetMapping("/")
//	public String customer(Customer customer, CustomerDetails customerDetails, Payment payment) {
//		logger.debug("===inside customer index===");
//		return "index";
//	}

	// ======================REGISTER CUSTOMER===============================
	@GetMapping("/")
//	@GetMapping("/register")
	public ModelAndView customerReg(@ModelAttribute("customer")Customer customer,ModelMap modelMap) {
		logger.debug("===inside customer index===");
		Map<String, String> sampleDropdownMap = new HashMap<String, String>();
		sampleDropdownMap.put("SELLER", "seller");
		sampleDropdownMap.put("BUYER", "buyer");
		
//		if customer present...
		List<Customer> customers = customerService.getAll();
		List<Customer> cust = customerService.listCustomer();
		logger.debug(customers.size() + " ==customer found==");
		modelMap.addAttribute("custList", customers);
		
		modelMap.addAttribute("cust", cust);
		
		return new ModelAndView("list", "dropDownItems", sampleDropdownMap);
	}

	@PostMapping("/register")
	public String saveCustomer(@ModelAttribute Customer customer, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "index";
		}
		customerService.add(customer);
		return "redirect:/customer/";
	}

	// =========================CUSTOMER DETAILS SAVING===========================
	@GetMapping("/new")
	public String addC(Model model) {
		model.addAttribute("customers", customerService.getAll());
		model.addAttribute("customerDetails", new CustomerDetails());
		model.addAttribute("payment", new Payment());
//		return "itemdetails";
		return "buysell";
	}
	
	@GetMapping("/buy/{id}")
	public String buy(Model model, @PathVariable("id")Long id) {
		Customer cust = customerService.findById(id);
		model.addAttribute("customers", cust);
		model.addAttribute("customerDetails", new CustomerDetails());
		model.addAttribute("payment", new Payment());
		return "buyer";
	}
	@PostMapping("/buy")
	public String buy(@Valid @ModelAttribute("customerDetails") CustomerDetails customerDetails,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "buyer";
		}
		customerDetailsRepository.save(customerDetails);
		return "redirect:/customer/list";

	}
	
	@PostMapping("/new")
	public String addResume(@Valid @ModelAttribute("customerDetails") CustomerDetails customerDetails,
			BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "itemdetails";
		}
		customerDetailsRepository.save(customerDetails);
		return "redirect:/customer/list";

	}

	// =========================PAYMENT DETAILS SAVING===========================
	@PostMapping("/payment")
	public String addPayment(@Valid @ModelAttribute("payment") Payment payment, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "itemdetails";
		}
		paymentService.add(payment);
		return "redirect:/customer/list";

	}

	// ===========================LISTING CUSTOMER AND DETAILS====================
	@GetMapping("/list")
	public ModelAndView list(@ModelAttribute("customer")Customer customer,ModelMap modelMap) {
		List<Customer> customers = customerService.getAll();
		List<Customer> cust = customerService.listCustomer();
		// List<Payment>payments=paymentService.findPaymentByCustomerId(((Customer)
		// customers).getId());
		if (customers == null) {
			logger.debug("======list of customer is empty====");
			return new ModelAndView("/");
		}
		logger.debug(customers.size() + " ==customer found==");
		modelMap.addAttribute("custList", customers);
		modelMap.addAttribute("cust", cust);
		return new ModelAndView("list");
	}

	@GetMapping("/list/{id}")
	public String getById(@PathVariable(value = "id") Long id, ModelMap model) {
		logger.debug("user id=====" + id);
		// Customer cust = customerService.getById(id);
		Customer cust = customerService.findById(id);
		List<CustomerDetails> cd = customerDetailsRepository.findCustomerDetailsByCustomerId(id);
		List<Payment> payments = paymentService.findPaymentByCustomerId(id);
		model.addAttribute("custOne", cust);
		model.addAttribute("custDetails", cd);
		model.addAttribute("payments", payments);

		return "customerone";
	}

}
