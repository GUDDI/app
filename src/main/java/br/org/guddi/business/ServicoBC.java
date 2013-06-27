package br.org.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Servico;
import br.org.guddi.persistence.ServicoDAO;

@BusinessController
public class ServicoBC extends DelegateCrud<Servico, Long, ServicoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
