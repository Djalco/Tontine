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
public class ManagePayments {
    protected String id;
    protected int amont;
    protected DatePayment datePayment;

    public ManagePayments(String id, int amont, DatePayment datePayment) {
        this.id = id;
        this.amont = amont;
        this.datePayment = datePayment;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    
}
