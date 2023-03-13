package be;

import java.sql.Date;

public class Department {
    public String dName;
    public int dNumber;
    public int mgrSSN;
    public Date mgrStartDate;
    public int empCount;

    public Department(String dName, int dNumber, int mgrSSN, Date mgrStartDate,int empCount) {
        this.dName = dName;
        this.dNumber = dNumber;
        this.mgrSSN = mgrSSN;
        this.mgrStartDate = mgrStartDate;
        this.empCount = empCount;
    }
}
