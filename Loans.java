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
public class Loans extends ManagePayments{
     public PaymentType paymentType;

    public Loans(PaymentType paymentType, String id, int amont, DatePayment datePayment) {
        super(id, amont, datePayment);
        this.paymentType = paymentType;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }

    
    
    public void isValidForLoan(Users user){
        
    }
}