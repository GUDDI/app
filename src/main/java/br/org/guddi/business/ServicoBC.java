package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Servico;
import br.org.guddi.persistence.ServicoDAO;
import br.org.guddi.security.Papeis;

@BusinessController
@RequiredRole(value = Papeis.MANAGER)
public class ServicoBC extends DelegateCrud<Servico, Long, ServicoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	public Servico load(Long id) {
	
		return getDelegate().loadFromDetalhamento(id);
	
	}
	
}
