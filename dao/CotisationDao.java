package dao;

import java.sql.SQLException;
import java.util.List;

import model.Cotisation;

public class CotisationDao extends Dao<Cotisation>{

	public CotisationDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int create(Cotisation obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(Cotisation obj) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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
