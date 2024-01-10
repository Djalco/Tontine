package dao;

import java.sql.SQLException;

public abstract class DaoFactory {

	public static SanctionDao getCotisationDao() throws SQLException{
		return new SanctionDao();
	}


	public static UserDao getUserDao() throws SQLException{
		return new UserDao();
	}


	public static SessionDao getSessionDao() throws SQLException{
		return new SessionDao();
	}


	public static ManagePaymentDao getManagePaymentDao() throws SQLException{
		return new ManagePaymentDao();
	}


	public static LoanDao getLoanDao() throws SQLException{
		return new LoanDao();
	}


	public static ContributionDao getContributionDao() throws SQLException{
		return new ContributionDao();
	}


	public static SettingDao getSettingDao() throws SQLException{
		return new SettingDao();
	}
	
	public static SanctionDao getSanctionDao() throws SQLException{
		return new SanctionDao();
	}

}