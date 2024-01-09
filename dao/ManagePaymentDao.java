package dao;

import model.enumration.ManagePaymentType;
import java.sql.SQLException;
import java.util.List;

import exception.EntityNotFoundException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.AbstractEntity;
import model.Cotisation;
import model.ManagePayment;

public abstract class ManagePaymentDao<T extends ManagePayment> extends Dao<T>{

	public ManagePaymentDao() throws SQLException {
		super();
		table = "user";
		idS="usr";
	}

	@Override
	public ManagePayment create(ManagePayment obj) throws SQLException, EntityNotFoundException {
		String sql = "INSERT INTO `ManagePayment`(`id`,`session`,`user`, `managePaymentType`) VALUES "
				+ "(?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, generateId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getUser().getId());
		//ps.setInt(4, obj.getManagement().getId());
		ps.executeUpdate();
                return getLast();
	}

	@Override
	public ManagePayment update(ManagePayment obj) throws SQLException, EntityNotFoundException {
		String sql = "UPDATE `cotisation` SET "
				+ "`session`=?,"
				+ "`user`=?,"
				+ "`managementPaymentType`=?,"
				+ "WHERE `id` = ?; ";
		PreparedStatement ps = con.prepareStatement(sql);

		ps.setString(1, generateId());
		ps.setString(2, obj.getSession().getId());
		ps.setString(3, obj.getUser().getId());
		//ps.setInt(4, obj.getManagePaymentType().getId());
                ps.executeUpdate();
                return find(obj.getId());
	}

//	@Override
//	public ManagePayment find(String id) throws SQLException, EntityNotFoundException {
//		String sql = "SELECT * FROM `"+table+"` WHERE id = ?";
//		PreparedStatement ps = con.prepareStatement(sql);
//		ps.setString(1, id);
//		ResultSet rs = ps.executeQuery();
//		if (rs.next()) {
//			return new ManagePayment(rs.getString("id"),rs.getString("session"),rs.getString("user"),rs.getInt("managementPaymentType")) ;
//                           
//		
//		throw new EntityNotFoundException("aucune info dispo");
//        }

	public List<ManagePayment> findBySession(String cotisation) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<ManagePayment> findByUser(String user) {
		// TODO Auto-generated method stub
		return null;
	}


}
