/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IBM_Backend_CO2.model;

import org.json.JSONObject;

/**
 *
 * @author nitra
 */
public class PublicBuilding {

    private String department;
    private double emissionsMtco2e;
    private String sourceType;

    public PublicBuilding(String department, double emissionsMtco2e, String sourceType) {
        this.department = department;
        this.emissionsMtco2e = emissionsMtco2e;
        this.sourceType = sourceType;
    }
    
    public PublicBuilding(JSONObject jsonObj) {
        this.department = jsonObj.getString("department");
        this.sourceType = jsonObj.getString("source_type");
        this.emissionsMtco2e = jsonObj.getDouble("emissions_mtco2e");
    }
    
    public String getDepartment() {
        return department;
    }
    
    public void setDepartment(String department) {
        this.department = department;
    }

    public double getEmissionsMtco2e() {
        return emissionsMtco2e;
    }

    public void setEmissionsMtco2e(double emissionsMtco2e) {
        this.emissionsMtco2e = emissionsMtco2e;
    }

    public String getSourceType() {
        return sourceType;
    }

    public void setSourceType(String sourceType) {
        this.sourceType = sourceType;
    }

    @Override
    public String toString() {
        return "PublicBuildingRes{" + "department=" + department + ", emissionsMtco2e=" + emissionsMtco2e + ", sourceType=" + sourceType + '}';
    }

    
}
