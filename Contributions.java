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
public class Contributions extends ManagePayments{

    public Contributions(String id, int amont, DatePayment datePayment) {
        super(id, amont, datePayment);
    }

    public Contributions() {
        super(null, 0, null);
    }
}
