package com.ERP.constants;

import java.util.ArrayList;
import java.util.List;

import com.ERP.model.Address;
import com.ERP.model.Bank;
import com.ERP.model.BankBranch;
import com.ERP.model.Vendor;
import com.ERP.model.VendorType;

public class Test {
	
	
	
	public static List<VendorType> getVendorTypeList()
	{
		List<VendorType> list=new ArrayList<>();
		
		VendorType v1=new VendorType(1, "Services");
		VendorType v2=new VendorType(2, "Goods");
		
		list.add(v1);
		list.add(v2);
		
		return list;
		
	}
	

	public static List<Bank> getBankList()
	{
		List<Bank> list=new ArrayList<>();
		
		Bank b1=new Bank(-1, "------ Select Bank ------");
		Bank b2=new Bank(1, "HDFC");
		Bank b3=new Bank(2, "AXIS");
		
		list.add(b1);
		list.add(b2);
		list.add(b3);
		
		return list;
		
	}
	public static List<BankBranch> getBankBranchList()
	{
		List<BankBranch> list=new ArrayList<>();
		
		Bank b1=new Bank(1, "HDFC");
		Bank b2=new Bank(2, "AXIS");
		
		BankBranch bb11=new BankBranch();
		//bb11.setBank(b1);
		bb11.setBank_branch_id(11);
		bb11.setBranch_name("HDFC -- Goregaon");
		bb11.setBranch_ifsc("123456789");
		
		BankBranch bb12=new BankBranch();
		//bb12.setBank(b1);
		bb12.setBank_branch_id(12);
		bb12.setBranch_name("HDFC -- Malad");
		bb12.setBranch_ifsc("123456789");
		
		BankBranch bb22=new BankBranch();
		//bb22.setBank(b2);
		bb22.setBank_branch_id(22);
		bb22.setBranch_name("AXIS -- Goregaon");
		bb22.setBranch_ifsc("123456789");
		
		BankBranch bb23=new BankBranch();
		//bb23.setBank(b2);
		bb23.setBank_branch_id(23);
		bb23.setBranch_name("AXIS -- Malad");
		bb23.setBranch_ifsc("123456789");
		
		
		list.add(bb11);
		list.add(bb12);
		list.add(bb22);
		list.add(bb23);
		
		return list;
		
	}
	
	
	public static List<BankBranch> getBankBranchList2(Long bankId)
	{
		List<BankBranch> list=new ArrayList<>();
		
		Bank b1=new Bank(1, "HDFC");
		Bank b2=new Bank(2, "AXIS");
		
		BankBranch bb11=new BankBranch();
		//bb11.setBank(b1);
		bb11.setBank_branch_id(11);
		bb11.setBranch_name("HDFC -- Goregaon");
		bb11.setBranch_ifsc("123456789");
		
		BankBranch bb12=new BankBranch();
		//bb12.setBank(b1);
		bb12.setBank_branch_id(12);
		bb12.setBranch_name("HDFC -- Malad");
		bb12.setBranch_ifsc("123456789");
		
		BankBranch bb22=new BankBranch();
		//bb22.setBank(b2);
		bb22.setBank_branch_id(22);
		bb22.setBranch_name("AXIS -- Goregaon");
		bb22.setBranch_ifsc("123456789");
		
		BankBranch bb23=new BankBranch();
		//bb23.setBank(b2);
		bb23.setBank_branch_id(23);
		bb23.setBranch_name("AXIS -- Malad");
		bb23.setBranch_ifsc("123456789");
		
		if(bankId == 1)
		{
			list.add(bb11);
			list.add(bb12);
		}
		else if(bankId == 2)
		{
			list.add(bb22);
			list.add(bb23);
		}
		
		
		
		return list;
		
	}
	
	public static List<Vendor> getVendorList()
	{
		
		List<Vendor> list = new ArrayList<>();
		
		Vendor v1=new Vendor();
		v1.setVendor_id(1);
		v1.setVendor_name("Harshad");
		v1.setVendor_nickName("Harsh");
		v1.setVendorTypeId(1);
		v1.setVendor_gst_number("123456789");
		v1.setBankAccountNumber("Account Number");
		v1.setBankId(1);
		v1.setBranch_ifsc("IFSC Code 123");
		v1.setBranchId(11);
		v1.setContact_person_alternate_phone_no("1234567899");
		v1.setContact_person_email("Test#@gmail.com");
		v1.setContact_person_mobile("1234567899");
		v1.setContact_person_name("Balaji");
		v1.setServiceRendered_GoodsSupplied("serviceRendered_GoodsSupplied");
		
		
		Vendor v2=new Vendor();
		v2.setVendor_id(2);
		v2.setVendor_name("John");
		v2.setVendor_nickName("jo");
		v2.setVendorTypeId(2);
		v2.setVendor_gst_number("123456789");
		v2.setBankAccountNumber("Account Number");
		v2.setBankId(2);
		v2.setBranch_ifsc("IFSC Code 123");
		v2.setBranchId(22);
		v2.setContact_person_alternate_phone_no("1234567899");
		v2.setContact_person_email("Test#@gmail.com");
		v2.setContact_person_mobile("1234567899");
		v2.setContact_person_name("LOdha");
		v2.setServiceRendered_GoodsSupplied("serviceRendered_GoodsSupplied");
		
		
		
		list.add(v1);
		list.add(v2);
		return list;
		
		
	}
	
	public static Vendor getVendor1()
	{
		
		Vendor v1=new Vendor();
		v1.setVendor_id(1);
		v1.setVendor_name("Harshad");
		v1.setVendor_nickName("Harsh");
		v1.setVendorTypeId(1);
		v1.setVendor_gst_number("123456789");
		v1.setBankAccountNumber("Account Number");
		Address a=new Address();
		a.setAddres_line1("Mumbai");
		v1.setAddress(a);
		v1.setBankId(1);
		v1.setBranch_ifsc("IFSC Code 123");
		v1.setBranchId(11);
		v1.setContact_person_alternate_phone_no("1234567899");
		v1.setContact_person_email("Test#@gmail.com");
		v1.setContact_person_mobile("1234567899");
		v1.setContact_person_name("Balaji");
		v1.setServiceRendered_GoodsSupplied("serviceRendered_GoodsSupplied");
		
		return v1;
	}
	
	
	public static Vendor getVendor2()
	{
		
		Vendor v2=new Vendor();
		v2.setVendor_id(2);
		v2.setVendor_name("John");
		v2.setVendor_nickName("jo");
		v2.setVendorTypeId(2);
		v2.setVendor_gst_number("123456789");
		v2.setBankAccountNumber("Account Number");
		v2.setBankId(2);
		Address a=new Address();
		a.setAddres_line1("Pune");
		v2.setAddress(a);
		v2.setBranch_ifsc("IFSC Code 123");
		v2.setBranchId(22);
		v2.setContact_person_alternate_phone_no("1234567899");
		v2.setContact_person_email("Test#@gmail.com");
		v2.setContact_person_mobile("1234567899");
		v2.setContact_person_name("LOdha");
		v2.setServiceRendered_GoodsSupplied("serviceRendered_GoodsSupplied");
		
		
		return v2;
	}
	
	public static List<String> getItems(){
		List<String> items=new ArrayList<>();
		items.add("items 1");
		items.add("items 2");
		items.add("items 3");
		items.add("items 4");
		items.add("items 5");
		
		return items;
	}
	
	public static List<String> getGrades(){
		List<String> grades=new ArrayList<>();
		grades.add("grades 1");
		grades.add("grades 2");
		grades.add("grades 3");
		grades.add("grades 4");
		grades.add("grades 5");
		
		return grades;
	}
	
	public static List<String> getQuantities(){
		List<String> quantities=new ArrayList<>();
		quantities.add("quantities 1");
		quantities.add("quantities 2");
		quantities.add("quantities 3");
		quantities.add("quantities 4");
		quantities.add("quantities 5");
		
		return quantities;
	}
	
	public static List<String> getUnits(){
		List<String> units=new ArrayList<>();
		units.add("units 1");
		units.add("units 2");
		units.add("units 3");
		units.add("units 4");
		units.add("units 5");
		
		return units;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
