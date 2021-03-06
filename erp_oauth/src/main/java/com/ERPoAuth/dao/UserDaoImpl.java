package com.ERPoAuth.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.ERP.constants.UserStatus;
import com.ERPoAuth.model.User;

@Repository("userDao")
public class UserDaoImpl extends AbstractDao<Integer, User> implements UserDao {

	final static Logger logger = Logger.getLogger(UserDaoImpl.class);

	public User findById(int id) {
		User user = getByKey(id);
		if (user != null) {
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	public User findBySSO(String sso) {
		logger.info("SSO : {}" + sso);
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User) crit.uniqueResult();
		if (user != null) {
			Hibernate.initialize(user.getUserProfiles());
		}
		return user;
	}

	@SuppressWarnings("unchecked")
	public List<User> findAllUsers() {
		Criteria criteria = createEntityCriteria().add(
				Restrictions.eq("userStatus", UserStatus.Active.toString()))
				.addOrder(Order.asc("firstName"));
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.
		List<User> users = (List<User>) criteria.list();

		return users;
	}

	public void save(User user) {
		persist(user);
	}

	public void deleteBySSO(String sso) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("ssoId", sso));
		User user = (User) crit.uniqueResult();
		delete(user);
	}

	public User check(String emailId) {
		Criteria crit = createEntityCriteria();
		crit.add(Restrictions.eq("email", emailId));
		User user = (User) crit.uniqueResult();
		if (user != null) {
			// List<User> users = (List<User>) crit.list();
			return user;
		}
		return null;
	}

	@Override
	public User findUserByContactNumber(String contactNumber) {
		Query query = getSession().getNamedQuery("findUserByContact")
				.setString("number", contactNumber);

		return (User) query.uniqueResult();
	}

	@Override
	public User findUserByEmailId(String email) {
		Query query = getSession().getNamedQuery("findUserByEmail").setString(
				"email", email);

		return (User) query.uniqueResult();
	}

	@Override
	public User mergeUser(User user) {

		User mergedUser = (User) getSession().merge(user);
		return mergedUser;
	}
}
