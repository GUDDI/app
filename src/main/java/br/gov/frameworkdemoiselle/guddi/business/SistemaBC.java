package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Sistema;
import br.gov.frameworkdemoiselle.guddi.persistence.SistemaDAO;

@BusinessController
public class SistemaBC extends DelegateCrud<Sistema, Long, SistemaDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
