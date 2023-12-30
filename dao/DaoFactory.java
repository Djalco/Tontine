package dao;

import java.sql.SQLException;

import model.Cotisation;

public class DaoFactory {
	public static CotisationDao getCotisationDao() throws SQLException{
		return new CotisationDao();
	}
}
