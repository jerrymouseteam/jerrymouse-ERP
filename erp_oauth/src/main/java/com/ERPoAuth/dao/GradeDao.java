package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.Grade;

public interface GradeDao {

	Grade findGradeById(long gradeId);

	Grade findGradeByName(String gradeName);

	void saveGrade(Grade grade);

	Grade updateGrade(Grade grade);

	List<Grade> findAllGrades();

	void deleteGrade(Grade grade);

	

}
