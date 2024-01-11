package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.EntityNotFoundException;
import model.AbstractEntity;
import model.Contribution;
import model.Loan;

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


	public List<Contribution> findByUser(String id) throws SQLException {
		List<Contribution> array = new ArrayList<Contribution>();
		String sql = "SELECT `id` FROM " + table + " WHERE `user` = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
				array.add(find(rs.getString("id")));
//				 array.get(array.size()-1).setRow(array.size());
		}
		return (ArrayList<Contribution>) array;
	}

	
}
