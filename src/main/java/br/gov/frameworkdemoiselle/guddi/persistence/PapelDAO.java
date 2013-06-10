package br.gov.frameworkdemoiselle.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.gov.frameworkdemoiselle.guddi.domain.Papel;

@PersistenceController
public class PapelDAO extends JPACrud<Papel, Long> {

	private static final long serialVersionUID = 1L;
	

}
