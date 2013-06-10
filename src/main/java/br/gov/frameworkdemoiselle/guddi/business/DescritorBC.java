package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Descritor;
import br.gov.frameworkdemoiselle.guddi.persistence.DescritorDAO;

@BusinessController
public class DescritorBC extends DelegateCrud<Descritor, Long, DescritorDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
