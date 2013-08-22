package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Sistema;
import br.org.guddi.persistence.SistemaDAO;
import br.org.guddi.security.IRoles;

/**
 *
 * @author escritorio
 */
@BusinessController
@RequiredRole(value = IRoles.MANAGER)
public class SistemaBC extends DelegateCrud<Sistema, Long, SistemaDAO> {

	private static final long serialVersionUID = 1L;
}
