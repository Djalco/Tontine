package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import exception.EntityNotFoundException;
import model.Sanction;
import model.Session;

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
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getInfractionPayment().getName());
		ps.setString(3, obj.getUser().getId());
		ps.setString(4, Session.getActiveSession().getId());
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

}
