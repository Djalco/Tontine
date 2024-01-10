package dao;

import java.sql.SQLException;
import java.util.List;

import exception.EntityNotFoundException;
import model.ManagePayment;

public class ManagePaymentDao extends Dao<ManagePayment> {

	public ManagePaymentDao() throws SQLException {
		super();
	}

	@Override
	public ManagePayment create(ManagePayment obj) throws SQLException, EntityNotFoundException {
		return getLast();
	}

	@Override
	public ManagePayment update(ManagePayment obj) throws SQLException {
		return find(obj.getId());
	}

	@Override
	public ManagePayment find(String id) throws SQLException {
		return null;
	}

	public List<ManagePayment> findBySession(String cotisation) {
		return null;
	}

	public List<ManagePayment> findByUser(String user) {
		return null;
	}

}
