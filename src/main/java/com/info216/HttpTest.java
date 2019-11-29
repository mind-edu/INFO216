package com.info216;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpTest {

    public static void main(String[] args) {
        Model model = ModelFactory.createDefaultModel();

        try {
            URL url = new URL("http://people.uib.no/sinoa/test.ttl");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            InputStream is = urlConnection.getInputStream();
            model.read(is, "http://ex.org/", "TURTLE");
        } catch (Exception e) {
            // TODO: handle exception
        }

        model.write(System.out);
    }
}