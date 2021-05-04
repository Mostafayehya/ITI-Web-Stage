/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.timers;

import java.util.Date;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author moust
 */
@Singleton
@LocalBean
public class AutomaticTimerBean {

    @Schedule(hour = "*", minute = "*/1", second = "*")
    public void myTimer() {
        System.out.println("=========================================================");
        System.out.println("Timer event: " + new Date());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
