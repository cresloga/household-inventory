package com.cresloga.inventory.household.householdinventory.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cresloga.inventory.household.householdinventory.models.jpa.GroceryItem;

@Repository
public interface GroceryItemRepository extends JpaRepository<GroceryItem, Integer> {
	
	List<GroceryItem> findAll();
	
	Optional<GroceryItem> findById(Integer id);
	
	void deleteById(Integer id);
}
