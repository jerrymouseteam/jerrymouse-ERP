package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;

public interface BankBranchService {

	BankBranch findByIfsc(String ifsc);

	BankBranch findByBranchName(String branchName);

	void saveBranch(BankBranch bankBranch);

	BankBranch updateBranch(BankBranch bankBranch);

	List<BankBranch> getAllBranches(Bank bank);

	boolean deleteBankBranch(long branchId);

}
