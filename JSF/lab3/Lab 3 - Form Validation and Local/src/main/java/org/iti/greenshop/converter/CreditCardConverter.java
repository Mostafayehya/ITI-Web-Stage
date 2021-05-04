package org.iti.greenshop.converter;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import org.iti.greenshop.model.CreditCard;

@FacesConverter(value = "CreditCardConverter", forClass = CreditCard.class)
public class CreditCardConverter implements Converter {
    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        CreditCard creditCard = null;
        String[] strings = value.split("-");
        if (strings.length == 4) {
            int[] parts = new int[4];
            for (int i = 0; i < 4; i++) {
                parts[i] = Integer.parseInt(strings[i]);
            }
            creditCard = new CreditCard(parts[0], parts[1], parts[2], parts[3]);
        }else{
            FacesMessage message = new FacesMessage("Conversion error occurred", "Invalid Card Number");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw  new ConverterException(message);
        }

        return creditCard;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        CreditCard creditCard = (CreditCard) value;
        int[] parts = creditCard.getParts();
        return parts[0] + "-" + parts[1] + "-" + parts[2] + "-" + parts[3];
    }
}
