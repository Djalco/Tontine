package dao;

import java.sql.SQLException;
import java.util.List;

import exception.EntityNotFoundException;
import model.Cotisation;

public class CotisationDao extends Dao<Cotisation>{

	public CotisationDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Cotisation create(Cotisation obj) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return getLast();
	}

	@Override
	public Cotisation update(Cotisation obj) throws SQLException {
		// TODO Auto-generated method stub
		return find(obj.getId());
	}

	@Override
	public Cotisation find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cotisation> findBySession(String cotisation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cotisation> findByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}
}
