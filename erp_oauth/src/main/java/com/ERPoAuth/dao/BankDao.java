package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;

public interface BankDao {

	Bank findByBankId(long bankId);

	Bank findByBankname(String bankName);

	void saveBank(Bank bank);

	Bank updateBank(Bank bank);

	List<Bank> findAllBanks();

	boolean deleteBank(long bankId);

	

}
