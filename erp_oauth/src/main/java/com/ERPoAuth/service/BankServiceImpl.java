package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.BankDao;
import com.ERPoAuth.dao.ProjectDao;
import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;

@Service("bankService")
@Transactional
public class BankServiceImpl implements BankService {

	@Autowired
	private BankDao dao;

	
	@Override
	public Bank findByBankId(long bankId) {
		// TODO Auto-generated method stub
		return dao.findByBankId(bankId);
	}

	@Override
	public Bank findByBankname(String bankName) {
		// TODO Auto-generated method stub
		return dao.findByBankname(bankName);
	}

	@Override
	public void saveBank(Bank bank) {
		System.out.println("@@@@@@@@@@@@ BankServiceImpl - saveBank - Bank : "+bank.getBank_name());
		dao.saveBank(bank);

	}

	@Override
	public Bank updateBank(Bank bank) {
		// TODO Auto-generated method stub
		return dao.updateBank(bank);
	}

	@Override
	public List<Bank> findAllBanks() {
		// TODO Auto-generated method stub
		return dao.findAllBanks();
	}

	@Override
	public boolean deleteBank(long bankId) {
		// TODO Auto-generated method stub
		return dao.deleteBank(bankId);
	}



}
