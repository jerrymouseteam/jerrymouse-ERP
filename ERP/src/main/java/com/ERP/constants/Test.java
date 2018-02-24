package com.ERP.constants;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ERP.model.Address;
import com.ERP.model.Bank;
import com.ERP.model.BankBranch;
import com.ERP.model.Project;
import com.ERP.model.Requisition;
import com.ERP.model.RequisitionItem;
import com.ERP.model.Vendor;
import com.ERP.model.VendorType;

public class Test {

	public static List<VendorType> getVendorTypeList() {
		List<VendorType> list = new ArrayList<>();

		VendorType v1 = new VendorType(1, "Services");
		VendorType v2 = new VendorType(2, "Goods");

		list.add(v1);
		list.add(v2);

		return list;

	}

	public static List<Bank> getBankList() {
		List<Bank> list = new ArrayList<>();

		Bank b1 = new Bank(-1, "------ Select Bank ------");
		Bank b2 = new Bank(1, "HDFC");
		Bank b3 = new Bank(2, "AXIS");

		list.add(b1);
		list.add(b2);
		list.add(b3);

		return list;

	}

	public static List<BankBranch> getBankBranchList() {
		List<BankBranch> list = new ArrayList<>();

		Bank b1 = new Bank(1, "HDFC");
		Bank b2 = new Bank(2, "AXIS");

		BankBranch bb11 = new BankBranch();
		// bb11.setBank(b1);
		bb11.setBank_branch_id(11);
		bb11.setBranch_name("HDFC -- Goregaon");
		bb11.setBranch_ifsc("123456789");

		BankBranch bb12 = new BankBranch();
		// bb12.setBank(b1);
		bb12.setBank_branch_id(12);
		bb12.setBranch_name("HDFC -- Malad");
		bb12.setBranch_ifsc("123456789");

		BankBranch bb22 = new BankBranch();
		// bb22.setBank(b2);
		bb22.setBank_branch_id(22);
		bb22.setBranch_name("AXIS -- Goregaon");
		bb22.setBranch_ifsc("123456789");

		BankBranch bb23 = new BankBranch();
		// bb23.setBank(b2);
		bb23.setBank_branch_id(23);
		bb23.setBranch_name("AXIS -- Malad");
		bb23.setBranch_ifsc("123456789");

		list.add(bb11);
		list.add(bb12);
		list.add(bb22);
		list.add(bb23);

		return list;

	}

	public static List<BankBranch> getBankBranchList2(Long bankId) {
		List<BankBranch> list = new ArrayList<>();

		Bank b1 = new Bank(1, "HDFC");
		Bank b2 = new Bank(2, "AXIS");

		BankBranch bb11 = new BankBranch();
		// bb11.setBank(b1);
		bb11.setBank_branch_id(11);
		bb11.setBranch_name("HDFC -- Goregaon");
		bb11.setBranch_ifsc("123456789");

		BankBranch bb12 = new BankBranch();
		// bb12.setBank(b1);
		bb12.setBank_branch_id(12);
		bb12.setBranch_name("HDFC -- Malad");
		bb12.setBranch_ifsc("123456789");

		BankBranch bb22 = new BankBranch();
		// bb22.setBank(b2);
		bb22.setBank_branch_id(22);
		bb22.setBranch_name("AXIS -- Goregaon");
		bb22.setBranch_ifsc("123456789");

		BankBranch bb23 = new BankBranch();
		// bb23.setBank(b2);
		bb23.setBank_branch_id(23);
		bb23.setBranch_name("AXIS -- Malad");
		bb23.setBranch_ifsc("123456789");

		if (bankId == 1) {
			list.add(bb11);
			list.add(bb12);
		} else if (bankId == 2) {
			list.add(bb22);
			list.add(bb23);
		}

		return list;

	}

	public static List<Vendor> getVendorList() {

		List<Vendor> list = new ArrayList<>();

		Vendor v1 = new Vendor();
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

		Vendor v2 = new Vendor();
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

	public static Vendor getVendor1() {

		Vendor v1 = new Vendor();
		v1.setVendor_id(1);
		v1.setVendor_name("Harshad");
		v1.setVendor_nickName("Harsh");
		v1.setVendorTypeId(1);
		v1.setVendor_gst_number("123456789");
		v1.setBankAccountNumber("Account Number");
		Address a = new Address();
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

	public static Vendor getVendor2() {

		Vendor v2 = new Vendor();
		v2.setVendor_id(2);
		v2.setVendor_name("John");
		v2.setVendor_nickName("jo");
		v2.setVendorTypeId(2);
		v2.setVendor_gst_number("123456789");
		v2.setBankAccountNumber("Account Number");
		v2.setBankId(2);
		Address a = new Address();
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

	public static List<String> getItems() {
		List<String> items = new ArrayList<>();
		items.add("items 1");
		items.add("items 2");
		items.add("items 3");
		items.add("items 4");
		items.add("items 5");

		return items;
	}

	public static List<String> getGrades() {
		List<String> grades = new ArrayList<>();
		grades.add("grades 1");
		grades.add("grades 2");
		grades.add("grades 3");
		grades.add("grades 4");
		grades.add("grades 5");

		return grades;
	}

	public static List<String> getQuantities() {
		List<String> quantities = new ArrayList<>();
		quantities.add("quantities 1");
		quantities.add("quantities 2");
		quantities.add("quantities 3");
		quantities.add("quantities 4");
		quantities.add("quantities 5");

		return quantities;
	}

	public static List<String> getUnits() {
		List<String> units = new ArrayList<>();
		units.add("units 1");
		units.add("units 2");
		units.add("units 3");
		units.add("units 4");
		units.add("units 5");

		return units;
	}
	
	public static Project getProject1()
	{
		Project p1 = new Project();
		p1.setProject_id(1);
		p1.setProjectName("Suchi Heights");
		p1.setSubDivisionName("Private Sector");
		p1.setStartDate(new Date());
		p1.setEndDate(new Date());
		p1.setProjectAddress("");
		p1.setRemarks("");
		p1.setContactPersonName("John");
		p1.setContactPersonEmail("");
		p1.setContactPersonEmail("");
		p1.setProjectClientName("Lodha");
		p1.setProjectClientPhone("");
		p1.setProjectClientEmail("");
		p1.setStructuralName("");
		p1.setStructuralPhone("");
		p1.setStructuralEmail("");
		
		return p1;
	}
	public static Project getProject2()
	{
		Project p2 = new Project();
		p2.setProject_id(2);
		p2.setProjectName("Raheja Heights");
		p2.setSubDivisionName("Private Sector");
		p2.setStartDate(new Date());
		p2.setEndDate(new Date());
		p2.setProjectAddress("");
		p2.setRemarks("");
		p2.setContactPersonName("Harshad");
		p2.setContactPersonEmail("");
		p2.setContactPersonEmail("");
		p2.setProjectClientName("Raheja");
		p2.setProjectClientPhone("");
		p2.setProjectClientEmail("");
		p2.setStructuralName("");
		p2.setStructuralPhone("");
		p2.setStructuralEmail("");

		
		return p2;
	}
	
	
	public static List<Project> getProjectListDetails() {

		List<Project> projectList = new ArrayList<>();

	

		projectList.add(Test.getProject1());
		projectList.add(Test.getProject2());
		return projectList;
	}

	
	
	public static List<RequisitionItem> getRequisitionItems() {
		List<RequisitionItem> requisitionItem = new ArrayList<>();

		RequisitionItem i1 = new RequisitionItem();
		i1.setRequisitionItemId(1);
		List<String> items = new ArrayList<>();
		items.add("items 1");
		List<String> units = new ArrayList<>();
		units.add("units 1");
		List<String> quantities = new ArrayList<>();
		quantities.add("quantities 1");
		List<String> grades = new ArrayList<>();
		grades.add("grades 1");
		i1.setItems(items);
		i1.setQuantities(quantities);
		i1.setGrades(grades);
		i1.setUnits(units);
		i1.setUsedFor("Test1");
		i1.setChecked(true);
		

		RequisitionItem i2 = new RequisitionItem();
		i2.setRequisitionItemId(2);
		List<String> items2 = new ArrayList<>();
		items2.add("items 2");
		List<String> units2 = new ArrayList<>();
		units2.add("units 2");
		List<String> quantities2 = new ArrayList<>();
		quantities2.add("quantities 2");
		List<String> grades2 = new ArrayList<>();
		grades2.add("grades 2");
		i2.setItems(items2);
		i2.setQuantities(quantities2);
		i2.setGrades(grades2);
		i2.setUnits(units2);
		i2.setUsedFor("Test2");
		i2.setChecked(true);

		requisitionItem.add(i1);
		requisitionItem.add(i2);

		return requisitionItem;
	}

	public static Requisition getRequisition1() {
		Requisition r1 = new Requisition();
		r1.setDateGen("2018-02-23");
		r1.setProjectId(1);
		r1.setDelDt("2018-02-23");
		r1.setExpectedDt("2018-02-23");
		r1.setReqDate("2018-02-23");
		r1.setJustification("Test Justification");
		r1.setRequestedBy("Harshad");
		r1.setRequisitionItemParameterses(Test.getRequisitionItems());
		r1.setReqNo(1L);

		return r1;
	}

	public static Requisition getRequisition2() {
		Requisition r2 = new Requisition();
		r2.setDateGen("2018-02-23");
		r2.setProjectId(2);
		r2.setDelDt("2018-02-23");
		r2.setReqDate("2018-02-23");
		r2.setExpectedDt("2018-02-23");
		r2.setJustification("Test 2 Justification");
		r2.setRequestedBy("John");
		r2.setRequisitionItemParameterses(Test.getRequisitionItems());
		r2.setReqNo(2L);

		return r2;
	}

	public static List<Requisition> getRequisitions() {
		List<Requisition> requisition = new ArrayList<>();

		Requisition r1 = Test.getRequisition1();

		Requisition r2 = Test.getRequisition2();

		requisition.add(r1);
		requisition.add(r2);

		return requisition;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
