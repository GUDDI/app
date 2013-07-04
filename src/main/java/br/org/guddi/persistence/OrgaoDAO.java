package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Orgao;
import java.util.logging.Logger;

@PersistenceController
public class OrgaoDAO extends JPACrud<Orgao, Long> {

	private static final long serialVersionUID = 1L;



}
