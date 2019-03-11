/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.swarch.cats;

import edu.upc.swarch.cats.CatFactsClient;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author enric
 */
public class FakeCatFacts
        implements CatFactsClient {

    @Override
    public List<String> retrieveFacts()
            throws Exception {
        List<String> list = new ArrayList<>();
        list.add("CATS 0");
        list.add("CATS 1");
        list.add("CATS 2");
        return list;
    }

}
