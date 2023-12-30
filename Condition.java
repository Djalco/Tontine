/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

/**
 *
 * @author Alexiapc
 */
public class Condition {
     protected IntegerProperty id;
     protected IntegerProperty nbMaxSanction;
     protected IntegerProperty nbMaxlatePayment;
     protected IntegerProperty nbMaxlateRemboursement;

    public Condition(int id, int nbMaxSanction, int nbMaxlatePayment, int nbMaxlateRemboursement) {
         this.id = new SimpleIntegerProperty(id);
         this.nbMaxSanction = new SimpleIntegerProperty(nbMaxSanction);
         this.nbMaxlatePayment = new SimpleIntegerProperty(nbMaxlatePayment);
        this.nbMaxlateRemboursement = new SimpleIntegerProperty(nbMaxlateRemboursement);
    }
    
    public Condition() {
         this.id = new SimpleIntegerProperty();
         this.nbMaxSanction = new SimpleIntegerProperty();
         this.nbMaxlatePayment = new SimpleIntegerProperty();
        this.nbMaxlateRemboursement = new SimpleIntegerProperty();
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
    
    public IntegerProperty NbMaxSanctionProperty() {
        return nbMaxSanction;
    }
    public void setNbMaxSanction(int nbMaxSanction) {
        this.nbMaxSanction.set(nbMaxSanction);
    }
    public int getNbMaxSanction() {
        return nbMaxSanction.get();
    }
    
    public IntegerProperty NbMaxlatePaymentProperty() {
        return nbMaxlatePayment;
    }
    public void setNbMaxlatePayment(int nbMaxlatePayment) {
        this.nbMaxlatePayment.set(nbMaxlatePayment);
    }
    public int getNbMaxlatePayment() {
        return nbMaxlatePayment.get();
    }
    
    public IntegerProperty NbMaxlateRemboursementtProperty() {
        return nbMaxlatePayment;
    }
    public void setNbMaxlateRemboursement(int nbMaxlateRemboursement) {
        this.nbMaxlateRemboursement.set(nbMaxlateRemboursement);
    }
    public int getNbMaxlateRemboursement() {
        return nbMaxlateRemboursement.get();
    }
}
