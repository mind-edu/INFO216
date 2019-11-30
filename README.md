# INFO216

来源于 : [https://wiki.uib.no/info216/index.php/](https://wiki.uib.no/info216/index.php/)

## 介绍

两个重要部分

- src文件夹 **项目源代码**
- assests/markdown/Examples.md  **项目源代码的文档说明**

    - Contents
    - [1	Lecture 1: Java, Jena, and Eclipse](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#lecture-1-java-jena-and-eclipse)
        - [1.1	Hello Jena](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#11-hello-jena)
    - [2	Lecture 2: RDF](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#lecture-2-rdf)
        - [2.1	Resource objects](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#21-resource-objects)
        - [2.2	Language-tagged literals](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#22-language-tagged-literals)
        - [2.3	Typed literals](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#23-typed-literals)
        - [2.4	Looping through statements](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#24-looping-through-statements)
        - [2.5	Selecting statements](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#25-selecting-statements)
        - [2.6	Using a selector](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#26-using-a-selector)
        - [2.7	Writing to file](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#27-writing-to-file)
        - [2.8	Contents of test.ttl](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#28-contents-of-testttl)
        - [2.9	Reading from file](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#29-reading-from-file)
        - [2.10	Reading from web resource](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#210-reading-from-web-resource)
    - [3	Lecture 3: SPARQL Query and Update](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#lecture-3-sparql-query-and-update)
        - [3.1	Basic INSERT DATA update](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#31-basic-insert-data-update)
        - [3.2	Basic SELECT query](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#32-basic-select-query)
        - [3.3	Convert the ResultSet into a JSON object](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#33-convert-the-resultset-into-a-json-object)
        - [3.4	SELECT query with Query object](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#34-select-query-with-query-object)
        - [3.5	SELECT query from SPARQL endpoint](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#35-select-query-from-sparql-endpoint)
        - [3.6	Basic ASK query](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#36-basic-ask-query)
        - [3.7	ASK query from IRL](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#37-ask-query-from-irl)
        - [3.8	Basic DESCRIBE query](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#38-basic-describe-query)
        - [3.9	Basic CONSTRUCT query](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#39-basic-construct-query)
        - [3.10	CONSTRUCT query from IRL](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#310-construct-query-from-irl)
        - [3.11	Complex SPARQL predicates (Fuseki)](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#311-complex-sparql-predicates-fuseki)
        - [3.12	SPARQL SELECT VALUES (and services)](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#312-sparql-select-values-and-services)
        - [3.13	Language-tagged literals (and functions, and services...)](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#313-language-tagged-literals-and-functions-and-services)
        - [3.14	Explanation of table.forEachRemaining(...)](https://github.com/mind-edu/INFO216/blob/master/assests/markdown/Examples.md#314-explanation-of-tableforeachremaining)
    - 4	Lecture 4: TDB and Fuseki
        - 4.1	Creating a dataset
        - 4.2	Creating/loading a TDB-backed dataset
        - 4.3	Fuseki
    - 5	Lecture 5: RDFS
        - 5.1	Creating an RDFS model
        - 5.2	RDFS entailment: subClassOf
        - 5.3	Outputting the RDFS axioms
        - 5.4	Removing axioms from RDFS outputs
        - 5.5	RDFS entailment: subPropertyOf
        - 5.6	Chained RDFS entailment: subPropertyOf and domain
        - 5.7	The Reasoner object
        - 5.8	Adding namespace prefixes
    - 6	Lecture 6: RDFS Plus
        - 6.1	Minimal OWL model example
        - 6.2	Outputting an OWL model without the axioms
        - 6.3	ASK query
        - 6.4	Listing OWL statements
        - 6.5	Adding OWL triples through method calls
    - 7	Lectures 7-9: Vocabularies and Linked Open Datasets
    - 8	Lecture 10: JSON and JSON-LD
        - 8.1	JSON-LD web API to Dataset
        - 8.2	Web API to JSON Object
        - 8.3	Prettyprint a JSON Object
        - 8.4	Read JSON-LD string into a Jena model
        - 8.5	Expand a JSON Object
        - 8.6	Flatten an expanded JSON-LD object
        - 8.7	Compact a JSON-LD Object
        - 8.8	Flatten a compacted JSON object
        - 8.9	Web API to String
        - 8.10	Web API to JSON Object
        - 8.11	Web API call proxy

