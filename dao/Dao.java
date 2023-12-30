package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.AbstractEntity;
import sql.BdConnexion;

public abstract class Dao <T>{

	protected String table;
	protected String bdName;
	protected Connection con = null;
	
	public Dao() throws SQLException{
		super();
		con = BdConnexion.getInstance();
	}

	public abstract int create(T obj) throws SQLException;
	
	public abstract int update(T obj) throws SQLException;

	public abstract T find(String id) throws SQLException;

	public int delete(String id) throws SQLException{
		String sql = "UPDATE `"+table+" SET `is_actif` = 0 WHERE `id` = ?";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, id);
		return pst.executeUpdate();
	};
	
	public ArrayList<T> getAll(int limit) throws SQLException{
		List<T> array = new ArrayList<T>();
		String sql = "SELECT `id` FROM " + table + " WHERE `is_actif` = 1 LIMIT ?;";
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, limit);
		ResultSet rs = pst.executeQuery();
		while(rs.next()) {
				array.add(find(rs.getString("id")));
				((AbstractEntity) array.get(array.size()-1)).setRow(array.size());
		}
		return (ArrayList<T>) array;
	}
	
}
