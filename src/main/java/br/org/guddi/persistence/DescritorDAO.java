package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Descritor;

/**
 *
 * @author escritorio
 */
@PersistenceController
public class DescritorDAO extends JPACrud<Descritor, Long> {

	private static final long serialVersionUID = 1L;

}
