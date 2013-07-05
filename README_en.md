# Guddi APP

## Click for intall

### The database

Choose your Database, we use Postgresql.

Create a base called "guddi" and change your persistence.xml or DataSource in JBoss

If you chose another Database not forget to change the dependence
in pom.xml.

        <dependency>
            <groupId> postgresql </ groupId>
            <artifactId> postgresql </ artifactId>
            <version> 9.1-901-1.jdbc4 </ version>
        </ Dependency>


## Installing and Configuring the Tomcat7

To compile choice the profile tomcat7 (Eclipse and Netbeans)

## Installing and Configuring the JBoss7

The following excerpt from the web.xml should be commented:
    
    <listener>
        <listener-class> org.jboss.weld.environment.servlet.Listener </ listener-class>
    </ Listener>
    
Create a module for your JDBC driver in JBoss:

 Create the following directory structure $ JBOSS_HOME / modules / org / postgresql / main
 Module.xml Create a file in the directory with the following main content

<? Xml version = "1.0" encoding = "UTF-8"?>
<module xmlns="urn:jboss:module:1.0" name="org.postgresql">
<resources>
<resource-root path="postgresql-9.1-902.jdbc4.jar"/>
</ Resources>
<dependencies>
<module name="javax.api"/>
<module name="javax.transaction.api"/>
</ Dependencies>
</ Module>

Note that path in resource-root tag is the name of the driver jar

Copy the JDBC driver to the main directory. He can be reached at [http://jdbc.postgresql.org] (http://jdbc.postgresql.org/download.html)

The structure should look like:

org
| _ Postgresql
| | _ Main
| | | _ Module.xml
| | | _ Postgresql-9.1-902.jdbc4.jar

Declare your driver in standalone.xml
File standalone.xml ($ JBOSS_HOME / standalone / configuration / standalone.xml) <drivers> locate the tag and insert the following snippet:
inside there will be a tag <datasources>. Enter the following code inside <datasources>:

    <driver name="postgresql" module="org.postgresql">
        <xa-datasource-class> org.postgresql.xa.PGXADataSource </ xa-datasource-class>
    </ Driver>

Create a DataSource for your JDBC connection in standalone.xml
Standalone.xml file, together with the statement of the driver, insert the following snippet:

<datasource jta="true" jndi-name="java:jboss/datasources/guddiDS" pool-name="guddiDS" enabled="true" use-ccm="false">
        <connection-url> jdbc: postgresql :/ / desenv-db01/guddi </ connection-url>
        <driver-class> org.postgresql.Driver </ driver-class>
        <driver> postgresql </ driver>
        <security>
            <user-name> User </ user-name>
            <password> password </ password>
        </ Security>
        <validation>
            <validate-on-match> false </ validate-on-match>
            <background-validation> false </ background-validation>
        </ Validation>
        <statement>
            <share-prepared-statements> false </ share-prepared-statements>
        </ Statement>
    </ Datasource>

change credentials.


Start Jboss and make application build using the following command. The maven will deploy in jboss

mvn install-P jboss7


To compile the profile jboss7 choice (Eclipse and Netbeans)

