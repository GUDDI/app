package br.org.guddi.security;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.org.guddi.business.SecurityBC;
import javax.inject.Inject;

/**
 * @author thiago.soares
 */
public class MyAuthorizer implements Authorizer {

    private static final long serialVersionUID = 9096827023234484L;
    @Inject
    private Identity identity;
    @Inject
    private SecurityBC securityBC;

    /**
     *
     * @param role
     * @return
     */
    @Override
    public boolean hasRole(String role) {
        Boolean hasRole = securityBC.hasRole(identity.getId(), Roles.getRole(role));
        return hasRole;
    }

    /**
     *
     * @param resource
     * @param operation
     * @return
     */
    @Override
    public boolean hasPermission(String resource, String operation) {
        Integer idOperacao = securityBC.hasPermission(identity.getId(), Resources.getResource(resource));
        return Operations.listOperations(idOperacao).contains(operation);
    }

}
