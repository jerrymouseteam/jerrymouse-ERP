package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.Grade;



public interface GradeService {

	Grade findByGradeId(long gradeId);

	Grade findByGradeName(String gradeName);

	void saveGrade(Grade grade);

	Grade updateGrade(Grade grade);

	List<Grade> findAllGrades();

	void deleteGrade(Grade grade);
}
