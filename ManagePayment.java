/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alexiapc
 */
public class ManagePayment {
    protected IntegerProperty id;
    protected IntegerProperty amont;
    public ObjectProperty<DatePayment> datePayment;

    public ManagePayment(int id,int amont, DatePayment datePayment) {
         this.id = new SimpleIntegerProperty(id);
          this.amont = new SimpleIntegerProperty(amont);
           this.datePayment = new SimpleObjectProperty<DatePayment>(datePayment);
    }
    
    public ManagePayment() {
         this.id = new SimpleIntegerProperty();
         this.amont = new SimpleIntegerProperty();
           this.datePayment = new SimpleObjectProperty<DatePayment>();
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
    
    
    public IntegerProperty AmontProperty() {
        return amont;
    }
    public void setAmont(int amont) {
        this.amont.set(amont);
    }
    public int getAmont() {
        return amont.get();
    }
    
    
    public ObjectProperty<DatePayment> DatePaymentProperty() {
        return datePayment;
    }
    public void setId(DatePayment datePayment) {
        this.datePayment.set(datePayment);
    }
    public DatePayment getDatePayment() {
        return datePayment.get();
    }

}
