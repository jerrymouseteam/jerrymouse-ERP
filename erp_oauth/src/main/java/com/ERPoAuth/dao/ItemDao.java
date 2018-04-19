package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.Item;

public interface ItemDao {

	Item findItemById(long itemId);

	Item findItemByName(String itemName);

	void saveItem(Item item);

	Item updateItem(Item item);

	List<Item> findAllItems();

	void deleteItem(Item item);

	

}
