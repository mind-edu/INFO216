package com.info216;

import org.apache.jena.query.Dataset;
import org.apache.jena.query.DatasetFactory;
import org.apache.jena.update.UpdateAction;
import org.apache.jena.riot.RDFDataMgr;
import org.apache.jena.riot.Lang;

public class HelloSPARQL {

    public static void main(String[] args){


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

        dataset.getDefaultModel().write(System.out, "TURTLE");
    }
}