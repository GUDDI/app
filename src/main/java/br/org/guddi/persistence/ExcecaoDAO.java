package br.org.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;
import br.org.guddi.domain.Excecao;
import java.util.logging.Logger;

@PersistenceController
public class ExcecaoDAO extends JPACrud<Excecao, Long> {

	private static final long serialVersionUID = 1L;



}
