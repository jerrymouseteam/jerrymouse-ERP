package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Unit;



public interface UnitService {

	Unit findByUnitId(long unitId);

	Unit findByUnitName(String unitName);

	void saveUnit(Unit unit);

	Unit updateUnit(Unit unit);

	List<Unit> findAllUnits();

	void deleteUnit(Unit unit);
}
