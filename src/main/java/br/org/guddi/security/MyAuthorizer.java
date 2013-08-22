package br.org.guddi.security;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.security.AuthenticationException;
import br.gov.frameworkdemoiselle.security.Authorizer;
import br.gov.frameworkdemoiselle.util.ResourceBundle;
import br.org.guddi.persistence.UsuarioDAO;

/**
 * @author thiago.soares
 */
public class MyAuthorizer implements Authorizer {

    private static final long serialVersionUID = 9096827023234484L;
    
    @Inject
    private Identity identity;
    
    @Inject
    private UsuarioDAO usuarioDAO;
    
    @Inject
    private ResourceBundle rb;

    /**
     *
     * @param role
     * @return
     */
    @Override
    public boolean hasRole(String role) {
        try {
        	return role.equals(identity.getPapel());
        } 
        catch (Exception ex) {
            throw new AuthenticationException(rb.getString("controle.acesso.tem.papel.excecao"), ex);
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
        	
        	Map<Integer, Integer> recursoOperacoes = identity.getRecursosOperacoes();
        	
        	List<String> operacoes = new ArrayList<String>();
        	operacoes.add(operation);
        	
        	Integer recurso = Resources.getResource(resource);
        	Integer operacao = Operations.getOperation(operacoes);
        	
        	for (Map.Entry<Integer, Integer> entry : recursoOperacoes.entrySet()){
        		if(recurso == entry.getKey() && operacao == entry.getValue()){
        			return true;
        		}
        	}
        	        	
        	return false;
        	
        } catch (Exception ex) {
            throw new AuthenticationException(rb.getString("controle.acesso.tem.permissao.excecao"), ex);
        }

    }
}
