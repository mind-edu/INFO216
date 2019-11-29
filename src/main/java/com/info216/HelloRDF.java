package com.info216;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Property;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;
import org.apache.jena.vocabulary.RDFS;
import org.apache.jena.datatypes.xsd.XSDDatatype;
import org.apache.jena.rdf.model.Statement;
import org.apache.jena.rdf.model.RDFNode;
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.sparql.vocabulary.FOAF;
import java.io.FileOutputStream;



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
        resFrance.addProperty(RDFS.label, "Frankrike", "no");
        resFrance.addProperty(RDFS.label, "France", "en");
        resFrance.addProperty(RDFS.label, "Francia", "es");

        resCadeTracy.addProperty(propVisited, resCanada);
        resCadeTracy.addProperty(propVisited, resFrance);

        Property propPopEst = model.createProperty(iriDbpedia + "ontology/populationEstimate");
        resFrance.addProperty(propPopEst, "66644000", XSDDatatype.XSDinteger);

        for (Statement stmt : model.listStatements().toList()) {
            System.out.println(stmt.toString());
        }


        for (Statement stmt : model.listStatements((Resource)null, RDFS.label, (RDFNode)null)
                .toList()) {
            System.out.println("Subject:   " + stmt.getSubject().toString());
            System.out.println("Predicate: " + stmt.getPredicate().toString());
            System.out.println("Object:    " + stmt.getObject().toString());
        }


        for (Statement stmt : model.listStatements(new SimpleSelector() {
                    @Override
                    public boolean test(Statement s) {
                        return (s.getPredicate().equals(FOAF.name));
                    }
                })
                .toList()) {
            System.out.println(stmt.getObject().toString());
        }

        model.write(System.out);
        try {
            model.write(new FileOutputStream("test.ttl"), "TURTLE");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
