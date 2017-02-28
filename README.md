# twodbs

A project to try out using 2 databases with different schemas in the same application.

Runs as a skinny war on payara-micro:

    java -jar payara-micro-4.1.1.171.0.1.jar --deploy target/twodbs-1.0-SNAPSHOT.war

Datasources are defined in web.xml, persistence units in persistence.xml.

ATM it looks like all tables get created in all PUs, even though I specify the &lt;class&gt;-es
in the PU definition.