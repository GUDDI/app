/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.org.guddi.domain.Papel;
import br.org.guddi.domain.Recurso;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.PapelDAO;
import br.org.guddi.persistence.RecursoDAO;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.security.Resources;
import br.org.guddi.security.Roles;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author 70744416353
 */
@BusinessController
public class SecurityBC {

    @Inject
    private UsuarioDAO usuarioDAO;
    @Inject
    private RecursoDAO recursoDAO;
    @Inject
    private PapelDAO papelDAO;

    public Usuario findByLogin(String login) {
        return usuarioDAO.findByLogin(login);
    }

    @Startup
    public void bootstrap() {
        try {

            recursoDAO.clear();
            List<String> listarec = Resources.getResourcesList();
            for (String recursos : listarec) {
                Recurso rec = recursoDAO.load(recursos);
                if (rec == null) {
                    rec = new Recurso();
                    rec.setId(Resources.getResource(recursos));
                    rec.setNome(recursos);
                    recursoDAO.insert(rec);
                }

            }

            papelDAO.clear();
            List<String> listapap = Roles.getRolesList();
            for (String papel : listapap) {
                Papel pap = null;
                pap = papelDAO.load(papel);
                if (pap == null) {
                    pap = new Papel();
                    pap.setId(Roles.getRole(papel));
                    pap.setDescricao(papel);
                    papelDAO.insert(pap);
                }
            }

        } catch (Exception e) {
            LOG.log(Level.SEVERE, e.getMessage());
        }
    }

    /**
     *
     * @param idUsuario
     * @param idRole
     * @return
     */
    public Boolean hasRole(Long idUsuario, Long idRole) {
        return usuarioDAO.hasRole(idUsuario, idRole);
    }

    /**
     *
     * @param idUsuario
     * @param idResource
     * @return
     */
    public Integer hasPermission(Long idUsuario, Long idResource) {
        return usuarioDAO.hasPermission(idUsuario, idResource);

    }
    private static final Logger LOG = Logger.getLogger(SecurityBC.class.getName());
}
