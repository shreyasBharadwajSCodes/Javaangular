package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Item;
import net.javaguides.springboot.repository.ItemRepository;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/item")
public class ItemController {
	@Autowired
	ItemRepository itemrepository;
	@GetMapping("/test")
	public List<Item> getAllInventory(){
		return itemrepository.findAll();
	}
	
	
	@PostMapping("/item")
	public Item createItem(@RequestBody Item item) {
		return itemrepository.save(item);
	}
	
	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getitemById(@PathVariable Long id) {
		Item item = itemrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("item "+id+" Does not exist"));
		return ResponseEntity.ok(item);
	}
	
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItemById(@PathVariable Long id,@RequestBody Item itemdetails) {
		Item item = itemrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Item "+id+" Does not exist"));
		item.setItemname(itemdetails.getItemname());
		item.setItemprice(itemdetails.getItemprice());
		Item itemupdated = itemrepository.save(item);
		return ResponseEntity.ok(itemupdated);
	}
	
	@DeleteMapping("/item/{id}")
	public ResponseEntity<Map<String,Boolean>> deleteItem(@PathVariable Long id){
		Item item = itemrepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Item "+id+" Does not exist"));
		itemrepository.delete(item);
		Map<String,Boolean> response = new HashMap();
		response.put("deleted",Boolean.TRUE);
		return ResponseEntity.ok(response);
		
	}
	
	@GetMapping("/searchitem/{name}")
	public List<Item> getItemsByName(@PathVariable String name){
		return itemrepository.findByNameMatch(name);
	}
}
