package day1.handlers;

import jakarta.xml.ws.handler.LogicalHandler;
import jakarta.xml.ws.handler.LogicalMessageContext;
import jakarta.xml.ws.handler.MessageContext;

public class MyLogicalHandler implements  LogicalHandler<LogicalMessageContext> {

    @Override
    public void close(MessageContext arg0) {
        System.out.println("Inside close inside My Logical Handler :\n\n" + arg0 );
        
    }

    @Override
    public boolean handleFault(LogicalMessageContext arg0) {
        System.out.println("Inside handleFault inside My Logical Handler \n\n:" + arg0 );
        return true;
    }

    @Override
    public boolean handleMessage(LogicalMessageContext arg0) {
        System.out.println("Inside handleMessage inside My Logical Handler :\n\n" + arg0 );
        return true;
    }




    
}
