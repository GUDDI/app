package br.gov.frameworkdemoiselle.guddi.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.guddi.business.DescritorBC;
import br.gov.frameworkdemoiselle.guddi.domain.Descritor;

@ViewController
@PreviousView("./descritor_list.jsf")
public class DescritorEditMB extends AbstractEditPageBean<Descritor, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private DescritorBC descritorBC;
	
	@Override
	@Transactional
	public String delete() {
		this.descritorBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.descritorBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.descritorBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.descritorBC.load(getId()));
	}

}