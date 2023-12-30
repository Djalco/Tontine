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
public class Sanctions {
     protected String id;
     protected InfrctionPayment infractionPayment;
     protected String startDate;
     protected int amont;
     protected DatePayment datePayment;
     protected PaymentType paymentType;

    public Sanctions(String id, InfrctionPayment infractionPayment, String startDate,
                            int amont, DatePayment datePayment, PaymentType paymentType) {
        this.id = id;
        this.infractionPayment = infractionPayment;
        this.startDate = startDate;
        this.amont = amont;
        this.datePayment = datePayment;
        this.paymentType = paymentType;
    }

     public Sanctions() {
        this.id = null;
        this.infractionPayment = null;
        this.startDate = null;
        this.amont = 0;
        this.datePayment = null;
        this.paymentType = null;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public InfrctionPayment getInfractionPayment() {
        return infractionPayment;
    }

    public void setInfractionPayment(InfrctionPayment infractionPayment) {
        this.infractionPayment = infractionPayment;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getAmont() {
        return amont;
    }

    public void setAmont(int amont) {
        this.amont = amont;
    }

    public DatePayment getDatePayment() {
        return datePayment;
    }

    public void setDatePayment(DatePayment datePayment) {
        this.datePayment = datePayment;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
    
     
}
