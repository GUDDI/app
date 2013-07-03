package br.org.guddi.business;

import br.gov.frameworkdemoiselle.lifecycle.Startup;
import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Papel;
import br.org.guddi.domain.Recursos;
import br.org.guddi.persistence.PapelDAO;
import br.org.guddi.security.IRoles;
import br.org.guddi.security.Resources;
import br.org.guddi.security.Roles;
import java.util.List;

@BusinessController
@RequiredRole(value = IRoles.ADMINISTRATOR)
public class PapelBC extends DelegateCrud<Papel, Long, PapelDAO> {

    private static final long serialVersionUID = 1L;


}
