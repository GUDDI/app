package br.org.guddi.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Recurso;
import br.org.guddi.domain.Usuario;
import br.org.guddi.persistence.RecursoDAO;
import br.org.guddi.security.IRoles;
import br.org.guddi.security.Resources;
import java.util.ArrayList;
import java.util.List;

@BusinessController
@RequiredRole(value = IRoles.ADMINISTRATOR)
public class RecursosBC extends DelegateCrud<Recurso, Long, RecursoDAO> {

	private static final long serialVersionUID = 1L;



}
