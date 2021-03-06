package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Excecao;
import br.org.guddi.persistence.ExcecaoDAO;
import br.org.guddi.security.IRoles;

/**
 *
 * @author escritorio
 */
@BusinessController
@RequiredRole(value = IRoles.MANAGER)
public class ExcecaoBC extends DelegateCrud<Excecao, Long, ExcecaoDAO> {

	private static final long serialVersionUID = 1L;

}
