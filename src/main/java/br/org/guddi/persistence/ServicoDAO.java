package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.org.guddi.domain.Servico;

@PersistenceController
public class ServicoDAO extends JPACrud<Servico, Long> {

	private static final long serialVersionUID = 1L;
	

}
