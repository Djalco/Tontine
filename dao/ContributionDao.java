package dao;

import exception.EntityNotFoundException;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Contribution;
import model.Session;

public class ContributionDao extends Dao<Contribution>{

	public ContributionDao() throws SQLException {
		super();
                //precise la table  
                table = "Contribution";
                //initialiser la 1ere partie de l'identifiant
		idS="cont";
	}


	public Contribution create(Contribution obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `contribution`(`id`, `session_contributed`) values "
				+ "(?,?)";
                
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getSessionContributed().getId());
		ps.executeUpdate();
		return getLast();
	}

	
	public Contribution update(Contribution obj) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `contribution` SET "
                                + "`session_contributed`=? "
                                + "WHERE `id` = ?; ";
				PreparedStatement ps = con.prepareStatement(sql);
		
                ps.setString(1, obj.getSessionContributed().getId());
                ps.setString(2, obj.getId());
		ps.executeUpdate();
		return find(obj.getId());
	
	}

	
	public Contribution find(String id) throws SQLException, EntityNotFoundException {
		String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Contribution(rs.getString("id"),rs.getString("session_contributed"));
		}
		throw new EntityNotFoundException("info non trouvé");
	}

	
}
