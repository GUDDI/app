package br.org.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Pesquisa;
import br.org.guddi.persistence.PesquisaDAO;
import java.util.ArrayList;
import java.util.List;

@BusinessController
public class PesquisarBC extends DelegateCrud<Pesquisa, Long, PesquisaDAO> {
	
	private static final long serialVersionUID = 1L;
        
        public List<Pesquisa> busca(String consulta){
            List<Pesquisa> lista = new ArrayList<Pesquisa>();
            
            for (int i = 0; i < 50; i++) {
            	lista.add(new Pesquisa("orgao "+i, "Servico " +i, "atributo " +i));
			}
            
            return lista;
        }
	
}
