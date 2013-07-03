package br.org.guddi.business;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.UsuarioDAO;

@BusinessController
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {
	
	private static final long serialVersionUID = 1L;
	
	public Usuario findByLogin(String login) {
		return getDelegate().findByLogin(login);
	}
}
