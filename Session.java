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
public class Session {
    protected IntegerProperty id;
    protected StringProperty dateSession;

    public Session(int id, String dateSession) {
        this.id = new SimpleIntegerProperty(id);
        this.dateSession = new SimpleStringProperty(dateSession);
    }
    
    public IntegerProperty IdProperty() {
        return id;
    }
    public void setId(int id) {
        this.id.set(id);
    }
    public int getId() {
        return id.get();
    }
    

    public StringProperty DateSessionProperty() {
        return dateSession;
    }
    public void setDateSession(String dateSession) {
        this.dateSession.set(dateSession);
    }
    public String getDateSession() {
        return dateSession.get();
    }

    
}
