package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Sistema;

/**
 *
 * @author escritorio
 */
@PersistenceController
public class SistemaDAO extends JPACrud<Sistema, Long> {

	private static final long serialVersionUID = 1L;
}
