package br.org.guddi.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.org.guddi.business.PapelBC;
import br.org.guddi.domain.Papel;

@ViewController
@PreviousView("./papel_list.jsf")
public class PapelEditMB extends AbstractEditPageBean<Papel, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private PapelBC papelBC;
	
	@Override
	@Transactional
	public String delete() {
		this.papelBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.papelBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.papelBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.papelBC.load(getId()));
	}

}