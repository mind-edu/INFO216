package com.info216;

import org.apache.jena.rdf.model.Model;
import org.apache.jena.rdf.model.ModelFactory;
import org.apache.jena.rdf.model.Resource;
import org.apache.jena.vocabulary.VCARD;

public class HelloJena {

    // 一些定义
    static String personURI = "http://somewhere/JohnSmith";
    static String info216 = "INFO216";
    static String teachers = "teachers";

    public static void main(String[] args) {

        // 1.创建一个空的模型
        Model model = ModelFactory.createDefaultModel();

        // 2.创建资源
        Resource andreas = model.createResource(personURI);

        // 3.添加属性
        andreas.addProperty(VCARD.FN, teachers);

        model.write(System.out);
    }
}
