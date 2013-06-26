package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredPermission;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Papel;
import br.gov.frameworkdemoiselle.guddi.domain.Usuario;
import br.gov.frameworkdemoiselle.guddi.persistence.PapelDAO;

@BusinessController
public class PapelBC extends DelegateCrud<Papel, Long, PapelDAO> {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	@RequiredRole("ADMINSTRADOR")
	@RequiredPermission(operation = "ADMINSTRADOR2", resource = "GUEST2")
	public void insert(Papel bean) {
		super.insert(bean);
	}

}
