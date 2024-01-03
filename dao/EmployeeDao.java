package dao;

public class EmployeeDao /*extends Dao<Employee>*/{
/*
	public EmployeeDao() throws SQLException {
		super();
		this.table = "employee";
	}

	@Override
	public int create(Employee obj) throws SQLException {
		String sql = "INSERT INTO `employee`(`registration_number`, "
				+ "`last_name`, `first_name`, `date_birth`, `place_birth`, "
				+ "`cni`, `mail`, `salary`, `address`, `sexe`, "
				+ "`job`, `entreprise`) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, obj.getMatricule());
		ps.setString(2, obj.getLastName());
		ps.setString(3, obj.getFirstName());
		ps.setDate(4, obj.getBirthDate());
		ps.setString(5, obj.getPlaceBirth());
		ps.setString(6, obj.getCni());
		ps.setString(7, obj.getMail());
		ps.setInt(8, obj.getSalary());
		ps.setString(9, obj.getAddress());
		ps.setString(10, obj.getSexe());
		ps.setString(11, obj.getJob());
		ps.setInt(12, obj.getEntreprise().getId());
		return ps.executeUpdate();
	}

	@Override
	public int update(Employee obj) throws SQLException {
		String sql = "UPDATE `employee` SET `registration_number`=?,"
				+ "`last_name`=?,`first_name`=?,`date_birth`=?,"
				+ "`place_birth`=?,`cni`=?,`mail`=?,"
				+ "`salary`=?,`address`=?,`sexe`=?,"
				+ "`job`=?,`entreprise`=? "
				+ "WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, obj.getMatricule());
		ps.setString(2, obj.getLastName());
		ps.setString(3, obj.getFirstName());
		ps.setDate(4, obj.getBirthDate());
		ps.setString(5, obj.getPlaceBirth());
		ps.setString(6, obj.getCni());
		ps.setString(7, obj.getMail());
		ps.setInt(8, obj.getSalary());
		ps.setString(9, obj.getAddress());
		ps.setString(10, obj.getSexe());
		ps.setString(11, obj.getJob());
		ps.setInt(12, obj.getEntreprise().getId());
		ps.setInt(13, obj.getId());
		return ps.executeUpdate();
	}

	@Override
	public Employee find(int id) throws SQLException {
		String sql = "SELECT * FROM `employee` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Employee(new Builder().whitMatricule(rs.getString("registration_number"))
					.whitId(id).whitLastName(rs.getString("last_name")).whitFirstName(rs.getString("first_name"))
					.whitBirthDate(rs.getDate("date_birth")).whitPlaceBirth(rs.getString("place_birth"))
					.whitCni(rs.getString("cni")).whitMail(rs.getString("mail")).whitSalary(rs.getInt("salary"))
					.whitAddress(rs.getString("address")).whitSexe(rs.getString("sexe"))
					.whitJob(rs.getString("job")).whitEntreprise(((EntrepriseDao) DaoFactory.getEntrepriseDao()).findByEmployee(id))
					.whitHoliday(DaoFactory.getHolidayDao().findByEmployee(id))
					.whitSanction(DaoFactory.getSanctionDao().findByEmployee(id))
					.whitPayment(DaoFactory.getPaymentDao().findByEmployee(id))
					.whitPayed(DaoFactory.getPaymentDao().existPaymentForThisMonth(id)));
		}
		throw new NotFoundEntityException("Employe non trouvé");
	}


	public Employee findMinimal(int id) throws SQLException {
		String sql = "SELECT * FROM `employee` WHERE id = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Employee(new Builder().whitMatricule(rs.getString("registration_number"))
					.whitId(id).whitLastName(rs.getString("last_name")).whitFirstName(rs.getString("first_name"))
					.whitBirthDate(rs.getDate("date_birth")).whitPlaceBirth(rs.getString("place_birth"))
					.whitCni(rs.getString("cni")).whitMail(rs.getString("mail")).whitSalary(rs.getInt("salary"))
					.whitAddress(rs.getString("address")).whitSexe(rs.getString("sexe"))
					.whitJob(rs.getString("job")));
		}
		throw new NotFoundEntityException("Employe non trouvé");
	}

	public List<Employee> findByEntreprise(int id) throws SQLException {
		List<Employee> array = new ArrayList<Employee>();
		String sql = "SELECT `id` FROM `employee` WHERE `is_actif` = 0 AND `entreprise` = " + id;
		Statement statement = con.createStatement();
		ResultSet rs = statement.executeQuery(sql);
		while(rs.next()) {
			if(find(rs.getInt("id"))!=null) {
				array.add(findMinimal(rs.getInt("id")));
				array.get(array.size()-1).setRow(array.size());
			}
		}
		return (ArrayList<Employee>) array;
	}
	
	public Employee findByMat(String mat) throws SQLException {
		String sql = "SELECT * FROM `employee` WHERE `registration_number`=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mat);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return new Employee(new Builder().whitMatricule(rs.getString("registration_number"))
					.whitId(rs.getInt("id")).whitLastName(rs.getString("last_name")).whitFirstName(rs.getString("first_name"))
					.whitBirthDate(rs.getDate("date_birth")).whitPlaceBirth(rs.getString("place_birth"))
					.whitCni(rs.getString("cni")).whitMail(rs.getString("mail")).whitSalary(rs.getInt("salary"))
					.whitAddress(rs.getString("address")).whitSexe(rs.getString("sexe"))
					.whitJob(rs.getString("job")));
		}
		throw new NotFoundEntityException("Employe non trouvé");
	}
	
	public boolean existByMat(String mat) throws SQLException {
		String sql = "SELECT * FROM `employee` WHERE `registration_number`=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, mat);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			return true;
		}
		return false;
	}*/

}
