package dao;

import java.sql.SQLException;

import model.ManagePayment;

public class ManagePaymentDao extends Dao<ManagePayment> {

	public ManagePaymentDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ManagePayment create(ManagePayment obj) throws SQLException {
		// TODO Auto-generated method stub
		return getLast();
	}

	@Override
	public ManagePayment update(ManagePayment obj) throws SQLException {
		// TODO Auto-generated method stub
		return find(obj.getId());
	}

	@Override
	public ManagePayment find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
