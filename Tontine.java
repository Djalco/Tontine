/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alexiapc
 */
public class Tontine {
    protected IntegerProperty id;

    public Tontine(int id) {
         this.id = new SimpleIntegerProperty(id);
    }
    
    public Tontine() {
         this.id = new SimpleIntegerProperty();
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

 
    
}
