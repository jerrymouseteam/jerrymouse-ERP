package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;

@Repository("bankDao")
public class BankDaoImpl extends AbstractDao<Long, Bank> implements BankDao {

	
	final static Logger logger = Logger.getLogger(BankDaoImpl.class);
	@Override
	public Bank findByBankId(long bankId) {
		Bank bank = getByKey(bankId);
		System.out.println("=>>>>>>>>>>>>>>>>>  bank "+bank.getBank_name());
		if (bank != null) {
			
			
			List<BankBranch> list=bank.getBank_branches();
			for(BankBranch b: list)
			{
				System.out.println("=>>>>>>>>>>>>>>>>> "+b.getBank_branch_id());
			}
			//return bank;
		}
		return bank;
	}

	@Override
	public Bank findByBankname(String bankName) {
		logger.info("BankName : {}" + bankName);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("bank_name", bankName));
		Bank bank = (Bank) crit.uniqueResult();
		if (bank != null) {
			return bank;
		}
		return null;
	}

	@Override
	public void saveBank(Bank bank) {
		System.out.println("@@@@@@@@@@@@ BankDaoImpl - saveBank - Bank : "+bank.getBank_name());
		persist(bank);

	}

	@Override
	public Bank updateBank(Bank bank) {
		return merge(bank);
	}

	@Override
	public List<Bank> findAllBanks() {
		Criteria criteria = createEntityCriteria().addOrder(
				Order.asc("bank_name"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		
		List<Bank> banks = (List<Bank>) criteria.list();
		return banks;
	}

	@Override
	public boolean deleteBank(long bankId) {
		
		return false;
	}

	
}
