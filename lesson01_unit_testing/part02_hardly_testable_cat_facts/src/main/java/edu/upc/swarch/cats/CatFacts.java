package edu.upc.swarch.cats;

import java.util.List;
import java.util.Random;

/**
 * CatFacts class does all the logic of the Cat Facts application, and that's
 * why it's so difficult to test:
 *
 * - This single class does too many things - It relies on a given external
 * service to work
 */
public class CatFacts {

    private CatFactsClient client;

    private Random rnd = new Random(System.nanoTime());

    public CatFacts(CatFactsClient client) {
        this.client = client;
    }

    /**
     * Returns a random cat fact
     *
     * @return
     * @throws Exception if the facts can't be retrieved
     */
    public String randomFact() throws Exception {
        List<String> facts = client.retrieveFacts();
        return facts.get(rnd.nextInt(facts.size()));
    }

}
