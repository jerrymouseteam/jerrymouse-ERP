package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.GradeDao;
import com.ERPoAuth.model.Grade;



@Service("gradeService")
@Transactional
public class GradeServiceImpl implements GradeService {

	@Autowired
	private GradeDao dao;

	@Override
	public Grade findByGradeId(long gradeId) {
		// TODO Auto-generated method stub
		return dao.findGradeById(gradeId);
	}

	@Override
	public Grade findByGradeName(String gradeName) {
		// TODO Auto-generated method stub
		return dao.findGradeByName(gradeName);
	}

	@Override
	public void saveGrade(Grade grade) {
		// TODO Auto-generated method stub
		
		dao.saveGrade(grade);
		
	}

	@Override
	public Grade updateGrade(Grade grade) {
		// TODO Auto-generated method stub
		return dao.updateGrade(grade);
	}

	@Override
	public List<Grade> findAllGrades() {
		
		return dao.findAllGrades();
	}

	@Override
	public void deleteGrade(Grade grade) {
		// TODO Auto-generated method stub
		dao.deleteGrade(grade);
	}

	
	



}
