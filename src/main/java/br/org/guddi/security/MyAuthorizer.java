package br.org.guddi.security;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.security.Authorizer;

/**
* @author thiago.soares
*/
public class MyAuthorizer implements Authorizer {

	private static final long serialVersionUID = -9096849270023234484L;
	
	@Inject
	private Identity identity;
        
        @Inject
        private EntityManager em;
	
	@Override
	public boolean hasRole(String role) {
		
		Boolean hasRole = (Boolean) em.createNativeQuery("SELECT COUNT(1) > 0 FROM guddi.usuario_papel WHERE id_usuario = :idUser AND id_papel = :role")
						   .setParameter("idUser", identity.getId())			     
						   .setParameter("role", Roles.getOperation(role))
						   .getSingleResult();
            
//           Boolean hasRole = identity.getPapeis().contains(role);
		
		return hasRole;
	}
        
	@Override 
	public boolean hasPermission(String resource, String operation) {
		Integer retorno = (Integer) em.createNativeQuery("SELECT operacao FROM guddi.usuario_recursos ur WHERE id_usuario = :idUser AND id_recursos = :resource")
				   .setParameter("idUser", identity.getId())			     
				   .setParameter("resource", Resources.getResource(resource))
				   .getSingleResult();
//                Boolean hasRole = (identity.getPapeis().contains(resource) || identity.getPapeis().contains(operation));
                
		return Operations.listOperations(retorno).contains(operation);
	}

}
