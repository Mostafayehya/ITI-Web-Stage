package org.iti.greenshop.converter;

import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.convert.Converter;
import jakarta.faces.convert.ConverterException;
import jakarta.faces.convert.FacesConverter;
import org.iti.greenshop.model.CreditCard;

import java.util.Calendar;
import java.util.Date;

@FacesConverter(value = "DateConverter")
public class DateConverter implements Converter {

    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Calendar calendar = Calendar.getInstance();
        String[] strings = value.split("-");
        if (strings.length == 3) {
            int[] parts = new int[3];
            for (int i = 0; i < 3; i++) {
                parts[i] = Integer.parseInt(strings[i]);
            }
           calendar.set(parts[2], parts[1], parts[0]);
        }else{
            FacesMessage message = new FacesMessage("Conversion error occurred", "The Right Format Is DD-MM-YYYY");
            message.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw  new ConverterException(message);
        }

        return calendar.getTime();
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Date date = (Date) value;

        return date.toString();
    }
}
