/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iti.greenshop;


import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;

/**
 *
 * @author ITI
 */
@FacesConverter("ccConverter")
public class CreditCardConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        CreditCard c = null;
        String [] str = value.split("-");
        if(str.length == 4){
            int [] parts = new int[4];
            for(int i=0;i<4;i++){
                parts[i] = Integer.parseInt(str[i]);
            }
            c = new CreditCard(parts[0],parts[1],parts[2],parts[3]); 
        }else{
            FacesMessage message = new FacesMessage("Conversion error occurred","Invalid Card Number.");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ConverterException(message);
        }
        return c;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        
        CreditCard c = (CreditCard)value;
        int [] parts = c.getParts();
        String s = parts[0]+"-"+parts[1]+"-"+parts[2]+"-"+parts[3];
        System.out.println("ana fe getAs String");
        return s;
    }
    
}
