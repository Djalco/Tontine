package dao;

import exception.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.Cotisation;
import model.Loan;
import model.ManagePayment;

public class LoanDao extends /*ManagePayment*/Dao<Loan> {
    public LoanDao() throws SQLException {
		super();
		table = "Loan";
		idS="loan";
	}

    public Loan create(Loan obj) throws SQLException, EntityNotFoundException {
  
      String sql = "INSERT INTO `Loan`(`id`, `cotisation`, `amount` `session_sold`) VALUES "
				+ "(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getCotisation().getId());
		ps.setInt(3, obj.getAmount());
		ps.setString(4, obj.getSessionSold().getId());
		
		ps.executeUpdate();
		return getLast();
    }

    public Loan update(Loan obj) throws SQLException, EntityNotFoundException {
       String sql = "UPDATE `Loan` SET "
				+ "`cotisation`=?, "
                               // + "`managementPaymentType`=?,"
                                + "`amount`=?, "
                                + "`session_sold`=?, "
				+ "WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, generateId());
		ps.setString(2, obj.getCotisation().getId());
                ps.setInt(3, obj.getAmount());
              //ps.setString(5, obj.getPaymentType().getId());
		ps.setString(4, obj.getSessionSold().getId());
		ps.executeUpdate();
		return find(obj.getId()); }

    
    public Loan find(String id) throws SQLException, EntityNotFoundException {
       String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Loan(rs.getString("id"),rs.getString("cotisation")/*,rs.getInt("managementPayment")*/
                                                                ,rs.getInt("amount"),rs.getString("sessio_sold"));
                        
					
		} throw new UnsupportedOperationException("aucun resultat"); //To change body of generated methods, choose Tools | Templates.
    }
}
