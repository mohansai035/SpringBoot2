package com.egiants.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.egiants.dao.ItemRepository;
import com.egiants.model.Item;
import com.google.common.collect.Lists;

@Service
public class FilterService {
@Autowired
private ItemRepository itemRepository;
	public  Predicate<Item> isPriceBetwee() {
      return ItemRepository.isPriceBetween();
    }
	public static <Item> Collection<Item> iterableToCollection(Iterable<Item> iterable) {
		  Collection<Item> collection = new ArrayList<>();
		  iterable.forEach(collection::add);
		  return collection;
		}
	 public  Iterable<Item> filterItems () {
		 Iterable<Item> items1=itemRepository.findAll();
		 Collection<Item> items=new ArrayList();
		items=iterableToCollection(items1);
	        return ItemRepository.filterEmployees(items, ItemRepository.isPriceBetween());
	    }

}
