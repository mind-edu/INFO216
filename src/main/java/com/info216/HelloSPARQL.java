package com.info216;

import org.apache.jena.query.*;
import org.apache.jena.update.UpdateAction;


public class HelloSPARQL {

    public static void main(String[] args) {


        Dataset dataset = DatasetFactory.create();

        UpdateAction.parseExecute(""
                + "PREFIX info216: <http://ex.org/teaching#>"
                + "INSERT DATA {"
                + "    info216:cade info216:teaches info216:ECO001 . "
                + "    GRAPH <http://ex.org/personal#Graph> {"
                + "        info216:cade info216:age '29' . "
                + "    }"
                + "}", dataset);

//        RDFDataMgr.write(System.out, dataset, Lang.TRIG);

//        dataset.getDefaultModel().write(System.out, "TURTLE");

//        ResultSet resultSet = QueryExecutionFactory
//                .create(""
//                        + "SELECT ?s ?p ?o WHERE {"
//                        + "    ?s ?p ?o ."
//                        + "}", dataset)
//                .execSelect();

//        resultSet.forEachRemaining(qsol -> System.out.println(qsol.toString()));

        Query query = QueryFactory.create(""
                + "SELECT ?s ?p ?o WHERE {"
                + "    ?s ?p ?o ."
                + "}");
        QueryExecution queryExecution = QueryExecutionFactory.create(query, dataset);
//        ResultSet resultSet = queryExecution.execSelect();
//        System.out.println(resultSet);
//        resultSet.forEachRemaining(qsol -> System.out.println(qsol.toString()));

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