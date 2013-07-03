/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.org.guddi.domain.Papel;
import br.org.guddi.domain.Recursos;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.PapelDAO;
import br.org.guddi.persistence.RecursosDAO;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.security.Resources;
import br.org.guddi.security.Roles;
import java.util.List;
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
    private RecursosDAO recursosDAO;
    @Inject
    private PapelDAO papelDAO;

    public Usuario findByLogin(String login) {
        return usuarioDAO.findByLogin(login);
    }

    @Startup
    public void loadDataRecursos() {
//        recursosDAO.clear();
//        List<String> lista = Resources.getResourcesList();
//        for (String recursos : lista) {
//            Recursos rec = recursosDAO.load(recursos);
//            if (rec == null) {
//                rec = new Recursos();
//                rec.setId(Resources.getResource(recursos));
//                rec.setNome(recursos);
//                recursosDAO.insert(rec);
//            }
//
//        }
    }

    @Startup
    public void loadDataRoles() {
//        papelDAO.clear();
//        List<String> lista = Roles.getRole();
//        for (String papel : lista) {
//            Papel pap = papelDAO.load(papel);
//            if (pap == null) {
//                pap = new Papel();
//                pap.setId(Resources.getResource(papel));
//                pap.setDescricao(papel);
//                papelDAO.insert(pap);
//            }
//
//        }
    }

    public Boolean hasRole(Long idUsuario, Long idRole) {
        return usuarioDAO.hasRole(idUsuario, idRole);
    }

    public Integer hasPermission(Long idUsuario, Long idResource){
        return usuarioDAO.hasPermission(idUsuario, idResource);

    }
}
