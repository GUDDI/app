package br.org.guddi.security;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.Authorizer;
import br.org.guddi.persistence.UsuarioDAO;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author thiago.soares
 */
public class MyAuthorizer implements Authorizer {

    private static final long serialVersionUID = 9096827023234484L;
    @Inject
    private Identity identity;
    @Inject
    private UsuarioDAO usuarioDAO;

    /**
     *
     * @param role
     * @return
     */
    @Override
    public boolean hasRole(String role) {
        try {
            Boolean hasRole = usuarioDAO.hasRole(identity.getId(), Roles.getRole(role));
            return hasRole;
        } catch (Exception ex) {
            throw new AuthenticationException("Usuário não tem regra", ex);
        }
    }

    /**
     *
     * @param resource
     * @param operation
     * @return
     */
    @Override
    public boolean hasPermission(String resource, String operation) {
        try {
            Integer idOperacao = usuarioDAO.hasPermission(identity.getId(), Resources.getResource(resource));
            return Operations.listOperations(idOperacao).contains(operation);
        } catch (Exception ex) {
            throw new AuthenticationException("Usuário não tem permissão", ex);
        }

    }
}
