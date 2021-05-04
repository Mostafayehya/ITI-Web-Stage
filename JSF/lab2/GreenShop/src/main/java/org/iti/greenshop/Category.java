/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.iti.greenshop;

/**
 *
 * @author iti
 */
public class Category {
    private String categoryLabel;
    private String categoryValue;
    private int categoryVotes;

    public Category(String categoryLabel, String categoryValue, int categoryVotes) {
        this.categoryLabel = categoryLabel;
        this.categoryValue = categoryValue;
        this.categoryVotes = categoryVotes;
    }
    
    

    public String getCategoryLabel() {
        return categoryLabel;
    }

    public void setCategoryLabel(String categoryLabel) {
        this.categoryLabel = categoryLabel;
    }

    public String getCategoryValue() {
        return categoryValue;
    }

    public void setCategoryValue(String categoryValue) {
        this.categoryValue = categoryValue;
    }

    public int getCategoryVotes() {
        return categoryVotes;
    }

    public void setCategoryVotes(int categoryVotes) {
        this.categoryVotes = categoryVotes;
    }
    
}
