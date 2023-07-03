package net.javaguides.springboot.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import net.javaguides.springboot.exception.DuplicateValueException;
import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Bill;
import net.javaguides.springboot.model.Customer;
import net.javaguides.springboot.repository.BillRepository;
import net.javaguides.springboot.repository.CustomerRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/Customer")
public class CustomerController {
	@Autowired
	CustomerRepository customerrepository;
	@Autowired
	BillRepository billrepository;
	@GetMapping("/test")
	public List<Customer> getAllInventory(){
		return customerrepository.findAll();
	}
	/*
	 * @ResponseBody
	 * public List<Customer> test() {
		Customer customer = new Customer();
		customer.setCid(1);
		customer.setCustomer_name("Shreyas");
		customer.setMobno("9866564646");
		try {
		customerrepository.save(customer);
		}
		catch(Exception e) {
			new DuplicateValueException("Mobile number you have entered already exists");
		}
		List<Customer> c = new ArrayList<>();
		c.add(customer);
		return  c;
	}*/
	@PostMapping("/Customer")
	public Customer createCustomer(@RequestBody Customer customer) {
		/*try {
		return customerrepository.save(customer);
		}catch(Exception e) {
			DuplicateValueException dve = new DuplicateValueException("Unable to add data\n");
			e.printStackTrace();
		}
		return customer;*/
		return customerrepository.save(customer);
	}
	
	@GetMapping("/Customer/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable Long id) {
		Customer customer = customerrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer "+id+" Does not exist"));
		return ResponseEntity.ok(customer);
	}
	
	@PutMapping("/Customer/{id}")
	public ResponseEntity<Customer> updateCustomerById(@PathVariable Long id,@RequestBody Customer customerdetails) {
		Customer customer = customerrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer "+id+" Does not exist"));
		customer.setCustomer_name(customerdetails.getCustomer_name());
		customer.setMobno(customerdetails.getMobno());
		Customer customerupdated = customerrepository.save(customer);
		return ResponseEntity.ok(customerupdated);
	}
	
	@DeleteMapping("/Customer/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteCustomer(@PathVariable Long id){
		Customer customer = customerrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Customer "+id+" Does not exist"));
		customerrepository.delete(customer);
		Map<String,Boolean> response = new HashMap();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("Customer/billhistory/{cid}")
	public List<Bill> getCustomerBill(@PathVariable Long cid){	
		return billrepository.getAllBillsByCID(cid); //Gets all bills as per customer id
	}
	
	@GetMapping("/alltransact")
	public List<Bill> getAllBills(){
		return billrepository.findAll();
	}
	
	@Transactional
	@PostMapping("/updatebill")
	public List<Bill> AddBill(@RequestBody List<Bill> b){
		for(int i=0;i<b.size();i++) {
			billrepository.save(b.get(i));
		}
		return b;
	}
	
	
}
