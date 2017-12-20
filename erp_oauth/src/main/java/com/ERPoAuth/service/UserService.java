package com.ERPoAuth.service;

import java.util.List;

import com.ERPoAuth.model.User;

public interface UserService {

	User findById(int id);

	User findBySSO(String sso);

	void saveUser(User user);

	void updateUser(User user);

	void deleteUserBySSO(String sso);

	List<User> findAllUsers();

	boolean isUserSSOUnique(Integer id, String sso);

	User check(String emailId);

	User mergeUser(User user);

	boolean isExistingContactNumber(String contactNumber);

	boolean isExistingEmailId(String email);

}
