package dao;

import exception.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cotisation;
import model.Loan;

public class LoanDao extends Dao<Loan> {
    public LoanDao() throws SQLException {
		super();
		table = "cotisation";
		idS="cot";
	}

    public Loan create(Loan obj) throws SQLException, EntityNotFoundException {
      String sql = "INSERT INTO `Loan`(`id`, `session`, `cotisatoion`, `managePaymentType`,'amount','session_sold) VALUES "
				+ "(?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getCotisation().getId());
                ps.setInt(4, obj.getAmount());
                //ps.setString(5, obj.getPaymentType().getId());
		ps.setString(6, obj.getSessionSold().getId());
		ps.executeUpdate();
		return getLast(); }

    public Loan update(Loan obj) throws SQLException, EntityNotFoundException {
       String sql = "UPDATE `cotisation` SET "
				+ "`session`=?,"
				+ "`cotisation`=?,"
                                + "`managementPaymentType`=?,"
                                + "`amount`=?,"
                                + "`session_sold`=?,"
				+ "WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, generateId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getCotisation().getId());
                ps.setInt(4, obj.getAmount());
              //ps.setString(5, obj.getPaymentType().getId());
		ps.setString(5, obj.getSessionSold().getId());
		ps.executeUpdate();
		return find(obj.getId()); }

    
    public Loan find(String id) throws SQLException, EntityNotFoundException {
       String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Loan(rs.getString("id"),rs.getString("session"),rs.getString("cotisation"),rs.getInt("managementPayment"),rs.getInt("amount"),rs.getString("sessio_sold"));
					
		} throw new UnsupportedOperationException("aucun resultat"); //To change body of generated methods, choose Tools | Templates.
    }
}
