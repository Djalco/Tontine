/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author Alexiapc
 */
public class Users {
    protected  String id;
    protected String login;
    protected String firstname;
    protected String lastname;
    protected String password;
    protected String mail;
    protected int phone;
    protected String role;
    protected int nbPerson;

    public Users(String id, String login, String firstname, String lastname, String password, String mail, int phone, String role, int nbPerson) {
        this.id = id;
        this.login = login;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.mail = mail;
        this.phone = phone;
        this.role = role;
        this.nbPerson = nbPerson;
    }
    
    public Users() {
        this.id = null;
        this.login = null;
        this.firstname = null;
        this.lastname = null;
        this.password = null;
        this.mail = null;
        this.phone = 0;
        this.role = null;
        this.nbPerson = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getNbPerson() {
        return nbPerson;
    }

    public void setNbPerson(int nbPerson) {
        this.nbPerson = nbPerson;
    }
    
    public void login(){
        
    }
    
    public void consultProfile(){
        
    }
   
}
