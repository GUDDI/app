package br.org.guddi.business;

import java.util.ArrayList;
import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.domain.Pesquisa;
import br.org.guddi.persistence.PesquisaDAO;
import br.org.guddi.util.searh.SearchFilter;

@BusinessController
public class PesquisarBC extends DelegateCrud<Pesquisa, Long, PesquisaDAO> {

	private static final long serialVersionUID = 1L;


	public void searhValidation(String searchParam) {
		//validar e filtar parametro de pesquisa
	}


	public int count(String searchParam) {
		return getDelegate().count(searchParam);
	}
	
	@Transactional
	public List<Pesquisa> search(String searchParam, SearchFilter filter) {
		return getDelegate().search(searchParam, filter);
	}
	

}
