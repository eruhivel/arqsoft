package edu.upc.swarch.cats;

public class CatFactsMain {
    public static void main(String[] args) throws Exception {
        CatFactsWebClient dataSource = new CatFactsWebClient();
        CatFacts facts = new CatFacts(dataSource);
        System.out.println(facts.randomFact());
    }
}