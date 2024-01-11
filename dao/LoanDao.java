package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.EntityNotFoundException;
import model.AbstractEntity;
import model.Loan;

public class LoanDao extends Dao<Loan>{

	public LoanDao() throws SQLException {
		super();
		table = "loan";
		idS="loan";
	}

	public Loan create(Loan obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `loan`(`id`, `session`, `user`, `amount`, `session_sold`) VALUES "
				+ "(?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getUser().getId());
		ps.setInt(4, obj.getAmount());
		ps.setString(5, obj.getSessionSold().getId());

		ps.executeUpdate();
		return getLast();
	}

	@Override
	public Loan update(Loan obj) throws SQLException, EntityNotFoundException {
		return obj;
	}

	@Override
	public Loan find(String id) throws SQLException, EntityNotFoundException {
	       String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Loan(rs.getString("id"),rs.getString("session"), 
					rs.getString("user"),rs.getInt("amount"),
					rs.getString("session_sold"), rs.getInt("status"));


		} throw new EntityNotFoundException("aucun resultat"); 
	}

	public Loan rembourseLoan(String id) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `loan` SET `status`= 3 WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, id);
		ps.executeUpdate();
		return find(id);
	}

	public List<Loan> findByUser(String id) throws SQLException, EntityNotFoundException {
		List<Loan> array = new ArrayList<Loan>();
		String sql = "SELECT `id` FROM `loan` WHERE `user` = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
				array.add(find(rs.getString("id")));
				((AbstractEntity) array.get(array.size()-1)).setRow(array.size());
		}
		return (ArrayList<Loan>) array;
	}
}
