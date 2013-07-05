package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Usuario;
import javax.persistence.NoResultException;

@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param email
     * @return
     */
    public Usuario findByUserName(String usuario) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }

    /**
     *
     * @param idUsuario
     * @param idRole
     * @return
     */
    public Boolean hasRole(Long idUsuario, Long idRole) {
        return (Boolean) getEntityManager().createNativeQuery("SELECT COUNT(1) > 0 FROM guddi.usuario WHERE id = :idUser AND id_papel = :role")
                .setParameter("idUser", idUsuario)
                .setParameter("role", idRole)
                .getSingleResult();
    }

    /**
     *
     * @param idUsuario
     * @param idResource
     * @return
     */
    public Integer hasPermission(Long idUsuario, Long idResource){
        return (Integer) getEntityManager().createNativeQuery("SELECT operacao FROM usuario_recursos ur WHERE id_usuario = :idUser AND id_recursos = :resource")
                .setParameter("idUser", idUsuario)
                .setParameter("resource", idResource)
                .getSingleResult();

    }
}
