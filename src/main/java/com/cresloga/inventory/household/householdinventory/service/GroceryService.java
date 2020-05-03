package com.cresloga.inventory.household.householdinventory.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.cresloga.inventory.household.householdinventory.constants.StatusCode;
import com.cresloga.inventory.household.householdinventory.exception.ServiceException;
import com.cresloga.inventory.household.householdinventory.models.dto.Item;
import com.cresloga.inventory.household.householdinventory.models.dto.Items;
import com.cresloga.inventory.household.householdinventory.models.jpa.GroceryItem;
import com.cresloga.inventory.household.householdinventory.repository.GroceryItemRepository;

@Service
public class GroceryService {

	private final GroceryItemRepository repository;
	
	@Autowired
	public GroceryService(GroceryItemRepository repository) {
		this.repository = repository;
	}
	
	public Items getAll() {
		Items items = new Items();
		List<GroceryItem> groceryItems = repository.findAll();
		if (CollectionUtils.isEmpty(groceryItems)) {
			throw new ServiceException(StatusCode.NOT_FOUND.getCode(), StatusCode.NOT_FOUND.getDesc());
		}
		groceryItems.stream().forEach(groceryItem -> {
			Item item = new Item();
			BeanUtils.copyProperties(groceryItem, item);
			items.add(item);
		});
		return items;
	}
	
	public Item getById(Integer id) {
		Item item = new Item();
		Optional<GroceryItem> groceryItemOpt = repository.findById(id);
		GroceryItem groceryItem = groceryItemOpt.isPresent() ? groceryItemOpt.get() : null;
		if (groceryItem == null) {
			throw new ServiceException(StatusCode.NOT_FOUND.getCode(), StatusCode.NOT_FOUND.getDesc());
		}
		BeanUtils.copyProperties(groceryItem, item);
		return item;
	}

	public void create(Item item) {
		GroceryItem groceryItem = new GroceryItem();
		BeanUtils.copyProperties(item, groceryItem);
		repository.save(groceryItem);
	}

	public void deleteById(Integer id) {
		repository.deleteById(id);
	}

	public void replaceById(Integer id, Item item) {
		Optional<GroceryItem> groceryItemOpt = repository.findById(id);
		GroceryItem groceryItem = groceryItemOpt.isPresent() ? groceryItemOpt.get() : null;
		if (groceryItem == null) {
			throw new ServiceException(StatusCode.NOT_FOUND.getCode(), StatusCode.NOT_FOUND.getDesc());
		}
		item.setId(id);
		BeanUtils.copyProperties(item, groceryItem);
		repository.save(groceryItem);
	}

	public void updateById(Integer id, BigDecimal quantity) {
		Optional<GroceryItem> groceryItemOpt = repository.findById(id);
		GroceryItem groceryItem = groceryItemOpt.isPresent() ? groceryItemOpt.get() : null;
		if (groceryItem == null) {
			throw new ServiceException(StatusCode.NOT_FOUND.getCode(), StatusCode.NOT_FOUND.getDesc());
		}
		groceryItem.setQuantity(quantity);
		repository.save(groceryItem);
	}
	
}
