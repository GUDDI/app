package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.guddi.domain.Orgao;
import br.org.guddi.domain.Recurso;

@PersistenceController
public class RecursoDAO extends JPACrud<Recurso, Long> {

	private static final long serialVersionUID = 1L;

        public Recurso load(String nome){
            return (Recurso) getEntityManager().createNamedQuery("Recurso.findByNome").setParameter("nome", nome).getSingleResult();
        }

        public void clear(){
            for (Recurso object : findAll()) {
                delete(object.getId());
            }
        }
}
