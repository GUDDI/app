package br.gov.frameworkdemoiselle.guddi.business;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import br.gov.frameworkdemoiselle.guddi.domain.Usuario;
import br.gov.frameworkdemoiselle.guddi.persistence.UsuarioDAO;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager em;
	
	public Usuario findByLogin(String login) {
		
		try {
			Usuario user = (Usuario) em.createNamedQuery("Usuario.findByUsuario").setParameter("usuario", login).getSingleResult();
			
			return user;
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
