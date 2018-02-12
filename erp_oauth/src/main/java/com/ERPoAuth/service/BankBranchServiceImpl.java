package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.BankBranchDao;
import com.ERPoAuth.dao.BankDao;
import com.ERPoAuth.dao.ProjectDao;
import com.ERPoAuth.model.Bank;
import com.ERPoAuth.model.BankBranch;

@Service("bankBranchService")
@Transactional
public class BankBranchServiceImpl implements BankBranchService {

	@Autowired
	private BankBranchDao bankBranchDao;

	
	

	@Override
	public BankBranch findByIfsc(String ifsc) {
		// TODO Auto-generated method stub
		return bankBranchDao.findByIfsc(ifsc);
	}

	@Override
	public BankBranch findByBranchName(String branchName) {
		// TODO Auto-generated method stub
		return bankBranchDao.findByBranchName(branchName);
	}

	@Override
	public void saveBranch(BankBranch bankBranch) {
		bankBranchDao.saveBranch(bankBranch);
		
	}

	@Override
	public BankBranch updateBranch(BankBranch bankBranch) {
		// TODO Auto-generated method stub
		return bankBranchDao.updateBranch(bankBranch);
	}

	@Override
	public List<BankBranch> getAllBranches(Bank bank) {
		// TODO Auto-generated method stub
		return bankBranchDao.getAllBranches(bank);
	}

	@Override
	public boolean deleteBankBranch(long branchId) {
		// TODO Auto-generated method stub
		return bankBranchDao.deleteBankBranch(branchId);
	}



}
