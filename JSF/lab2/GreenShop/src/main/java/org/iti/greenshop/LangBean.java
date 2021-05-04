package org.iti.greenshop;

import java.io.Serializable;
import java.util.Locale;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Named;
//import javax.faces.bean.ManagedBean;
//import javax.faces.bean.SessionScoped;
//import javax.faces.context.FacesContext;
//import javax.inject.Named;
 

  
@Named("lang")
@SessionScoped
public class LangBean implements Serializable{
     
    private static final long serialVersionUID = 1L;
     
    private Locale locale = FacesContext.getCurrentInstance().getViewRoot().getLocale();
    private String  direction;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
 
    public Locale getLocale() {
        return locale;
    }
 
    public String getLanguage() {
        return locale.getLanguage();
    }
 
    public void changeLanguage(String language) {
        System.out.println("# Change Local");
        if("ar".equals(language)){
        locale =  new Locale("ar", "EG");
            this.direction = "rtl";
        }else{ 
            locale =  new Locale("en", "US");
            this.direction="ltr";
        }

        FacesContext.getCurrentInstance().getViewRoot().setLocale(locale);
    }
}