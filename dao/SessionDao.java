package dao;

import java.sql.SQLException;

import exception.EntityNotFoundException;
import model.Session;

public class SessionDao extends Dao<Session> {

	public SessionDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public Session create(Session obj) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return getLast();
	}

	@Override
	public Session update(Session obj) throws SQLException {
		// TODO Auto-generated method stub
		return find(obj.getId());
	}

	@Override
	public Session find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
