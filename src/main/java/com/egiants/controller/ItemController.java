package com.egiants.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.egiants.model.Item;
import com.egiants.model.ProductAttributeDetail;
import com.egiants.service.FilterService;
import com.egiants.service.ItemService;



@RestController
@RequestMapping("/items")
public class ItemController {

	@Autowired
	private ItemService is;
	
	@Autowired
	private FilterService fcs;
	
	
	
	
	// create/update
	@RequestMapping(path = "/add", consumes = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST) // Map
																												// ONLY
																												// GET
																												// Requests
	public @ResponseBody void addItem(@RequestParam Long id, @RequestParam String name,
			@RequestParam BigDecimal price) {
		Item addItem = new Item(id, name, price);
		is.addItem(addItem);
	}

	// read all
	@RequestMapping(path = "/findAll", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Iterable<Item> getAll() {
		return is.getAllItems();
	}

	// read by id
	@RequestMapping(path = "/find/{id}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Item getItem(@PathVariable("id") Long id) {
		return is.getItem(id);
	}

	@RequestMapping(path = "/search/{name}/{price}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Iterable<Item> search(@PathVariable("name") String name,
			@PathVariable("price") BigDecimal price) {
		return is.search(name, price);
	}

	// delete item
	@RequestMapping(path = "/delete/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody void deleteItem(@PathVariable("id") Long id) {
		is.deleteItem(id);
	}


	@RequestMapping(path = "/filterPrice", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
	public @ResponseBody Iterable<Item> filterByPrice() {
		return fcs.filterItems();
	}
	
}
