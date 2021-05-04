/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab6.async;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;
import javax.ejb.Remote;

/**
 *
 * @author moust
 */
@Remote
public interface AsynchronousSessionBeanRemote {
    
    public void slowMethod();
    
    public Future<Long> slowMethodWithReturnValue();
    
}
