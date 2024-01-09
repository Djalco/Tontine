package dao;

import java.sql.SQLException;

public class DaoFactory {

	public static CotisationDao getCotisationDao() throws SQLException{
		return new CotisationDao();
	}


	public static UserDao getUserDao() throws SQLException{
		return new UserDao();
	}


	public static SessionDao getSessionDao() throws SQLException{
		return new SessionDao();
	}


//	public static ManagePaymentDao getManagePaymentDao() throws SQLException{
//		return new ManagePaymentDao() {};
//	}


	public static LoanDao getLoanDao() throws SQLException{
		return new LoanDao();
	}


	public static ContributionDao getContributionDao() throws SQLException{
		return new ContributionDao();
	}

}