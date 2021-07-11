package com.company;

public class EmployeeDetailsDTO {
    String engineerName;
    String engineerRole;
    String manager;
    int featurePoint;
    int uatBugPoint;
    int prodBugPoint;

    public EmployeeDetailsDTO() {
    }

    public EmployeeDetailsDTO(String engineerName, String engineerRole, String manager, int featurePoint, int uatBugPoint, int prodBugPoint) {
        this.engineerName = engineerName;
        this.engineerRole = engineerRole;
        this.manager = manager;
        this.featurePoint = featurePoint;
        this.uatBugPoint = uatBugPoint;
        this.prodBugPoint = prodBugPoint;
    }

    public String getEngineerName() {
        return engineerName;
    }

    public void setEngineerName(String engineerName) {
        this.engineerName = engineerName;
    }

    public String getEngineerRole() {
        return engineerRole;
    }

    public void setEngineerRole(String engineerRole) {
        this.engineerRole = engineerRole;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public int getFeaturePoint() {
        return featurePoint;
    }

    public void setFeaturePoint(int featurePoint) {
        this.featurePoint = featurePoint;
    }

    public int getUatBugPoint() {
        return uatBugPoint;
    }

    public void setUatBugPoint(int uatBugPoint) {
        this.uatBugPoint = uatBugPoint;
    }

    public int getProdBugPoint() {
        return prodBugPoint;
    }

    public void setProdBugPoint(int prodBugPoint) {
        this.prodBugPoint = prodBugPoint;
    }
}
