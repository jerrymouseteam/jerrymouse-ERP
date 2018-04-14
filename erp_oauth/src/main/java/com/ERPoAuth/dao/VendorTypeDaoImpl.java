package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.VendorType;

@Repository("vendorTypeDao")
public class VendorTypeDaoImpl extends AbstractDao<Long, VendorType> implements VendorTypeDao {

	final static Logger logger = Logger.getLogger(VendorTypeDaoImpl.class);

	@Override
	public VendorType findByVendorTypeId(long vendorTypeId) {
		VendorType vendorType = getByKey(vendorTypeId);
		if (vendorType != null) {
			return vendorType;
		}
		return null;
	}

	@Override
	public VendorType findByVendorTypeName(String vendor_type_name) {
		logger.info("findByVendorTypeName : {}" + vendor_type_name);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("vendorType_name", vendor_type_name));
		VendorType vendorType = (VendorType) crit.uniqueResult();
		if (vendorType != null) {
			return vendorType;
		}
		return null;
	}

	@Override
	public void saveVendorType(VendorType vendorType) {
		persist(vendorType);

	}

	@Override
	public VendorType updateVendorType(VendorType vendorType) {
		return merge(vendorType);
	}

	@Override
	public List<VendorType> findAllVendorTypes() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("vendorType_name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<VendorType> vendorTypes = (List<VendorType>) criteria.list();
		return vendorTypes;
	}

	@Override
	public void deleteVendorType(VendorType vendorType) {
		// TODO Auto-generated method stub
		delete(vendorType);
	}

}
