package com.info216;

import org.apache.jena.query.*;
import org.apache.jena.rdf.model.Model;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.riot.Lang;
import org.apache.jena.riot.RDFDataMgr;

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

        RDFDataMgr.write(System.out, dataset, Lang.TRIG);

        ResultSet resultSet = QueryExecutionFactory
                .create(""
                        + "SELECT ?s ?p ?o WHERE {"
                        + "    ?s ?p ?o ."
                        + "}", dataset)
                .execSelect();

        resultSet.forEachRemaining(qsol -> System.out.println(qsol.toString()));

    }
}