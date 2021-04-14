/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IBM_Backend_CO2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 *
 * @author nitra
 */
@ExtendWith(SpringExtension.class)
@RestClientTest(PubBuildServiceClient.class)
public class TestingRestApplicationTests {
    @Autowired
    private PubBuildServiceClient pubBuildServ;

    @Test
    public void checkFilteredAmount() throws Exception {
        
        assertThat(pubBuildServ.getAll().size()).isEqualTo(692);
    }
}
