# Contents

来源于 : [https://wiki.uib.no/info216/index.php/Examples](https://wiki.uib.no/info216/index.php/Examples)

官方网站上面的例子很多都有错误的，这里进行了更新，但是目录保持不变 :

## Lecture 1: Java, Jena, and Eclipse

改用 IDEA 编辑器

### 1.1 Hello Jena

源码见 /src/main/java/com/info216/HelloJena.java

```java
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
```

输出结果是 :

```java
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#">
  <rdf:Description rdf:about="http://somewhere/JohnSmith">
    <vcard:FN>teachers</vcard:FN>
  </rdf:Description>
</rdf:RDF>
```

说明 :

## Lecture 2: RDF

### 2.1 Resource objects

```java
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
```

运行结果说明 :

```
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#"
    xmlns:j.0="http://no.uib.infomedia.info216/">
  <rdf:Description rdf:about="http://no.uib.infomedia.info216/Cade_Tracy">
    <j.0:visited rdf:resource="http://dbpedia.org/resource/France"/>
    <j.0:visited rdf:resource="http://dbpedia.org/resource/Canada"/>
    <vcard:FN>Cade Tracy</vcard:FN>
  </rdf:Description>
</rdf:RDF>
```

> 说明

### 2.2 Language-tagged literals

```java
        resFrance.addProperty(RDFS.label, "Frankrike", "no");
        resFrance.addProperty(RDFS.label, "France", "en");
        resFrance.addProperty(RDFS.label, "Francia", "es");
```

输出的结果是:

```
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#"
    xmlns:j.0="http://no.uib.infomedia.info216/"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#">
  <rdf:Description rdf:about="http://no.uib.infomedia.info216/Cade_Tracy">
    <j.0:visited>
      <rdf:Description rdf:about="http://dbpedia.org/resource/France">
        <rdfs:label xml:lang="es">Francia</rdfs:label>
        <rdfs:label xml:lang="en">France</rdfs:label>
        <rdfs:label xml:lang="no">Frankrike</rdfs:label>
      </rdf:Description>
    </j.0:visited>
    <j.0:visited rdf:resource="http://dbpedia.org/resource/Canada"/>
    <vcard:FN>Cade Tracy</vcard:FN>
  </rdf:Description>
</rdf:RDF>
```

### 2.3 Typed literals

```java
import org.apache.jena.datatypes.xsd.XSDDatatype;

....

        Property propPopEst = model.createProperty(iriDbpedia + "ontology/populationEstimate");
        resFrance.addProperty(propPopEst, "66644000", XSDDatatype.XSDinteger);
```

输出结果是 :

```
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#"
    xmlns:j.0="http://dbpedia.org/resource/ontology/"
    xmlns:j.1="http://no.uib.infomedia.info216/"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#">
  <rdf:Description rdf:about="http://no.uib.infomedia.info216/Cade_Tracy">
    <j.1:visited>
      <rdf:Description rdf:about="http://dbpedia.org/resource/France">
        <j.0:populationEstimate rdf:datatype="http://www.w3.org/2001/XMLSchema#integer"
        >66644000</j.0:populationEstimate>
        <rdfs:label xml:lang="es">Francia</rdfs:label>
        <rdfs:label xml:lang="en">France</rdfs:label>
        <rdfs:label xml:lang="no">Frankrike</rdfs:label>
      </rdf:Description>
    </j.1:visited>
    <j.1:visited rdf:resource="http://dbpedia.org/resource/Canada"/>
    <vcard:FN>Cade Tracy</vcard:FN>
  </rdf:Description>
</rdf:RDF>
```

### 2.4 Looping through statements

```java
import org.apache.jena.rdf.model.Statement;

...

        for (Statement stmt : model.listStatements().toList()) {
            System.out.println(stmt.toString());
        }
```

输出的结果是：

```
[http://no.uib.infomedia.info216/Cade_Tracy, http://no.uib.infomedia.info216/visited, http://dbpedia.org/resource/France]
[http://no.uib.infomedia.info216/Cade_Tracy, http://no.uib.infomedia.info216/visited, http://dbpedia.org/resource/Canada]
[http://no.uib.infomedia.info216/Cade_Tracy, http://www.w3.org/2001/vcard-rdf/3.0#FN, "Cade Tracy"]
[http://dbpedia.org/resource/France, http://dbpedia.org/resource/ontology/populationEstimate, "66644000"^^http://www.w3.org/2001/XMLSchema#integer]
[http://dbpedia.org/resource/France, http://www.w3.org/2000/01/rdf-schema#label, "Francia"@es]
[http://dbpedia.org/resource/France, http://www.w3.org/2000/01/rdf-schema#label, "France"@en]
[http://dbpedia.org/resource/France, http://www.w3.org/2000/01/rdf-schema#label, "Frankrike"@no]
```

### 2.5 Selecting statements

```java
import org.apache.jena.rdf.model.RDFNode;

...

        for (Statement stmt : model
                .listStatements((Resource)null, RDFS.label, (RDFNode)null)
                .toList()) {
            System.out.println("Subject:   " + stmt.getSubject().toString());
            System.out.println("Predicate: " + stmt.getPredicate().toString());
            System.out.println("Object:    " + stmt.getObject().toString());
        }
```

输出的结果是：
```
Subject:   http://dbpedia.org/resource/France
Predicate: http://www.w3.org/2000/01/rdf-schema#label
Object:    Francia@es
Subject:   http://dbpedia.org/resource/France
Predicate: http://www.w3.org/2000/01/rdf-schema#label
Object:    France@en
Subject:   http://dbpedia.org/resource/France
Predicate: http://www.w3.org/2000/01/rdf-schema#label
Object:    Frankrike@no
```

### 2.6 Using a selector

```java
import org.apache.jena.rdf.model.SimpleSelector;
import org.apache.jena.sparql.vocabulary.FOAF;

...

        for (Statement stmt : model
                .listStatements(new SimpleSelector() {
                    public boolean test(Statement s) {
                        return (s.getPredicate().equals(FOAF.name));
                    }
                })
                .toList()) {
            System.out.println(stmt.getObject().toString());
        }
```

输出的结果是 :

```
没有输出结果来
```


### 2.7 Writing to file

```java
        try {
            model.write(new FileOutputStream("test.ttl"), "TURTLE");
        } catch (Exception e) {
            // TODO: handle exception
        }
```

运行成功了，但是路径好像不太对的

### 2.8 Contents of **test.ttl**

```java
<http://no.uib.infomedia.info216/Cade_Tracy>
        <http://no.uib.infomedia.info216/visited>
                <http://dbpedia.org/resource/France> , <http://dbpedia.org/resource/Canada> ;
        <http://www.w3.org/2001/vcard-rdf/3.0#FN>
                "Cade Tracy" .

<http://dbpedia.org/resource/France>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Francia"@es , "France"@en , "Frankrike"@no ;
        <http://dbpedia.org/resource/ontology/populationEstimate>
                66644000 .
```

### 2.9 Reading from file

新建新的类文件 ReadJena.java

```java
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
```

输出的结果是：

```
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#"
    xmlns:vcard="http://www.w3.org/2001/vcard-rdf/3.0#"
    xmlns:j.0="http://dbpedia.org/resource/ontology/"
    xmlns:j.1="http://no.uib.infomedia.info216/"
    xmlns:rdfs="http://www.w3.org/2000/01/rdf-schema#">
  <rdf:Description rdf:about="http://no.uib.infomedia.info216/Cade_Tracy">
    <vcard:FN>Cade Tracy</vcard:FN>
    <j.1:visited rdf:resource="http://dbpedia.org/resource/Canada"/>
    <j.1:visited>
      <rdf:Description rdf:about="http://dbpedia.org/resource/France">
        <j.0:populationEstimate rdf:datatype="http://www.w3.org/2001/XMLSchema#integer"
        >66644000</j.0:populationEstimate>
        <rdfs:label xml:lang="no">Frankrike</rdfs:label>
        <rdfs:label xml:lang="en">France</rdfs:label>
        <rdfs:label xml:lang="es">Francia</rdfs:label>
      </rdf:Description>
    </j.1:visited>
  </rdf:Description>
</rdf:RDF>
```

### 2.10 Reading from web resource

新建新的类文件 HttpTest.java

```java
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
```

(There are more advanced ways to download web resources from Java, but HttpUrlConnection is a straightforward and built-in way to get started.)

输出结果是：

```
<rdf:RDF
    xmlns:rdf="http://www.w3.org/1999/02/22-rdf-syntax-ns#">
</rdf:RDF>
```


## Lecture 3: SPARQL Query and Update

### 3.1 Basic INSERT DATA update

新建一个 HelloSPARQL.java 文件 :

```java
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

    }
}
```

输出的结果是:

```
<http://ex.org/teaching#cade>
        <http://ex.org/teaching#teaches>
                <http://ex.org/teaching#ECO001> .

<http://ex.org/personal#Graph> {
    <http://ex.org/teaching#cade>
            <http://ex.org/teaching#age>  "29" .
}
```

To output only the default graph use:

```java
		dataset.getDefaultModel().write(System.out, "TURTLE");
```

The method dataset.getNamedModel("http://ex.org/personal#Graph"); lets you output a named model instead.

只输出结果是:

```
<http://ex.org/teaching#cade>
        <http://ex.org/teaching#teaches>
                <http://ex.org/teaching#ECO001> .
```


### 3.2 Basic SELECT query

```java
    ResultSet resultSet = QueryExecutionFactory
        .create(""
            + "SELECT ?s ?p ?o WHERE {"
            + "    ?s ?p ?o ."
            + "}", dataset)
        .execSelect();

    // jdk 1.8 forEachRemaining lamada表达式
    resultSet.forEachRemaining(qsol -> System.out.println(qsol.toString()));
```

输出的结果是 ：

```
( ?p = <http://ex.org/teaching#teaches> ) ( ?o = <http://ex.org/teaching#ECO001> ) ( ?s = <http://ex.org/teaching#cade> )
```

> 说明：

### 3.3 Convert the ResultSet into a JSON object

```java
        List<Map> jsonList = new Vector<Map>();
        while (resultSet.hasNext()) {
            QuerySolution qsol = resultSet.nextSolution();
            Iterator<String> varNames = qsol.varNames();
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            while (varNames.hasNext()) {
                String varName = varNames.next();
                jsonMap.put(varName, qsol.get(varName).toString());
            }
            jsonList.add(jsonMap);
        }
        System.out.println(jsonList);
```

输出的结果是:

```
[{p=http://ex.org/teaching#teaches, s=http://ex.org/teaching#cade, o=http://ex.org/teaching#ECO001}]
```


### 3.4 SELECT query with Query object

```java
    // select example
    Query query = QueryFactory.create(""
            + "SELECT ?s ?p ?o WHERE {"
            + "    ?s ?p ?o ."
            + "}");
    QueryExecution queryExecution = QueryExecutionFactory.create(query, dataset);   
    ResultSet resultSet = queryExecution.execSelect();
    resultSet.forEachRemaining(qsol -> System.out.println(qsol.toString()));

```

输出的结果是:

```
( ?p = <http://ex.org/teaching#teaches> ) ( ?o = <http://ex.org/teaching#ECO001> ) ( ?s = <http://ex.org/teaching#cade> )
```


### 3.5 SELECT query from SPARQL endpoint

If a named graph in your dataset has a triple with a subject that is a DBpedia IRI:

```java
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
```

没有输出结果的

### 3.6 Basic ASK query

```java
    QueryExecution queryExecution = QueryExecutionFactory.create(""
            + "ASK { GRAPH ?g { ?s ?p ?o } }"
            + "", dataset);
    boolean res = queryExecution.execAsk();
    System.out.println("The result is " + res);
```

运行的结果是:

````
The result is false
````

### 3.7 ASK query from IRL

```java
    QueryExecution queryExecution = QueryExecutionFactory.create(""
            + "ASK "
            + "    FROM <http://people.uib.no/sinoa/european-populations.ttl> { "
            + "       <" + iriDbpedia + "Vatican_City> ?p ?o . "
            + "    }"
            + "");
    boolean res = queryExecution.execAsk();
    System.out.println("The result is " + res);
```

输出的结果是:
```
The result is true
```

### 3.8 Basic DESCRIBE query

```java
    Model franceModel = QueryExecutionFactory.create(""
            + "DESCRIBE <" + iriDbpedia + "France>"
            + "", dataset).execDescribe();
    franceModel.write(System.out, "TURTLE");
```

没有输出结果

### 3.9 Basic CONSTRUCT query

```java
    Model franceModel = QueryExecutionFactory.create(""
            + "CONSTRUCT { ?s ?p ?o . } WHERE { "
            + "    GRAPH ?g { ?s ?p ?o . } "
            + "}", dataset).execConstruct();
    franceModel.write(System.out, "TURTLE");
```

没有输出结果

### 3.10 CONSTRUCT query from IRL

```java
    Model franceModel = QueryExecutionFactory.create(""
            + "CONSTRUCT { ?s ?p ?o . } "
            + "    FROM <http://people.uib.no/sinoa/european-populations.ttl> "
            + "WHERE { "
            + "    ?s ?p ?o . "
            + "}").execConstruct();
    franceModel.write(System.out, "TURTLE");
```

输出的结果如下：

```
<http://dbpedia.org/resource/Russia>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Russia"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                144192450 .

<http://dbpedia.org/resource/San_Marino>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "San Marino"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                32576 .

<http://dbpedia.org/resource/Estonia>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Estonia"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                1311759 .

<http://dbpedia.org/resource/Austria>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Austria"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                8662588 .

<http://dbpedia.org/resource/Republic_of_Ireland>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Republic of Ireland"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                4635400 .

<http://dbpedia.org/resource/Vatican_City>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Vatican City"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                842 .

<http://dbpedia.org/resource/Liechtenstein>
        <http://www.w3.org/2000/01/rdf-schema#label>
                "Liechtenstein"@en ;
        <http://dbpedia.org/ontology/populationTotal>
                37340 .
```
输出的结果很多的，这里只是部分数据的，仅供参考的

### 3.11 Complex SPARQL predicates (Fuseki)

In the apache-jena-fuseki-*version* folder:

```java
fuseki-server --localhost --update --mem /mem
```

In your web browser, goto http://localhost:3030/ . Use SPARQL ENDPOINT http://localhost:3030/mem/update for the INSERT updates andhttp://localhost:3030/mem/query for the SELECT queries below.

```java
PREFIX x: <http://example.org/myex#>

INSERT DATA {
    x:IngridAlexandra x:father x:HaakonMagnus ;
                      x:mother x:MetteMarit .
    x:HaakonMagnus x:sister x:MarthaLouise .
}
```

Keep the PREFIX line in all the following queries:

```java
SELECT ?s ?o WHERE {
    ?s (x:father | x:mother) ?o .
}
SELECT ?s ?o WHERE {
    ?s (x:father / x:sister) ?o .
}
SELECT ?s ?o WHERE {
    ?s ^(x:father / x:sister) ?o .
}
SELECT ?s ?o WHERE {
    ?s (^x:sister / ^x:father) ?o .
}
SELECT ?s ?o WHERE {
    ?s !x:sister ?o .
}
```

Add some mother-triples:

```java
INSERT DATA {
    x:HaakonMagnus x:father x:Harald .
    x:Harald x:father x:Olav .
    x:Olav x:father x:Haakon .
}
SELECT ?o WHERE
{
    x:IngridAlexandra x:father+ ?o .
}
SELECT ?o WHERE
{
    x:IngridAlexandra x:father* ?o .
}
SELECT ?o WHERE
{
    x:IngridAlexandra x:father? ?o .
}
SELECT ?o WHERE
{
    x:IngridAlexandra x:father{2} ?o .
}
SELECT ?o WHERE
{
    x:IngridAlexandra x:father{2,4} ?o .
}
```

### 3.12 SPARQL SELECT VALUES (and services)

The code below retreives DBpedia descriptions of the three Scandinavian capitals, using VALUES:

```java
		Dataset dataset = DatasetFactory.create();
		
		ResultSet table = QueryExecutionFactory.create(""
				+ "SELECT * WHERE {"
				+ "    VALUES ?city {"
				+ "	       <http://dbpedia.org/resource/Copenhagen>"
				+ "	       <http://dbpedia.org/resource/Oslo>"
				+ "	       <http://dbpedia.org/resource/Stockholm>"
				+ "    }"
				+ "    SERVICE <http://dbpedia.org/sparql> {"
				+ "		   ?city <" + RDFS.comment + "> ?comment ."
				+ "    }"
				+ "}", dataset).execSelect();
		
		table.forEachRemaining(row -> System.out.println(row));
```

To retrieve only English-language descriptions, you can add a FILTER inside the SERVICE call:

```java
		...
				+ "    SERVICE <http://dbpedia.org/sparql> {"
				+ "		   ?city <" + RDFS.comment + "> ?comment ."
				+ "        FILTER( lang(?comment) = 'en' )"
				+ "    }"
		...
```

### 3.13 Language-tagged literals (and functions, and services...)

This works because we use the language-tagged literal 'Copenhagen'@en in the INSERT DATA update (and, as a result, it outputs DBpedia-triples about Copenhagen):

```java
		Dataset dataset = DatasetFactory.create();
		
		String prefixes = ""
				+ "PREFIX rex: <http://ex.org#>"
				+ "PREFIX dbpedia: <http://dbpedia.org/resource/>";
		UpdateAction.parseExecute(prefixes
				+ "INSERT DATA {"
				+ "    rex:Margrethe <" + FOAF.based_near + "> 'Copenhagen'@en ."
				+ "}", dataset);

		ResultSet table = QueryExecutionFactory.create(prefixes
				+ "SELECT * WHERE {"
				+ "    ?person <" + FOAF.based_near + "> ?label ."
				+ "    SERVICE <http://dbpedia.org/sparql> {"
				+ "        ?city <" + RDFS.label + "> ?label ."
				+ "    }"
				+ "}", dataset).execSelect();
		
		table.forEachRemaining(row -> System.out.println(row.toString()));
```

If we do INSERT DATA *without* the language tag @en, we get no result (because the city labels in DBpedia are language-tagged):

```java
		UpdateAction.parseExecute(prefixes
				+ "INSERT DATA {"
				+ "    rex:Margrethe <" + FOAF.based_near + "> 'Copenhagen'@en ."
				+ "}", dataset);
```

We can, however, rewrite the query to use the *strlang* function that adds language tags to labels. So this works with the previous INSERT DATA:

```java
		ResultSet table = QueryExecutionFactory.create(prefixes
				+ "SELECT * WHERE {"
				+ "    ?person <" + FOAF.based_near + "> ?label ."
				+ "    BIND(strlang(?label, 'en') AS ?taglabel)"				
				+ "    SERVICE <http://dbpedia.org/sparql> {"
				+ "        ?city <" + RDFS.label + "> ?taglabel ."
				+ "    }"
				+ "}", dataset).execSelect();
```

To go the other way (if our local labels were language-tagged and DBpedia's not, we could do a similar thing, but use the reverse *str*-function instead of *strlang*.

### 3.14 Explanation of table.forEachRemaining(...)

The lambda-syntax in this code line may be new for you:

```java
	table.forEachRemaining(row -> System.out.println(row.toString()));
```

The straightforward way to write it **(that doesn't work)**, would be just:

```java
	table.forEachRemaining(System.out.println(row.toString()));
```

But this doesn't work because we cannot send a method call as a parameter in Java, and our code introduces a *row* variable that is not declared anywhere.

Instead, we could try to define a new method somewhere else inside our class:

```java
	void printRow(QuerySolution row) {
		System.out.println(row.toString());
	};
```

and then pass that function to forEachRemaining **(doesn't work either)**:

```java
	table.forEachRemaining(printRow);
```

But this doesn't work because you cannot pass functions as arguments like that in Java.

Finally, we could try to define a whole new class - a subclass of a Consumer class:

```java
class RowPrinter implements Consumer<QuerySolution> {
	public void accept(QuerySolution row) {
		System.out.println(row.toString());
	}
}
```

Here, we define the class RowPrinter as a *Consumer* of *QuerySolution*s, because Jena defines each row in a ResultSet-table to be a QuerySolution. In other words, we can view a ResultSet (table) as a *stream* of QuerySolutions (rows) that the RowPrinter consumes one by one. The method name *accept* is defined by the *Consumer*-class. We cannot chose another name (and, actually, *Consumer* is a Java interface, not a class).

We *can* pass an object of this class to forEachRemaining - this is exactly what it expects (**this works!**):

```java
	table.forEachRemaining(new RowPrinter());
```

But it is pretty cumbersome to write a new class like RowPrinter every time we want to do a forEachRemaining-call - or some other streaming call. Therefore Java 8 has introduced a shorthand, a *lambda expression*:

```java
	table.forEachRemaining(row -> System.out.println(row.toString());
```

Whenever Java 8 or later sees code like this, it behaves as if we had explicitly written a RowPrinter or similar Consumer-class like the one above.

## Lecture 4: TDB and Fuseki

### 4.1 Creating a dataset

```java
        Dataset dataset = TDBFactory.createDataset();
        Model defaultModel = dataset.getDefaultModel();

        ...

        dataset.close()
```

This creates an in-memory dataset, which is not persistent.

### 4.2 Creating/loading a TDB-backed dataset

```java
        Dataset dataset = TDBFactory.createDataset("TDBTest");
        Model defaultModel = dataset.getDefaultModel();

        ...

        dataset.close()
```

The first time it is run, this creates a persistent dataset, backed by a TDB triple store located in the directory "TDBTest" inside your Eclipse project. Refresh the project to see it (or F5).

When re-run later, this loads the dataset from the TDB store.

It is important to close a TDB-backed dataset before the program terminates. Otherwise, you need to go into the database folder (for example the "TDBTest" directory inside your Eclipse project) and delete the file named "tdb.lock". (Do a refresh with F5 if you do not see it in Eclipse.)

### 4.3 Fuseki

When you get started, it is easiest to run Fuseki from the directory where you unpacked it along with the other Jena downloads, for example:

```java
 cd C:\Programs\Jena\apache-jena-fuseki-3.6.0
```

or

```
 cd /opt/Jena/apache-jena-fuseki-3.6.0
```

Start the Fuseki server with this command on Windows:

```
 fuseki-server --localhost --loc=C:\...\your\Eclipse\workspace\INFO216\TDBTest /tdb
```

On Linux:

```
 sh fuseki-server --localhost --loc=C:\...\your\Eclipse\workspace\INFO216\TDBTest /tdb
```

Here, TDBTest is the name of the triple store, INFO216 is the name of the Eclipse project, located inside your Eclipse workspace. Use the **--help** option to see what the other options do.

Open a web browser and go to **localhost:3030** to run queries/updates and otherwise explore and use the TDB-backed dataset.

You can also start Fuseki without the "--loc" option:

```
 fuseki-server --localhost 
```

or

```
 sh fuseki-server --localhost 
```

When you go to **localhost:3030** in your web browser, Fuseki will now appear empty at first, but you can create new datasets and load triples into them from files or from the web. If you choose to create datasets that are persistent, they will not end up in the Eclipse project folder, but in a subfolder of the Fuseki-installation folder, for example:

```
 C:\Programs\Jena\apache-jena-fuseki-3.6.0\runatabases\TDBTest
```

## Lecture 5: RDFS

### 5.1 Creating an RDFS model

```
        Model rdfModel = ModelFactory.createDefaultModel();
        InfModel rdfsModel = ModelFactory.createRDFSModel(rdfModel);
```

### 5.2 RDFS entailment: subClassOf

```
        String iriBase = "http://no.uib.infomedia.info216/";

        Resource resUCB = rdfsModel.createResource(iriBase + "UCB");
        Resource resUniversity = rdfsModel.createResource(iriBase + "University");
        resUCB.addProperty(RDF.type, resUniversity);

        Resource resHEI = rdfsModel.createResource(iriBase + "HEI");
        resUniversity.addProperty(RDFS.subClassOf, resHEI);

        rdfsModel.write(System.out, "TURTLE");
```

The output will show that University of Califoria, Berkeley (UCB) is a Higher-Education Institution (HEI), even though we did not assert that explicitly.

### 5.3 Outputting the RDFS axioms

```
        ModelFactory
            .createRDFSModel(ModelFactory.createDefaultModel())
            .write(System.out, "TURTLE");
```

### 5.4 Removing axioms from RDFS outputs

Here, we write the triples in rdfsModel to the console, after eliminating all triples that are axioms:

```
        InfModel axiomModel = ModelFactory.createRDFSModel(ModelFactory.createDefaultModel());
        ModelFactory
            .createDefaultModel()
            .add(rdfsModel)
            .remove(axiomModel)
            .write(System.out, "TURTLE");
```

### 5.5 RDFS entailment: subPropertyOf

```
        Resource resCadeTracy = rdfsModel.createResource(rdfsModel.getNsPrefixURI("") + "Cade_Tracy");
        Property propHasBScFrom = rdfsModel.createProperty(rdfsModel.getNsPrefixURI("") + "hasBScFrom");
        resCadeTracy.addProperty(propHasBScFrom, resUCB);

        Property propGraduatedFrom = rdfsModel.createProperty(rdfsModel.getNsPrefixURI("") + "graduatedFrom");
        propHasBScFrom.addProperty(RDFS.subPropertyOf, propGraduatedFrom);

        rdfsModel.write(System.out, "TURTLE");
```

The output will show that Cade graduated from University of Califoria, Berkeley (UCB), even though we did not assert that explicitly.

### 5.6 Chained RDFS entailment: subPropertyOf and domain

```
        propGraduatedFrom.addProperty(RDFS.domain, FOAF.Person);
       
        rdfsModel.write(System.out, "TURTLE");
```

The output will show that Cade is a FOAF person, even though we did not assert that explicitly.

### 5.7 The Reasoner object

This outputs the name of the Reasoner's class:

```
        System.out.println(rdfsModel.getReasoner().getClass().toString());
```



### 5.8 Adding namespace prefixes

```
        rdfsModel.setNsPrefix("", iriBase);
        rdfsModel.setNsPrefix("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
        rdfsModel.setNsPrefix("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
```

We can do this in a single call too, by first creating a map:

```
        rdfsModel.setNsPrefixes(new HashMap() {{
            put("", iriBase);
            put("rdf", "http://www.w3.org/1999/02/22-rdf-syntax-ns#");
            put("rdfs", "http://www.w3.org/2000/01/rdf-schema#");
        }});
```

(The "double-brace notation" *{{ ... }}* lets us add code to initialise the new HashMap object at construction, before we pass it as a parameter to setNsPrefixes.)

Instead of

```
        Resource resUCB = rdfsModel.createResource(iriBase + "UCB");
```

we can now write

```
        Resource resUCB = rdfsModel.createResource(rdfsModel.getNsPrefixURI("") + "UCB");
```

to reduce the need for global strings in large programs and to eliminate inconsistencies by keeping all prefixes in the same place.

## Lecture 6: RDFS Plus

Here and below we use this main method, so we can place the Jena code in the constructor for the HelloRDFSPlus class (this is a little bit tidier than putting everything straight into the *static main()* method :-)).

```
    public static void main(String[] args) {
        new HelloRDFSPlus();   
    }
```

### 6.1 Minimal OWL model example

A minimal working *OntModel* example:

```java
    HelloRDFSPlus() {
       
        String base = "http://ex.org/info216#";
        String prefixes = ""
            + "PREFIX ex: <" + base + "> "
            + "PREFIX owl: <" + OWL.getURI() + "> ";

        OntModel owlModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);
       
        UpdateAction.parseExecute(prefixes
            + "INSERT DATA {"
            + "    ex:INFO310 ex:buildsOn ex:INFO216 . "
            + "    ex:INFO216 ex:buildsOn ex:INFO116 . "
            + "    ex:INFO116 ex:buildsOn ex:INFO100 . "
            + "    ex:buildsOn a owl:TransitiveProperty . "
            + "}", owlModel);

        owlModel.getWriter("TURTLE").write(owlModel, System.out, "base");
    }
```

The last line is important: you cannot write out an OntModel using the owlModel.write(...) method that we used for RDF and RDFS models.

### 6.2 Outputting an OWL model without the axioms

You can also output the OntModel without axioms:

```java
        OntModel emptyOwlModel = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM_RULE_INF);
        ModelFactory
            .createDefaultModel()
            .add(owlModel)
            .remove(emptyOwlModel)
            .write(System.out, "TURTLE");
```

### 6.3 ASK query

A more direct way to test that reasoning over transitive properties works:

```java
        System.out.println("Transitive properties work: " +
            QueryExecutionFactory
                .create(prefixes
                    + "ASK {"
                    + "    ex:INFO310 ex:buildsOn ex:INFO100 . "
                    + "}", owlModel)
                .execAsk());
```

### 6.4 Listing OWL statements

Or you can output just the triples that have buildsOn as their predicate:

```java
        ObjectProperty buildsOn = owlModel.createObjectProperty(base + "buildsOn");
        List<Statement> stmts = owlModel
                .listStatements((Resource)null, buildsOn, (RDFNode)null)
                .toList();
        for (Statement stmt : stmts)
            System.out.println(stmt.toString());
    }
```

### 6.5 Adding OWL triples through method calls

Instead of using SPARQL Update, you can populate the OntModel as follows:

```java
        Individual info100 = owlModel.createIndividual(base + "INFO100", OWL.Thing);
        Individual info116 = owlModel.createIndividual(base + "INFO116", OWL.Thing);
        Individual info216 = owlModel.createIndividual(base + "INFO216", OWL.Thing);
        Individual info310 = owlModel.createIndividual(base + "INFO310", OWL.Thing);

        ObjectProperty buildsOn = owlModel.createObjectProperty(base + "buildsOn");
        buildsOn.addProperty(RDF.type, OWL.TransitiveProperty);
        info310.addProperty(buildsOn, info216);
        info216.addProperty(buildsOn, info116);
        info116.addProperty(buildsOn, info100);
```

(We pass OWL.Thing to the createIndividual method to indicate the class of the individual we create. Because we have not created a specific ex:Course class, we just use OWL.Thing, which is the most general of all classes in OWL.)

## Lectures 7-9: Vocabularies and Linked Open Datasets

No code examples from these lectures.

## Lecture 10: JSON and JSON-LD

### 10.1 JSON-LD web API to Dataset

The following code loads the result of a JSON-LD web API call straight into a Jena dataset:

```java
    String uri = "http://www.europeana.eu/api/v2/record/92065/"
            + "BibliographicResource_1000056084136.jsonld?wskey=tX3Zstfo2";  
    Model model = RDFDataMgr.loadModel(uri, Lang.JSONLD);
    model.write(System.out, "TURTLE");
```

If you are going to run this more than once, please register at [[1\]](https://pro.europeana.eu/get-api) to get your own API key, instead of using my personal key *tX3Zstfo2*. You can find more JSON-LD web APIs at [[2\]](https://github.com/json-ld/json-ld.org/wiki/Users-of-JSON-LD).

### 10.2 Web API to JSON Object

In newer versions of Jena (at least since 3.2.0), you can load the results of regular JSON web API call into a Java object as follows:

```java
    String url = "http://api.geonames.org/postalCodeLookupJSON?postalcode=46020&country=ES&username=demo";
    Object jsonObj = JsonUtils.fromURL(new URL(url), JsonUtils.getDefaultHttpClient());
```

(The user name *demo* is only good for a small number of daily calls. You will need to register your own user name at api.geonames.org to call GeoNames many times in a day. See the top bullet points here: [[3\]](http://www.geonames.org/export/web-services.html).)

### 10.3 Prettyprint a JSON Object

```java
    System.out.println(JsonUtils.toPrettyString(jsonObj));
```

### 10.4 Read JSON-LD string into a Jena model

When you have a JSON-LD string, you can read it into a Jena model as follows (replace "" with a base IRI if needed):

```java
    String jsonStr = JsonUtils.toPrettyString(jsonObj);

    Model model = ModelFactory.createDefaultModel();
    RDFDataMgr.read(model, new StringReader(jsonStr), "", Lang.JSONLD);

    model.write(System.out, "TURTLE");
```

or as follows (again, replace "" with a base IRI if needed):

```java
    String jsonStr = JsonUtils.toPrettyString(jsonObj);

    Model model = ModelFactory.createDefaultModel();
    model.read(IOUtils.toInputStream(jsonStr, "UTF-8"), "", "JSON-LD");

    model.write(System.out, "TURTLE");
```

### 10.5 Expand a JSON Object

**Proxy object:** The next few examples will assume the following proxy JSON object, which we pretend has been returned from a JSON web API call:

```java
    // we pretend this string comes from a regular JSON web API call
    String proxyJsonReponse = ""
            + "{"
            + "    \"name\" : \"Markus Lanthaler\", "
            + "    \"workplaceHomepage\" : \"http://www.homepage.com/ML\", "
            + "    \"address\" : {"
            + "        \"streetAddress\" : \"Somestreet 123\", "
            + "        \"cityAddress\" : \"ZIP-4567 Acity\" "
            + "    }"
            + "}";

    // parse the string into a JSON object
    Object jsonObj = JsonUtils.fromString(proxyJsonReponse);
    System.out.println(JsonUtils.toPrettyString(jsonObj));
```

**Create context object:** First create a context object:

```java
    // create a context object
    String baseIRI = "http://ex.org/base#";

    Map contextObj = new LinkedHashMap();
    contextObj.put("name", FOAF.name.getURI());
    contextObj.put("workplaceHomepage", "@id");
    contextObj.put("address", baseIRI + "address");
    contextObj.put("streetAddress", baseIRI + "streetAddress");
    contextObj.put("cityAddress", baseIRI + "cityAddress");
```

This is a more advanced way to do the same thing, which some people think looks clearer:

```java
    // create a context object
    String baseIRI = "http://ex.org/base#";

    Map contextObj = new LinkedHashMap() {{
            put("name", FOAF.name.getURI());
            put("workplaceHomepage", "@id");
            put("address", baseIRI + "address");
            put("streetAddress", baseIRI + "streetAddress");
            put("cityAddress", baseIRI + "cityAddress");
    }};
```

(The latter example uses an *anonymous inner class* with an *instance initialization block*. This explains the double-nested { { and } }-braces: the outer {...} pair is for the anonymous class and the inner {...} pair is for its initialization block, which is the only thing the inner class defines.)

*Note that without a mapping for "address" in the context, expansion will not work for "street-" and "cityAdress", because they are nested inside "address" in the JSON object.*

We have two ways to expand a JSON object: either with or without an explicit options object.

**Simple compacting:** We first try expansion without an explicit options object. This is the simplest way to do it:

```java
    ((Map) jsonObj).put("@context", contextObj);      
    Object expandedObj = JsonLdProcessor.expand(jsonObj);
    System.out.println(JsonUtils.toPrettyString(expandedObj));
```

To avoid the type-unsafe casting, you can do:

```java
    Map json = new LinkedHashMap();
    if (jsonObj instanceof Map)
        json = (Map) jsonObj;
    json.put("@context", contextObj);
    Object expandedObj = JsonLdProcessor.expand(json);
    System.out.println(JsonUtils.toPrettyString(expandedObj));
```

**Compacting with options object:** We now look at expansion with an explicit options object, which can give more control:

```java
    // create and set an options object
    JsonLdOptions expandOptions = new JsonLdOptions(baseIRI);
    expandOptions.setExpandContext(contextObj);
  
    // expand the JSON object
    Object expandedObj = JsonLdProcessor.expand(jsonObj, expandOptions);
    System.out.println(JsonUtils.toPrettyString(expandedObj));
```

### 10.6 Flatten an expanded JSON-LD object

```java
    Object flattenedExpandedObj = JsonLdProcessor.flatten(expandedObj, new JsonLdOptions());
    System.out.println(JsonUtils.toPrettyString(flattenedExpandedObj));
```

### 10.7 Compact a JSON-LD Object

You can run the code below on the following proxy string, or you can use it on the outputs from a semantic JSON-LD web API.

```java
    // we pretend this string comes from a semantic JSON-LD web API call
    String proxyJsonLdReponse = ""
            + "{"
            + "    \"@id\" : \"http://www.homepage.com/ML\", "
            + "    \"http://xmlns.com/foaf/0.1/name\" : [ { "
            + "        \"@value\" : \"Markus Lanthaler\" "
            + "    } ], "
            + "    \"http://ex.org/base#address\" : [ { "
            + "        \"http://ex.org/base#cityAddress\" : [ { "
            + "            \"@value\" : \"ZIP-4567 Acity\" "
            + "        } ], "
            + "        \"http://ex.org/base#streetAddress\" : [ { "
            + "            \"@value\" : \"Somestreet 123\" "
            + "        } ] "
            + "    } ] "
            + "}";

    // create a JSON object
    Object jsonObj = JsonUtils.fromString(proxyJsonLdReponse);
    System.out.println(JsonUtils.toPrettyString(jsonObj));
```

First create a context object:

```java
    // create a context object
    String baseIRI = "http://ex.org/base#";
    Map contextObj = new HashMap() {{
        put("@context", new HashMap() {{
            put("name", FOAF.name.getURI());
            put("workplaceHomepage", "@id");
            put("address", baseIRI + "address");
            put("streetAddress", baseIRI + "streetAddress");
            put("cityAddress", baseIRI + "cityAddress");
        }});
    }};
```

Then compact the JSON-LD object using the context object:

```java
    Object compactedObj = JsonLdProcessor.compact(jsonObj, contextObj, new JsonLdOptions());
    System.out.println(JsonUtils.toPrettyString(compactedObj));

    // if you want pure JSON, you can also remove the context object:
    ((Map) compactedObj).remove("@context");
```

### 10.8 Flatten a compacted JSON object

Flatten the compacted JSON object:

```
    Object flattenedCompactedObj = JsonLdProcessor.flatten(compactedObj, defaultOptions);
    System.out.println(JsonUtils.toPrettyString(flattenedCompactedObj));
```

### 10.9 Web API to String

If you want full control of your HTTP connection, this is a fairly simple and straightforward way to call a web API and return the results as a String. It is independent of Jena and Json. (There are many APIs available that do this in more advanced ways, but it will get you started.)

```java
    // calls a Web API and returns the result as a string
    // this method is not necessary, but included because it may be useful for some of you
    String getResponseBody(URL serverAddress) {
        String responseBody = null;

        HttpURLConnection connection = null;

        BufferedReader rd  = null;
        StringBuilder sb = null;
        String line = null;

        try {
            // send GET request
            connection = null;
            connection = (HttpURLConnection)serverAddress.openConnection();
            connection.setRequestMethod("GET");
            // connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.connect();

            // receive response
            rd  = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            sb = new StringBuilder();

            // turn response into a string
            while ((line = rd.readLine()) != null)
            {
                sb.append(line + '\n');
            }
            responseBody = sb.toString();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // close the connection
            connection.disconnect();
            rd = null;
            sb = null;
            connection = null;
        }
      
        return responseBody;
    }
```

### 10.10 Web API to JSON Object

Builds on the above full-control example, but assumes the result of the web API call is JSON and parses it.

```java
    static Object getJsonBody(URL serverAddress) {
        Object jsonObject = null;
        HttpURLConnection connection = null;

        try {
            // send GET request
            connection = null;
            connection = (HttpURLConnection)serverAddress.openConnection();
            connection.setRequestMethod("GET");
            // connection.setDoOutput(true);
            connection.setReadTimeout(10000);
            connection.connect();

            // parse JSON reponse
            jsonObject = JsonUtils.fromInputStream(connection.getInputStream());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (ProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //close the connection
            connection.disconnect();
            connection = null;
        }

        return jsonObject;      
    }
```

You call this like we did in one of the first examples, but with the call-line changed:

```java
    String url = "http://api.geonames.org/postalCodeLookupJSON"
            + "?postalcode=46020&country=ES&username=demo";
    Object jsonObj = getJsonBody(new URL(url));
```

### 10.11 Web API call proxy

While you develop and test, you will fire off the same API calls many times. This will usually be unproblematic, but it can cause problems if you exceed hourly/daily/etc. API call limits. In such cases you can write API call proxies, which look like real API calls to the rest of the program, and return JSON strings or object, but which return the same test string/object every time (without actually making an API call).

For example, the below method seems to behave like the previous **getJsonBody** method, but returns a fixed JSON object:

```java
    static Object getJsonBodyProxy(URL url) {
      
        String jsonBody = "{\"postalcodes\":[{\"adminCode2\":\"V\",\"adminCode1\":\"VC\","
                + "\"adminName2\":\"Valencia\",\"lng\":-0.377386808395386,"
                + "\"countryCode\":\"ES\",\"postalcode\":\"46020\","
                + "\"adminName1\":\"Comunidad Valenciana\",\"placeName\":\"Valencia\","
                + "\"lat\":39.4697524227712}]}";
        try {
            return JsonUtils.fromString(jsonBody);
        } catch(Exception ex) {
            return null;
        }
    }
```


