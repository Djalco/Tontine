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
public class Conditions {
     protected String id;
     protected int nbMaxSanction;
     protected int nbMaxlatePayment;
     protected int nbMaxlateRemboursement;

    public Conditions(String id, int nbMaxSanction, int nbMaxlatePayment, int nbMaxlateRemboursement) {
        this.id = id;
        this.nbMaxSanction = nbMaxSanction;
        this.nbMaxlatePayment = nbMaxlatePayment;
        this.nbMaxlateRemboursement = nbMaxlateRemboursement;
    }
    
    public Conditions() {
        this.id = null;
        this.nbMaxSanction = 0;
        this.nbMaxlatePayment = 0;
        this.nbMaxlateRemboursement = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getNbMaxSanction() {
        return nbMaxSanction;
    }

    public void setNbMaxSanction(int nbMaxSanction) {
        this.nbMaxSanction = nbMaxSanction;
    }

    public int getNbMaxlatePayment() {
        return nbMaxlatePayment;
    }

    public void setNbMaxlatePayment(int nbMaxlatePayment) {
        this.nbMaxlatePayment = nbMaxlatePayment;
    }

    public int getNbMaxlateRemboursement() {
        return nbMaxlateRemboursement;
    }

    public void setNbMaxlateRemboursement(int nbMaxlateRemboursement) {
        this.nbMaxlateRemboursement = nbMaxlateRemboursement;
    }

   
}
