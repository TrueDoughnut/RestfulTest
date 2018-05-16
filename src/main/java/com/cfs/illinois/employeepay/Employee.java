package com.cfs.illinois.employeepay;

public class Employee {

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

    public void setName(String name) {
        this.name = name;
    }

    public String getAgency() {
        return agency;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public String getAgencyDivision() {
        return agencyDivision;
    }

    public void setAgencyDivision(String agencyDivision) {
        this.agencyDivision = agencyDivision;
    }

    public String getPositionTitle() {
        return positionTitle;
    }

    public void setPositionTitle(String positionTitle) {
        this.positionTitle = positionTitle;
    }

    public String getPeriodPayRate() {
        return periodPayRate;
    }

    public void setPeriodPayRate(String periodPayRate) {
        this.periodPayRate = periodPayRate;
    }

    public String getYTDGross() {
        return YTDGross;
    }

    public void setYTDGross(String YTDGross) {
        this.YTDGross = YTDGross;
    }


}
