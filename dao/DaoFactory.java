package dao;

import java.sql.SQLException;

public abstract class DaoFactory {
	static SanctionDao sanctionDao;
	static UserDao userDao;
	static SessionDao sessionDao;
	static LoanDao loanDao;
	static ContributionDao contributionDao;
	static SettingDao settingDao;

	public static UserDao getUserDao() throws SQLException{
		if(userDao==null) userDao = new UserDao();
		return userDao;
	}

	public static SessionDao getSessionDao() throws SQLException{
		if(sessionDao==null) sessionDao = new SessionDao();
		return sessionDao;
	}

	public static LoanDao getLoanDao() throws SQLException{
		if(loanDao==null) loanDao = new LoanDao();
		return loanDao;
	}

	public static ContributionDao getContributionDao() throws SQLException{
		if(contributionDao==null) contributionDao = new ContributionDao();
		return contributionDao;
	}

	public static SettingDao getSettingDao() throws SQLException{
		if(settingDao==null) settingDao = new SettingDao();
		return settingDao;
	}
	
	public static SanctionDao getSanctionDao() throws SQLException{
		if(sanctionDao==null) sanctionDao = new SanctionDao();
		return sanctionDao;
	}

}