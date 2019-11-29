# Text book

The text book in INFO216 is *Semantic Web for the Working Ontologist, Second Edition: Effective Modeling in RDFS and OWL by Dean Allemang and James Hendler (Jun 3, 2011). Morgan Kaufmann.* **The whole book is obligatory reading.**

# Other materials

In addition, **the materials listed below for each lecture is either mandatory or suggested reading.** Currently, the readings are not updated from 2017, so some of them may change. Make sure you download the papers and web sites in good time before the exam. That way you are safe if a site becomes unavailable or somehow damaged the last few days before the exam. Note that to download some of the papers, you need to be inside UiB's network. Either use a computer directly on the UiB network or connect to your UiB account with VPN if you are elsewhere.

Finally, **the lectures and lectures notes are also part of the curriculum.**

# Lectures

Below are the mandatory and suggested readings for each lecture. All the text-book chapters are mandatory.

## Lecture 1: Introduction

Themes:

- Web of Data
- INFO216
- Jena
- The programming project

Mandatory readings:

- Chapters 1-2 in Allemang & Hendler. *In text book.*
- [Tim Berners-Lee talks about the semantic web](http://www.youtube.com/watch?v=HeUrEh-nqtU) (mandatory)
- [Apache architecture overview](http://jena.apache.org/about_jena/architecture.html) (mandatory)
- [The core RDF API](http://jena.apache.org/documentation/rdf/index.html) (mandatory)
- [An introduction to RDF and the Jena RDF API](http://jena.apache.org/tutorials/rdf_api.html) (mandatory)
- Slides from the lecture
  - [Additional slides from the lecture](https://wiki.uib.no/info216/index.php/File:S01-Intro-WoD-Jena-7.pdf)

Useful materials:

- [Welcome to Apache Jena](http://jena.apache.org/about_jena/) (useful starting page)
- [Apache Jena](http://jena.apache.org/index.html) main page (useful starting page)
- [Jena tutorials](http://jena.apache.org/tutorials/) (useful starting page)
- [Package org.apache.jena.rdf.model](https://jena.apache.org/documentation/javadoc/jena/) (supplementary, but necessary for the labs and project - lab 1 and the lecture notes lists the classes and methods you should look at)

Additional resources:

- PechaKucha: [How to Create a PechaKucha Presentation](https://www.pechakucha.com/cities/lambertville-new-hope/blogs/creating-a-presentation-update)
- Elevator pitch:[Some tips on how to plan your elevator pitch](https://www.linkedin.com/learning/creating-your-personal-brand/creating-a-perfect-elevator-pitch) and an [example](https://www.youtube.com/watch?v=Q19WW65kLkI)

## Lecture 2: RDF

Themes:

- RDF
- Programming RDF in Jena
- Finding datasets and vocabularies for your projects

Mandatory readings:

- Chapter 3 in Allemang & Hendler. *In text book.*
- [W3C's RDF 1.1 Primer](https://www.w3.org/TR/rdf11-primer/) (mandatory)
- We also continue with the Jena RDF materials from lecture 1:
  - [The core RDF API](http://jena.apache.org/documentation/rdf/index.html) (mandatory)
  - [An introduction to RDF and the Jena RDF API](http://jena.apache.org/tutorials/rdf_api.html) (mandatory)
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S02-RDF-8.pdf)

Useful materials:

- W3C's RDF 1.1 Concepts and Abstract Syntax

   

  (cursory)

  - [Package org.apache.jena.rdf.model](https://jena.apache.org/documentation/javadoc/jena/) (supplementary, but necessary for the labs and project)

## Lecture 3: SPARQL

Themes:

- SPARQL
- Programming SPARQL in Jena
- SPARQL Update
- Programming SPARQL Update in Jena

Mandatory readings:

- Chapter 5 in Allemang & Hendler. *In text book.*
- [SPARQL 1.1 Update Language](http://www.w3.org/TR/sparql11-update/) (Sections 1-3 are obligatory)
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S03-SPARQL-12.pdf)

Useful materials:

- [SPARQL 1.1 Query Language](http://www.w3.org/TR/sparql11-query/)

- [SPARQL 1.1 Update Language](http://www.w3.org/TR/sparql11-update/) (the rest of it)

- [SPARQL 1.1 Overview](https://www.w3.org/TR/sparql11-overview/)

- Javadoc

   

  for Apache Jena ARQ 3.2.0

  - Query, QueryFactory, QueryExecution, QueryExecutionFactory, ResultSet
  - UpdateFactory, UpdateAction



## Lecture 4: Architecture

Themes:

- Application architecture
- Application components
- Triple stores
- Visualisation

Mandatory readings:

- Chapter 4 in Allemang & Hendler. *In text book.*
- [Apache architecture overview](http://jena.apache.org/about_jena/architecture.html) (mandatory, from lecture 1)
- [Apache's TDB](https://jena.apache.org/documentation/tdb/index.html) (mandatory)
- [Apache's TDB Java API](https://jena.apache.org/documentation/tdb/java_api.html) (mandatory)
- [Apache Jena Fuseki](https://jena.apache.org/documentation/fuseki2/index.html) (mandatory, we use Fuseki 2)
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S04-architecture-5.pdf)

Useful materials:

- [Package org.apache.jena.tdb](https://jena.apache.org/documentation/javadoc/tdb/) Class TDBFactory (createDataset)
- [Skjæveland 2012: Sgvizler.](http://www.eswc2012.org/sites/default/files/eswc2012_submission_303.pdf) *Paper.*
- [Sgvizler 0.6](http://mgskjaeveland.github.io/sgvizler/)
- [Lohmann et al. (2019): Visualizing Ontologies with VOWL. *Semantic Web Journal.*](https://wiki.uib.no/info216/index.php/File:LohmannEtAl2016-VisualizingOntologiesWithVOWL.pdf) *Paper.*
- [VOWL: Visual Notation for OWL Ontologies](http://vowl.visualdataweb.org/)

## Lecture 5: RDFS

Themes:

- RDFS
- Axioms, rules and entailment
- Programming RDFS in Jena

Mandatory readings:

- Chapters 6-7 in Allemang & Hendler. *In text book.*
- [W3C's RDF Schema 1.1](http://www.w3.org/TR/rdf-schema/) (mandatory)
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S05-RDFS-10.pdf)

Useful materials:

- [W3C's RDF 1.1 Semantics](https://www.w3.org/TR/rdf11-mt/) (cursory, except the axioms and entailments in sections 8 and 9, which we will review in the lecture)

- [Reasoners and rules engines: Jena inference support](https://jena.apache.org/documentation/inference/index.html) (cursory; sections 1 and 3 are relevant, but quite hard)

- Javadoc

   

  for

  - Model (createRDFSModel)
  - InfModel (getRawModel, remove + the same methods as Model)
  - RDFS (label, comment, subClassOf, subPropertyOf, domain, range...)
  - Reasoner (but we will not use it directly)



Case-based examples:

- [RDFS Eating vegetables case](https://wiki.uib.no/info216/index.php/File:S5_RDFS_Example.pdf)

## Lecture 6: RDFS Plus

Themes:

- Basic OWL concepts
- Axioms, rules and entailments
- Programming basic OWL in Jena

Mandatory readings:

- Chapter 8 in Allemang & Hendler. *In text book.*
- [Slides from the lecture.](https://wiki.uib.no/info216/index.php/File:S06-RDFSPlus-4.pdf)

Useful materials:

- Javadoc

   

  for

  - OntModel (createOntologyModel)
  - OntModelSpec (the different reasoners are outlined [here (very long)](https://jena.apache.org/documentation/inference/index.html), OWL_MEM_RULE_INF is a good starting point)
  - OWL (defines built-in OWL resources)
  - OntClass, Individual, ObjectProperty, DatatypeProperty



Case-based examples:

- [RDFS Plus People and Person case](https://wiki.uib.no/info216/index.php/File:S6_RDFS_Plus_Example.pdf)

OWL helpful clarifications:

- [owl:InverseFuctionalProperty vs owl:propertyDisjointWith](https://wiki.uib.no/info216/index.php/File:OWL-example_I.pdf)

## Lecture 7: Vocabularies

Themes:

- LOD vocabularies and ontologies

Mandatory readings:

- Chapters 9-10 and 13 in Allemang & Hendler. *In text book.*
- [Linked Open Vocabularies (LOV)](http://lov.okfn.org/dataset/lov/)
- [LODstats](http://stats.lod2.eu/)
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S07-Vocabularies-21.pdf)

Useful materials:

- Vocabularies:
  - [SKOS - Simple Knowledge Organization System Home Page](http://www.w3.org/2004/02/skos/)
  - [schema.org - Full Hierarchy](http://schema.org/docs/full.html)
  - [Dublin Core (DC)](http://dublincore.org/)
  - [Friend of a Friend (FOAF)](http://xmlns.com/foaf/spec/)
  - [geo: World Geodetic Standard (WGS) 84](https://www.w3.org/2003/01/geo/wgs84_pos) (and [few more general comments here](https://www.w3.org/2003/01/geo/))
  - [The RDF Data Cube Vocabulary](https://www.w3.org/TR/vocab-data-cube/)
  - [Annotating vocabulary descriptions (VANN)](http://purl.org/vocab/vann/)
  - [Vocabulary Status (VS)](https://www.w3.org/2003/06/sw-vocab-status/note)
  - [Creative Commons (CC) Vocabulary](http://creativecommons.org/ns)
  - [Vocabulary of Interlinked Datasets (VoID)](http://vocab.deri.ie/void)
  - [Provenance Interchange (PROV)](http://www.w3.org/ns/prov#)
  - [Event Ontology (event)](http://motools.sourceforge.net/event/event.html)
  - [Time ontology in OWL (time, OWL-time)](http://www.w3.org/TR/owl-time/)
  - [Timeline Ontology (tl)](http://motools.sourceforge.net/timeline/timeline.html)
  - [Biographical Information (BIO)](http://vocab.org/bio/)
  - [Semantic Interlinked Online Communities (SIOC)](http://rdfs.org/sioc/spec/)
  - [Bibliographic Ontology (bibo)](http://bibliontology.com/)
  - [Music Ontology (mo)](http://www.musicontology.com/)



## Lecture 8 and 9: Linked Open Datasets

Themes:

- Important Linked Open Datasets
  - DBpedia
  - LinkedGeoData
  - GeoNames
  - Wikidata
  - and others

Mandatory readings:

- [Bizer, C., Heath, T., & Berners-Lee, T. (2009). Linked data-the story so far. Semantic services, interoperability and web applications: emerging concepts, 205-227.](https://wiki.uib.no/info216/index.php/File:BizerHeathBernersLee-LinkedData2009-TheStorySoFar.pdf)
- [Färber, M., Ell, B., Menne, C., & Rettinger, A. (2015). A Comparative Survey of DBpedia, Freebase, OpenCyc, Wikidata, and YAGO. Semantic Web Journal, July.](https://wiki.uib.no/info216/index.php/File:FarberEtAl-ComparativeSurvey-SWJ2015.pdf)
- [The Linking Open Data (LOD) cloud diagram](http://lod-cloud.net/)
- [LODstats](http://stats.lod2.eu/)
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S08-LinkedOpenDatasets-23.pdf)

Useful materials:

- [Dbpedia](http://wiki.dbpedia.org/about)
- [Wikidata](https://www.wikidata.org/wiki/Wikidata:Introduction)
- [GeoNames](http://www.geonames.org/about.html)
- [WordNet - A lexical database for English](https://wordnet.princeton.edu/)
- [BabelNet](http://live.babelnet.org/about)

## Lecture 10: Services

Themes:

- JSON, JSON-LD
- Semantic web services
- Semantic workflows

Mandatory readings:

- [JSON Syntax](http://json.org/) (mandatory)
- Section 2 in W3C's [JSON-LD 1.0 Processing Algorithms and API](https://www.w3.org/TR/json-ld-api/) (mandatory)
- Slides from the lecture
  - [JSON-LD slides](https://wiki.uib.no/info216/index.php/File:S10-JSONLD.pdf)

Useful materials:

- [JSON-LD 1.1 - A JSON-based Serialization for Linked Data](http://json-ld.org/spec/latest/json-ld/) (supplementary reference)

- JSON for Linked Data

   

  (supplementary)

  - [What is Linked Data?](http://www.youtube.com/watch?v=4x_xzT5eF5Q) Short video introduction to Linked Data by Manu Sporny
  - [What is JSON-LD?](http://www.youtube.com/watch?v=vioCbTo3C-4) Short video introduction to JSON-LD by Manu Sporny

## Lecture 11: OWL

Themes:

- Advanced OWL
- Axioms, rules and entailments
- Programming advanced OWL in Jena

Mandatory readings:

- Chapters 11-12 in Allemang & Hendler. *In text book.*
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S11-OWL-15-utlagt.pdf)

Useful materials:

- [OWL 2 Document Overview](http://www.w3.org/TR/owl-overview) (cursory)
- [OWL2 Primer](http://www.w3.org/TR/owl-primer) (cursory)
- [OWL 2 Quick Reference Guide](https://www.w3.org/TR/2012/REC-owl2-quick-reference-20121211/) (cursory)
- [VOWL: Visual Notation for OWL Ontologies](http://vowl.visualdataweb.org/v2) (cursory)
- [WebVOWL](http://vowl.visualdataweb.org/webvowl/index.html#sioc) (cursory)
- [Jena Ontology API](https://jena.apache.org/documentation/ontology/) (we will most likely not go into this) (cursory)

## Lecture 12: OWL DL

Themes:

- Description logic
- Decision problems
- OWL-DL
- Programming with OWL-DL reasoners in Jena

Mandatory readings:

- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S12-OWL-DL-10.pdf)

Useful materials:

- [Nardi & Brachman: Introduction to Description Logics. Chapter 1 in Description Logic Handbook.](https://wiki.uib.no/info216/index.php/File:NardiBrachman-IntroductionToDescriptionLogic.pdf) *(cursory)*
- Baader & Nutt: Basic Description Logics. Chapter 2 in Description Logic Handbook.
  - *Cursory*, quickly gets mathematical after the introduction. In particular, sections 2.2.2.3-4 about fixpoint semantics apply to TBoxes with cyclic definitions, which we do not consider in this course. We also do not consider the stuff about rules, epistemics, and reasoning from section 2.2.5 on.
- [Complexity of Reasoning in Description Logics. Powered by Evgeny Zolin.](http://www.cs.man.ac.uk/~ezolin/dl/) (informative)

## Lecture 13: Ontology development

Themes:

- Ontology Development 101 method

Mandatory readings:

- Chapters 14-16 in Allemang & Hendler. *In text book.*
- [Noy & McGuinness (2001): Ontology Development 101: A Guide to Creating Your First Ontology.](http://liris.cnrs.fr/alain.mille/enseignements/Ecole_Centrale/What is an ontology and why we need it.htm) *Paper.*
- [Slides from the lecture](https://wiki.uib.no/info216/index.php/File:S13-OntologyDevelopment-4.pdf)

Useful materials:

- [Sicilia et al. (2012): Empirical findings on ontology metrics.](http://www.sciencedirect.com/science/article/pii/S095741741101640X) *Paper.* (cursory)