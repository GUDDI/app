package br.gov.frameworkdemoiselle.guddi.business;

import br.gov.frameworkdemoiselle.stereotype.BusinessController;
import br.gov.frameworkdemoiselle.template.DelegateCrud;

import br.gov.frameworkdemoiselle.guddi.domain.Excecao;
import br.gov.frameworkdemoiselle.guddi.persistence.ExcecaoDAO;

@BusinessController
public class ExcecaoBC extends DelegateCrud<Excecao, Long, ExcecaoDAO> {
	
	private static final long serialVersionUID = 1L;
	
}
