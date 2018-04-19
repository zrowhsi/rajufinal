package np.com.ishworb.app.controller;

import java.util.ArrayList;
import java.util.Collection;
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
import org.springframework.web.servlet.ModelAndView;

import np.com.ishworb.app.entity.Customer;
import np.com.ishworb.app.entity.CustomerDetails;
import np.com.ishworb.app.entity.CustomerDform;
import np.com.ishworb.app.entity.ItemDetails;
import np.com.ishworb.app.entity.Payment;
import np.com.ishworb.app.repository.CustomerDetailsRepository;
import np.com.ishworb.app.repository.ItemRepository;
import np.com.ishworb.app.service.CustomerService;
import np.com.ishworb.app.service.PaymentService;

@Controller
public class AccountController {
	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;
	@Autowired
	CustomerDetailsRepository customerDetailsRepository;
	@Autowired
	PaymentService paymentService;
	@Autowired
	ItemRepository itemRepository;
	

	@GetMapping(value="/")
	public String index() {
		return "index";
	}
	
	@GetMapping(value="/home")
	public String test() {
		return "invoice";
	}
	
	@GetMapping("/home/buy")
	public String buy(CustomerDetails customerDetails,Model model) {
		List<ItemDetails> itemList = itemRepository.findAll();
		model.addAttribute("items", itemList);
		model.addAttribute("itemDetails", new ItemDetails());
		model.addAttribute("customers", customerService.getAll());
//		model.addAttribute("customerDetails", new CustomerDetails());
		model.addAttribute("payment", new Payment());
		
		return "itemdynamic";
	}
	
	
	@PostMapping("/home/buy")
	public String buy(@Valid @ModelAttribute("itemDetails") ItemDetails itemDetails,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "buyer";
		}
		itemRepository.save(itemDetails);
		return "redirect:/home/buy";
	}
	@PostMapping("/item/buy")
	public String itembuy(@Valid @ModelAttribute("customerDetails") CustomerDetails customerDetails,
			BindingResult result, Model model) {
		
		if (result.hasErrors()) {
			return "buyer";
		}
		System.out.println(customerDetails);
		customerDetailsRepository.save(customerDetails);
		return "redirect:/home/buy";
	}
	
	
	@GetMapping("/customer/{id}")
	public String getById(@PathVariable(value = "id") Long id, ModelMap model) {
		logger.debug("user id=====" + id);
		// Customer cust = customerService.getById(id);
		Customer cust = customerService.findById(id);
		List<CustomerDetails> cd = customerDetailsRepository.findCustomerDetailsByCustomerId(id);
		List<Payment> payments = paymentService.findPaymentByCustomerId(id);
		model.addAttribute("custOne", cust);
		model.addAttribute("custDetails", cd);
		model.addAttribute("payments", payments);

		return "singlecustomer";
	}
	
	@GetMapping("/buy/{id}")
	public String buy(Model model, @PathVariable("id")Long id) {
		Customer cust = customerService.findById(id);
//		model.addAttribute("customers", cust);
		model.addAttribute("custOne", cust);
		model.addAttribute("customerDetails", new CustomerDetails());
		model.addAttribute("payment", new Payment());
		return "customerbuy";
	}
	
	@GetMapping("/buy")
	public ModelAndView buyIndex(Customer customer,Model model) {
		model.addAttribute("customers", customerService.getAll());
		model.addAttribute("customerDetails", new CustomerDetails());
		model.addAttribute("payment", new Payment());
		logger.debug("===inside customer index===");
		Map<String, String> sampleDropdownMap = new HashMap<String, String>();
		sampleDropdownMap.put("SELLER", "seller");
		sampleDropdownMap.put("BUYER", "buyer");
		
		return new ModelAndView("buysell", "dropDownItems", sampleDropdownMap);
	}
	
	
}
