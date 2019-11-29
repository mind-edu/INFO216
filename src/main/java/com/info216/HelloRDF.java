package com.info216;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class HelloRDF {
    public static void main(String[] args) {
        String iriBase = "http://no.uib.infomedia.info216/";
        String iriDbpedia = "http://dbpedia.org/resource/";
        Model model = ModelFactory.createDefaultModel();
        Resource resCadeTracy = model.createResource(iriBase + "Cade_Tracy");
        resCadeTracy.addLiteral(VCARD.FN, "Cade Tracy");
        Resource resCanada = model.createResource(iriDbpedia + "Canada");
        Resource resFrance = model.createResource(iriDbpedia + "France");
        Property propVisited = model.createProperty(iriBase + "visited");
        resCadeTracy.addProperty(propVisited, resCanada);
        resCadeTracy.addProperty(propVisited, resFrance);
        model.write(System.out);
    }
}
