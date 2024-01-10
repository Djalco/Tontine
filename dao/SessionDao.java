package dao;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import exception.EntityNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
		ps.setDate(3, getSessionDate(obj.getNumSession()));
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
		if (rs.next()) 
			return new Session(rs.getString("id"),rs.getInt("num_session"),rs.getDate("date_session").toLocalDate());


		throw new EntityNotFoundException("Utilisateur non trouvé");

	}

	public void init() throws SQLException, EntityNotFoundException {
		int numSession=0, numSessionSetting=0;
		String sql = "SELECT `number_session` FROM `setting`";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			numSessionSetting = rs.getInt(1);


		sql = "SELECT count(*) as size FROM `session`";
		ps = con.prepareStatement(sql);
		rs = ps.executeQuery();
		if(rs.next())
			numSession = rs.getInt(1);
		if(numSession == 0 || numSession != numSessionSetting) {
			for(int i = 0; i<numSessionSetting-numSession; i++) {
				create(new Session("",i+1,null));
			}
		}
	}


	public Date getSessionDate(int num) throws SQLException {
		Date next = null;
		String sql = "SELECT * FROM `setting`";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			int typeDate = rs.getInt("type_date");
			LocalDate first = rs.getDate("start_date").toLocalDate();
			if(typeDate == 0) 
				return Date.valueOf(first.plusWeeks(num-1));

			return Date.valueOf(first.plusMonths(num-1));
		}
		return next;
	}

	public int getCotisation(String id) throws SQLException {
		String sql = "SELECT count(*) number_contribution FROM `contribution` WHERE session_contributed = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	public int getNotCotisation(String id) throws SQLException {
		String sql = "SELECT count(*) FROM `user` u "
				+ "WHERE u.`id` NOT IN (SELECT `user` "
				+ "                   FROM `contribution` "
				+ "                   WHERE `session_contributed` = ?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}
	
//	SELECT * FROM `user` u 
//	JOIN `session` s
//		WHERE u.`id` NOT IN (SELECT `user` 
//		                   FROM `contribution` 
//		                   WHERE `session_contributed` < 'sess-024-003')
//	    AND u.`id` NOT IN (SELECT `user`
//	                       FROM `sanction`
//	                       WHERE `session_start` < 'sess-024-003')
//	    AND s.`id` < 'sess-024-003'
    
	public int getLoan(String id, int numSession) throws SQLException {
		String sql = "SELECT count(*) number_loan FROM `loan` WHERE session = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

	public Session getActiveSession() throws SQLException {
		String sql = "SELECT * FROM `session` WHERE date_session > CURRENT_DATE ORDER BY date_session LIMIT 1";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) 
			return new Session(rs.getString("id"),rs.getInt("num_session"),rs.getDate("date_session").toLocalDate());
		return null;
	}

	public List<Session> getAllAfterActiveSess() throws SQLException {
		List<Session> sessions = new ArrayList<Session>();
		String sql = "SELECT * FROM `session` WHERE `id` > ? ";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, Session.getActiveSession().getId());
		ResultSet rs = ps.executeQuery();
		while (rs.next()) 
			sessions.add(new Session(rs.getString("id"),rs.getInt("num_session"),rs.getDate("date_session").toLocalDate()));
		return sessions;
	}
}







































