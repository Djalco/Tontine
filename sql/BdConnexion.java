package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;

public class BdConnexion {

	private static String urlVerify = "jdbc:mysql://localhost:3306";
	private static String url = "jdbc:mysql://localhost:3306/employee_management";
	private static String dbName = "employee_management";
	private static String user = "root";
	private static String passwd = "";
	
	private static Connection con;
	
	public static Connection getInstance() throws SQLException {
		
		con = DriverManager.getConnection(urlVerify, user, passwd);
		
		Statement statement = con.createStatement();
		
		String query = "SELECT SCHEMA_NAME FROM information_schema.SCHEMATA WHERE SCHEMA_NAME = '" + dbName + "'";
		
		try {
			ResultSet resultSet = statement.executeQuery(query);
			if(!resultSet.next()) {
				createDatabase();
			}
			con.close();
			con = DriverManager.getConnection(url, user, passwd);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	private static void createDatabase() throws SQLException {
		String sql = "CREATE DATABASE employee_management;";
		String createEntreprise = "CREATE TABLE `entreprise` ("
				+ "`id` INT NOT NULL AUTO_INCREMENT , "
				+ "`name` VARCHAR(50) NOT NULL , "
				+ "`boss_name` VARCHAR(50) NOT NULL , "
				+ "`is_actif` INT NOT NULL DEFAULT '0',"
				+ "PRIMARY KEY (`id`)) "
				+ "ENGINE = InnoDB;";
		String insertEntreprise = "INSERT INTO `entreprise` (`id`, `name`, `boss_name`, `is_actif`) VALUES "
				+ "(1, 'NebSociety', 'Monkey D Luffy', 0), "
				+ "(2, 'Soul Society', 'Ichigo', 0), "
				+ "(3, 'One Piece Trading', 'Brondon Njotsa', 0);";
		String createEmployee = "CREATE TABLE `employee` ("
				+ "`id` INT NOT NULL AUTO_INCREMENT , "
				+ "`registration_number` VARCHAR(50) NOT NULL , "
				+ "`last_name` VARCHAR(50) NOT NULL , "
				+ "`first_name` VARCHAR(50) NOT NULL , "
				+ "`date_birth` DATE NOT NULL , "
				+ "`place_birth` VARCHAR(50) NOT NULL , "
				+ "`cni` VARCHAR(50) NOT NULL , "
				+ "`mail` VARCHAR(50) NOT NULL , "
				+ "`salary` INT NOT NULL , "
				+ "`address` VARCHAR(50) NOT NULL , "
				+ "`sexe` VARCHAR(50) NOT NULL , "
				+ "`job` VARCHAR(50) NOT NULL , "
				+ "`entreprise` INT(50) NOT NULL , "
				+ "`is_actif` INT NOT NULL DEFAULT '0',"
				+ "PRIMARY KEY (`id`),"
				+ "FOREIGN KEY (`entreprise`) REFERENCES `entreprise` (`id`)"
				+ ") ENGINE = InnoDB;";
		String insertEmployee = "INSERT INTO `employee` "
				+ "(`id`, `registration_number`, `last_name`, `first_name`, "
				+ "`date_birth`, `place_birth`, `cni`, `mail`, `salary`, "
				+ "`address`, `sexe`, `job`, `entreprise`) VALUES "
				+ "(NULL, 'mat-256-987-324', 'Nyah', 'Erika', '2004-08-01', 'Baffoussam', "
				+ "'681wded35eded', 'erickanyah@gmail.com', '250000', 'bonaberi', "
				+ "'Femme', 'Manager', '2'), "
				+ "(NULL, 'mat-654-832-987', 'Makam', 'Audrey', '2006-02-25', 'Douala', "
				+ "'64de468d4ce7ce', 'makam@gmail.com', '500000', 'Logbessou', "
				+ "'Femme', 'Chef departement', '2')";
		String createHoliday = "CREATE TABLE `holiday` "
				+ "(`id` INT NOT NULL AUTO_INCREMENT , "
				+ "`employee` INT NOT NULL , "
				+ "`startDate` DATE NOT NULL , "
				+ "`endDate` DATE NOT NULL , "
				+ "`is_actif` INT NOT NULL DEFAULT '0',"
				+ "FOREIGN KEY (`employee`) REFERENCES `employee` (`id`),"
				+ "PRIMARY KEY (`id`)) ENGINE = InnoDB;";
		String insertHoliday = "INSERT INTO `holiday` "
				+ "(`id`, `employee`, `startDate`, `endDate`) VALUES "
				+ "(NULL, '1', '2023-08-13', '2023-08-12'), "
				+ "(NULL, '2', '2023-08-27', '2023-09-02')";
		String createSanction = "CREATE TABLE `sanction` "
				+ "(`id` INT NOT NULL AUTO_INCREMENT , "
				+ "`employee` INT NOT NULL , "
				+ "`description` TEXT NOT NULL , "
				+ "`startDate` DATE NOT NULL , "
				+ "`endDate` DATE NOT NULL , "
				+ "`is_actif` INT NOT NULL DEFAULT '0',"
				+ "FOREIGN KEY (`employee`) REFERENCES `employee` (`id`),"
				+ "PRIMARY KEY (`id`)) ENGINE = InnoDB;";
		String insertSanction = "INSERT INTO `sanction` "
				+ "(`id`, `employee`, `description`, `startDate`, `endDate`) VALUES "
				+ "(NULL, '1', 'Mauvaises conduite envers les supperieurs\\r\\n     "
				+ "-Injures envers son superieurs\\r\\n     "
				+ "-Tentatives de fraudes\\r\\n     "
				+ "-Somnalence et pets intempestifs', '2023-08-13', '2023-08-09');";
		String usersCreate = "CREATE TABLE `employee_management`.`users` ("
				+ "`id` INT NOT NULL AUTO_INCREMENT , "
				+ "`last_name` VARCHAR(30) NOT NULL , "
				+ "`first_name` VARCHAR(30) NOT NULL , "
				+ "`login` VARCHAR(30) NOT NULL , "
				+ "`mail` VARCHAR(30) NOT NULL , "
				+ "`password` VARCHAR(30) NOT NULL , "
				+ "`name_entreprise` VARCHAR(30) NOT NULL , "
				+ "PRIMARY KEY (`id`)"
				+ ") ENGINE = InnoDB;";
		String paymentCreate = "CREATE TABLE `employee_management`.`payment` ("
				+ "`id` INT NOT NULL AUTO_INCREMENT , "
				+ "`employee` INT NOT NULL , "
				+ "`payment_date` DATE NOT NULL , "
				+ "`amount` INT NOT NULL , "
				+ "FOREIGN KEY (`employee`) REFERENCES `employee` (`id`),"
				+ "PRIMARY KEY (`id`)) ENGINE = InnoDB;";
		String usersInsert = "INSERT INTO `users` "
				+ "(`id`, `last_name`, `first_name`, `login`, `mail`, "
				+ "`password`, `name_entreprise`) VALUES (NULL, 'Paul', 'Menkene', 'paulo', 'paul@menkene.com', 'paupaul', 'SoftSky')";
		Connection con = DriverManager.getConnection(urlVerify, user, passwd);
		PreparedStatement ps = con.prepareStatement(sql);
		ps.executeUpdate();
		execute(Arrays.asList(createEntreprise,insertEntreprise,createEmployee,insertEmployee,
				createHoliday,insertHoliday,createSanction,insertSanction,paymentCreate,
				usersCreate,usersInsert));
	}
	
	private static void execute(List<String> sqls) throws SQLException {
		for(String sql: sqls) {
			Connection con = DriverManager.getConnection(url, user, passwd);
			PreparedStatement ps = con.prepareStatement(sql);
			ps.executeUpdate();
		}
	}

}
