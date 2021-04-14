package com.example.IBM_Backend_CO2;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IbmBackendCo2Application {

    private static final Logger logger = LogManager.getLogger(IbmBackendCo2Application.class);

    public static void main(String[] args) {
        /*
        try {
            IDao myDao = new Json_Dao();

            PublicBuildingResCon pbc = new PublicBuildingResCon(myDao);

            System.out.println(pbc.all());
        } catch (MalformedURLException ex) {
            logger.error("MalformedURLException for the DAO Object.", ex);
        }*/
        
        SpringApplication.run(IbmBackendCo2Application.class, args);
    }

}
