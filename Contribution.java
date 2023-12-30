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
public class Contribution extends ManagePayment{

    public Contribution(int id, int amont, DatePayment datePayment) {
        super(id, amont, datePayment);
    }

    public Contribution() {
         super(0, 0, null);
    }
   
}
