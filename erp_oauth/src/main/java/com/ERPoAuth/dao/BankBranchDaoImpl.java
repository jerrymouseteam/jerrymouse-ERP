package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;

@Repository("bankBranchDao")
public class BankBranchDaoImpl extends AbstractDao<Long, BankBranch> implements BankBranchDao {

	final static Logger logger = Logger.getLogger(BankBranchDaoImpl.class);

	@Override
	public BankBranch findByIfsc(String ifsc) {
		logger.info("BankName : {}" + ifsc);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("branch_ifsc", ifsc));
		BankBranch bankBranch = (BankBranch) crit.uniqueResult();
		if (bankBranch != null) {
			return bankBranch;
		}
		return null;
	}

	@Override
	public BankBranch findByBranchName(String branchName) {
		logger.info("findByBranchName : {}" + branchName);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("branch_name", branchName));
		BankBranch bankBranch = (BankBranch) crit.uniqueResult();
		if (bankBranch != null) {
			return bankBranch;
		}
		return null;
	}

	@Override
	public void saveBranch(BankBranch bankBranch) {
		persist(bankBranch);

	}

	@Override
	public BankBranch updateBranch(BankBranch bankBranch) {
		// TODO Auto-generated method stub
		return merge(bankBranch);
	}

	@Override
	public List<BankBranch> getAllBranches(Bank bank) {
		
		

		return null;
	}

	@Override
	public boolean deleteBankBranch(long branchId) {
		// TODO Auto-generated method stub
		return false;
	}

}
