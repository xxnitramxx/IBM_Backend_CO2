/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.IBM_Backend_CO2.dao;

import com.example.IBM_Backend_CO2.model.PublicBuilding;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.springframework.stereotype.Component;

/**
 *
 * @author nitra
 */
@Component("jsonDao")
public class JsonDao implements IDao {

    private static final Logger logger = LogManager.getLogger(JsonDao.class);

    private static final String DEF_STR_API = "https://data.sfgov.org/resource/pxac-sadh.json?$limit=5000";

    private final URL DATA_URL;
    private final boolean CACHE_DATA;

    private List<PublicBuilding> loadedData;

    public JsonDao() throws MalformedURLException {
        this(DEF_STR_API, true);
    }

    public JsonDao(String strAPI, boolean CACHE_DATA) throws MalformedURLException {
        this(new URL(strAPI), CACHE_DATA);
    }

    public JsonDao(URL DATA_URL, boolean CACHE_DATA) {
        this.DATA_URL = DATA_URL;
        this.CACHE_DATA = CACHE_DATA;
        this.loadedData = new ArrayList<>();
    }

    @Override
    public List<PublicBuilding> loadData() {
        if (!CACHE_DATA || this.loadedData.isEmpty()) {
            this.loadedData = new ArrayList<>();
            HttpsURLConnection conn = null;

            try {
                conn = (HttpsURLConnection) DATA_URL.openConnection();
                conn.setRequestMethod("GET");
                conn.setRequestProperty("Accept", "application/json");
                if (conn.getResponseCode() != 200) {
                    throw new RuntimeException("Failed : HTTP Error code : "
                            + conn.getResponseCode());
                }

                parseInputStream(conn.getInputStream());
            } catch (ProtocolException ex) {
                logger.error("Protocol GET not supported by the HttpsURLConnection", ex);
            } catch (IOException ex) {
                logger.error("IOException occured during the request/loading of the data from the URL: {}", DATA_URL, ex);
            } finally {
                if (conn != null) {
                    conn.disconnect();
                }
            }
        }

        return this.loadedData;
    }

    private void parseInputStream(InputStream conn) throws IOException {

        try (InputStreamReader in = new InputStreamReader(conn);
                BufferedReader br = new BufferedReader(in);) {
            JSONTokener tokener = new JSONTokener(br);
            JSONArray json = new JSONArray(tokener);

            Iterator<Object> iter = json.iterator();
            while (iter.hasNext()) {
                JSONObject jObj = (JSONObject) iter.next();
                try {
                    PublicBuilding pubBuild = new PublicBuilding(jObj);
                    loadedData.add(pubBuild);

                } catch (JSONException ex) {
                    logger.warn("Failed to parse the json object into a PublicBuilding Object: {}", jObj, ex);
                }
            }
        }
    }
}
