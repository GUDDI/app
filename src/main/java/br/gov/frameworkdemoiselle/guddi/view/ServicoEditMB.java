package br.gov.frameworkdemoiselle.guddi.view;

import javax.inject.Inject;
import br.gov.frameworkdemoiselle.annotation.PreviousView;
import br.gov.frameworkdemoiselle.stereotype.ViewController;
import br.gov.frameworkdemoiselle.template.AbstractEditPageBean;
import br.gov.frameworkdemoiselle.transaction.Transactional;
import br.gov.frameworkdemoiselle.guddi.business.ServicoBC;
import br.gov.frameworkdemoiselle.guddi.domain.Servico;

@ViewController
@PreviousView("./servico_list.jsf")
public class ServicoEditMB extends AbstractEditPageBean<Servico, Long> {

	private static final long serialVersionUID = 1L;

	@Inject
	private ServicoBC servicoBC;
	
	@Override
	@Transactional
	public String delete() {
		this.servicoBC.delete(getId());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String insert() {
		this.servicoBC.insert(getBean());
		return getPreviousView();
	}
	
	@Override
	@Transactional
	public String update() {
		this.servicoBC.update(getBean());
		return getPreviousView();
	}
	
	@Override
	protected void handleLoad() {
		setBean(this.servicoBC.load(getId()));
	}

}