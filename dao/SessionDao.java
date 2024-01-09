package dao;

import java.sql.SQLException;

import exception.EntityNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
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
		String sql = "INSERT INTO `session`(`id`, `num_session`, `date_session`) values "
				+ "(?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setInt(2, obj.getNumSession());
		ps.setDate(3, Date.valueOf(obj.getDateSession()));
		ps.executeUpdate();
		return getLast();
	
	}

	@Override
	public Session update(Session obj) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `session` SET "
				+ "`num_session`=?,"
				+ "`date_session`=? "
                                + "WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setInt(1, obj.getNumSession());
		ps.setDate(2, Date.valueOf(obj.getDateSession()));
                ps.setString(3, obj.getId());
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
			return new Session(rs.getString("id"),rs.getInt("num_session"),rs.getDate("date_session").toLocalDate());
					
		}
		throw new EntityNotFoundException("Utilisateur non trouvé");
	
	}

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); //To change body of generated methods, choose Tools | Templates.
    }
}
 






































