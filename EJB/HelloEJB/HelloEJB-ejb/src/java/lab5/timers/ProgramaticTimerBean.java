/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab5.timers;

import java.lang.System.Logger;
import static java.lang.System.getLogger;
import javax.annotation.Resource;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.ScheduleExpression;
import javax.ejb.Timeout;
import javax.ejb.TimerService;

/**
 *
 * @author moust
 */
@Singleton
public class ProgramaticTimerBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @Resource
    private TimerService timerService;
    
    
    @Timeout
    public void timeOut(){
        
        System.out.println("=========================================================");
        System.out.println("=========================================================");
        System.out.println("Timeout envoked!!");
        
      
        System.out.println("=========================================================");
        System.out.println("=========================================================");
    }
    
    public void initTimer(){
        System.out.println("INIT-CALLED");
        
        ScheduleExpression scheduleExpression = new ScheduleExpression();
        
        scheduleExpression.hour("*").minute("*").second("*/8");
        
        timerService.createCalendarTimer(scheduleExpression);
        
    }
}
