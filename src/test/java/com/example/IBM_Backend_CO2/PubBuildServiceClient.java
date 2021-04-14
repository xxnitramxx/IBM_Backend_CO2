/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IBM_Backend_CO2;

import com.example.IBM_Backend_CO2.model.PublicBuilding;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

/**
 *
 * @author nitra
 */
@Service
public class PubBuildServiceClient {

    @Autowired
    private TestRestTemplate restTemplate;

    public Set<PublicBuilding> getAll() {
        System.out.println(restTemplate.getForObject("http://localhost:8080/",
                String.class));
        System.out.println(restTemplate.getForObject("/publicbuildings",
                Set.class));
        return restTemplate.getForObject("/publicbuildings",
                Set.class);
    }
}
