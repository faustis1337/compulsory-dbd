package be;

import java.sql.Date;

public class Department {
    private String dName;
    private int dNumber;
    private int mgrSSN;
    private Date mgrStartDate;
    private int empCount;

    public Department(String dName, int dNumber, int mgrSSN, Date mgrStartDate,int empCount) {
        this.dName = dName;
        this.dNumber = dNumber;
        this.mgrSSN = mgrSSN;
        this.mgrStartDate = mgrStartDate;
        this.empCount = empCount;
    }
}
