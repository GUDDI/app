package br.gov.frameworkdemoiselle.guddi.persistence;

import br.gov.frameworkdemoiselle.stereotype.PersistenceController;
import br.gov.frameworkdemoiselle.template.JPACrud;

import br.gov.frameworkdemoiselle.guddi.domain.Tag;

@PersistenceController
public class TagDAO extends JPACrud<Tag, Long> {

	private static final long serialVersionUID = 1L;
	

}
