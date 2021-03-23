package day3;

import java.util.Date;

public class Teacher extends Person {

    Date hiringDate;

    public Teacher(Date hiringDate) {
        this.hiringDate = hiringDate;
    }

    public Teacher(String firstName, String lastName, Date hiringDate) {
        super(firstName, lastName);
        this.hiringDate = hiringDate;
    }

    public Date getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(Date hiringDate) {
        this.hiringDate = hiringDate;
    }
}
