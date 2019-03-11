package edu.upc.swarch.cats;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class CatFactsTest {

    @Test
    public void testWithMock() throws Exception {
        List<String> factsSet = new ArrayList<>();
        factsSet.add("CATS 0");
        factsSet.add("CATS 1");
        factsSet.add("CATS 2");

        CatFactsClient service = Mockito.mock(CatFactsClient.class);
        Mockito.when(service.retrieveFacts()).thenReturn(factsSet);
        CatFacts cf = new CatFacts(service);
        String fact = cf.randomFact();

        // THEN tge tetyrbed fact is contained
        // in the set of facts returned from the
        // Cat Facts Service
        Assert.assertTrue(factsSet.contains(fact));
    }

    @Test
    public void testWithMockSpy() throws Exception {
        List<String> factsSet = new ArrayList<>();
        factsSet.add("CATS 0");
        factsSet.add("CATS 1");
        factsSet.add("CATS 2");

        CatFactsClient service = Mockito.spy(CatFactsClient.class);
        Mockito.when(service.retrieveFacts()).thenReturn(factsSet);
        CatFacts cf = new CatFacts(service);
        String fact = cf.randomFact();

        // THEN tge tetyrbed fact is contained
        // in the set of facts returned from the
        // Cat Facts Service
        Assert.assertTrue(factsSet.contains(fact));
        Mockito.verify(service, Mockito.only()).retrieveFacts();
    }

    @Test
    public void testCatFacts() throws Exception {
        // GIVEN a Cat Facts Application
        CatFacts cf = new CatFacts(
                new FakeCatFacts()
        );
        // WHEN a random fact is retrieved
        String fact = cf.randomFact();

        List<String> expectedReturnedData = new ArrayList<>();
        expectedReturnedData.add("CATS 0");
        expectedReturnedData.add("CATS 1");
        expectedReturnedData.add("CATS 2");

        // THEN tge tetyrbed fact is contained
        // in the set of facts returned from the
        // Cat Facts Service
        Assert.assertTrue(expectedReturnedData.contains(fact));
    }
}
