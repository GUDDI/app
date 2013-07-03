package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.guddi.domain.Usuario;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

	private static final long serialVersionUID = 1L;
	
        public Usuario findByLogin(String login) {
		try {
			return (Usuario) getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", login).getSingleResult();
		} catch (NonUniqueResultException e) {
			return null;
		} catch (NoResultException e) {
			return null;
		}
	}

}
