/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IBM_Backend_CO2.controller;

import com.example.IBM_Backend_CO2.dao.IDao;
import com.example.IBM_Backend_CO2.model.PublicBuilding;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author nitra
 */
@RestController
public class PublicBuildingCon {

    @Autowired
    @Qualifier("jsonDao")
    private IDao DAO;

    @GetMapping("/publicbuildings")
    public Set<PublicBuilding> all(@RequestParam(value = "department", defaultValue = "") String department, @RequestParam(value = "sourceType", defaultValue = "") String sourceType) {
        List<PublicBuilding> tempPubBuild = this.DAO.loadData();

        return tempPubBuild.stream().filter(s -> {
            return s.getEmissionsMtco2e() != 0 
                    && (department.equals("") || (!department.equals("") && s.getDepartment().contains(department))) 
                    && (sourceType.equals("") || (!sourceType.equals("") && s.getSourceType().contains(sourceType)));
        }).map(element -> {
            return (PublicBuilding) element;
        }).collect(Collectors.toSet());

    }

}
