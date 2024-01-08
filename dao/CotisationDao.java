package dao;

import java.sql.SQLException;
import java.util.List;

import exception.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Cotisation;
import model.User;

public class CotisationDao extends Dao<Cotisation>{

	public CotisationDao() throws SQLException {
		super();
		table = "cotisation";
		idS="cot";
	}

	@Override
	public Cotisation create(Cotisation obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `cotisation`(`id`, `user`, `session`, `managePayment`) VALUES "
				+ "(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getUser().getId());
		ps.setString(3, obj.getSession().getId());
		ps.setString(4, obj.getManagePayment().getId());
		ps.executeUpdate();
		return getLast();
	}

	@Override
	public Cotisation update(Cotisation obj) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `cotisation` SET "
				+ "`user`=?,"
				+ "`session`=?,"
				+ "`managementPayment`=?,"
				+ "WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, obj.getUser().getId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getManagePayment().getId());
		ps.setString(4, obj.getId());
		ps.executeUpdate();
		return find(obj.getId());
	}

	@Override
	public Cotisation find(String id) throws SQLException, EntityNotFoundException {
		String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Cotisation(rs.getString("id"),rs.getString("user"),rs.getString("session"),rs.getString("managementPayment"));
					
		}
		throw new EntityNotFoundException("Utilisateur non trouvé");
	}
	

	public List<Cotisation> findBySession(String cotisation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cotisation> findByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}
}
