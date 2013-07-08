/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.org.guddi.business;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.org.guddi.domain.Recurso;
import br.org.guddi.persistence.RecursoDAO;
import br.org.guddi.security.Resources;

/**
 *
 * @author 70744416353
 */

@BusinessController
public class SecurityBC {

    @Inject
    private RecursoDAO recursoDAO;

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


        } 
        catch (Exception e) {
           // LOG.log(Level.SEVERE, e.getMessage());
        }
    }



}
