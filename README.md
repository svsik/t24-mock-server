This is a T24 Iris Mock Spring Boot application that is deploying to the WildFly application server.  This uses the mvn build system and creates a .war file that can be deployed. 

This repo can also be deployed directly as a docker container using the WildFly S2I builder image on OpenShift 3 with the following command:

	oc new-app wildfly:latest~https://agit.kbc.be:6088/scm/kbcie/[TBD].git