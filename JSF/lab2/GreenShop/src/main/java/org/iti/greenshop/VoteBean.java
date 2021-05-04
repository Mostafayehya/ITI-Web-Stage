/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iti.greenshop;

import java.io.Serializable;


import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;

/**
 *
 * @author iti
 */
@Named("voteBean")
@SessionScoped
public class VoteBean implements Serializable{
    private ListBean listBean;

    boolean voted;
    String chosen;

    public VoteBean() {}

    public ListBean getListBean() {
        return listBean;
    }

    public void setListBean(ListBean listBean) {
        System.out.println("inject manage ");
        this.listBean = listBean;
    }

    public boolean isVoted() {
        return voted;
    }

    public void setVoted(boolean voted) {
        this.voted = voted;
    }

    public String getChosen() {
        return chosen;
    }

    public void setChosen(String chosen) {
        this.chosen = chosen;
    }
    
    public String voteButtonBack(){

        if(getChosen() != null){
            listBean.incrementCategory(getChosen());
            setVoted(true);
            return "results";
        }else{
            return "";
        }
    }
            
}
