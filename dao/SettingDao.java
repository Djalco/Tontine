package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import sql.BdConnexion;

public class SettingDao {

	public static boolean settingIsExist() throws SQLException {
		Connection con = BdConnexion.getInstance();
		String sql = "SELECT count(*) as size FROM `setting`";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) 
			return (rs.getInt("size")>0);
		return false;
	}

	public static void initSetting(int number_session, int fequency, int type_date, int amount_tontine, int type_payment_loan,
			int amount_payment_loan, int type_payment_infraction, int amount_payment_infraction, int amount_cotisation, LocalDate startDate) throws SQLException {
		Connection con = BdConnexion.getInstance();
		String sql = "INSERT INTO `setting`(`number_session`, `fequency`, `type_date`, `amount_tontine`, `type_payment_loan`, `amount_payment_loan`, "
				+ "`type_payment_infraction`, `amount_payment_infraction`, `amount_cotisation`, `start_date`) VALUES "
				+ "(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, number_session);
		ps.setInt(2, fequency);
		ps.setInt(3, type_date);
		ps.setInt(4, amount_tontine);
		ps.setInt(5, type_payment_loan);
		ps.setInt(6, amount_payment_loan);
		ps.setInt(7, type_payment_infraction);
		ps.setInt(8, amount_payment_infraction);
		ps.setInt(9, amount_cotisation);
		ps.setDate(10, Date.valueOf(startDate));
		ps.executeUpdate();
	}

	public static int getTypePamentLoan() throws SQLException {
		Connection con = BdConnexion.getInstance();
		String sql = "SELECT `type_payment_loan` FROM `setting`";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		return -1;
	}

	public static int getAmountPamentLoan() throws SQLException {
		Connection con = BdConnexion.getInstance();
		String sql = "SELECT `amount_payment_loan` FROM `setting`";
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		if(rs.next())
			return rs.getInt(1);
		return -1;
	}
}
