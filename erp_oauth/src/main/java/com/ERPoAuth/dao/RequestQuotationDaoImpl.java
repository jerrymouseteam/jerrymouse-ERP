package com.ERPoAuth.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.ERPoAuth.model.RequestQuotation;
import com.ERPoAuth.model.RequestQuotationWithProcedure;
import com.ERPoAuth.model.Vendor;
import com.ERPoAuth.model.VendorType;

@Repository("requestQuotationDao")
public class RequestQuotationDaoImpl extends AbstractDao<Long, RequestQuotation> implements RequestQuotationDao {

	final static Logger logger = Logger.getLogger(RequestQuotationDaoImpl.class);

	@Override
	public Vendor findByRequestQuotationId(long requestQuotationId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveRequestQuotation(RequestQuotation requestQuotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public RequestQuotation updateVendor(RequestQuotation requestQuotation) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RequestQuotation> findAllRequestQuotations() throws Exception {

		Criteria criteria = createEntityCriteria();
		criteria.setFirstResult(0);
		criteria.setMaxResults(10);
		criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);// To avoid
																		// duplicates.

		List<RequestQuotation> requestQuotations = (List<RequestQuotation>) criteria.list();
		return requestQuotations;
	}

	@Override
	public void deleteRequestQuotation(RequestQuotation requestQuotation) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createQuotationWithProc(RequestQuotationWithProcedure requestQuotationWithProcedure)
			throws SQLException {
		Connection conn = null;
		CallableStatement cs = null;
		try {
			SessionFactoryImplementor impl = getSessionFactoryImplementor();
			ConnectionProvider cp = impl.getConnectionProvider();
			conn = cp.getConnection();
			String sql = "{call sp_createQuotation(?,?,?,?,?,?,?,?)}";
			cs = conn.prepareCall(sql);
			cs.setObject(1, requestQuotationWithProcedure.getRequisitionId()); // Set
																				// the
																				// output
																				// parameters
			cs.setObject(2, requestQuotationWithProcedure.getLastDateOfRFQSubmission()); // Set
																							// the
																							// output
																							// parameters
			cs.setObject(3, requestQuotationWithProcedure.getRequestQuotationDeliveryDate());// Set
																								// the
																								// output
																								// parameters
			cs.setObject(4, "ACTIVE"); // Set the output parameters
			cs.setObject(5, requestQuotationWithProcedure.getRequestQuotationComments()); // Set
																							// the
																							// output
																							// parameters
			cs.setObject(6, "A||B"); // Set the output parameters
			cs.setObject(7, "CREATE_QUOTATION"); // Set the output parameters
			cs.registerOutParameter(8, java.sql.Types.INTEGER); // Set the
																// parameters
																// for the
																// second output
																// parameters
			cs.execute(); // Calling a stored procedure
			int name = cs.getInt(8);// Gets the output parameters
			System.out.println(name);
			if (!conn.getAutoCommit()) {
				conn.commit();
			}

			cs.close();
			conn.close();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			cs.close();
			conn.close();
		}

	}

}
