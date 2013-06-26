package br.gov.frameworkdemoiselle.guddi.security;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import br.gov.frameworkdemoiselle.guddi.business.UsuarioBC;
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
		
		Boolean hasRole = (Boolean) em.createNativeQuery("SELECT COUNT(1) > 0 FROM public.usuario_papel up JOIN public.papel p ON p.id = up.id_papel " +
													     "WHERE up.id_usuario = :idUser AND p.descricao = :role ")
						   .setParameter("idUser", identity.getId())			     
						   .setParameter("role", role)
						   .getSingleResult();
		
		return hasRole;
	}

	@Override //TODO Discutir essa implementacao. O que seriam resource e operation na visão de Papel
	public boolean hasPermission(String resource, String operation) {
		Boolean hasRole = (Boolean) em.createNativeQuery("SELECT COUNT(1) > 0 FROM public.usuario_papel up JOIN public.papel p ON p.id = up.id_papel " +
														 "WHERE up.id_usuario = :idUser AND (p.descricao = :resource OR p.descricao = :operation)")
				   .setParameter("idUser", identity.getId())			     
				   .setParameter("resource", resource)
				   .setParameter("operation", operation)
				   .getSingleResult();

		return hasRole;
	}

}
