/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3.singleton;

import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author moust
 */
@Singleton
@LocalBean
public class CounterBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private int hits = 1;
// Increment and return the number of hits

    public int getHits() {
        System.out.println("=========================================================");
        return hits++;
    }
}
