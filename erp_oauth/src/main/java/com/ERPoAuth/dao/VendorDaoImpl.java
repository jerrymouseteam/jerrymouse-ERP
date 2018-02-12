package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.model.VendorType;

@Repository("vendorDao")
public class VendorDaoImpl extends AbstractDao<Long, Vendor> implements VendorDao {

	final static Logger logger = Logger.getLogger(VendorDaoImpl.class);

	@Override
	public Vendor findByVendorId(long vendorId) {
		Vendor vendor = getByKey(vendorId);
		if (vendor != null) {
			return vendor;
		}
		return null;
	}

	@Override
	public Vendor findByVendorName(String vendor_name) {
		logger.info("findByVendorTypeName : {}" + vendor_name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("vendor_name", vendor_name));
		Vendor vendor = (Vendor) crit.uniqueResult();
		if (vendor != null) {
			return vendor;
		}
		return null;
	}

	@Override
	public void saveVendor(Vendor vendor) {
		persist(vendor);

	}

	@Override
	public Vendor updateVendor(Vendor vendor) {
		return merge(vendor);
	}

	@Override
	public List<Vendor> findAllVendors() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("vendor_name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<Vendor> vendors = (List<Vendor>) criteria.list();
		return vendors;
	}

	@Override
	public void deleteVendor(Vendor vendor) {
		// TODO Auto-generated method stub
		delete(vendor);
	}

}
