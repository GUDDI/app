package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Recurso;
import java.util.logging.Logger;

@PersistenceController
public class RecursoDAO extends JPACrud<Recurso, Long> {

	private static final long serialVersionUID = 1L;

        /**
     *
     * @param nome
     * @return
     */
    public Recurso load(String nome){
            return (Recurso) getEntityManager().createNamedQuery("Recurso.findByNome").setParameter("nome", nome).getSingleResult();
        }

        /**
     *
     */
    public void clear(){
            for (Recurso object : findAll()) {
                delete(object.getId());
            }
        }

}
