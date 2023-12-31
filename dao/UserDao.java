package dao;

import java.sql.SQLException;

import model.User;

public class UserDao extends Dao<User> {

	public UserDao() throws SQLException {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public User create(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return getLast();
	}

	@Override
	public User update(User obj) throws SQLException {
		// TODO Auto-generated method stub
		return find(obj.getId());
	}

	@Override
	public User find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
