package com.info216;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;

public class HelloSPARQL {

    public static void main(String[] args) {

        Dataset dataset = DatasetFactory.create();
        String iriDbpedia = "http://dbpedia.org/resource/";


        Model franceModel = QueryExecutionFactory.create(""
                + "CONSTRUCT { ?s ?p ?o . } "
                + "    FROM <http://people.uib.no/sinoa/european-populations.ttl> "
                + "WHERE { "
                + "    ?s ?p ?o . "
                + "}").execConstruct();
        franceModel.write(System.out, "TURTLE");
    }
}