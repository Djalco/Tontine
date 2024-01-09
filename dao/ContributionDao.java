package dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import model.Contribution;

public class ContributionDao extends Dao<Contribution>{

	public ContributionDao() throws SQLException {
		super();
                table = "session";
		idS="sess";
	}


	public Contribution create(Contribution obj) throws SQLException {
		String sql = "INSERT INTO `session`(`id`, `createDate`,'lastModifyDate','amont','session','cotisation', `session_contributed`) values "
				+ "(?,?,?,?,?,?,?)";
                
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setDate(2, Date.valueOf(obj.getCreateDate()));
		ps.setDate(3, Date.valueOf(obj.getDateSession()));
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

	
}
