package com.info216;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.FileInputStream;

public class ReadJena {

    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        try {
            model.read(new FileInputStream("test.ttl"), "http://ex.org/", "TURTLE");
        } catch (Exception e) {
            // TODO: handle exception
        }

        model.write(System.out);
    }
}
