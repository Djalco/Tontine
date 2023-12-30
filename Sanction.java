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
public class Sanction {
     protected IntegerProperty id;
     protected ObjectProperty<InfrctionPayment> infractionPayment;
     protected ObjectProperty<String> startDate;
     protected IntegerProperty amont;
     protected ObjectProperty<DatePayment> datePayment;
     protected ObjectProperty<PaymentType> paymentType;

    public Sanction(int id, InfrctionPayment infractionPayment, String startDate,
                int amont, DatePayment datePayment, PaymentType paymentType) {
        this.infractionPayment = new SimpleObjectProperty<InfrctionPayment>(infractionPayment);
        this.startDate = new SimpleObjectProperty<String>(startDate);
        this.paymentType = new SimpleObjectProperty<PaymentType>(paymentType);
        this.id = new SimpleIntegerProperty(id);
        this.amont = new SimpleIntegerProperty(amont);
        this.datePayment = new SimpleObjectProperty<DatePayment>(datePayment);
    }
     
    public Sanction() {
        this.infractionPayment = new SimpleObjectProperty<InfrctionPayment>();
        this.startDate = new SimpleObjectProperty<String>();
        this.paymentType = new SimpleObjectProperty<PaymentType>();
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
    
    public ObjectProperty StartDateProperty() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate.set(startDate);
    }
    public String getStartDate() {
        return startDate.get();
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
    
    public ObjectProperty PaymentTypeProperty() {
        return paymentType;
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType.set(paymentType);
    }
    public PaymentType getPaymentType() {
        return paymentType.get();
    }
    
    public ObjectProperty InfractionPaymentProperty() {
        return paymentType;
    }
    public void setInfractionPayment(InfrctionPayment infractionPayment) {
        this.infractionPayment.set(infractionPayment);
    }
    public InfrctionPayment getInfractionPayment() {
        return infractionPayment.get();
    }
}
