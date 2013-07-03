package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Descritor;
import br.org.guddi.persistence.DescritorDAO;
import br.org.guddi.security.IRoles;

@BusinessController
@RequiredRole(value = IRoles.MANAGER)
public class DescritorBC extends DelegateCrud<Descritor, Long, DescritorDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
