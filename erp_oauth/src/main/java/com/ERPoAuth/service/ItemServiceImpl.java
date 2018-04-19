package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.ItemDao;
import com.ERPoAuth.model.Item;



@Service("itemService")
@Transactional
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao dao;

	@Override
	public Item findByItemId(long itemId) {
		// TODO Auto-generated method stub
		return dao.findItemById(itemId);
	}

	@Override
	public Item findByItemName(String itemName) {
		// TODO Auto-generated method stub
		return dao.findItemByName(itemName);
	}

	@Override
	public void saveItem(Item bank) {
		// TODO Auto-generated method stub
		
		dao.saveItem(bank);
		
	}

	@Override
	public Item updateItem(Item bank) {
		// TODO Auto-generated method stub
		return dao.updateItem(bank);
	}

	@Override
	public List<Item> findAllItems() {
		
		return dao.findAllItems();
	}

	@Override
	public void deleteItem(Item Item) {
		// TODO Auto-generated method stub
		dao.deleteItem(Item);
	}

	
	



}
