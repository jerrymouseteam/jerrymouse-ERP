package com.ERPoAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.dao.UserDao;
import com.ERPoAuth.model.User;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public User findById(int id) {
		return dao.findById(id);
	}

	public User findBySSO(String sso) {
		User user = dao.findBySSO(sso);
		return user;
	}

	public void saveUser(User user) {
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		dao.save(user);
	}

	/*
	 * Since the method is running with Transaction, No need to call hibernate
	 * update explicitly. Just fetch the entity from db and update it with
	 * proper values within transaction. It will be updated in db once
	 * transaction ends.
	 */
	public void updateUser(User user) {
		User entity = dao.findById(user.getId());
		if (entity != null) {
			entity.setSsoId(user.getSsoId());
			if (!user.getPassword().equals(entity.getPassword())) {
				entity.setPassword(passwordEncoder.encode(user.getPassword()));
			}
			entity.setFirstName(user.getFirstName());
			entity.setLastName(user.getLastName());
			entity.setEmail(user.getEmail());
			entity.setUserProfiles(user.getUserProfiles());
		}
	}

	public void deleteUserBySSO(String sso) {
		dao.deleteBySSO(sso);
	}

	public List<User> findAllUsers() {
		return dao.findAllUsers();
	}

	public User check(String emailId) {
		return dao.check(emailId);
	}

	public boolean isUserSSOUnique(Integer id, String sso) {
		User user = findBySSO(sso);
		System.out.println(" User in isUserSSOUnique " + user);
		if (user != null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isExistingContactNumber(String contactNumber) {
		User user = dao.findUserByContactNumber(contactNumber);
		if (user != null) {
			return true;
		}
		return false;

	}

	@Override
	public boolean isExistingEmailId(String email) {
		User user = dao.findUserByEmailId(email);
		if (user != null) {
			return true;
		}
		return false;

	}

	@Override
	public User mergeUser(User user) {

		User mergedUser = dao.mergeUser(user);
		return mergedUser;
	}

}
