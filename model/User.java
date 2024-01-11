package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.scene.text.Text;
import model.enumration.InfractionPayment;
import model.enumration.Role;
import model.enumration.Status;

public class User extends AbstractEntity{
	private static User userConnected;
	private static List<User> users = new ArrayList<User>();
	private String login;
	private String firstname;
	private String lastname;
	private String password;
	private String mail;
	private String phone;
	private Role role;
	private int nbPerson;

	static{
		try {
			userConnected= DaoFactory.getUserDao().find("usr-023-001");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public User(UserBuilder builder) {
		id = builder.id;
		login = builder.login;
		firstname = builder.firstname;
		lastname = builder.lastname;
		password = builder.password;
		mail = builder.mail;
		phone = builder.phone;
		role = Role.getRole(builder.role);
		nbPerson = builder.nbPerson;

		if(!users.contains(this))users.add(this);
	}

	public User() {
	}

	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public void setRole(String role) {
		this.role = Role.getRole(role);
	}
	public int getNbPerson() {
		return nbPerson;
	}
	public void setNbPerson(int nbPerson) {
		this.nbPerson = nbPerson;
	}

	public static User getUserConnected() {
		return userConnected;
	}

	public static void setUserConnected(User userConnected) {
		User.userConnected = userConnected;
	}

	public static List<User> getList() {
		return users;
	}


	public static class UserBuilder {
		private String id = "";
		private int role = 0;
		private String login = "";
		private String firstname = "";
		private String lastname = "";
		private String password = "";
		private String mail = "";
		private String phone = "";
		private int nbPerson = 0;

		public UserBuilder id (String id) {
			this.id = id;
			return this;
		}

		public UserBuilder role(int role) {
			this.role = role;
			return this;
		}

		public UserBuilder login(String login) {
			this.login = login;
			return this;
		}

		public UserBuilder firstname(String firstname) {
			this.firstname = firstname;
			return this;
		}

		public UserBuilder lastname(String lastname) {
			this.lastname = lastname;
			return this;
		}

		public UserBuilder password(String password) {
			this.password = password;
			return this;
		}

		public UserBuilder mail(String mail) {
			this.mail = mail;
			return this;
		}

		public UserBuilder phone(String phone) {
			this.phone = phone;
			return this;
		}

		public UserBuilder nbPerson(int nbPerson) {
			this.nbPerson = nbPerson;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}


	@Override
	public void setEntity(AbstractEntity t) {
		User u = (User) t;

		login = u.login;
		firstname = u.firstname;
		lastname = u.lastname;
		password = u.password;
		mail = u.mail;
		phone = u.phone;
		role = u.role;
		nbPerson = u.nbPerson;
	}

	@Override
	public String toString() {
		return lastname + " " + firstname;
	}

	public Text getStatusContributiontion() throws SQLException {
		boolean status = DaoFactory.getUserDao().userIsValidContribution(id);
		Text t = new Text(status?"Valide":"Invalide");
		if (status)
			t.getStyleClass().add("status-good");
		else
			t.getStyleClass().add("status-not-good");
		return t;
	}

	public Text getStatusLoan() throws SQLException {
		boolean status = DaoFactory.getUserDao().userIsValidLoan(id);
		Text t = new Text(status?"Valide":"Invalide");
		if (status)
			t.getStyleClass().add("status-good");
		else
			t.getStyleClass().add("status-not-good");
		return t;
	}

	public List<Loan> getLoan() throws SQLException, EntityNotFoundException {
		return DaoFactory.getLoanDao().findByUser(id);
	}

	public int getAmountLoan() throws SQLException, EntityNotFoundException {
		int amount = 0;
		for(Loan loan: DaoFactory.getLoanDao().findByUser(id))
			amount+=loan.getAmount();
		return amount;
	}

	public int getAmount() throws SQLException {
		return DaoFactory.getContributionDao().findByUser(id).size() * Contribution.getAmount();
	}

	public int getValidLoan() throws SQLException, EntityNotFoundException {
		int nb = 0;
		for(Loan loan: DaoFactory.getLoanDao().findByUser(id))
			nb+=loan.getStatus()==Status.VALID?1:0;
		return nb;
	}

	public int getAmountInfraction() throws SQLException, EntityNotFoundException {
		int amount = 0;
		System.out.println(DaoFactory.getSanctionDao().findByUser(id).size());
		for(Sanction s: DaoFactory.getSanctionDao().findByUser(id))
			amount+=s.getAmount();
		return amount;
	}

	public int getAmountInfractionLoan() throws SQLException, EntityNotFoundException {
		int amount = 0;
		for(Sanction s: DaoFactory.getSanctionDao().findByUser(id))
			if(s.getInfractionPayment() == InfractionPayment.LATE_REMBOURSEMENT)
			amount+=s.getAmount();
		return amount;
	}

	public int getAmountInterest() throws SQLException, EntityNotFoundException {
		int amount = 0;
		for(Loan s: DaoFactory.getLoanDao().findByUser(id))
			amount+=s.getInterest();
		return amount;
	}

	public int getAmountRemaining() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().getAll(10000).size()*Contribution.getAmount()-getAmount();
	}

	public int getPos() throws SQLException, EntityNotFoundException {
		return DaoFactory.getUserDao().getAll(10000).indexOf(this)+1;
	}

	public List<Sanction> getInfraction() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSanctionDao().findByUser(id);
	}

	public int getNbInfractionLoan() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSanctionDao().findByUser(id)
				.stream().filter(e-> e.getInfractionPayment() == InfractionPayment.LATE_REMBOURSEMENT)
				.toList().size();
	}

	public int getNbSession() throws SQLException, EntityNotFoundException {
		return DaoFactory.getSessionDao().getAll(10000).size();
	}

	public int getNbSessionContribute() throws SQLException {
		return DaoFactory.getContributionDao().findByUser(id).size();
	}

}
