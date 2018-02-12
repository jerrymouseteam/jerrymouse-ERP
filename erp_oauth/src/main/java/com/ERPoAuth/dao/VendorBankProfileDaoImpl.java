package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.model.VendorBankProfile;

@Repository("vendorBankProfileDao")
public class VendorBankProfileDaoImpl extends AbstractDao<Long, VendorBankProfile> implements VendorBankProfileDao {

	final static Logger logger = Logger.getLogger(VendorBankProfileDaoImpl.class);

	

	@Override
	public VendorBankProfile findByvendorBankProfileId(long vendorBankProfileId) {
		VendorBankProfile vendorBankProfile = getByKey(vendorBankProfileId);
		if (vendorBankProfile != null) {
			return vendorBankProfile;
		}
		return null;
	}

	@Override
	public void saveVendorBankProfile(VendorBankProfile vendorBankProfile) {
		persist(vendorBankProfile);

	}

	@Override
	public VendorBankProfile updateVendorBankProfile(VendorBankProfile vendorBankProfile) {
		return merge(vendorBankProfile);
	}

	@Override
	public List<VendorBankProfile> findAllVendorBankProfiles() {
		Criteria criteria = createEntityCriteria().addOrder(Order.asc("bank_account_number"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<VendorBankProfile> vendorBankProfiles = (List<VendorBankProfile>) criteria.list();
		return vendorBankProfiles;
	}

	@Override
	public void deleteVendorBankProfile(VendorBankProfile vendorBankProfile) {
		delete(vendorBankProfile);

	}

}
