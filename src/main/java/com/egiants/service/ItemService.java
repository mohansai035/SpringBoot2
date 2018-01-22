package com.egiants.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.egiants.dao.ItemRepository;
import com.egiants.model.Item;
import com.egiants.model.Product;

@Service
public class ItemService {
	@Autowired
	private ItemRepository itemRepository;
	
	 public Page<Item> getByPrice(BigDecimal price, int pageNumber, int pageSize) {
	        return itemRepository.findByPrice(price, new PageRequest(pageNumber, pageSize));
	    }
    
	 public Iterable<Item> getItemsById(BigDecimal price, List<Long> productIds) {
	        return itemRepository.findByItemIds(price, productIds);
	    }

	
	// create
	public void addItem(Item item) {
		itemRepository.save(item);
	}

	// read all
	public Iterable<Item> getAllItems() {
		return itemRepository.findAll();
	}

	// read one
	public Item getItem(Long id) {
		if (itemRepository.findOne(id) != null)
			return itemRepository.findOne(id);
		else
			return null;
	}

	/// search item by name and price
	public Iterable<Item> search(String name, BigDecimal price) {
		return itemRepository.findByitemNameInAndPriceIn(name, price);
	}

	// update item - same as create as crudrep checks for id
	public void updateItem(String id, Item item) {
		itemRepository.save(item);
	}

	// delete item
	public void deleteItem(Long id) {
		itemRepository.delete(id);
	}

}
