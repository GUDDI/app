package br.org.guddi.security;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.org.guddi.business.SecurityBC;

/**
 * @author thiago.soares
 */
public class MyAuthorizer implements Authorizer {

    private static final long serialVersionUID = -9096849270023234484L;
    @Inject
    private Identity identity;
    @Inject
    private SecurityBC securityBC;

    @Override
    public boolean hasRole(String role) {
        Boolean hasRole = securityBC.hasRole(identity.getId(), Roles.getRole(role));
        return hasRole;
    }

    @Override
    public boolean hasPermission(String resource, String operation) {
        Integer idOperacao = securityBC.hasPermission(identity.getId(), Resources.getResource(resource));
        return Operations.listOperations(idOperacao).contains(operation);
    }
}
