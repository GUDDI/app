package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Papel;
import java.util.logging.Logger;

@PersistenceController
public class PapelDAO extends JPACrud<Papel, Long> {

	private static final long serialVersionUID = 1L;

        /**
     *
     * @param descricao
     * @return
     */
    public Papel load(String descricao){
            return (Papel) getEntityManager().createNamedQuery("Papel.findByDescricao").setParameter("descricao", descricao).getSingleResult();
        }

        /**
     *
     */
    public void clear(){
            for (Papel object : findAll()) {
                delete(object.getId());
            }
        }

}
