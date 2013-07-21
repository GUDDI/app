package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.message.SeverityType;
import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Usuario;
import br.org.guddi.util.CriptografiaUtil;
import javax.persistence.NoResultException;

/**
 *
 * @author escritorio
 */
@PersistenceController
public class UsuarioDAO extends JPACrud<Usuario, Long> {

    private static final long serialVersionUID = 1L;

    /**
     *
     * @param usuario
     * @return
     */
    public Usuario findByUserName(String usuario) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByUsuario").setParameter("usuario", usuario).getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
    }
    
    public Usuario findByEmail(String email) {
        try {
            return (Usuario) getEntityManager().createNamedQuery("Usuario.findByEmail").setParameter("email", email).getSingleResult();
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
    public Boolean hasRole(Long idUsuario, Short idRole) {
        return (Boolean) getEntityManager().createNativeQuery("SELECT COUNT(1) > 0 FROM guddi.usuario WHERE id = :idUser AND papel = :papel")
                .setParameter("idUser", idUsuario)
                .setParameter("papel", idRole)
                .getSingleResult();
    }

    /**
     *
     * @param idUsuario
     * @param idResource
     * @return
     */
    public Integer hasPermission(Long idUsuario, Long idResource) {
        return (Integer) getEntityManager().createNativeQuery("SELECT operacao FROM usuario_recursos ur WHERE id_usuario = :idUser AND id_recursos = :resource")
                .setParameter("idUser", idUsuario)
                .setParameter("resource", idResource)
                .getSingleResult();

    }

    /**
     *
     * @param usuario
     * @return
     */
    public void UpdatePassWithAminesia(String aminesia, String senhanova) throws Exception {
        try {
            Usuario usu = (Usuario) getEntityManager().createNamedQuery("Usuario.findByAminesia").setParameter("aminesia", aminesia).getSingleResult();
            if (usu != null) {
                usu.setSenha(CriptografiaUtil.getCodigoMd5(senhanova));
                update(usu); 
            }else{
                 throw new Exception("Pegar mensagem do propertie - Senha atual inválida");
            }
        } catch (NoResultException e) {
           throw e;
        }
    }
    
   
}
