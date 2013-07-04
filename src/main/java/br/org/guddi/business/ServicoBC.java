package br.org.guddi.business;

import br.gov.frameworkdemoiselle.security.RequiredRole;
import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;
import br.org.guddi.domain.Servico;
import br.org.guddi.persistence.ServicoDAO;
import br.org.guddi.security.IRoles;
import java.util.logging.Logger;

@BusinessController
@RequiredRole(value = IRoles.MANAGER)
public class ServicoBC extends DelegateCrud<Servico, Long, ServicoDAO> {
	
	private static final long serialVersionUID = 1L;
	
	/**
     *
     * @param id
     * @return
     */
    @Override
    public Servico load(Long id) {
	
		return getDelegate().loadFromDetalhamento(id);
	
	}
    private static final Logger LOG = Logger.getLogger(ServicoBC.class.getName());
	
}
