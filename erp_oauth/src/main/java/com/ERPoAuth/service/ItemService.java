package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Item;



public interface ItemService {

	Item findByItemId(long itemId);

	Item findByItemName(String itemName);

	void saveItem(Item item);

	Item updateItem(Item item);

	List<Item> findAllItems();

	void deleteItem(Item Item);
}
