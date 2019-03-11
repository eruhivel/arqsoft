/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.swarch.cats;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author enric
 */
public class CatFactsWebClient implements CatFactsClient {

    /**
     * Constant containing the Web Address of the cat facts service. Try to open
     * it from your web browser and see what happens!
     */
    static String SERVICE_URL = "https://cat-fact.herokuapp.com/facts";

    // Open a connection between our application and the server
    @Override
    public List<String> retrieveFacts() throws Exception {

        URLConnection conn = new URL(SERVICE_URL).openConnection();

        // List of retrieved cat facts
        List<String> facts = new ArrayList<>();

        // This two lines read the JSON response from the cats server
        ObjectMapper mapper = new ObjectMapper();
        JsonNode response = mapper.readTree(new InputStreamReader(conn.getInputStream()));

        // The response for the server has a field called "all", that contains a list of cat facts
        // We iterate it.
        Iterator<JsonNode> it = response.get("all").elements();
        while (it.hasNext()) {
            JsonNode factJson = it.next();
            JsonNode text = factJson.get("text"); // Each cat fact has a field named "text" with the actual fact
            if (text != null) {
                facts.add(text.asText());
            }
        }
        return facts;
    }
}
