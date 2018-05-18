package com.cfs.illinois.employeepay;

public class Employee{

    private String name;
    private String agency;
    private String agencyDivision;
    private String positionTitle;
    private String periodPayRate, YTDGross;

    public Employee(String name, String agency,
                    String agencyDivision, String positionTitle,
                    String periodPayRate, String YTDGross) {
        this.name = name;
        this.agency = agency;
        this.agencyDivision = agencyDivision;
        this.positionTitle = positionTitle;
        this.periodPayRate = periodPayRate;
        this.YTDGross = YTDGross;
    }

    public String getName() {
        return name;
    }

    public String getAgency() {
        return agency;
    }

    public String getAgencyDivision() {
        return agencyDivision;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public String getPeriodPayRate() {
        return periodPayRate;
    }

    public String getYTDGross() {
        return YTDGross;
    }
}
