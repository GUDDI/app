package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Pesquisa;
import br.gov.frameworkdemoiselle.guddi.persistence.PesquisaDAO;
import java.util.ArrayList;
import java.util.List;

@BusinessController
public class PesquisarBC extends DelegateCrud<Pesquisa, Long, PesquisaDAO> {
	
	private static final long serialVersionUID = 1L;
        
        public List<Pesquisa> busca(String consulta){
            List<Pesquisa> lista = new ArrayList<Pesquisa>();
            return lista;
        }
	
}
