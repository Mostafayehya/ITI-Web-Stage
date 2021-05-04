package org.iti.greenshop.model;

public class CreditCard {
    int partOne;
    int partTwo;
    int partThree;
    int partFour;

    public CreditCard(int partOne, int partTwo, int partThree, int partFour) {
        this.partOne = partOne;
        this.partTwo = partTwo;
        this.partThree = partThree;
        this.partFour = partFour;
    }

    public int[] getParts(){
        int[] parts = new int[4];
        parts[0] = this.partOne;
        parts[1] = this.partTwo;
        parts[2] = this.partThree;
        parts[3] = this.partFour;


        return parts;
    }
}
