/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import exception.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import model.Sanction;
import model.Session;

/**
 *
 * @author Alexiapc
 */
public class SanctionDao extends Dao<Sanction>{

    public SanctionDao() throws SQLException {
		super();
		table = "Sanction";
		idS="sanc";
	}
    @Override
    public Sanction create(Sanction obj) throws SQLException, EntityNotFoundException {
        
            String sql = "INSERT INTO `sanction`(`id`, `infraction_payment`, `session_start`, `session_sold`) VALUES "
                    + "(?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, generateId());
            ps.setString(2, obj.getInfractionPayment().getName());
            ps.setString(3, obj.getSessionStart().getId());
            ps.setString(4, obj.getSessionSold().getId());
            ps.executeUpdate();
            return getLast();
        }  
  
    @Override
    public Sanction find(String id) throws SQLException, EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Sanction update(Sanction obj) throws SQLException, EntityNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
