app
===

Universal Description, Discovery and Integration for Government 

Funcionamento:

No Banco

Escolha o banco de sua preferencia, nós utilizamos o Postgres

Crie uma base chamada "guddi" e altere o persistence.xml

Se você escolheu outro banco não esqueça de alterar a dependencia 
no pom.xml, para seu banco

        <dependency>
            <groupId>postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <version>9.1-901-1.jdbc4</version>
        </dependency> 


No Tomcat7

Para compilar escolha o perfil tomcat7 (Eclipse e Netbeans)

No JBoss 

Comente no web.xml
    <listener>
        <listener-class>org.jboss.weld.environment.servlet.Listener</listener-class>
    </listener>

Para compilar escolha o perfil jboss7 (Eclipse e Netbeans)

