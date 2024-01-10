package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import exception.EntityNotFoundException;
import model.AbstractEntity;
import model.Sanction;
import model.Session;
import model.enumration.InfractionPayment;

public class SanctionDao extends Dao<Sanction>{

	public SanctionDao() throws SQLException {
		super();
		table = "sanction";
		idS="san";
	}

	@Override
	public Sanction create(Sanction obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `sanction`(`id`, `infraction_payment`, `user`, `session_start`) VALUES "
				+ "(?,?,?,?)";
		System.out.println(obj.getUser().getId());
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setInt(2, obj.getInfractionPayment().getId());
		ps.setString(3, obj.getUser().getId());
		ps.setString(4, obj.getSessionStart().getId());
		ps.executeUpdate();
		return getLast();
	}

	@Override
	public Sanction update(Sanction obj) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Sanction find(String id) throws SQLException, EntityNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void initSanction() throws SQLException, EntityNotFoundException {
		initSanctionContribution();
	}
	
	public void initSanctionContribution() throws SQLException, EntityNotFoundException {
		String sql = "SELECT u.`id` AS `user_id`, s.`id` AS `session_id` FROM `user` u "
				+ "JOIN `session` s "
				+ "	WHERE u.`id` NOT IN (SELECT `user` "
				+ "	                   FROM `contribution` "
				+ "	                   WHERE `session_contributed` < ?) "
				+ "    AND u.`id` NOT IN (SELECT `user` "
				+ "                       FROM `sanction` "
				+ "                       WHERE `session_start` < ?) "
				+ "    AND s.`id` < ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, Session.getActiveSession().getId());
		pst.setString(2, Session.getActiveSession().getId());
		pst.setString(3, Session.getActiveSession().getId());
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
			System.out.println(rs.getString("user_id"));
			create(new Sanction("",InfractionPayment.LATE_PAYMENT.getId(),
					rs.getString("user_id"),rs.getString("session_id"),Session.getActiveSession().getId()));
		}
	}

}
