/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IBM_Backend_CO2.dao;

import com.example.IBM_Backend_CO2.model.PublicBuilding;
import java.util.List;

/**
 *
 * @author nitra
 */

public interface IDao {
    public List<PublicBuilding> loadData();
}
