package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.EntityNotFoundException;
import model.AbstractEntity;
import model.Session;
import model.User;
import model.User.UserBuilder;;

public class UserDao extends Dao<User> {

	public UserDao() throws SQLException {
		super();
		table = "user";
		idS="usr";
	}

	@Override
	public User create(User obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `user`(`id`, `login`, `firstname`, `lastname`, `password`, `mail`, `phone`, `role`, `nb_person`) VALUES "
				+ "(?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getLogin());
		ps.setString(3, obj.getFirstname());
		ps.setString(4, obj.getLastname());
		ps.setString(5, obj.getPassword());
		ps.setString(6, obj.getMail());
		ps.setString(7, obj.getPhone());
		ps.setInt(8, obj.getRole().getId());
		ps.setInt(9, obj.getNbPerson());
		ps.executeUpdate();
		return getLast();
	}

	@Override
	public User update(User obj) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `user` SET "
				+ "`login`=?,"
				+ "`firstname`=?,"
				+ "`lastname`=?,"
				+ "`password`=?,"
				+ "`mail`=?,"
				+ "`phone`=?,"
				+ "`role`=?,"
				+ "`nb_person`=? "
				+ "WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, obj.getLogin());
		ps.setString(2, obj.getFirstname());
		ps.setString(3, obj.getLastname());
		ps.setString(4, obj.getPassword());
		ps.setString(5, obj.getMail());
		ps.setString(6, obj.getPhone());
		ps.setInt(7, obj.getRole().getId());
		ps.setInt(8, obj.getNbPerson());
		ps.setString(9, obj.getId());
		ps.executeUpdate();
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
					.login(rs.getString("login"))
					.firstname(rs.getString("firstname"))
					.lastname(rs.getString("lastname"))
					.password(rs.getString("password"))
					.mail(rs.getString("mail"))
					.phone(rs.getString("phone"))
					.role(rs.getInt("role"))
					.nbPerson(rs.getInt("nb_person")));
		}
		throw new EntityNotFoundException("Utilisateur non trouvé");
	}

	public Session getNextSessionContribute(String id) throws SQLException, EntityNotFoundException {
		String sql = "SELECT * FROM  `session` "
				+ "WHERE `id` NOT IN "
				+ "	(SELECT `session_contributed` FROM `contribution` c  "
				+ "     WHERE `user` = ?) "
				+ "ORDER BY date_session ASC "
				+ "LIMIT 1;";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return DaoFactory.getSessionDao().find(rs.getString("id"));
		}
		return null;
	}



	public ArrayList<User> getAllWithNotLoan(int limit) throws SQLException, EntityNotFoundException{
		List<User> array = new ArrayList<User>();
		String sql = "SELECT u.* FROM `user` u  WHERE "
				+ "u.`id` NOT IN (SELECT `user` "
				+ "              FROM loan "
				+ "              WHERE status = 0 )";
		PreparedStatement pst = con.prepareStatement(sql);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			array.add(find(rs.getString("id")));
			((AbstractEntity) array.get(array.size()-1)).setRow(array.size());
		}
		return (ArrayList<User>) array;
	}
	
	public boolean userIsValidContribution(String id) throws SQLException {
		String sql = "SELECT count(*) FROM `sanction` WHERE `status` = 1 and `user` = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt(1)==0;
		}
		return false;
	}

	public boolean userIsValidLoan(String id) throws SQLException {
		String sql = "SELECT count(*) FROM `loan` WHERE `status` = 2 and `user` = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return rs.getInt(1)==0;
		}
		return false;
	}

	public User findLogin(String id) throws SQLException, EntityNotFoundException {
		String sql = "SELECT `id` FROM `user` WHERE `login` = ? OR `mail` = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ps.setString(2, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return find(rs.getString(1));
		}
		return null;
	}

}
