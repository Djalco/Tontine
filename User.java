/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alexiapc
 */
public class User {
    protected  IntegerProperty id;
    protected StringProperty login;
    protected StringProperty firstname;
    protected StringProperty lastname;
    protected StringProperty password;
    protected StringProperty mail;
    protected IntegerProperty phone;
    protected StringProperty role;
    protected IntegerProperty nbPerson;

    public User(int id, String login, String firstname, String lastname, String password, String mail, 
                                 int phone, String role, int nbPerson) {
        
        this.id = new SimpleIntegerProperty(id);
      this.login = new SimpleStringProperty(login);
        this.firstname = new SimpleStringProperty(firstname);
        this.lastname = new SimpleStringProperty(lastname);
        this.password = new SimpleStringProperty(password);
        this.mail = new SimpleStringProperty(mail);
        this.phone = new SimpleIntegerProperty(phone);
        this.role = new SimpleStringProperty(role);
        this.nbPerson = new SimpleIntegerProperty(nbPerson);
    }
    
     public User() {
        
        this.id = new SimpleIntegerProperty();
      this.login = new SimpleStringProperty();
        this.firstname = new SimpleStringProperty();
        this.lastname = new SimpleStringProperty();
        this.password = new SimpleStringProperty();
        this.mail = new SimpleStringProperty();
        this.phone = new SimpleIntegerProperty();
        this.role = new SimpleStringProperty();
        this.nbPerson = new SimpleIntegerProperty();
    }
     

    public int getId() {
        return id.get();
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public IntegerProperty IdProperty() {
        return id;
    }
    

    public String getLogin() {
        return login.get();
    }
    public void setLogin(String login) {
        this.login.set(login);
    }
    public StringProperty LoginProperty() {
        return login;
    }

    
    public String getFirstname() {
        return firstname.get();
    }
    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }
    public StringProperty FirstnameProperty() {
        return firstname;
    }
    

    public String getLastname() {
        return lastname.get();
    }
    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }
    public StringProperty LastnameProperty() {
        return lastname;
    }
    

    public String getPassword() {
        return password.get();
    }
    public void setPassword(String password) {
        this.password.set(password);
    }
    public StringProperty PasswordProperty() {
        return password;
    }
    

    public String getMail() {
        return mail.get();
    }
    public void setMail(String mail) {
        this.mail.set(mail);
    }
    public StringProperty MailProperty() {
        return mail;
    }
    

    public int getPhone() {
        return phone.get();
    }
    public void setPhone(int phone) {
        this.phone.set(phone);
    }
    public IntegerProperty PhoneProperty() {
        return phone;
    }
    

    public String getRole() {
        return role.get();
    }
    public void setRole(String role) {
        this.role.set(role);
    }
    public StringProperty RoleProperty() {
        return role;
    }
    
    
    public int getNbPerson() {
        return nbPerson.get();
    }
    public void setNbPerson(int nbPerson) {
        this.nbPerson.set(nbPerson);
    }
    public IntegerProperty NbPersonProperty() {
        return nbPerson;
    }
    
    public void login(){
        
    } 
    
    public void consultProfil(){
        
    }
}
