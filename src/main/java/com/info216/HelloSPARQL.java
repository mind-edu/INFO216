package com.info216;

import org.apache.jena.query.*;
import org.apache.jena.update.UpdateAction;


public class HelloSPARQL {

    public static void main(String[] args) {

        Dataset dataset = DatasetFactory.create();

        ResultSet resultSet = QueryExecutionFactory.create(""
                + "SELECT ?s ?p ?o WHERE {"
                + "    GRAPH ?g { ?s ?p2 ?o2 . } "
                + "       SERVICE <http://dbpedia.org/sparql> {"
                + "        ?s ?p ?o ."
                + "    }"
                + "}", dataset).execSelect();

        while (resultSet.hasNext()) {
            QuerySolution qs = resultSet.nextSolution();
            System.out.println(qs.toString());
        }
    }
}