package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.UnitDao;
import com.ERPoAuth.model.Unit;

@Service("unitService")
@Transactional
public class UnitServiceImpl implements UnitService {

	@Autowired
	private UnitDao dao;

	@Override
	public Unit findByUnitId(long unitId) {
		// TODO Auto-generated method stub
		return dao.findUnitById(unitId);
	}

	@Override
	public Unit findByUnitName(String unitName) {
		// TODO Auto-generated method stub
		return dao.findUnitByName(unitName);
	}

	@Override
	public void saveUnit(Unit unit) {
		// TODO Auto-generated method stub

		dao.saveUnit(unit);

	}

	@Override
	public Unit updateUnit(Unit unit) {
		// TODO Auto-generated method stub
		return dao.updateUnit(unit);
	}

	@Override
	public List<Unit> findAllUnits() {

		return dao.findAllUnits();
	}

	@Override
	public void deleteUnit(Unit unit) {
		// TODO Auto-generated method stub
		dao.deleteUnit(unit);
	}

}
