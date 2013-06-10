package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Orgao;
import br.gov.frameworkdemoiselle.guddi.persistence.OrgaoDAO;

@BusinessController
public class OrgaoBC extends DelegateCrud<Orgao, Long, OrgaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
