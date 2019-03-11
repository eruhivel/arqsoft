/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.upc.swarch.cats;

import java.util.List;

/**
 *
 * @author enric
 */
public interface CatFactsClient {

    /**
     * Retrieve from the web service a list of cat facts. DON'T WORRY IF YOU
     * DON'T UNDERSTAND IT. It's just an example of a highly coupled, hardly
     * testable code.
     *
     * @return
     * @throws Exception if the connection can't be established or the response
     * from the server does not have a valid format.
     */
    List<String> retrieveFacts() throws Exception;
}
