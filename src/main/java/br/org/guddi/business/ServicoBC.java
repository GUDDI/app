package br.org.guddi.business;

import java.util.List;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Servico;
import br.org.guddi.persistence.ServicoDAO;

@BusinessController

public class ServicoBC extends DelegateCrud<Servico, Long, ServicoDAO> {

	private static final long serialVersionUID = 1L;

	/**
     *
     * @param id
     * @return
     */
    @Override
    public Servico load(Long id) {
    	
		return getDelegate().loadFromDetalhamento(id);

	}

    @Override
    public List<Servico> findAll(){
    	return getDelegate().findAll();
    }

}
