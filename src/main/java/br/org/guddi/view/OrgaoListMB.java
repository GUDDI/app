package br.org.guddi.view;

import java.util.List;

import javax.inject.Inject;

import br.gov.frameworkdemoiselle.annotation.NextView;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractListPageBean;
import br.org.guddi.business.OrgaoBC;
import br.org.guddi.domain.Orgao;

/**
 *
 * @author escritorio
 */
@ViewController
@NextView("./orgao_edit.jsf")
@PreviousView("./orgao_list.jsf")
public class OrgaoListMB extends AbstractListPageBean<Orgao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrgaoBC orgaoBC;

    @Override
	protected List<Orgao> handleResultList() {
		return this.orgaoBC.findAll();
	}

}