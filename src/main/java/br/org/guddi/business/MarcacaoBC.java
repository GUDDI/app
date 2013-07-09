package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Marcacao;
import br.org.guddi.persistence.MarcacaoDAO;
import br.org.guddi.security.IRoles;

/**
 *
 * @author escritorio
 */
@BusinessController
@RequiredRole(value = IRoles.ADMINISTRATOR)
public class MarcacaoBC extends DelegateCrud<Marcacao, Long, MarcacaoDAO> {

	private static final long serialVersionUID = 1L;


}
