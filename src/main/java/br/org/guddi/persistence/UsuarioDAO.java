package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.guddi.domain.Usuario;
import br.org.guddi.security.Operations;
import br.org.guddi.security.Resources;
import br.org.guddi.security.Roles;
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

    public Boolean hasRole(Long idUsuario, Long idRole) {
        return (Boolean) getEntityManager().createNativeQuery("SELECT COUNT(1) > 0 FROM guddi.usuario_papel WHERE id_usuario = :idUser AND id_papel = :role")
                .setParameter("idUser", idUsuario)
                .setParameter("role", idRole)
                .getSingleResult();
    }

    public Integer hasPermission(Long idUsuario, Long idResource){
        return (Integer) getEntityManager().createNativeQuery("SELECT operacao FROM guddi.usuario_recursos ur WHERE id_usuario = :idUser AND id_recursos = :resource")
                .setParameter("idUser", idUsuario)
                .setParameter("resource", idResource)
                .getSingleResult();

    }
}
