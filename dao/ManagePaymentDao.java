package dao;

import java.sql.SQLException;
import java.util.List;

import exception.EntityNotFoundException;
import model.Cotisation;
import model.ManagePayment;

public class ManagePaymentDao extends Dao<ManagePayment> {

	public ManagePaymentDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public ManagePayment create(ManagePayment obj) throws SQLException, EntityNotFoundException {
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

	public List<ManagePayment> findBySession(String cotisation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ManagePayment> findByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}

}
