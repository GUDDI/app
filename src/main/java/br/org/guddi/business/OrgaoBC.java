package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Orgao;
import br.org.guddi.persistence.OrgaoDAO;
import br.org.guddi.security.Papeis;

@BusinessController
@RequiredRole(value = Papeis.ADMINISTRADOR)
public class OrgaoBC extends DelegateCrud<Orgao, Long, OrgaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
