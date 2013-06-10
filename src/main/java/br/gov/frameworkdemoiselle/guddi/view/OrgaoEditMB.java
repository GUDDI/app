package br.gov.frameworkdemoiselle.guddi.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.guddi.business.OrgaoBC;
import br.gov.frameworkdemoiselle.guddi.domain.Orgao;

@ViewController
@PreviousView("./orgao_list.jsf")
public class OrgaoEditMB extends AbstractEditPageBean<Orgao, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private OrgaoBC orgaoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.orgaoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.orgaoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.orgaoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.orgaoBC.load(getId()));
	}

}