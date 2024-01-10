package controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import controller.generic.EntityControllerAbstract;
import dao.DaoFactory;
import exception.EntityNotFoundException;
import javafx.fxml.FXML;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.VBox;
import model.User;
import model.enumration.Role;
import util.Validator;
import util.Validator.RegexType;

public class UserController extends EntityControllerAbstract<User>{


	@FXML
	private VBox firstname;

	@FXML
	private VBox lastname;

	@FXML
	private VBox login;

	@FXML
	private VBox mail;

	@FXML
	private VBox noms;

	@FXML
	private VBox password;

	@FXML
	private VBox phone;

	@FXML
	private VBox role;

	@FXML
	private VBox verifyPassword;

	@Override
	protected void setField() throws Exception {
		if (entity == null)
			throw new EntityNotFoundException( "L'Entité nulle");
		setTextField(login, entity.getLogin());
		setTextField(mail, entity.getMail());
		setTextField(password, entity.getPassword());
		setTextField(verifyPassword, entity.getPassword());
		setTextField(lastname, entity.getLastname());
		setTextField(firstname, entity.getFirstname());
		setTextField(phone, entity.getPhone());
		getComboBox(role).getSelectionModel().select(entity.getRole().getName());
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
		valueFactory.setValue(entity.getNbPerson());
		Spinner<Integer> spinner = getSpinner(noms);
		
		spinner.setValueFactory(valueFactory);
	}

	@Override
	protected void clearField() throws Exception {
		setTextField(login, "");
		setTextField(mail, "");
		setTextField(password, "");
		setTextField(verifyPassword, "");
		setTextField(lastname, "");
		setTextField(firstname, "");
		setTextField(phone, "");
		
		getComboBox(role).getSelectionModel().selectFirst();
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
		valueFactory.setValue(0);
		Spinner<Integer> spinner = getSpinner(noms);
		
		spinner.setValueFactory(valueFactory);
	}

	@Override
	protected void disableField(boolean disable) {
		setDisable(login, disable);
		setDisable(mail, disable);
		setDisable(password, disable);
		setDisable(verifyPassword, disable);
		setDisable(lastname, disable);
		setDisable(firstname, disable);
		setDisable(phone, disable);
		setDisable(role, disable);
		setDisable(noms, disable);
	}
	

	@Override
	protected void initComponent() throws Exception {
		setValidatorTextField(login, 
				new Validator("Le login ne doit pas être videeeeee",6,"Le login doit faire au moins 6 caractères",
						RegexType.LOGIN.getRegex(),"Le login ne contient que des lettres minuscules"));

		setValidatorPassword(password, 
				new Validator("Le mot de passe ne doit pas être vide",8,"Le mot de passe doit faire au moins 8 caractères",
						RegexType.PASSWORD.getRegex(),"Le mot de passe n'est pas valide"),
				verifyPassword,
				new Validator("Les deux mots de passes sont differents"));

		setValidatorTextField(mail, 
				new Validator("Le mail ne doit pas être vide",
						RegexType.MAIL.getRegex(),"Le mail n'est pas valide"));
		
		setValidatorTextField(lastname, 
				new Validator("Le nom ne doit pas être vide",4,"Le nom doit faire au moins 4 caractères"));
		
		setValidatorTextField(firstname, 
				new Validator("Le prenom ne doit pas être vide",4,"Le prenom doit faire au moins 4 caractères"));
		
		setValidatorTextField(phone, 
				new Validator("Le téléphone ne doit pas être vide",9,"Le téléphone est formé d'au moins 9 chiffres"));
		
		getComboBox(role).getItems().addAll(Role.MEMBER, Role.SECRETARY);
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, Integer.MAX_VALUE);
		valueFactory.setValue(1);
		
		getSpinner(noms).setValueFactory(valueFactory);
		
		
	}

	@Override
	protected void buildEntity() throws Exception {
		if(entity == null)
			entity = new User();
		entity.setLogin(getTexteField(login).getText());
		entity.setMail(getTexteField(mail).getText());
		entity.setPassword(getTexteField(password).getText());
		entity.setLastname(getTexteField(lastname).getText());
		entity.setFirstname(getTexteField(firstname).getText());
		entity.setPhone(getTexteField(phone).getText());
		try {
			entity.setRole((Role) getComboBox(role).getSelectionModel().getSelectedItem());
		}catch(Exception e) {
			entity.setRole((String) getComboBox(role).getSelectionModel().getSelectedItem());
		}
		entity.setNbPerson(getSpinner(noms).getValue());
		}

	@Override
	protected void setDao() throws SQLException {
		dao = DaoFactory.getUserDao();
		
	}


}
