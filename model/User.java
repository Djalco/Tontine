package model;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import dao.DaoFactory;
import model.enumration.Role;

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
	private String nbPerson;

	private User(UserBuilder builder) {
		id = builder.id;
		login = builder.login;
		firstname = builder.firstname;
		lastname = builder.lastname;
		password = builder.password;
		mail = builder.mail;
		phone = builder.phone;
		role = builder.role;
		nbPerson = builder.nbPerson;

		if(!users.contains(this))users.add(this);
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
	public String getNbPerson() {
		return nbPerson;
	}
	public void setNbPerson(String nbPerson) {
		this.nbPerson = nbPerson;
	}

	private List<ManagePayment> getManagePaymeny() throws SQLException {
		return DaoFactory.getManagePaymentDao().findByUser(id);
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
		private Role role = null;
		private String login = "";
		private String firstname = "";
		private String lastname = "";
		private String password = "";
		private String mail = "";
		private String phone = "";
		private String nbPerson = "";

		public UserBuilder(String id, Role role) {
			this.id = id;
			this.role = role;
		}

		public UserBuilder login(String login) {
			this.login = login;
			return this;
		}

		public User build() {
			return new User(this);
		}
	}



}
