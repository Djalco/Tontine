package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import exception.EntityNotFoundException;
import model.Contribution;

public class ContributionDao extends Dao<Contribution> {

	public ContributionDao() throws SQLException {
		super();
		table = "contribution";
		idS="ctb";
	}
	

	public Contribution create(Contribution obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `contribution`(`id`, `session`, `user`, `session_contributed`) VALUES "
				+ "(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getUser().getId());
		ps.setString(4, obj.getSessionContributed().getId());
		ps.executeUpdate();
		return getLast();
	}

	
	public Contribution update(Contribution obj) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	
	public Contribution find(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


	public List<Contribution> findBySession(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
