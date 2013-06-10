package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Atributo;
import br.gov.frameworkdemoiselle.guddi.persistence.AtributoDAO;

@BusinessController
public class AtributoBC extends DelegateCrud<Atributo, Long, AtributoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
