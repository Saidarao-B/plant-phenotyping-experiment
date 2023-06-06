Plant Phenotyping Data Warehouse

1. Please design a relational database schema (e.g. as ER or UML diagram) to manage simple plant phenotyping experiments. 
Therefore you need to design a "Plant Genetic Resources" (entity ACCESSIONS), which should be describes with a unique accession number and a subset of three randomly selected attributes from the MCPD standard (https://www.genesys-pgr.org/descriptorlists/0cd31350-234b-4ebf-80bc-fc65f14f7541 ).

Every Accession can be used for field or greenhouse EXPERIMENTS, which are described by at least two different TRAITS (https://www.google.com/search?q=plant+phenotypic+traits)


2. Please Implement a preferably Java Application to
	a. Set-up and connect to a local database (H2,mysql,postgres…)
	b. Create the previously designed database model. Please ensure the referential integrity among the implemented tables in consideration of the beforehand modeled relationships
	c. Store some example datasets


3. Please extend the application and integrate a simple REST endpoint with the verb “PUT” to create new Accessions and a “GET” verb to retrieve the data of all Experiments for a given Accession as JSON document


4. Please provide the source code in an accessible GIT Repository and add a short documentation, which shows the database schema and describes how to execute and test the application.


-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-

Solution:

1. Find attached Entity relationship diagram (ER diagram).

2. Find the developed Maven application for the above scenario can be find in the application folder.

3. For complete develeopment of H2 database and REST endpoint and application testing report atached. 


												   *-*-*-*-*-*-*-*
-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-|  Thank you  |-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
												   *-*-*-*-*-*-*-*






