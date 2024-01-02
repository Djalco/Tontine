package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import exception.EntityNotFoundException;
import model.User;
import model.User.UserBuilder;;

public class UserDao extends Dao<User> {

	public UserDao() throws SQLException {
		super();
		table = "user";
		bdName="usr";
	}

	@Override
	public User create(User obj) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return getLast();
	}

	@Override
	public User update(User obj) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return find(obj.getId());
	}

	@Override
	public User find(String id) throws SQLException, EntityNotFoundException {
		String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new User(new UserBuilder().id(rs.getString("id"))
					
					.nbPerson(rs.getInt("nb_person")));
		}
		throw new EntityNotFoundException("Employe non trouvé");
	}

}
