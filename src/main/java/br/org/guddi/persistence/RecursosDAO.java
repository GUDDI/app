package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.guddi.domain.Orgao;
import br.org.guddi.domain.Recursos;

@PersistenceController
public class RecursosDAO extends JPACrud<Recursos, Long> {

	private static final long serialVersionUID = 1L;

        public Recursos load(String nome){
            return (Recursos) getEntityManager().createNamedQuery("Recursos.findByNome").setParameter("nome", nome).getSingleResult();
        }

        public void clear(){
            for (Recursos object : findAll()) {
                delete(object.getId());
            }
        }
}
