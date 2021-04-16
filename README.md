# IBM Backend CO2

This is an example project for the dataset [San Francisco Municipal Greenhouse Gas Inventory](https://data.sfgov.org/Energy-and-Environment/San-Francisco-Municipal-Greenhouse-Gas-Inventory/pxac-sadh). 
It is a Java project developed with the Spring Boot Framework to offer access to modified/filtered data of the dataset. The REST application is running on a Tomcat server.

## REST API
You can access the API with the URL `/publicbuildings` (for example `localhost:8080/publicbuildings`). 
To filter the data for the department name you have to add the parameter `department` in the URL (for example `localhost:8080/publicbuildings?department=Recreation%20and%20Park%20Department`)

### Response
The reponse JSON data is an array of Objects wich contain:
- the name of the department `department`
- the CO2 emissions `emissionsMtco2e`
- the fuel type `sourceType`
All data entries with a CO2 emissions of 0 are removed.

```
[{"department":"Library","emissionsMtco2e":5.09393909154412E-4,"sourceType":"Electric"},...]
```

## Live demo

The link for the life demo: 
[All data `/publicbuildings`](https://ibmbackendco2.herokuapp.com/publicbuildings)
[Filtered for the department name `Police`](https://ibmbackendco2.herokuapp.com/publicbuildings?Police)