package com.ERPoAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.ERPoAuth.model.Item;
import com.ERPoAuth.service.ItemService;





@RestController
public class ItemRestController {

	@Autowired
	ItemService itemService;

	@RequestMapping(value = "/item/list", method = RequestMethod.GET)
	public ResponseEntity<List<Item>> getAllItems() {
	
		
		
	
		System.out.println("================= ItemRestController - getAllItems ====================");
		List<Item> ItemList = itemService.findAllItems();
		//System.out.println("================= ItemRestController - getAllItems - ItemList : "+ItemList);
		if (ItemList.isEmpty()) {
			return new ResponseEntity<List<Item>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Item>>(ItemList, HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/item/create/", method = RequestMethod.POST)
	public ResponseEntity<Item> createItem(@RequestBody Item Item,
			UriComponentsBuilder ucBuilder) {

		try {
			itemService.saveItem(Item);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Item>(Item, HttpStatus.OK);
	}

	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.PUT)
	public ResponseEntity<Item> updateItem(@PathVariable("itemId") Long itemId,
			@RequestBody Item Item) {
		System.out.println("Updating User " + itemId);

		Item mergedItem = itemService.updateItem(Item);
		return new ResponseEntity<Item>(mergedItem, HttpStatus.OK);
	}

	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.DELETE)
	public ResponseEntity<Item> deleteItem(@PathVariable Long itemId) {
		System.out.println("Fetching & Deleting User with ssoId " + itemId);

		Item Item = itemService.findByItemId(itemId);
		if (Item == null) {
			System.out.println("Unable to delete. User with itemId " + itemId + " not found");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}

		itemService.deleteItem(Item);
		return new ResponseEntity<Item>(HttpStatus.NO_CONTENT);
	}

	@RequestMapping(value = "/item/{itemId}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Item> getUser(@PathVariable("itemId") Long itemId) {
		System.out.println("Fetching User with id " + itemId);
		Item Item = itemService.findByItemId(itemId);
		if (Item == null) {
			System.out.println("User with id " + itemId + " not found");
			return new ResponseEntity<Item>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Item>(Item, HttpStatus.OK);
	}
	
	
}
