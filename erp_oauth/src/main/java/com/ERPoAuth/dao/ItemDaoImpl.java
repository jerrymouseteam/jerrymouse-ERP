package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Item;
import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.model.VendorType;

@Repository("itemDao")
public class ItemDaoImpl extends AbstractDao<Long, Item> implements ItemDao {

	final static Logger logger = Logger.getLogger(ItemDaoImpl.class);

	@Override
	public Item findItemById(long itemId) {
		Item item = getByKey(itemId);
		if (item != null) {
			return item;
		}
		return null;
	}

	@Override
	public Item findItemByName(String itemName) {
		logger.info("findItemByName : {}" + itemName);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("itemName", itemName));
		Item item = (Item) crit.uniqueResult();
		if (item != null) {
			return item;
		}
		return null;
	}

	@Override
	public void saveItem(Item item) {
		Long l = saveEntity(item);

	}

	@Override
	public Item updateItem(Item item) {
		return merge(item);
	}

	@Override
	public List<Item> findAllItems() {
		
		
		
		Criteria criteria = createEntityCriteriaOpenSession();
		criteria.addOrder(Order.asc("itemId"));
		criteria.setFirstResult(0);
		criteria.setMaxResults(50);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<Item> items = (List<Item>) criteria.list();
		
		//System.out.println("### Item Dao findAllItems items -- "+items);
		return items;
	}

	@Override
	public void deleteItem(Item item) {
		delete(item);

	}

}
