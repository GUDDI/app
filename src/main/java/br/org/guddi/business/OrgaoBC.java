package br.org.guddi.business;

import java.util.List;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Orgao;
import br.org.guddi.persistence.OrgaoDAO;
import br.org.guddi.security.IRoles;

/**
 *
 * @author escritorio
 */
@BusinessController
@RequiredRole(value = IRoles.ADMINISTRATOR)
public class OrgaoBC extends DelegateCrud<Orgao, Long, OrgaoDAO> {
	
	private static final long serialVersionUID = 1L;

	@Override
	@RequiredRole(value = {IRoles.ADMINISTRATOR, IRoles.MANAGER})
	public List<Orgao> findAll() {
		return super.findAll();
	}

	@Override
	@RequiredRole(value = {IRoles.ADMINISTRATOR, IRoles.MANAGER})
	public Orgao load(Long id) {
		return super.load(id);
	}

}
