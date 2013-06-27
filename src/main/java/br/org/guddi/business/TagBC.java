package br.org.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.org.guddi.domain.Tag;
import br.org.guddi.persistence.TagDAO;

@BusinessController
public class TagBC extends DelegateCrud<Tag, Long, TagDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
