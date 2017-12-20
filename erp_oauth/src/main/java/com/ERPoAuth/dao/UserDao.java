package com.ERPoAuth.dao;

import java.util.List;

import com.ERPoAuth.model.User;

public interface UserDao {

	User findById(int id);

	User findBySSO(String sso);

	void save(User user);

	void deleteBySSO(String sso);

	List<User> findAllUsers();

	User check(String emailId);

	User findUserByContactNumber(String contactNumber);

	User findUserByEmailId(String email);

	User mergeUser(User user);

}
