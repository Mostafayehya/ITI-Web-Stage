package day1.handlers;

import java.util.Set;

import javax.xml.namespace.QName;

import jakarta.xml.ws.handler.MessageContext;
import jakarta.xml.ws.handler.soap.SOAPHandler;
import jakarta.xml.ws.handler.soap.SOAPMessageContext;

public class MyProtocolHandler implements SOAPHandler<SOAPMessageContext> {

    @Override
    public void close(MessageContext arg0) {
        System.out.println("Close inside My protocol Handler :" + arg0);        
    }

    @Override
    public boolean handleFault(SOAPMessageContext arg0) {
        System.out.println("handleFault inside My protocol Handler :" + arg0);
                return true;
    }

    @Override
    public boolean handleMessage(SOAPMessageContext arg0) {
        System.out.println("handleMessage inside My protocol Handler :" + arg0);
        return true;
    }

    @Override
    public Set<QName> getHeaders() {
        System.out.println("Inside GetHeaders inside My protocol Handler :");
        return null;
    }




    
}
