/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Alexiapc
 */
public class Loan extends ManagePayment{
     public ObjectProperty<PaymentType> paymentType;

    public Loan(PaymentType paymentType, int id, int amont, DatePayment datePayment) {
        super(id, amont, datePayment);
        this.paymentType = new SimpleObjectProperty<PaymentType>(paymentType);
    }
     
     public Loan() {
        super(0, 0, null);
        this.paymentType = new SimpleObjectProperty<PaymentType>();
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
    
    public void isValidForLoan(User user){
        
    }
}