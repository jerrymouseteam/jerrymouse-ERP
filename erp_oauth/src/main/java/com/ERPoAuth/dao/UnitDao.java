package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.Unit;

public interface UnitDao {

	Unit findUnitById(long unitId);

	Unit findUnitByName(String unitName);

	void saveUnit(Unit unit);

	Unit updateUnit(Unit unit);

	List<Unit> findAllUnits();

	void deleteUnit(Unit unit);

	

}
