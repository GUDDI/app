package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.UsuarioDAO;
import br.org.guddi.security.IRoles;

@BusinessController
@RequiredRole(value = IRoles.ADMINISTRATOR)
public class UsuarioBC extends DelegateCrud<Usuario, Long, UsuarioDAO> {

	private static final long serialVersionUID = 1L;



}
