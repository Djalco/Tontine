package dao;

import java.sql.SQLException;

import exception.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cotisation;
import model.Session;

public class SessionDao extends Dao<Session> {

	public SessionDao() throws SQLException {
		super();
                table = "session";
		idS="sess";
	}

	@Override
	public Session create(Session obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `session`(`id`, `num_session`, `date_session` "
				+ "(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setInt(2, obj.getNumSession());
		//ps.setDate(3, obj.getDateSession());
		ps.executeUpdate();
		return getLast();
	
	}

	@Override
	public Session update(Session obj) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `session` SET "
				+ "`num_session`=?,"
				+ "`date_session`=?,";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, generateId());
		ps.setInt(2, obj.getNumSession());
		//ps.setL(3, obj.getDateSession());
		ps.executeUpdate();
		return find(obj.getId());
	}

	@Override
	public Session find(String id) throws SQLException, EntityNotFoundException {
		String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			//return new Session(rs.getString("id"),rs.getInt("num_session"),rs.getString("date_session"));
					
		}
		throw new EntityNotFoundException("Utilisateur non trouvé");
	
	}

}
 