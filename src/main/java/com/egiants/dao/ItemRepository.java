package com.egiants.dao;





import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.egiants.model.Item;
import com.egiants.model.Product;


// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
@Repository
public interface ItemRepository extends CrudRepository<Item, Long>,JpaSpecificationExecutor<Item>,PagingAndSortingRepository<Item, Long>{
     
	//public Iterable<Item> findAll(Predicate predicate);

    Page<Item> findByPrice(@Param("price") BigDecimal price, Pageable pageable);

    @Query("SELECT p FROM Item p WHERE p.price = :price AND p.itemId IN (:itemIds)")
    Iterable<Item> findByItemIds(@Param("price") BigDecimal price, @Param("itemIds") List<Long> itemIds);

	public Iterable<Item> findByitemNameInAndPriceIn(String name, BigDecimal prices);
	public static   Predicate<Item> isPriceBetween() {
        return p -> p.getPrice().intValue()>100 && p.getPrice().intValue()<200;
    }
	public static   Iterable<Item> filterEmployees (Collection<Item> items, Predicate<Item> predicate) {
		
        return items.stream().filter(predicate).collect(Collectors.<Item>toList());
    }
}
