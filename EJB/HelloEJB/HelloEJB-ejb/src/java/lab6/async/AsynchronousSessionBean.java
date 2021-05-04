/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.async;

import java.util.concurrent.CompletableFuture;
import javax.ejb.LocalBean;
import java.util.logging.Level;

import java.util.concurrent.Future;
import java.util.logging.Logger;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

/**
 *
 * @author moust
 */
@Stateless
@LocalBean
public class AsynchronousSessionBean implements AsynchronousSessionBeanRemote {

    private static Logger logger = Logger.getLogger(
            AsynchronousSessionBean.class.getName());

    @Override
    public void slowMethod() {

        long startTime = System.currentTimeMillis();
        logger.info("entering " + this.getClass().getCanonicalName()
                + ".slowMethod()");
        try {
            Thread.sleep(5000); //simulate processing for 10 seconds
        } catch (InterruptedException ex) {
            Logger.getLogger(AsynchronousSessionBean.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        logger.info("leaving " + this.getClass().getCanonicalName()
                + ".slowMethod()");
        long endTime = System.currentTimeMillis();
        logger.info("execution took " + (endTime - startTime)
                + " milliseconds");
    }

    @Asynchronous
    @Override
    public Future<Long> slowMethodWithReturnValue() {

        try {
            Thread.sleep(5000); //simulate processing for 15 seconds
        } catch (InterruptedException ex) {
            Logger.getLogger(AsynchronousSessionBean.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
        
        return new AsyncResult<Long>(42L);
    }
}

// Add business logic below. (Right-click in editor and choose
// "Insert Code > Add Business Method")

